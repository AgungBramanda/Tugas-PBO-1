package InvestmentApp;

import java.util.ArrayList;
import java.util.List;

public class Login {
    private static List<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new Account("admin", "admin123", "admin"));
        accounts.add(new Account("customer", "cust123", "customer"));
    }

    public static Account login(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }
}