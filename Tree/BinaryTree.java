package Tree;


//Kelas Node digunakan untuk merepresentasikan sebuah node dalam pohon biner.
//Setiap node memiliki data dan dua anak: kiri dan kanan.

class Node {
    // Data yang disimpan dalam node
    int data;  
    // Anak kiri dan anak kanan dari node
    Node left, right;  
    
    
    //Konstruktor Node.
    //@param data Data yang akan disimpan dalam node
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * Kelas BinaryTree digunakan untuk merepresentasikan sebuah pohon biner.
 */
public class BinaryTree {

    // Akar dari pohon biner
    Node root;  

    //Metode utama untuk menjalankan program.
    //@param args Argumen dari command line (tidak digunakan)
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();  

        // Membuat nodes
        tree.root = new Node(1);
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.right.left.left = new Node(10);

        // Print tree untuk verifikasi
        printTree(tree.root, "", true);
    }

    /**
     * Metode untuk mencetak struktur pohon biner.
     *
     * @param node Node yang akan dicetak
     * @param indent Indentasi yang digunakan untuk mencetak
     * @param last Menandakan apakah node adalah node terakhir dalam tingkatannya
     */
    public static void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            // Mencetak data node
            System.out.println(indent + "+-- " + node.data);  
            // Menyesuaikan indentasi
            indent += last ? "    " : "|   ";  
             // Mencetak anak kanan
            printTree(node.right, indent, false); 
             // Mencetak anak kiri
            printTree(node.left, indent, true); 
        }
    }
}