//Mendefinisikan paket (package) di mana kelas ini berada, yaitu dalam paket "Graph"
package Graph;

//Mengimpor paket utilitas dari Java, yang mencakup kelas-kelas seperti Map, List, dan HashMap
import java.util.*;

//Mendefinisikan kelas Edges, yang merepresentasikan sisi (edge) dalam graf. Setiap sisi memiliki tujuan (destination) dan bobot (weight).
class Edges {
    //Mendeklarasikan variabel instance destination yang merupakan tujuan dari suatu sisi
    String destination;
    //Mendeklarasikan variabel instance weight yang merupakan bobot dari suatu sisi.
    int weight;

    // Mendefinisikan konstruktor untuk membuat objek Edges baru dengan tujuan dan bobot yang diberikan.
    public Edges(String destination, int weight) {
        //Menginisialisasi variabel instance destination dengan nilai yang diberikan dalam konstruktor
        this.destination = destination;
        //Menginisialisasi variabel instance weight dengan nilai yang diberikan dalam konstruktor
        this.weight = weight;
    }
}

// Mendeklarasikan variabel instance adjacencyList yang merupakan representasi dari adjacency list untuk graf. Setiap node memiliki daftar sisi yang terhubung dengan node tersebut.
public class BfsGraphTraversal {
    private Map<String, List<Edges>> adjacencyList;

    //Mendefinisikan konstruktor untuk membuat objek BfsGraphTraversal. Dalam konstruktor, adjacency list diinisialisasi sebagai HashMap.
    public BfsGraphTraversal() {
        //Menginisialisasi adjacencyList sebagai objek HashMap saat objek BfsGraphTraversal dibuat
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
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Mendapatkan daftar tetangga dan bobot dari node
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // BFS traversal dari node sumber
    public void bfsTraversal(String start) {
        //Membuat objek HashSet dengan tipe data String untuk menyimpan node yang telah dikunjungi selama traversal.
        Set<String> visited = new HashSet<>();
        //Membuat objek LinkedList dengan tipe data String sebagai antrian (queue) untuk menyimpan node-node yang akan dikunjungi.
        Queue<String> queue = new LinkedList<>();

        //Menambahkan node start ke dalam antrian queue. Langkah ini menandakan dimulainya traversal dari node start
        queue.add(start);
        // Menambahkan node start ke dalam set visited. Ini menandakan bahwa node start telah dikunjungi
        visited.add(start);

        //Memulai loop while yang akan berjalan selama antrian queue tidak kosong.
        while (!queue.isEmpty()) {
            //Mengambil dan menghapus node yang berada di depan antrian queue dan menyimpannya dalam variabel current
            String current = queue.poll();
            //Mencetak node current ke layar. Langkah ini menggambarkan node yang sedang diolah pada iterasi saat ini
            System.out.print(current + " ");

            // Menambahkan semua tetangga yang belum dikunjungi ke antrian
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                    //System.out.print("-> (" + edge.weight + ") " + edge.destination + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Membuat objek BfsGraphTraversal dengan nama graph. Ini merupakan langkah untuk memulai penggunaan kelas tersebut.
        BfsGraphTraversal graph = new BfsGraphTraversal();
        //Memanggil metode addNode("A") pada objek graph. Metode ini menambahkan node "A" ke dalam graf
        graph.addNode("A");
        //Memanggil metode addNode("B") pada objek graph. Metode ini menambahkan node "B" ke dalam graf
        graph.addNode("B");
        //Memanggil metode addNode("C") pada objek graph. Metode ini menambahkan node "C" ke dalam graf
        graph.addNode("C");
        //Memanggil metode addNode("D") pada objek graph. Metode ini menambahkan node "D" ke dalam graf
        graph.addNode("D");

        //Memanggil metode addEdge("A", "B", 5) pada objek graph. Metode ini menambahkan sisi (edge) antara node "A" dan "B" dengan bobot 5 ke dalam graf.
        graph.addEdge("A", "B", 5);
        //Memanggil metode addEdge("A", "C", 3) pada objek graph. Metode ini menambahkan sisi antara node "A" dan "C" dengan bobot 3 ke dalam graf.
        graph.addEdge("A", "C", 3);
        //Memanggil metode addEdge("B", "C", 2) pada objek graph. Metode ini menambahkan sisi antara node "B" dan "C" dengan bobot 2 ke dalam graf.
        graph.addEdge("B", "C", 2);
        //Memanggil metode addEdge("C", "D", 4) pada objek graph. Metode ini menambahkan sisi antara node "C" dan "D" dengan bobot 4 ke dalam graf.
        graph.addEdge("C", "D", 4);

        //Memanggil metode bfsTraversal("A") pada objek graph
        graph.bfsTraversal("A");
    }
}