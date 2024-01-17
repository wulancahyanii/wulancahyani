package Sorting;

/**
 * Kelas yang menyediakan metode untuk mengurutkan array menggunakan algoritma Insertion Sort.
 */
public class InsertionSort {

    /**
     * Metode untuk mengurutkan array integer menggunakan algoritma Insertion Sort.
     *
     * @param array Array of integers yang akan diurutkan.
     * @return Array yang sudah diurutkan.
     */
    public static int[] insertion(int[] array) {
        //Mendeklarasikan variabel ukuran dan menginisialisasinya dengan panjang (jumlah elemen) dari array yang diberikan. 
        int ukuran = array.length;
        //Mendeklarasikan dua variabel integer, yaitu max dan j.
        int max, j;
        //Mendeklarasikan dan menginisialisasi variabel i dengan nilai 1. 
        int i = 1;

        while (i < ukuran) {
            max = array[i];
            j = i;
            // Pindahkan elemen yang lebih besar dari max satu posisi ke kanan
            while (j > 0 && array[j - 1] > max) {
                //Nilai dari elemen di sebelah kiri dari posisi saat ini (array[j - 1]) dipindahkan ke posisi saat ini (array[j]).
                array[j] = array[j - 1];
                //ndeks j dikurangi satu untuk melanjutkan proses penyisipan ke elemen sebelah kiri yang lebih rendah.
                j--;
            }
            // Letakkan max di posisi yang tepat
            array[j] = max;
            //menetapkan nilai max ke dalam posisi yang benar, indeks i ditingkatkan.
            i++;
        }
        //Mengembalikan array yang telah diurutkan
        return array;
    }

    /**
     * Metode utama yang menjalankan program.
     */
    public static void main(String[] args) {
        //Mendeklarasikan dan menginisialisasi array dengan nama array yang berisi nilai { 9, 5, 1, 4, 3 }. 
        int[] array = { 9, 5, 1, 4, 3 };
        //Memanggil metode insertion dengan menggunakan array array sebagai argumen. Hasil pengembalian dari metode insertion disimpan dalam array sortedArray.
        int[] sortedArray = insertion(array);
        
        // Mencetak array yang sudah diurutkan
        System.out.println("Sorted array:");
        //digunakan untuk mengiterasi melalui setiap elemen dalam array sortedArray. Setiap elemen diwakili oleh variabel value.
        for (int value : sortedArray) {
            //Mencetak nilai value (elemen dari array) diikuti oleh spasi ke konsol. 
            System.out.print(value + " ");
        }
    }
}