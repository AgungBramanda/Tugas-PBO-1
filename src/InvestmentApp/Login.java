package InvestmentApp;

import java.util.HashMap;
import java.util.Map;

public class Login {
    private static final Map<String, String> adminAccounts = new HashMap<String, String>();
    private static final Map<String, String> customerAccounts = new HashMap<String, String>();

    static {
        adminAccounts.put("admin", "admin123");       // Username admin: admin, Password: admin123
        customerAccounts.put("customer", "cust123");   // Username customer: customer, Password: cust123
    }

    public static String login(String username, String password) {
        if (adminAccounts.containsKey(username) && adminAccounts.get(username).equals(password)) {
            return "admin";
        }
        if (customerAccounts.containsKey(username) && customerAccounts.get(username).equals(password)) {
            return "customer";
        }
        return "gagal";
    }
}
