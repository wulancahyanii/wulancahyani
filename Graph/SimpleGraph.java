//Mendefinisikan paket (package) dengan nama "Graph".
package Graph;

// Mengimpor semua kelas yang ada dalam paket java.util
import java.util.*;

//Mendeklarasikan kelas SimpleGraph
class SimpleGraph {
    //Mendeklarasikan atribut adjacencyList sebagai Map yang memiliki kunci bertipe Integer (simpul) dan nilai bertipe List<Integer> (daftar tetangga dari simpul tersebut).
    private Map<Integer, List<Integer>> adjacencyList;

    //Mendeklarasikan konstruktor tanpa parameter untuk kelas SimpleGraph
    public SimpleGraph() {
        //atribut adjacencyList diinisialisasi sebagai objek baru dari kelas HashMap.
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    // Mendapatkan daftar tetangga dari node
    public List<Integer> getNeighbors(int node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Mencetak graf
    public void printGraph() {
        for (int node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    //Mendeklarasikan metode main. Ini adalah metode yang akan dijalankan saat program dimulai.
    public static void main(String[] args) {
        //Membuat objek graph dari kelas SimpleGraph. Ini adalah representasi dari graf sederhana dengan simpul bertipe Integer yang akan kita gunakan.
        SimpleGraph graph = new SimpleGraph();
        //Menambahkan simpul 0 ke dalam graf.
        graph.addNode(0);
        //Menambahkan simpul 1 ke dalam graf.
        graph.addNode(1);
        //Menambahkan simpul 2 ke dalam graf.
        graph.addNode(2);
        //Menambahkan simpul 3 ke dalam graf.
        graph.addNode(3);

        //Menambahkan tepi antara simpul 0 dan 1.
        graph.addEdge(0, 1);
        //Menambahkan tepi antara simpul 0 dan 2.
        graph.addEdge(0, 2);
        //Menambahkan tepi antara simpul 1 dan 2.
        graph.addEdge(1, 2);
        //Menambahkan tepi antara simpul 2 dan 0.
        graph.addEdge(2, 0);
        //Menambahkan tepi antara simpul 2 dan 3.
        graph.addEdge(2, 3);

        //Mencetak representasi graf ke dalam konsol menggunakan metode printGraph().
        graph.printGraph();
    }
}