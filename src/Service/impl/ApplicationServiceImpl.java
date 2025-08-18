package Service.impl;
import Model.BanckAccount;
import Model.User;
import Service.AccountService;
import Service.ApplicationService;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
    Scanner scanner = new Scanner(System.in);
    private User loggedInUser;
    @Override
    public void startApplication() {
        int counter = 0;
        while (true) {
            boolean isExit = false;

            System.out.println("<<<<<<<<<<<<<<<<< Welcome to " + BanckAccount.getName() + " " + ">>>>>>>>>>>>>>>>>>");
            System.out.println("Please enter your choice:");
            System.out.println("  a-Login   b-Register     c-Exit    ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    login();
                    break;
                case 'b':
                    signup();
                    break;
                case 'c':
                    isExit = true;

                    break;
                default:
                    counter++;

                    System.out.println("Invalid choice");
                    break;
            }

            if (isExit) {
                System.out.println("Exit , and Thank you for using E-WalletSystem");
                break;
            }
            if (counter == 4) {
                System.out.println("Too many invalid attempts. try again later.");
                break;
            }


        }
    }

    BanckAccount bankAccount = new BanckAccount();
    AccountService accountService = new AccountServiceImpl(bankAccount);
    AccountValidationServiceImpl accountValidationService = new AccountValidationServiceImpl();

    private void signup() {
        System.out.println("Register");
        System.out.println("Enter your username:");
        String username = scanner.next();
        if (!accountValidationService.isUserNameValid(username)) {
            System.out.println("Invalid character username must to be start Upper case & didn't contain numbers and can't be less than 2 characters : ");
            return;
        }
        System.out.println("Enter your email:");
        String email = scanner.next();
        if (!accountValidationService.isEmailValid(email)){
            System.out.println("Invalid email format");
            System.out.println("your email must be verified with gmail ");
            return;
        }

        System.out.println("Enter your password:");
        String password = scanner.next();
        if (!accountValidationService.isPasswordValid(password)) {
            System.out.println("Invalid password format");
            System.out.println("password must include upper case, lower case , number , [@#$%&^*_+)(!] and at least 10 characters");
            return;
        }
        System.out.println("Enter your phone number:");
        String phone = scanner.next();
        if (!accountValidationService.isPhoneNumberValid(phone)){
            System.out.println( "Invalid phone number format and must start with 20 ");
            return;
        }



        User user1 = new User(username, email, password, phone);
        if (accountService.createAccount(user1)) {
            System.out.println("Account created successfully");
        }
    }


    private void login() {
        while (true) {
            System.out.println("Login");
            System.out.print("Enter your email: ");
            String email = scanner.next();
            System.out.print("Enter your password: ");
            String password = scanner.next();

            boolean found = false;
            for (User user : bankAccount.getUsers()) {
                if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    loggedInUser = user;
                    System.out.println("Login successful");
                    found = true;
                    break;
                }
            }

            if (found) {
                showUserMenu();
                break;
            } else {
                System.out.println(" a- Try again   b- Forget password   c- Exit   ");
                char choice = scanner.next().charAt(0);
                switch (choice) {
                    case 'a':
                        break;
                    case 'b':
                        forgetPassword();
                        break;
                    case 'c':
                        System.out.println("Exit , and Thank you for using E-WalletSystem");
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }

                }
            }
        }

    private void forgetPassword() {
        System.out.println("Forget Password");

        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your email: ");
            String email = scanner.next();
            System.out.println("Enter your phone number: ");
            String phoneNumber = scanner.next();

            boolean found = false;
            for (User u : bankAccount.getUsers()) {
                if (email.equals(u.getEmail()) && phoneNumber.equals(u.getPhoneNumber())) {
                    found = true;

                    System.out.println("Enter your new password: ");
                    String newPassword = scanner.next();
                    System.out.println("Confirm your new password: ");
                    String confirmPassword = scanner.next();

                    if (!newPassword.equals(confirmPassword)) {
                        System.out.println("Passwords do not match");
                        return;
                    }

                    if (!accountValidationService.isPasswordValid(newPassword)) {
                        System.out.println("Invalid password format");
                        System.out.println("password must include upper case, lower case , number , [@#$%&^*_+)(!] and at least 10 characters");
                        return;
                    }

                    u.setPassword(newPassword);
                    System.out.println("Password changed successfully");
                    return;
                }
            }

            if (!found) {
                attempts++;
                System.out.println("Invalid email or phone number. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println("Too many invalid attempts. Try again later.");
    }






    private void showUserMenu() {
            User account = accountService.getAccount(loggedInUser);
            System.out.println("Welcome " + account.getUserName()+ " - " + "Your balance is " + account.getBalance() + " $ " + " - " + "Email: " + account.getEmail() + " - " + "Phone: " + account.getPhoneNumber());

            while (true) {
                System.out.println("Please enter your choice:");
                System.out.println("  a-Deposit    b-Withdraw    c-Check Balance    d- transfer    e- change password    f-removeAccount    g-Logout    ");

                char choice = scanner.next().charAt(0);
                boolean isExit = false;
                switch (choice) {
                    case 'a':
                        deposit();
                        break;
                    case 'b':
                        withdraw();
                        break;
                    case 'c':
                        checkBalance();
                        break;
                    case 'd':
                        transfer();
                        break;
                    case 'e':
                        changePassword();
                        break;
                    case 'f':
                        removeAccount();
                        isExit=true;
                        break;
                    case 'g':
                        logout();
                        isExit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                if (isExit) {
                    System.out.println("Exit , and Thank you for using E-WalletSystem");
                    return;
                }

            }
        }

    private void removeAccount() {
        System.out.println("pls enter your password to remove your account:");
        String password = scanner.next();
        if (!loggedInUser.getPassword().equals(password)){
            System.out.println("Invalid password");
            return;
        }
        bankAccount.getUsers().remove(loggedInUser);
        System.out.println("Account removed successfully");
        }



    private void changePassword() {
        System.out.println("Change Password");
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.next();
        if (!loggedInUser.getPassword().equals(currentPassword)) {
            System.out.println("Invalid password");
            return;
        }
        System.out.print("Enter your new password: ");
        String newPassword = scanner.next();
        System.out.print("Confirm your new password: ");
        String confirmPassword = scanner.next();
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match");
            return;
        }
        if (!accountValidationService.isPasswordValid(newPassword)) {
            System.out.println("Invalid password format");
            System.out.println("password must include upper case, lower case , number , [@#$%&^*_+)(!] and at least 10 characters");
            return;
        }
        loggedInUser.setPassword(newPassword);
        System.out.println("Password changed successfully");
    }


    private void checkBalance() {
        loggedInUser.setBalance(accountService.getAccount(loggedInUser).getBalance());
        System.out.println("Your balance is " + loggedInUser.getBalance());
    }

    private void logout() {
        loggedInUser = null;
        System.out.println("Logout");
    }

    private void deposit() {
        System.out.println("pls enter the amount to deposit:");
        double amount = scanner.nextDouble();
        accountService.deposit(loggedInUser, amount);
    }

    private void withdraw() {
        System.out.println("pls enter the amount to withdraw:");
        double amount = scanner.nextDouble();
        accountService.withdraw(loggedInUser, amount);
    }

    private void transfer() {
        System.out.println("pls enter the amount to transfer:");
        double amount = scanner.nextDouble();
        System.out.println("pls enter the phoneNumber of the receiver:");
        String phoneNumber = scanner.next();
        accountService.transfer(loggedInUser, phoneNumber, amount);
    }

}

