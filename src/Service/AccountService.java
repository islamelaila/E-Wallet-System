package Service;

import Model.User;

public interface AccountService {

   boolean createAccount(User user);

   User getAccount(User user);

   void deposit(User user, double amount);

   void withdraw(User user, double amount);

   void transfer(User fromUser, String phoneNumber, double amount);

}