//Mendefinisikan paket (package) dengan nama "Graph"
package Graph;

//Mengimpor pustaka utilitas dari Java, termasuk kelas-kelas seperti List, ArrayList, Map
import java.util.*;

// Kelas Edge merepresentasikan sisi dalam graf.
// Implementasi Comparable untuk memungkinkan pembandingan berdasarkan bobot.
class Edge implements Comparable<Edge> {
    String source;       // Node sumber sisi
    String destination;  // Node tujuan sisi
    int weight;          // Bobot sisi

    // Konstruktor untuk membuat sisi baru
    public Edge(String source, String destination, int weight) {
        // Menginisialisasi variabel instance source dengan nilai dari parameter source.
        this.source = source;
        //Menginisialisasi variabel instance destination dengan nilai dari parameter destination
        this.destination = destination;
        //Menginisialisasi variabel instance weight dengan nilai dari parameter weight.
        this.weight = weight;
    }

    // Metode compareTo untuk membandingkan sisi berdasarkan bobotnya.
    // Digunakan untuk pengurutan sisi.
    @Override
    //Digunakan untuk membandingkan sisi berdasarkan bobotnya.
    public int compareTo(Edge other) {
        //Menggunakan metode statis compare dari kelas Integer untuk membandingkan bobot dua sisi.
        return Integer.compare(this.weight, other.weight);
    }
}

// Kelas KruskalGraphTraversal mengimplementasikan algoritma Kruskal untuk mencari Minimum Spanning Tree.
public class KruskalGraphTraversal {
    private List<Edge> edges = new ArrayList<>(); // Daftar untuk menyimpan semua sisi.
    private Map<String, String> parent = new HashMap<>(); // Map untuk menyimpan representasi set (Union-Find).

    // Metode untuk menambahkan sisi ke graf.
    public void addEdge(String source, String destination, int weight) {
        //Menambahkan sisi baru ke dalam daftar edges.
        edges.add(new Edge(source, destination, weight));
    }

    // Metode 'find' untuk Union-Find. Mencari representasi set dari sebuah node.
    // Jika sebuah node tidak memiliki representasi, ia mewakili dirinya sendiri.
    public String find(String node) {
        //Jika node tidak memiliki representasi, maka ditetapkan sebagai representasinya sendiri.
        if (!parent.containsKey(node)) {
            parent.put(node, node);
        }

        // Path Compression: Meningkatkan efisiensi dengan menghubungkan node langsung ke representasi setnya.
        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
        }

        //Mengembalikan representasi set dari node.
        return parent.get(node);
    }

    // Metode 'union' untuk menggabungkan dua set dalam Union-Find.
    public void union(String node1, String node2) {
        //Mencari representasi set dari node1 menggunakan metode find dan menyimpannya dalam variabel parent1.
        String parent1 = find(node1);
        //Mencari representasi set dari node2 menggunakan metode find dan menyimpannya dalam variabel parent2.
        String parent2 = find(node2);
        //Menggabungkan dua set dengan menetapkan representasi set dari parent1 ke parent2.
        parent.put(parent1, parent2);
    }

    // Metode untuk menjalankan algoritma Kruskal dan mencetak Minimum Spanning Tree.
    public void kruskalMST() {
        Collections.sort(edges); // Mengurutkan semua sisi berdasarkan bobot.

        int mstWeight = 0; // Menyimpan total bobot dari MST.
        //Memulai iterasi melalui semua sisi yang telah diurutkan.
        for (Edge edge : edges) {
            //Mencari representasi set dari edge.source menggunakan metode find dan menyimpannya dalam variabel root1.
            String root1 = find(edge.source);
            //Mencari representasi set dari edge.destination menggunakan metode find dan menyimpannya dalam variabel root2.
            String root2 = find(edge.destination);

            // Jika dua node tidak berada dalam set yang sama, tambahkan sisi ke MST dan gabungkan setnya.
            if (!root1.equals(root2)) {
                //Mencetak sisi ke MST dan mencantumkan bobotnya
                System.out.println(edge.source + " - " + edge.destination + " [" + edge.weight + "]");
                // Menambahkan bobot sisi ke total bobot MST.
                mstWeight += edge.weight;
                //Menggabungkan dua set dengan memanggil metode union.
                union(edge.source, edge.destination);
            }
        }

        //Mencetak total bobot dari MST setelah iterasi selesai.
        System.out.println("Total bobot MST: " + mstWeight);
    }

    // Metode main untuk menjalankan algoritma.
    public static void main(String[] args) {
        //Membuat objek dari kelas KruskalGraphTraversal yang akan digunakan untuk memodelkan dan mengeksekusi algoritma Kruskal.
        KruskalGraphTraversal graph = new KruskalGraphTraversal();
        
        // Menambahkan sisi-sisi ke graf.
        //Menambahkan sisi dari "A" ke "B" dengan bobot 6 ke dalam graf.
        graph.addEdge("A", "B", 6);
        //Menambahkan sisi dari "A" ke "D" dengan bobot 4 ke dalam graf.
        graph.addEdge("A", "D", 4);
        //Menambahkan sisi dari "B" ke "C" dengan bobot 7 ke dalam graf.
        graph.addEdge("B", "C", 7);
        //Menambahkan sisi dari "B" ke "E" dengan bobot 10 ke dalam graf.
        graph.addEdge("B", "E", 10);
        //Menambahkan sisi dari "C" ke "D" dengan bobot 8 ke dalam graf.
        graph.addEdge("C", "D", 8);
        //Menambahkan sisi dari "C" ke "E" dengan bobot 5 ke dalam graf.
        graph.addEdge("C", "E", 5);
        //Menambahkan sisi dari "D" ke "E" dengan bobot 3 ke dalam graf.
        graph.addEdge("D", "E", 3);
        
        // Menjalankan algoritma Kruskal.
        graph.kruskalMST();
    }

}