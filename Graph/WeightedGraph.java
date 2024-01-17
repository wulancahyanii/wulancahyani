//Graph berbobot untuk directed graph

//Mendefenisikan package dengan nama Graph
package Graph;
//Mengimpor semua kelas yang ada dalam paket java.util
import java.util.*;

//Mendefinisikan kelas Edge yang akan merepresentasikan tepi (edge) dalam graf. 
class Edge {
    //Mendefinisikan atribut-atribut kelas Edge, yaitu destination untuk menyimpan tujuan dari tepi dan weight untuk menyimpan bobot dari tepi.
    String destination;
    int weight;

    //Membuat konstruktor untuk kelas Edge yang menerima dua parameter (destination dan weight)
    public Edge(String destination, int weight) {
        // nilai yang di teruskan sebagai parameter konstruktor destination
        this.destination = destination;
        //nilai yang di teruskan sebagai parameter konstruktor weight
        this.weight = weight;
    }
}
// Deklarasi kelas WeightedGraph
class WeightedGraph {
    //Mendeklarasikan atribut adjacencyList sebagai tipe data Map yang memiliki kunci bertipe String dan nilai bertipe List<Edge> 
    private Map<String, List<Edge>> adjacencyList;

    //Mendeklarasikan konstruktor tanpa parameter untuk kelas WeightedGraph. 
    public WeightedGraph() {
        //atribut adjacencyList diinisialisasi sebagai objek baru dari kelas HashMap
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Mendeklarasikan metode printGraph
    public void printGraph() {
        //Memulai iterasi melalui kunci (simpul) dari adjacencyList. Dengan menggunakan adjacencyList.keySet(),kita dapat mengakses setiap simpul dalam graf.
        for (String node : adjacencyList.keySet()) {
            //Mencetak pesan yang menunjukkan simpul yang sedang diproses, yaitu "Node [node] terhubung dengan: ".
            System.out.print("Node " + node + " terhubung dengan: ");
            //Memulai iterasi melalui setiap tepi (edge) yang terhubung dengan simpul yang sedang diproses.
            for (Edge edge : adjacencyList.get(node)) {
                //Mencetak informasi mengenai setiap tepi yang terhubung dengan simpul. Ini mencakup tujuan (edge.destination) dan bobot (edge.weight) dari tepi tersebut.
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            //Mencetak baris kosong setelah selesai mencetak informasi untuk satu simpul
            System.out.println();
        }
    }

    //Mendeklarasikan metode utama (main),Parameter String[] args adalah argumen baris perintah yang dapat diteruskan ke program
    public static void main(String[] args) {
        //Membuat objek graph dari kelas WeightedGraph. Ini adalah representasi dari graf berbobot yang akan kita gunakan.
        WeightedGraph graph = new WeightedGraph();
        //Menambahkan simpul A ke dalam graf.
        graph.addNode("A");
        // Menambahkan simpul B ke dalam graf.
        graph.addNode("B");
        //Menambahkan simpul C ke dalam graf.
        graph.addNode("C");
        //Menambahkan simpul D ke dalam graf.
        graph.addNode("D");

        //Menambahkan tepi berbobot 5 antara simpul A dan B.
        graph.addEdge("A", "B", 5);
        //Menambahkan tepi berbobot 3 antara simpul A dan C.
        graph.addEdge("A", "C", 3);
        //Menambahkan tepi berbobot 2 antara simpul B dan C.
        graph.addEdge("B", "C", 2);
        //Menambahkan tepi berbobot 4 antara simpul C dan D.
        graph.addEdge("C", "D", 4);

        //Mencetak representasi graf berbobot ke dalam konsol menggunakan metode printGraph()
        graph.printGraph();
    }
}