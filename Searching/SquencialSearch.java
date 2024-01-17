package Searching;


import java.util.Scanner;

//Mendeklarasikan kelas SequentialSearch.
public class SquencialSearch{
    //Mendeklarasikan metode sequentialSearch. Metode ini menerima dua parameter: array arr yang akan dicari dan nilai target yang dicari di dalam array.
    public static int sequentialSearch(int[] arr, int target) {
        //Memulai loop for untuk mengiterasi melalui setiap elemen dalam array arr. Variabel i digunakan sebagai indeks iterasi.
        for (int i = 0; i < arr.length; i++) {
            //Memeriksa apakah elemen saat ini (arr[i]) sama dengan nilai target yang dicari.
            if (arr[i] == target) {
                return i;  // Elemen ditemukan, mengembalikan indeks
            }
        }
        return -1;  // Elemen tidak ditemukan
    }

    public static void main(String[] args) {
        //Sebuah array bertipe int, berisi sepuluh elemen dengan nilai berturut-turut dari 12-90
        int[] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90};

        try (// Membaca angka yang ingin dicari dari pengguna
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            // Mencari elemen dalam array
            int result = sequentialSearch(arr, target);

            // Menampilkan hasil pencarian
            if (result != -1) {
                System.out.println("Elemen " + target + " ditemukan pada indeks " + result + ".");
            } else {
                System.out.println("Elemen " + target + " tidak ditemukan dalam array.");
            }
        }
    }
}

