package Searching;

import java.util.Scanner;

    public class Binarysearch { //Nama kelas
        public static int binarySearch(int[] arr, int target) { //Metode ini akan menerima dua parameter: arr, yang merupakan array bilangan bulat yang akan dicari, dan target, yang merupakan nilai yang ingin dicari dalam array.
            int awal= 0;
            int akhir = arr.length - 1;

            while (awal <= akhir) { // menggunakan perulangan while
                int mid = awal+ (akhir - awal) / 2; //Rumus untuk mencari nilai tengah

                if (arr[mid] == target) { // jik nilai tengah sama dengan target
                    return mid; // pencarian berhenti
                } else if (arr[mid] < target) { // jika nilai tengah lebih keci dari target
                    awal = mid + 1;
                } else { // jika nilai tengah lebih besar dari target
                    akhir = mid - 1;
                }
            }

            return -1; // Target tidak ditemukan dalam array
        }

        public static void main(String[] args) { // metode main,titik utama program
            int[] sortedArray = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90}; // data yang akan dicari

            try (// Membaca data yang ingin dicari dari pengguna
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Masukkan data yang ingin dicari: "); // mencetak pesan
                int targetValue = scanner.nextInt(); // nilai disimpan dalam variabel targetValue

                // Melakukan pencarian dengan algoritma Binary Search
                int result = binarySearch(sortedArray, targetValue);

                // Menampilkan hasil pencarian
                if (result != -1) { // jika target ditemukan
                    System.out.println("Target " + targetValue + " ditemukan di indeks " + result + ".");
                } else { // jika target tidak ditemukan
                    System.out.println("Target " + targetValue + " tidak ditemukan dalam array.");
                }
            }
        }
    }


