package Google.CodeJam17.qualification;

import java.util.ArrayList;

public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {

        // Create a new Node and initialize it
        Node newNode = new Node(key, name);

        // If there is no root this becomes root
        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new Node
            Node parent;

            while (true) {

                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (key < focusNode.key) {

                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) {

                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) {

                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth
    private void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node
            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node
            System.out.println(focusNode);

            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    private void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    private void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }

    }

    private Node findNode(int key) {

        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (focusNode.key != key) {

            // If we should search to the left
            if (key < focusNode.key) {

                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;

            }

            // The node wasn't found
            if (focusNode == null) {
                return null;
            }

        }

        return focusNode;

    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

//        theTree.addNode(50, "Boss");
//
//        theTree.addNode(25, "Vice President");
//
//        theTree.addNode(15, "Office Manager");
//
//        theTree.addNode(30, "Secretary");
//
//        theTree.addNode(75, "Sales Manager");
//
//        theTree.addNode(85, "Salesman 1");
        
        ArrayList<Integer> al = new ArrayList();
        for(int i=1;i<21;i++){
            al.add(i);
        }
        
        tree.addNode(10,"10");
        tree.addNode(15,"15");
        tree.addNode(5,"5");
        tree.addNode(18,"18");
        tree.addNode(2,"2");
        tree.addNode(7,"7");
        tree.addNode(12,"12");
        tree.addNode(3,"3");
        tree.addNode(8,"8");
        tree.addNode(13,"13");
        tree.addNode(16,"16");
        tree.addNode(19,"19");
        tree.addNode(1,"1");
        tree.addNode(4,"4");
        tree.addNode(6,"6");
        tree.addNode(9,"9");
        tree.addNode(11,"11");
        tree.addNode(14,"14");
        tree.addNode(19,"19");
        tree.addNode(20,"20");
        
        

//	Different ways to traverse binary trees
        tree.inOrderTraverseTree(tree.root);
        System.out.println("=============================");
        tree.preorderTraverseTree(tree.root);
        System.out.println("=============================");
        tree.postOrderTraverseTree(tree.root);
        System.out.println("=============================");
        // Find the node with key 75
        System.out.println("\nNode with the key 75");

        System.out.println(tree.findNode(75));

    }
}

class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {

        this.key = key;
        this.name = name;

    }

    public String toString() {

        return name + " has the key " + key;

        /*
         * return name + " has the key " + key + "\nLeft Child: " + leftChild +
         * "\nRight Child: " + rightChild + "\n";
         */
    }

}
