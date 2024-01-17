//Mendeklarasikan bahwa kelas ini berada dalam paket (package) dengan nama "Graph".
package Graph;

//Mengimpor seluruh kelas dari paket java.util, yang termasuk kelas-kelas dasar dan struktur data seperti Map dan List
import java.util.*;

//Mendefinisikan kelas DirectedGraph
class DirectedGraph {
    // Mendeklarasikan variabel adjacencyList sebagai Map yang menggunakan String sebagai kunci (key) dan List<String> sebagai nilai (value).
    private Map<String, List<String>> adjacencyList;

    //Mendefinisikan konstruktor kelas DirectedGraph
    public DirectedGraph() {
        //Inisialisasi variabel adjacencyList sebagai objek baru dari kelas HashMap
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf (hanya satu arah untuk graf berarah)
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Mendapatkan daftar tetangga dari node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Mencetak graf
    //Mendefinisikan metode printGraph
    public void printGraph() {
        // Memulai loop for yang akan mengiterasi melalui setiap kunci (node) dalam adjacencyList
        for (String node : adjacencyList.keySet()) {
            //Mencetak teks yang menunjukkan node saat ini dan mempersiapkan untuk mencetak tetangga (neighbor) dari node tersebut.
            System.out.print("Node " + node + " terhubung dengan: ");
            //Memulai loop for dalam loop utama untuk mengiterasi melalui setiap tetangga dari node saat ini.
            for (String neighbor : adjacencyList.get(node)) {
                //Mencetak tetangga saat ini ke konsol, diikuti dengan spasi.
                System.out.print(neighbor + " ");
            }
            //indah baris untuk memisahkan output untuk setiap node. Ini membuat hasil cetakan menjadi lebih mudah dibaca.
            System.out.println();
        }
    }

    //Mendefinisikan metode main sebagai titik masuk program.
    public static void main(String[] args) {
        //Membuat objek dari kelas DirectedGraph yang akan digunakan untuk memodelkan graf berarah
        DirectedGraph graph = new DirectedGraph();
        //Menambahkan node "A" ke dalam graf
        graph.addNode("A");
        // Menambahkan node "B" ke dalam graf.
        graph.addNode("B");
        //Menambahkan node "C" ke dalam graf.
        graph.addNode("C");
        //Menambahkan node "D" ke dalam graf.
        graph.addNode("D");

        //Menambahkan edge dari "A" ke "B" ke dalam graf.
        graph.addEdge("A", "B");
        //Menambahkan edge dari "A" ke "C" ke dalam graf.
        graph.addEdge("A", "C");
        //Menambahkan edge dari "B" ke "C" ke dalam graf.
        graph.addEdge("B", "C");
        //Menambahkan edge dari "C" ke "A" ke dalam graf.
        graph.addEdge("C", "A");
        //Menambahkan edge dari "C" ke "D" ke dalam graf.
        graph.addEdge("C", "D");

        //Memanggil metode printGraph() pada objek graph untuk mencetak struktur graf.
        graph.printGraph();
    }
}