import java.util.Scanner;

public class BubbleSortChallenge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Validasi input jumlah data
        int n;
        do {
            System.out.print("Masukkan jumlah data: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.println("Jumlah data harus lebih dari 0. Silakan coba lagi.");
            }
        } while (n <= 0);

        input.nextLine(); // membersihkan buffer

        // 3. Memilih tipe data: Integer atau String
        System.out.print("Apakah data berupa angka atau nama? (angka/nama): ");
        String tipe = input.nextLine();

        // 2. Memilih mode pengurutan
        System.out.print("Pilih mode pengurutan (asc/desc): ");
        String mode = input.nextLine();

        int jumlahPertukaran = 0;
        int jumlahPerbandingan = 0;

        if (tipe.equalsIgnoreCase("angka")) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Masukkan data ke-" + (i + 1) + ": ");
                data[i] = input.nextInt();
            }

            // Bubble Sort angka
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    jumlahPerbandingan++;
                    boolean condition = mode.equalsIgnoreCase("asc") ? data[j] > data[j + 1] : data[j] < data[j + 1];
                    if (condition) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                        jumlahPertukaran++;
                    }
                }
            }

            System.out.println("\nHasil pengurutan:");
            for (int num : data) {
                System.out.print(num + " ");
            }

        } else if (tipe.equalsIgnoreCase("nama")) {
            String[] data = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Masukkan nama ke-" + (i + 1) + ": ");
                data[i] = input.nextLine();
            }

            // Bubble Sort String (menggunakan compareTo)
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    jumlahPerbandingan++;
                    boolean condition = mode.equalsIgnoreCase("asc")
                            ? data[j].compareToIgnoreCase(data[j + 1]) > 0
                            : data[j].compareToIgnoreCase(data[j + 1]) < 0;
                    if (condition) {
                        String temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                        jumlahPertukaran++;
                    }
                }
            }

            System.out.println("\nHasil pengurutan:");
            for (String name : data) {
                System.out.print(name + " ");
            }

        } else {
            System.out.println("Tipe data tidak dikenali. Gunakan 'angka' atau 'nama'.");
        }

        System.out.println("\n\nJumlah pertukaran: " + jumlahPertukaran);
        System.out.println("Jumlah perbandingan: " + jumlahPerbandingan);

        input.close();
    }
}
