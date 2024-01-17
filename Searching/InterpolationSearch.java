package Searching;

import java.util.Scanner;

    //Sebuah kelas bernama InterpolationSearch
    public class InterpolationSearch {
        //endeklarasikan metode interpolationSearch. Metode ini menerima dua parameter: array arr yang akan dicari dan nilai target 
        public static int interpolationSearch(int[] arr, int target) {
            // Mendeklarasikan variabel lokal awal dan menginisialisasinya dengan nilai 0.
            int awal = 0;
            //Mendeklarasikan variabel lokal akhir dan menginisialisasinya dengan nilai panjang array dikurangi 1. 
            int akhir= arr.length - 1;

            while (awal <= akhir && target >= arr[awal] && target <= arr[akhir]) { // while akan berlanjut selama
                //Memeriksa apakah indeks awal dan akhir sudah sama. 
                if (awal == akhir) {
                    //Memeriksa apakah nilai elemen pada indeks awal array sama dengan nilai target yang dicari.
                    if (arr[awal] == target) {
                        return akhir;  // Elemen ditemukan, mengembalikan indeks
                    }
                    return -1;  // Elemen tidak ditemukan
                }

                int mid = awal + (((target - arr[awal]) * (akhir- awal)) / (arr[akhir] - arr[awal]));

                if (arr[mid] == target) {
                    return mid;  // Elemen ditemukan, mengembalikan indeks
                }

                //memeriksa apakah nilai pada indeks mid (nilai tengah) dari array kurang dari nilai target yang dicari.
                if (arr[mid] < target) {
                    awal = mid + 1;
                } else {
                    akhir = mid - 1;
                }
            }

            return -1;  // Elemen tidak ditemukan
        }

        public static void main(String[] args) {
            //Sebuah array bertipe int, berisi sepuluh elemen dengan nilai berturut-turut dari 12-90
            int[] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90};

            try (// Membaca nilai yang ingin dicari dari pengguna
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Masukkan nilai yang ingin dicari: ");
                int target = scanner.nextInt();

                // Melakukan pencarian dengan algoritma Interpolation Search
                int result = interpolationSearch(arr, target);

                // Menampilkan hasil pencarian
                if (result != -1) {
                    System.out.println("Elemen " + target + " ditemukan pada indeks " + result + ".");
                } else {
                    System.out.println("Elemen " + target + " tidak ditemukan dalam array.");
                }
            }
        }
    }


