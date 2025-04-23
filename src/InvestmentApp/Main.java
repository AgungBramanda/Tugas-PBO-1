package InvestmentApp;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            System.out.println("=== Aplikasi Investasi ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");

            int pilihan = Input.nextInt("Pilih: ");

            switch (pilihan) {
                case 1:
                    String username = Input.nextLine("Username: ");
                    String password = Input.nextLine("Password: ");

                    String role = String.valueOf(Login.login(username, password));

                    if (role.equals("admin")) {
                        Admin admin = new Admin();
                        admin.menu();
                    } else if (role.equals("customer")) {
                        Customer customer = new Customer();
                        customer.menu();
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                        Input.pressEnter();
                    }
                    break;
                case 2:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
