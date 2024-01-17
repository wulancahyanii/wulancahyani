package Tree;

import java.util.LinkedList;
import java.util.Queue;


 //Kelas Node digunakan untuk merepresentasikan sebuah node dalam Binary Search Tree (BST).
class Node {
    //digunakan untuk menyimpan nilai atau data yang terkait dengan suatu node dalam pohon biner
    int data;
    //digunakan untuk menunjukkan node anak kiri (left) dan node anak kanan (right) dari suatu node dalam pohon biner
    Node left, right;

    // Ini adalah deklarasi konstruktor,Konstruktor ini akan dipanggil ketika objek baru dari kelas Node dibuat.
    public Node(int data) {
        //pembuatan objek akan disimpan di dalam variabel data objek yang sedang dibuat.
        this.data = data;
        //baris ini mengatur kedua variabel left dan right menjadi null.
        left = right = null;
    }
}


//Kelas BinarySearchTree menyediakan implementasi untuk Binary Search Tree.
public class TraversalBst {

    //mendeklarasikan variabel root yang bertipe Node. 
    Node root;

    //Metode insert merupakan suatu metode yang bertugas untuk menyisipkan (insert) suatu node baru dengan nilai tertentu ke dalam pohon biner. 
    public Node insert(Node root, int data) {
        //Cek apakah root (akar) null
        if (root == null) {
            //Jika null, buat node baru dengan data dan jadikan sebagai root
            root = new Node(data);
            return root;
        }

        //Proses penelusuran dan penyisipan dalam pohon
        if (data < root.data) {
            //Jika nilai data kurang dari root, sisipkan ke anak kiri
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            //Jika nilai data lebih dari root, sisipkan ke anak kanan
            root.right = insert(root.right, data);
        }

        //Kembalikan root (tidak ada perubahan jika data sudah ada)
        return root;
    }

    
     //Melakukan traversal in-order pada BST.
    public void inOrder(Node root) {
        if (root != null) {
            //Jika root tidak null, lanjutkan dengan in-order traversal
            inOrder(root.left);//Rekursif ke anak kiri
            // Cetak niai dari root
            System.out.print(root.data + " ");
            inOrder(root.right);//Rekursif ke anak kanan
        }
    }

    
    //Melakukan traversal post-order pada BST.
    public void postOrder(Node root) {
        //Periksa root
        if (root != null) {
            //jika root tidak null, lanjutkan dengan post-order traversal
            postOrder(root.left);//Rekursif ke anak kiri
            postOrder(root.right);//Rekursif ke anak kanan
            //Cetak nilai dari root
            System.out.print(root.data + " ");
        }
    }

    
     //Melakukan traversal level-order (Breadth-First Search) pada BST.
     public void levelOrder(Node root) {
        //Periksa apakah root null, jika ya, keluar dari metode
        if (root == null) return;

        //Buat antrian menggunakan LinkedList
        Queue<Node> queue = new LinkedList<>();
        //Tambahkan root ke dalam antrian
        queue.add(root);

        //Selama antrian tidak kosong
        while (!queue.isEmpty()) {
            //Ambil dan hapus elemen pertama dari antrian
            Node current = queue.poll();
            //Cetak nilai dari node yang diambil
             System.out.print(current.data + " ");

            //Jika anak kiri tidak null, tambahkan ke antrian
            if (current.left != null) queue.add(current.left);
            //Jika anak kanan tidak null, tambahkan ke antrian
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        //Membuat objek dari kelas TraversalBst
        TraversalBst bst = new TraversalBst();
        
        // Membuat struktur BST dan menyisipkan nilai kedalamnya
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        //Menampilkan In-Order traversal
        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        //Menampilkan Post-Order traversal
        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        //Menampilkan Level-Order traversal
        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}