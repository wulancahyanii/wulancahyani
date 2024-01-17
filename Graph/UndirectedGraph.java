//Mendefinisikan paket (package) dengan nama "Graph"
package Graph;

//Mengimpor semua kelas yang ada dalam paket java.util, yang mencakup berbagai kelas dan antarmuka yang mendukung koleksi, seperti List dan Map.
import java.util.*;

//Mendeklarasikan kelas UndirectedGraph. Kelas ini akan digunakan untuk merepresentasikan graf tidak terarah.
class UndirectedGraph {
    //Mendeklarasikan atribut adjacencyList sebagai Map yang memiliki kunci bertipe String (simpul) dan nilai bertipe List<String>.
    private Map<String, List<String>> adjacencyList;

    //Mendeklarasikan konstruktor tanpa parameter untuk kelas UndirectedGraph
    public UndirectedGraph() {
        //atribut adjacencyList diinisialisasi sebagai objek baru dari kelas HashMap.
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf (tambahkan di kedua arah untuk graf tidak terarah)
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Mendapatkan daftar tetangga dari node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Mendeklarasikan metode printGraph untuk Mencetak representasi graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    //Mendeklarasikan metode main
    public static void main(String[] args) {
        //atribut adjacencyList diinisialisasi sebagai objek baru dari kelas HashMap.
        UndirectedGraph graph = new UndirectedGraph();
        //Menambahkan simpul A ke dalam graf.
        graph.addNode("A");
        //Menambahkan simpul B ke dalam graf.
        graph.addNode("B");
        //Menambahkan simpul C ke dalam graf.
        graph.addNode("C");
        //Menambahkan simpul D ke dalam graf.
        graph.addNode("D");

        //Menambahkan tepi antara simpul A dan B.
        graph.addEdge("A", "B");
        //Menambahkan tepi antara simpul A dan C.
        graph.addEdge("A", "C");
        //Menambahkan tepi antara simpul A dan C.
        graph.addEdge("B", "C");
        //Menambahkan tepi antara simpul C dan D.
        graph.addEdge("C", "D");

        //Mencetak representasi graf ke dalam konsol menggunakan metode printGraph().
        graph.printGraph();
    }
}