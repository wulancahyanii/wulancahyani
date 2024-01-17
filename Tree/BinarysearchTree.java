package Tree;//mendeklarasikan paket (package) dengan nama "Tree". 

//mendeklarasikan kelas utama BinarysearchTree
public class BinarysearchTree {
    class Node {
        int data;
        // Setiap objek Node merepresentasikan simpul dalam BST dan memiliki data serta
        // dua anak (kiri dan kanan).
        Node left, right;

        // konstruktor Node yang digunakan untuk membuat objek Node baru dengan data
        // tertentu dan kedua anaknya diatur menjadi null.
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //Baris ini menandakan dimulainya definisi kelas BinarySearchTree.
    class BinarySearchTree {
        //Baris ini mendeklarasikan variabel instance root, yang akan menyimpan referensi ke akar dari pohon pencarian biner (BST).
        Node root;

        //Baris ini mendefinisikan konstruktor kelas BinarySearchTree.
        BinarySearchTree() {
            //Baris ini menginisialisasi variabel root dengan nilai null di dalam konstruktor. 
            root = null;
        }

        //Baris ini mendefinisikan metode insert yang digunakan untuk memasukkan elemen baru ke dalam pohon pencarian biner (BST).
        void insert(int data) {
            //Metode ini memanggil metode rekursif insertRec dan mengatur nilai root dengan hasil dari metode rekursif tersebut.
            root = insertRec(root, data);
        }

        //Baris ini mendefinisikan metode rekursif insertRec yang bertanggung jawab untuk memasukkan elemen baru ke dalam BST.
        Node insertRec(Node root, int data) {
            //Baris ini memeriksa apakah simpul saat ini (root) adalah null, yang menandakan bahwa tempat di pohon ini kosong.
            if (root == null) {
                //Jika root adalah null, maka baris ini membuat node baru dengan data yang diberikan dan mengatur root agar menunjuk ke node baru tersebut.
                root = new Node(data);
                // jika root bukan null dari awal, metode ini mengembalikan root
                return root;
            }

            //Baris ini memeriksa apakah nilai data yang akan dimasukkan kurang dari nilai data simpul saat ini.
            if (data < root.data) {
                //Jika data kurang dari root.data, maka pemanggilan rekursif dilakukan pada anak kiri (root.left). 
                root.left = insertRec(root.left, data);
            //Baris ini memeriksa apakah nilai data yang akan dimasukkan lebih besar dari nilai data simpul saat ini.
            } else if (data > root.data) {
                //Jika data lebih dari root.data, maka pemanggilan rekursif dilakukan pada anak kanan (root.right).
                root.right = insertRec(root.right, data);
            }

            //metode ini mengembalikan root
            return root;
        }

        //Baris ini mendeklarasikan metode inorder yang digunakan untuk melakukan traversal inorder pada pohon pencarian biner (BST).
        void inorder() {
            inorderRec(root);
        }

        //Baris ini mendeklarasikan metode rekursif inorderRec yang menerima parameter root (simpul saat ini).
        void inorderRec(Node root) {
            //Baris ini memeriksa apakah simpul saat ini tidak null.
            if (root != null) {
                //Jika tidak null, metode ini melakukan pemanggilan rekursif pada anak kiri simpul saat ini (root.left).
                inorderRec(root.left);
                //Setelah menelusuri anak kiri, nilai dari simpul saat ini (root.data) dicetak.
                System.out.print(root.data + " ");
                //metode ini melakukan pemanggilan rekursif pada anak kanan simpul saat ini (root.right).
                inorderRec(root.right);
            }
        }

        //Baris ini mendeklarasikan metode preorder yang digunakan untuk melakukan traversal preorder pada pohon pencarian biner (BST). 
        void preorder() {
            preorderRec(root);
        }

        // Baris ini mendeklarasikan metode rekursif preorderRec yang menerima parameter root (simpul saat ini). 
        void preorderRec(Node root) {
            //Baris ini memeriksa apakah simpul saat ini tidak null.
            if (root != null) {
                //Jika tidak null, nilai dari simpul saat ini (root.data) dicetak.
                System.out.print(root.data + " ");
                //Setelah mencetak nilai, metode ini melakukan pemanggilan rekursif pada anak kiri simpul saat ini (root.left).
                preorderRec(root.left);
                //metode ini melakukan pemanggilan rekursif pada anak kanan simpul saat ini (root.right).
                preorderRec(root.right);
            }
        }

        //Baris ini mendeklarasikan metode postorder yang digunakan untuk melakukan traversal postorder pada pohon pencarian biner (BST). 
        void postorder() {
            //Metode ini memanggil metode rekursif postorderRec dan melewatkan akar pohon (root) sebagai parameter awal.
            postorderRec(root);
        }

        //Baris ini mendeklarasikan metode rekursif postorderRec yang menerima parameter root (simpul saat ini).
        void postorderRec(Node root) {
            //Baris ini memeriksa apakah simpul saat ini tidak null.
            if (root != null) {
                //Jika tidak null, metode ini melakukan pemanggilan rekursif pada anak kiri simpul saat ini (root.left).
                postorderRec(root.left);
                //metode ini melakukan pemanggilan rekursif pada anak kanan simpul saat ini (root.right).
                postorderRec(root.right);
                // Terakhir, nilai dari simpul saat ini (root.data) dicetak.
                System.out.print(root.data + " ");
            }
        }
    }

    //Baris ini menandakan dimulainya definisi kelas MainBinarySearchTree.
    public class MainBinarySearchTree {
        //Baris ini mendeklarasikan metode main, yang akan dijalankan ketika program dimulai. Metode ini merupakan titik awal eksekusi program.
        public void main(String[] args) {
            //Baris ini membuat objek dari kelas BinarySearchTree dengan nama tree.
            BinarySearchTree tree = new BinarySearchTree();

            //Menyisipkan nilai ke dalam pohon
            tree.insert(50);
            tree.insert(30);
            tree.insert(70);
            tree.insert(10);
            tree.insert(35);
            tree.insert(65);
            tree.insert(80);

            // Mencetak pesan yang menyatakan bahwa traversal inorder akan dimulai.
            System.out.println("Inorder traversal:");
            //Memanggil metode inorder untuk melakukan traversal inorder dan mencetak nilai-nilai pohon.
            tree.inorder();

            //Mencetak pesan yang menyatakan bahwa traversal preorder akan dimulai.
            System.out.println("\n\nPreorder traversal:");
            //Memanggil metode preorder untuk melakukan traversal preorder dan mencetak nilai-nilai pohon.
            tree.preorder();

            //Mencetak pesan yang menyatakan bahwa traversal postorder akan dimulai.
            System.out.println("\n\nPostorder traversal:");
            //Memanggil metode postorder untuk melakukan traversal postorder dan mencetak nilai-nilai pohon.
            tree.postorder();
        }
    }

}
