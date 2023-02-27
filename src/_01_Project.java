import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _01_Project {
    public static String username, password;

    public static void main(String[] args) {


        // Define Scanner Class...
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        // Define Bank Transactions List..."Deposit", "Withdraw", "Transfer", "Open Account"...
        List<String> actions = new ArrayList<>(Arrays.asList("Money_Deposit", "Withdraw_Money", "Transfer", "Exit"));

        // Define bank customers username list..."User1", "User2", "User3"...
        List<String> users = new ArrayList<>(Arrays.asList("User1", "User2", "User3"));
        // Define a list of bank customers passwords..."password1", "password2", "password3"...
        List<String> passwords = new ArrayList<>(Arrays.asList("password1", "password2", "password3"));
        // Define a list of bank account numbers for bank customers.."1234", "5678", "9999"
        List<String> accounts = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));
        // Define the amount of money in the bank accounts of bank customers...200, 1000, 5000
        List<Integer> funds = new ArrayList<>(Arrays.asList(200, 1000, 5000));
        // TODO IMPORTANT NOTE: The data in the lists you enter above are related to each other according to the index number.
        // TODO Example -> The password of 'User1' is 'password1', the account number is '1234' and the amount of money in his account is '200'...

  /*
        while (true){

         Let's ask the user to enter username and password in an endless loop...
         Let's confirm the username and password entered from the console by calling the confirmUsernameAndPassword() method...
         If the correct username and password are entered, let's ask for the desired action by printing the message "You have successfully logged in" ...
         If an unregistered username and password are entered, the message "No such registered user was found in the system. Try again"
         Let's show it and return the user to the username and password entry again..

        }
    */
        boolean condition = false;
        while (!condition) {
            System.out.println("Username:");
            username = scan.nextLine();

            System.out.println("Password");
            password = scan.nextLine();

            condition = confirmUsernameAndPassword(users, passwords, username, password);
            if (condition) {
                System.out.println("You have successfully logged in, congratulation");
                break;
            } else
                System.out.println("There is no such user registered in the system, please, try again");
        }

/*
        while (true){

         If the choice is wrong, let's give the warning "You did not make a successful choice..." and ask him to choose again..
         When the right choice is made, the operation selected by the user is transferred to the code via SWITCH Statements
         Case 1: "This ATM is temporarily closed for deposits... We are sorry".
         Case 2: "Which account do you want to withdraw money from?" ask the user
                  Take the account numbers from the list above and print them on the screen.
                 "How much money do you want to withdraw?" Let's ask.. Let's get user input...
                  Let's complete the withdrawal process from the account by calling the withdraw() method below...
                  Let's go back to the operations loop again...
         Case 3: Let's get back to the head by saying "We can't perform this process at the moment...".
         Case 4: System.exit(1); Copy and paste the code here into case 4 exactly...
         default:"You did not make a successful selection..." message..

    */
        while (condition) {
            System.out.println("Please, chose the action you want do do");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i) + " - " + (i + 1));
            }
            int userChoice = scanInt.nextInt();

            switch (userChoice) {
                case 1: {
                    System.out.println("Sorry, this ATM is temporarily disabled for deposits...");
                    condition = true;
                    break;


                }
                case 2: {
                    boolean keys = true;
                    System.out.println("Which account do you want witdraw money from?");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(accounts.get(i));
                    }
                    String accountNum = scan.nextLine();
                    for (int i = 0; i < 3; i++) {
                        if (accountNum.equals(accounts.get(i)))
                            keys = false;
                    }

                    while (keys) {
                        System.out.println("You includend wrong account number, Try Aging");
                        System.out.println("Which account do you want wihdraw money from?");
                        for (int i = 0; i < 3; i++) {
                            System.out.println(accounts.get(i));
                        }
                        accountNum = scan.nextLine();
                        for (int i = 0; i < 3; i++) {
                            if (accountNum.equals(accounts.get(i)))
                                keys = false;
                        }

                    }

                    System.out.println("How much money do you want to withdraw?");
                    int money = scanInt.nextInt();


                    withdraw(accounts, funds, accountNum, money);

                    break;
                }

                case 3: {
                    System.out.println("We are currently unable to perform this operation... Sorry");
                    break;

                }
                case 4:
                    System.exit(1);
                    break;

                default: {
                    System.out.println("You select unsuccesful choise... Try again please");
                    break;
                }

            }
        }



       /*
        }
       */
    }

    private static void withdraw(List<String> accounts, List<Integer> funds, String chosenAccount, int amountToWithdraw) {

   /*
        This method takes the values in the accounts (accounts) and funds (the amount of money in the account) lists that it takes as a parameter.
        It has been created to be used with the values  entered by the user...
        For example: If the user wanted to withdraw money from the account numbered 1234, specify the account from which the money will be withdrawn and the amount of money to be withdrawn.
        In order to deduct from the account balance, the account with which index number must be found, the amount of money with the same index must be removed from the list of funds.
        The amount of money remaining in the user's account should be indicated by deducting.

        If the user has entered the account number incorrectly or the amount of money in their account is not sufficient
        "An unexpected error has occurred...Have a nice day..." should warn...

         */
        int index = 0;
        int kalan = 0;
        for (int i = 0; i < 3; i++) {
            if (chosenAccount.equals(accounts.get(i))) {
                index = i;
            }
        }

        if (amountToWithdraw <= funds.get(index)) {
            kalan = funds.get(index) - amountToWithdraw;
            funds.set(index, kalan);
            System.out.println("Pleace take your money. " + funds.get(index) + " Euros left in your account");

        } else
            System.out.println("You dont have enough balance, your balance " + funds.get(index) + " Euros");


    }

    private static boolean confirmUsernameAndPassword(List<String> users, List<String> passwords, String username, String password) {

  /*
        If the user does not enter one of the username and password we created above, this method should return FALSE.
        According to this, make the user confirmation using the given parameters.
     */

        boolean is = false;
        for (int i = 0; i < 3; i++) {
            if (users.get(i).equals(username) &&
                    passwords.get(i).equals(password)) {
                is = true;
            }

        }

        return is;
    }
}





