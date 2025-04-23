package InvestmentApp;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private static List<Saham> sahamList = new ArrayList<Saham>();
    private static List<SuratBerhargaNegara> sbnList = new ArrayList<SuratBerhargaNegara>();

    static {
        sahamList.add(new Saham("TLKM", "Telkom Indonesia", 4000));
        sahamList.add(new Saham("BBCA", "Bank Central Asia", 8500));
        sahamList.add(new Saham("BBRI", "Bank Rakyat Indonesia", 5000));

        sbnList.add(new SuratBerhargaNegara("ORI", 6.5, 3, "2028-05-01", 1000000000));
        sbnList.add(new SuratBerhargaNegara("SBR", 6.0, 2, "2027-05-01", 800000000));
        sbnList.add(new SuratBerhargaNegara("ST", 5.5, 2, "2027-05-01", 600000000));
    }

    public void menu() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            System.out.println("=== Menu Admin ===");
            Menu.adminMenu();
            int pilihan = Input.nextInt("Pilih: ");

            switch (pilihan) {
                case 1:
                    tambahSaham();
                    break;
                case 2:
                    ubahHargaSaham();
                    break;
                case 3:
                    tambahSBN();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void tambahSaham() {
        String kode = Input.nextLine("Kode Saham: ");
        String nama = Input.nextLine("Nama Perusahaan: ");
        int harga = Input.nextInt("Harga: ");
        sahamList.add(new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan!");
    }

    private void ubahHargaSaham() {
        View.showSahamList(sahamList);
        String kode = Input.nextLine("Masukkan kode saham: ");
        for (int i = 0; i < sahamList.size(); i++) {
            Saham s = sahamList.get(i);
            if (s.getKode().equalsIgnoreCase(kode)) {
                int hargaBaru = Input.nextInt("Harga baru: ");
                s.setHarga(hargaBaru);
                System.out.println("Harga saham berhasil diubah!");
                return;
            }
        }
        System.out.println("Saham tidak ditemukan!");
    }

    private void tambahSBN() {
        String nama = Input.nextLine("Nama SBN: ");
        double bunga = Double.parseDouble(Input.nextLine("Bunga (%): "));
        int jangka = Input.nextInt("Jangka Waktu (tahun): ");
        String jatuhTempo = Input.nextLine("Tanggal Jatuh Tempo (yyyy-MM-dd): ");
        int kuota = Input.nextInt("Kuota Nasional: ");
        sbnList.add(new SuratBerhargaNegara(nama, bunga, jangka, jatuhTempo, kuota));
        System.out.println("SBN berhasil ditambahkan!");
    }

    public static List<Saham> getSahamList() {
        return sahamList;
    }

    public static List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }
}