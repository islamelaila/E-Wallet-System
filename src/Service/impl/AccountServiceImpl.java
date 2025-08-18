package Service.impl;

import Model.BanckAccount;
import Model.User;
import Service.AccountService;

public class AccountServiceImpl implements AccountService {

    BanckAccount bankAccount = new BanckAccount();

    // Constructor
    public AccountServiceImpl(BanckAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean createAccount(User user) {
        for (User u : bankAccount.getUsers()) {
            if (u.getEmail().equals(user.getEmail())) {
                System.out.println("User already exists");
                return false;
            }
            }
        bankAccount.getUsers().add(user);
        return true ;
    }

    @Override
    public User getAccount(User user) {
        for (User u : bankAccount.getUsers()) {
            if (u.getEmail().equals(user.getEmail())) {
                return user ;
            }
        }
        return null ;
    }



    @Override
    public void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        System.out.println("Deposit successful. New balance: " + user.getBalance());
    }

    @Override
    public void withdraw(User user, double amount) {
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance");
        } else {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Withdraw successful. New balance: " + user.getBalance());
        }
    }

    @Override
    public void transfer(User fromUser, String phoneNumber, double amount) {
        for (User receiver : bankAccount.getUsers()) {
            if (receiver.getPhoneNumber().equals(phoneNumber)) {
                if (fromUser.getBalance() < amount) {
                    System.out.println("Insufficient balance");
                    return;
                }
                receiver.setBalance(receiver.getBalance() + amount);
                fromUser.setBalance(fromUser.getBalance() - amount);
                System.out.println("Transfer successful. New balance: " + fromUser.getBalance());
                return;
            }
        }
        System.out.println("Receiver not found");
    }



}
