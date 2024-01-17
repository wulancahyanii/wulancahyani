package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Kelas yang merepresentasikan sebuah node pada pohon biner.
class Node {
    //mendeklarasikan variabel instance value yang bertipe String. 
    String value;
    //mendeklarasikan dua variabel instance bertipe Node, yaitu left dan right. 
    Node left;
    Node right;

    
    //Konstruktor untuk kelas Node.
    //@param value Nilai dari node.
     public Node(String value) {
        //Menyimpan nilai yang diberikan ke variabel instance "value"
        this.value = value;
        //Menginisialisasi variabel "left" dengan null
        left = null;
        //Menginisialisasi variabel "right" dengan null
        right = null;
    }
}


//Kelas yang merepresentasikan sebuah pohon biner.
class StringBst {
    //suatu variabel bernama root yang merupakan instance dari kelas Node
    Node root;

    
    //Konstruktor default, menginisialisasi root menjadi null.
     public StringBst() {
        //variabel-instance root dari objek yang sedang dibuat diatur menjadi null.
        root = null;
    }

    
    //Menyisipkan sebuah node baru ke pohon biner. 
    //@param root  Node root saat ini.
    //@param value Nilai yang akan disisipkan.
    //@return Node root yang baru.
     public Node insert(Node root, String value) {
        //Cek apakah root (akar) null
        if (root == null) {
            //Jika null, buat node baru dengan value dan jadikan sebagai root
            root = new Node(value);
            return root;
        }

        //Proses penelusuran dan penyisipan dalam pohon
        if (value.compareTo(root.value) < 0) {
            //Jika value kurang dari root.value, sisipkan ke anak kiri
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            //Jika value lebih dari root.value, sisipkan ke anak kanan
            root.right = insert(root.right, value);
        }

        //Kembalikan root (tidak ada perubahan jika value sudah ada)
        return root;
    }

   
    //Melakukan traversal pre-order pada pohon biner.
    //@param root Node root saat ini.
    public void preorder(Node root) {
        //Cek apakah root tidak null
        if (root != null) {
            //Cetak nilai dari root saat ini
            System.out.print(root.value + " ");
            //Rekursif ke anak kiri dan anak kanan secara pre-order
            preorder(root.left);
            preorder(root.right);
        }
    }

    
    //Melakukan traversal in-order pada pohon biner. 
    //@param root Node root saat ini.
    public void inorder(Node root) {
        //Cek apakah root tidak null
        if (root != null) {
            //Rekursif ke anak kiri secara in-order
            inorder(root.left);
            //Cetak nilai dari root saat ini
            System.out.print(root.value + " ");
            //Rekursif ke anak kanan secara in-order
            inorder(root.right);
        }
    }

    
    
    //Melakukan traversal post-order pada pohon biner.
    //@param root Node root saat ini.
    public void postorder(Node root) {
        //Cek apakah root tidak null
        if (root != null) {
            //Rekursif ke anak kiri secara post-order
            postorder(root.left);
            //Rekursif ke anak kanan secara post-order
            postorder(root.right);
            //Cetak nilai dari root saat ini
            System.out.print(root.value + " ");
        }
    }
    //Melakukan traversal level-order pada pohon biner.
    //@param root Node root saat ini.
    public void levelOrder(Node root) {
        //Cek apakah root null, jika ya, keluar dari metode
        if (root == null)
            return;

        //Buat antrian menggunakan LinkedList dan tambahkan root ke antrian
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //Lakukan traversal level-order menggunakan antrian
        while (!queue.isEmpty()) {
            //Ambil dan hapus elemen pertama dari antrian
            Node current = queue.poll();
            //Cetak nilai dari node yang diambil
            System.out.print(current.value + " ");

            //Tambahkan anak kiri dan anak kanan ke antrian jika ada
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

    }

   
    //Mencetak pohon biner dalam bentuk struktur tree folder
    //@param node   Node awal (biasanya root).
    //@param prefix Prefix untuk baris saat ini.
    //@param isTail Apakah node ini adalah anak terakhir dari parentnya.
    public void printTree(Node node, String prefix, boolean isTail) {
        //Cek apakah node tidak null
        if (node != null) {
            //Cetak prefix, label (value) node, dan tanda anak cabang (tail)
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);

            //Buat daftar node anak
            List<Node> children = new ArrayList<>();
            if (node.left != null)
                children.add(node.left);
            if (node.right != null)
                children.add(node.right);
            //Loop untuk mencetak setiap node anak dengan rekursi
            for (int i = 0; i < children.size() - 1; i++) {
                printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            //Cetak node anak terakhir dengan tail yang benar
            if (children.size() > 0) {
                printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

   
    //Metode main untuk mengeksekusi kode.
    //@param args Argumen dari baris perintah.
    public static void main(String[] args) {
        //Membuat objek pohon biner string
        StringBst tree = new StringBst();
        // Menambahkan beberapa nilai string ke dalam pohon
        tree.root = tree.insert(tree.root, "Mango");
        tree.insert(tree.root, "Apple");
        tree.insert(tree.root, "Orange");
        tree.insert(tree.root, "Banana");
        tree.insert(tree.root, "Grapes");
        tree.insert(tree.root, "Pineapple");
        tree.insert(tree.root, "Peach");

        //Mencetak struktur pohon biner menggunakan metode printTree
        System.out.println("Struktur pohon biner:");
        tree.printTree(tree.root, "", true);

        //Melakukan traversal pre-order dan mencetak hasilnya
        System.out.println("Traversal pre-order:");
        tree.preorder(tree.root);

        //Melakukan traversal in-order dan mencetak hasilnya
        System.out.println("\nTraversal in-order:");
        tree.inorder(tree.root);

        //Melakukan traversal post-order dan mencetak hasilnya
        System.out.println("\nTraversal post-order:");
        tree.postorder(tree.root);

        //Melakukan traversal level-order dan mencetak hasilnya
        System.out.println("\nTraversal level-order:");
        tree.levelOrder(tree.root);
    }
}