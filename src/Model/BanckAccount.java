package Model;

import java.util.ArrayList;
import java.util.List;

public class BanckAccount {

    private static final String name = "E-WalletSystem" ;

    private static List<User> users = new ArrayList<>();


    // getters and setters

    public static String getName() {
        return name;
    }

    public static List<User>  getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
