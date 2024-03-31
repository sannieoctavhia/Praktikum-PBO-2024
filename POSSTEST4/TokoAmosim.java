package POSSTEST4;

import java.util.ArrayList;
import java.util.Scanner;

class Merchandise {
    private String nama;  
    private double harga; 

    public Merchandise(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public Merchandise(String nama) {
        this.nama = nama;
        this.harga = 0.0;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return "Nama : " + nama + ", Harga : $ " + harga;
    }
}

class ProdukMerchandise extends Merchandise {
    private String jenis;

    public ProdukMerchandise(String nama, double harga, String jenis) {
        super(nama, harga);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis : " + jenis;
    }
}

// Penjelasan Polimorfisme
// class Merchandise memiliki dua konstruktor yang berbeda untuk mendukung overloading.
// Selain itu, metode toString() di class Merchandise di-override di class ProdukMerchandise 
// untuk mendukung polimorfisme. Metode toString() akan memberikan representasi string dari objek Merchandise
// sesuai dengan class yang digunakan.

public class TokoAmosim {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Merchandise> daftarProduk = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("=== SISTEM PENDATAAN PRODUK GHIBLI MERCHANDISE DI AMO'SIM STUDIO ===");
            System.out.println("====================================================================");
            System.out.println("1 | Tambah Produk");
            System.out.println("2 | Lihat Produk");
            System.out.println("3 | Update Produk");
            System.out.println("4 | Hapus Produk");
            System.out.println("5 | Exit ");
            System.out.println("====================================================================");

            System.out.println("Masukkan pilihan menu : ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahProduk(daftarProduk, scanner);
                    break;
                case 2:
                    lihatProduk(daftarProduk);
                    break;
                case 3:
                    updateProduk(daftarProduk, scanner);
                    break;
                case 4:
                    hapusProduk(daftarProduk, scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program~ silahkan datang kembali!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan pilih menu 1-5");
            }
        } while (pilihan != 5);
    }

    private static void tambahProduk(ArrayList<Merchandise> daftarProduk, Scanner scanner) {
        System.out.println("---------------------------------------");
        System.out.println("----------Masukkan nama produk--------- : ");
        String nama = scanner.next();
        System.out.println("---------------------------------------");
        System.out.println("--------Masukkan harga produk---------- : ");
        double harga = scanner.nextDouble();
        System.out.println("--------Masukkan jenis produk---------- : ");
        String jenis = scanner.next();

        ProdukMerchandise produkBaru = new ProdukMerchandise(nama, harga, jenis);
        daftarProduk.add(produkBaru);

        System.out.println("Produk berhasil ditambahkan");
    }

    private static void lihatProduk(ArrayList<Merchandise> daftarProduk) {
        if (daftarProduk.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            System.out.println("Daftar produk : ");
            for (Merchandise produk : daftarProduk) {
                System.out.println(produk);
            }
        }
    }

    private static void updateProduk(ArrayList<Merchandise> daftarProduk, Scanner scanner) {
        lihatProduk(daftarProduk);

        if (!daftarProduk.isEmpty()) {
            System.out.println("Masukkan nomor produk yang akan diupdate : ");
            int nomorProduk = scanner.nextInt();

            if (nomorProduk >= 1 && nomorProduk <= daftarProduk.size()) {
                System.out.println("Masukkan nama produk baru : ");
                String nama = scanner.next();
                System.out.println("Masukkan harga produk baru : ");
                double harga = scanner.nextDouble();
                System.out.println("Masukkan jenis produk baru : ");
                String jenis = scanner.next();

                ProdukMerchandise produkUpdate = new ProdukMerchandise(nama, harga, jenis);
                daftarProduk.set(nomorProduk - 1, produkUpdate);

                System.out.println("Produk berhasil diupdate.");
            } else {
                System.out.println("Nomor produk tidak valid.");
            }
        }
    }

    private static void hapusProduk(ArrayList<Merchandise> daftarProduk, Scanner scanner) {
        lihatProduk(daftarProduk);

        if (!daftarProduk.isEmpty()) {
            System.out.println("Masukkan nomor produk yang ingin dihapus : ");
            int nomorProduk = scanner.nextInt();

            if (nomorProduk >= 1 && nomorProduk <= daftarProduk.size()) {
                daftarProduk.remove(nomorProduk - 1);
                System.out.println("Produk berhasil dihapus.");
            } else {
                System.out.println("Nomor produk tidak valid.");
            }
        }
    }
}
