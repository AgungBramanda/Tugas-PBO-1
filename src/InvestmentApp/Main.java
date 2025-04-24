package InvestmentApp;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Clear.clearScreen();
            System.out.println("+==================================+");
            System.out.println("|      Aplikasi Investasi         |");
            System.out.println("+==================================+");
            System.out.println("| 1. Login                        |");
            System.out.println("| 2. Keluar                       |");
            System.out.println("+==================================+");

            int pilihan = Input.nextInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    loginProcess();
                    break;
                case 2:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi investasi!");
                    Input.pressEnter();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    Input.pressEnter();
            }
        }
    }

    private static void loginProcess() {
        Clear.clearScreen();
        String username = Input.nextLine("Username: ");
        String password = Input.nextLine("Password: ");

        String role = Login.login(username, password);

        if (role.equals("admin")) {
            Admin admin = new Admin();
            admin.menu();
        } else if (role.equals("customer")) {
            Customer customer = new Customer();
            customer.menu();
        } else {
            System.out.println("+==================================+");
            System.out.println("|  Login gagal!                  |");
            System.out.println("|  Username atau password salah. |");
            System.out.println("+==================================+");
            Input.pressEnter();
        }
    }
}
