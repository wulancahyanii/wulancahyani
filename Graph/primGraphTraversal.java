//Mendefinisikan paket (package) dengan nama "Graph"
package Graph;

//Mengimpor semua kelas yang ada dalam paket java.util
import java.util.*;

// Mendeklarasikan kelas Edge yang mengimplementasikan antarmuka Comparable
class Edge implements Comparable<Edge> {
    //Kelas ini digunakan untuk merepresentasikan tepi dengan informasi sumber (source),tujuan (destination), dan bobot (weight).
    String source;
    String destination;
    int weight;

    //Mendeklarasikan konstruktor untuk kelas Edge dengan tiga parameter:source (simpul sumber), destination (simpul tujuan), dan weight (bobot atau bobot tepi).
    public Edge(String source, String destination, int weight) {
        //Menginisialisasi atribut source dari objek Edge dengan nilai dari parameter source
        this.source = source;
        //Menginisialisasi atribut destination dari objek Edge dengan nilai dari parameter destination
        this.destination = destination;
        // Menginisialisasi atribut weight dari objek Edge dengan nilai dari parameter weight.
        this.weight = weight;
    }

    //Memberi tahu kompilator bahwa metode di bawahnya akan menggantikan (override) metode yang ada dalam antarmuka atau kelas induknya.
    @Override
    //Mengimplementasikan metode compareTo dari antarmuka Comparable
    public int compareTo(Edge other) {
        //Membandingkan bobot (weight) dari objek Edge saat ini (this) dengan objek Edge lainnya (other)
        return Integer.compare(this.weight, other.weight);
    }
}

//Mendeklarasikan kelas primGraphTraversal
public class primGraphTraversal {

    //Mendeklarasikan atribut adjacencyList sebagai Map yang memiliki kunci bertipe String (simpul) dan nilai bertipe List<Edge> (daftar tepi)
    private Map<String, List<Edge>> adjacencyList;

    //Mendeklarasikan konstruktor untuk kelas primGraphTraversal.
    public primGraphTraversal() {
        //Menginisialisasi atribut adjacencyList sebagai objek baru dari kelas HashMap
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        //adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // Untuk graf tidak terarah
    }

    // Mendapatkan daftar tetangga dan bobot dari node
    // Mendeklarasikan metode getNeighbors yang menerima satu parameter, yaitu node
    public List<Edge> getNeighbors(String node) {
        //Mengembalikan daftar tetangga dari simpul node. Jika simpul tersebut tidak ditemukan dalam adjacencyList, metode ini akan mengembalikan daftar kosong menggunakan Collections.emptyList()
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Algoritma Prim untuk mencari MST
    public void primMST(String start) {
        // PriorityQueue untuk memilih edge dengan bobot terkecil
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        //Mendeklarasikan sebuah set untuk melacak simpul-simpul yang sudah termasuk MST, dengan membuat objek HashSet 
        Set<String> inMST = new HashSet<>();
        //Memndeklarasikan sebuah Map yang digunakan untuk menyimpan informasi mengenai tepi(edges) dengan objek baru bernama new HashMap
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan node awal
        //Menambahkan simpul awal (start) ke dalam himpunan inMST
        inMST.add(start);
        //Memulai perulangan for untuk mengiterasi melalui semua tepi yang terhubung dengan simpul start dalam graf.
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            // Menambahkan tepi (edge) ke dalam PriorityQueue (pq). PriorityQueue akan mengurutkan elemen-elemen berdasarkan bobotnya, sehingga tepi dengan bobot terkecil akan memiliki prioritas tertinggi.
            pq.add(edge);
            // Menambahkan mapping antara tujuan (edge.destination) dan tepi (edge) ke dalam edgeTo (HashMap)
            edgeTo.put(edge.destination, edge);
        }

        int totalWeight = 0; // Variabel untuk menyimpan total bobot
        //Memulai loop while yang akan terus berjalan selama PriorityQueue (pq) tidak kosong.
        while (!pq.isEmpty()) {
            //Mengambil dan menghapus tepi dengan bobot terkecil dari PriorityQueue (pq). poll() akan mengembalikan elemen dengan prioritas tertinggi.
            Edge edge = pq.poll();
            //Memeriksa apakah simpul tujuan dari edge sudah termasuk dalam MST
            if (inMST.contains(edge.destination)) continue;

            inMST.add(edge.destination);
            //Mencetak informasi tentang tepi yang ditambahkan ke MST. Ini mencakup simpul sumber (edgeTo.get(edge.destination).source), simpul tujuan (edge.destination), dan bobot (edge.weight).
            System.out.println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");
            totalWeight += edge.weight; // Menambahkan bobot edge ke total bobot

            //Memulai loop for untuk iterasi melalui semua tepi yang terhubung dengan simpul tujuan (edge.destination) dari tepi sebelumnya.
            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                //Memeriksa apakah simpul tujuan dari nextEdge belum termasuk dalam MST. Jika iya, maka kita pertimbangkan untuk menambahkan tepi ini ke MST.
                if (!inMST.contains(nextEdge.destination)) {
                    //Menambahkan nextEdge ke dalam PriorityQueue (pq). PriorityQueue akan secara otomatis mengurutkan berdasarkan bobotnya, sehingga tepi dengan bobot terkecil akan memiliki prioritas tertinggi.
                    pq.add(nextEdge);
                    //Menambahkan mapping antara simpul tujuan (nextEdge.destination) dan tepi (nextEdge) ke dalam edgeTo
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        //Mencetak total bobot dari Minimum Spanning Tree (MST).
        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot
    }

    //Mendeklarasikan metode main, yang merupakan titik awal dari program Java.
    public static void main(String[] args) {
        //Membuat objek dari kelas primGraphTraversal yang akan digunakan untuk memodelkan dan mengeksekusi algoritma Prim.
        primGraphTraversal graph = new primGraphTraversal();

        // Menambahkan node ke graph
        //Menambahkan simpul "A" ke dalam graph
        graph.addNode("A");
        //Menambahkan simpul "B" ke dalam graph
        graph.addNode("B");
        //Menambahkan simpul "C" ke dalam graph
        graph.addNode("C");
        //Menambahkan simpul "D" ke dalam graph
        graph.addNode("D");
        // Menambahkan simpul "E" ke dalam graph
        graph.addNode("E");

        // menambahkan edge atau sisi ke graph
        //Menambahkan tepi dari "A" ke "B" dengan bobot 6 ke dalam graf.
        graph.addEdge("A", "B", 6);
        // Menambahkan tepi dari "A" ke "D" dengan bobot 4 ke dalam graf.
        graph.addEdge("A", "D", 4);
        //Menambahkan tepi dari "B" ke "C" dengan bobot 7 ke dalam graf.
        graph.addEdge("B", "C", 7);
        //Menambahkan tepi dari "B" ke "E" dengan bobot 10 ke dalam graf.
        graph.addEdge("B", "E", 10);
        //Menambahkan tepi dari "C" ke "D" dengan bobot 8 ke dalam graf.
        graph.addEdge("C", "D", 8);
        //Menambahkan tepi dari "C" ke "E" dengan bobot 5 ke dalam graf.
        graph.addEdge("C", "E", 5);
        // Menambahkan tepi dari "D" ke "E" dengan bobot 3 ke dalam graf.
        graph.addEdge("D", "E", 3);
        
        // menjalankan algoritma prim dengan node random A
        graph.primMST("A");
    }

    
}