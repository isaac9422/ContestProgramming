/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google.CodeJam17.qualification;

/**
 *
 * @author jhunior
 */
public class Solution {

    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        int[] n = new int[20];
//        for (int i = 1; i < 21; i++) {
//            n[i - 1] = i;
//        }
//        
//        TreeNode tree = sortedArrayToBST(n);
//        
//        
////	Different ways to traverse binary trees
//        tree.inOrderTraverseTree(tree);
//        System.out.println("=============================");
//        tree.preorderTraverseTree(tree);
//        System.out.println("=============================");
//        tree.postOrderTraverseTree(tree);
//        System.out.println("=============================");
        
        int n = 7;
        System.out.println(n/2);
    }
    
    

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth
    public void inOrderTraverseTree(TreeNode focusNode) {

        if (focusNode != null) {

            // Traverse the left node
            inOrderTraverseTree(focusNode.left);

            // Visit the currently focused on node
            System.out.println(focusNode.val);

            // Traverse the right node
            inOrderTraverseTree(focusNode.right);

        }

    }

    public void preorderTraverseTree(TreeNode focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode.val);

            preorderTraverseTree(focusNode.left);
            preorderTraverseTree(focusNode.right);

        }

    }

    public void postOrderTraverseTree(TreeNode focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);

            System.out.println(focusNode.val);

        }

    }
}
