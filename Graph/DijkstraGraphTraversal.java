//Mendeklarasikan bahwa kelas ini berada dalam paket (package) dengan nama "Graph"
package Graph;

//Mengimpor seluruh kelas dari paket java.util, yang termasuk kelas-kelas dasar dan struktur data seperti List
import java.util.*;

//Mendefinisikan kelas Sisi
class Sisi {
    //Mendeklarasikan variabel instance destination yang akan menyimpan tujuan dari sisi
    String destination;
    //Mendeklarasikan variabel instance weight yang akan menyimpan bobot dari sisi.
    int weight;

    // Mendefinisikan konstruktor untuk kelas Sisi. Konstruktor ini akan digunakan untuk membuat objek sisi dengan tujuan dan bobot yang diberikan
    public Sisi(String destination, int weight) {
        //Menginisialisasi variabel instance destination dengan nilai yang diberikan saat pembuatan objek
        this.destination = destination;
        //Menginisialisasi variabel instance weight dengan nilai yang diberikan saat pembuatan objek
        this.weight = weight;
    }
}

//Mendeklarasikan kelas DijkstraGraphTraversal
public class DijkstraGraphTraversal {
    //Mendeklarasikan variabel instance adjacencyList, yang merupakan sebuah Map yang menggunakan String sebagai kunci (node) dan List<Sisi>
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    //Mendeklarasikan metode addNode yang digunakan untuk menambahkan node ke graf
    public void addNode(String node) {
        //Menambahkan node ke adjacencyList jika node tersebut belum ada dalam map
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    //Mendeklarasikan metode dijkstra yang menerima dua parameter string start dan end, merepresentasikan node awal dan node akhir
    public int dijkstra(String start, String end) {
        //Mendeklarasikan sebuah PriorityQueue (pq) yang berisi Map.Entry yang berupa pasangan (node, jarak). Dalam hal ini, node diurutkan berdasarkan nilai (jarak)
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        //Mendeklarasikan Map (distances) untuk menyimpan jarak terpendek dari node awal ke setiap node lain dalam graf
        Map<String, Integer> distances = new HashMap<>();
        //Mendeklarasikan sebuah Set (settled) untuk menyimpan node yang sudah di-settle, yaitu node yang jarak terpendeknya sudah ditentukan
        Set<String> settled = new HashSet<>();

        //Menginisialisasi semua node dalam distances dengan nilai tak terhingga (Integer.MAX_VALUE), kecuali node awal (start) yang diatur menjadi 0
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        //Menambahkan entri awal ke PriorityQueue dengan node awal (start) dan jarak 0
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        //Memulai loop yang akan berjalan selama PriorityQueue belum kosong
        while (!pq.isEmpty()) {
            //Mengambil dan menghapus entri teratas dari PriorityQueue, dan mendapatkan node yang sedang dievaluasi
            String current = pq.poll().getKey();
            //Jika node yang sedang dievaluasi adalah node akhir, mengembalikan jarak terpendek ke node akhir
            if (current.equals(end)) {
                return distances.get(end);
            }

            //ika node yang sedang dievaluasi sudah di-settle, lanjut ke iterasi selanjutnya
            if (settled.contains(current)) {
                continue;
            }
            //Menambahkan node yang sedang dievaluasi ke dalam settled, menandakan bahwa jarak terpendeknya sudah ditentukan
            settled.add(current);

            //Iterasi melalui semua sisi yang terhubung dengan node yang sedang dievaluasi
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                //Jika node tujuan sisi belum di-settle, lanjutkan evaluasi
                if (!settled.contains(edge.destination)) {
                    //Menghitung jarak baru ke node tujuan
                    int newDistance = distances.get(current) + edge.weight;
                    // Jika jarak baru lebih kecil dari jarak yang sudah ada, perbarui nilai jarak dan tambahkan entri baru ke PriorityQueue dengan node tujuan dan jarak baru
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        //Mengembalikan jarak terpendek dari node awal (start) ke node akhir (end)
        return distances.get(end);
    }

    //Mendeklarasikan metode main, yang merupakan metode utama yang akan dijalankan saat program dimulai
    public static void main(String[] args) {
        //Membuat objek baru dari kelas DijkstraGraphTraversal yang akan digunakan untuk membangun dan menjalankan algoritma dijkstra
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();
        
        //Menambahkan sisi dari node "A" ke node "B" dengan bobot 6 ke graf
        graph.addEdge("A", "B", 6);
        //Menambahkan sisi dari node "A" ke node "D" dengan bobot 4 ke graf
        graph.addEdge("A", "D", 4);
        //Menambahkan sisi dari node "B" ke node "C" dengan bobot 7 ke graf
        graph.addEdge("B", "C", 7);
        //Menambahkan sisi dari node "C" ke node "E" dengan bobot 5 ke graf
        graph.addEdge("C", "E", 5);
        //Menambahkan sisi dari node "D" ke node "E" dengan bobot 3 ke graf
        graph.addEdge("D", "E", 3);
        // Menambahkan sisi dari node "D" ke node "B" dengan bobot 12 ke graf
        graph.addEdge("D", "B", 12);
        //Menambahkan sisi dari node "A" ke node "E" dengan bobot 8 ke graf
        graph.addEdge("A", "E", 8);
        //Menambahkan sisi dari node "B" ke node "E" dengan bobot 10 ke graf.
        graph.addEdge("B", "E", 10);
        
        //Menjalankan algoritma Dijkstra untuk menghitung jarak terpendek dari node "A" ke node "E" dan menyimpan hasilnya dalam variabel distance
        int distance = graph.dijkstra("A", "E");
        //Mencetak hasil jarak terpendek dari node awal ("A") ke node akhir ("E").
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}