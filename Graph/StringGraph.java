//Mendefinisikan paket (package) dengan nama "Graph".
package Graph;

//Mengimpor semua kelas yang ada dalam paket java.util
import java.util.*;

//Mendeklarasikan kelas StringGraph. 
class StringGraph {
    //Mendeklarasikan atribut adjacencyList sebagai Map yang memiliki kunci bertipe String (simpul) dan nilai bertipe List<String> (daftar tetangga dari simpul tersebut).
    private Map<String, List<String>> adjacencyList;

    //Mendeklarasikan konstruktor tanpa parameter untuk kelas StringGraph
    public StringGraph() {
        //atribut adjacencyList diinisialisasi sebagai objek baru dari kelas HashMap.
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    // Mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    //Mendeklarasikan metode main. Ini adalah metode yang akan dijalankan saat program dimulai.
    public static void main(String[] args) {
        // Membuat objek graph dari kelas StringGraph
        StringGraph graph = new StringGraph();
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
        //Menambahkan tepi antara simpul B dan C.
        graph.addEdge("B", "C");
        //Menambahkan tepi antara simpul C dan A.
        graph.addEdge("C", "A");
        //Menambahkan tepi antara simpul C dan D.
        graph.addEdge("C", "D");

        //Mencetak representasi graf ke dalam konsol menggunakan metode printGraph().
        graph.printGraph();
    }
}