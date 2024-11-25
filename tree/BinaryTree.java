

package tree;


import java.util.Objects;

public class BinaryTree<T> {

    protected TreeNode<T> root = null;

    /* Tree Traversal methods */

    //HINT for three traversal methods: you can call toString() on the node's
    //     data when you are executing the "root" command on a given node
    //     (e.g. curNode.data.toString() + " ";) // Note the space added at the end

    public String getInOrder() {
        return getInOrder(root); // call getInOrder starting at the root!
    }
    private String getInOrder(TreeNode<T> curNode) {
        String result = "";
        // String to store the result^
        if(curNode == null){
            return result;
            // if a null node is come across, it will not be added to the result
        }
        else{
            result += getInOrder(curNode.left);
            // recursively goes down the left subtree calling "getInOrder"
            result += curNode.data.toString() + " ";
            // appends the current node to the string
            result += getInOrder(curNode.right);
            // recursively goes down the right subtree calling "getInOrder"
        }
        return result;
        // returns the string
    }


    public String getPreOrder() {
        return getPreOrder(root); // call getPreOrder starting at the root!
    }
    private String getPreOrder(TreeNode<T> curNode) {
        // if tree is empty return string
        // else { visit the root, preorder traverse the left subtree, then preorder traverse the right subtree}
        //TODO: return the pre order traversal of this tree, space separated
        String result = "";
        if(curNode == null){
            return result;
            // if a null node is come across, it will not be added to the result
        }
        else{
            result += curNode.data.toString() + " ";
            // appends the current node to the result
            result += getPreOrder(curNode.left);
            // recursively goes down the left subtree calling "getPreOrder"
            result += getPreOrder(curNode.right);
            // recursively goes down the right subtree calling "getPreOrder"
        }
        return result;
        // returns the result string
    }


    public String getPostOrder() {
        return getPostOrder(root);  // call getPostOrder starting at the root!
    }
    private String getPostOrder(TreeNode<T> curNode) {
        //TODO: return the post order traversal of this tree, space separated
        String result = "";
        if(curNode == null){
            return result;
            // if a null node is come across, it will not be added to the result
        }
        else{
            result += getPostOrder(curNode.left);
            // recursively goes down the left subtree calling "getPostOrder"

            result += getPostOrder(curNode.right) + " ";
            // recursively goes down the right subtree calling "getPreOrder"

            result += curNode.data.toString();
            // appends the current node to the result

        }
        return result;
        //returns the result string
    }


    //------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE
    //------------------------------------------------------------------------

    /* A somewhat more pretty print method for debugging */
    public void printTree() {
        printTree(this.root, 0);
        System.out.println("\n\n");
    }
    private void printTree(TreeNode<T> curNode, int indentLev) {
        if(curNode == null) return;
        for(int i=0; i<indentLev; i++) {
            if(i == indentLev - 1) System.out.print("|-----");
            else System.out.print("      ");
        }
        System.out.println(curNode.data);
        printTree(curNode.left, indentLev+1);
        printTree(curNode.right, indentLev+1);
    }

    //TODO: Look at these methods and think about how they might be useful for this assignment
    public int height() {
        return height(root);
    }

    /* Computes the height of the tree on the fly */
    protected int height(TreeNode<T> node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }



    @Override
    public boolean equals(Object obj){
        if( this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        BinaryTree<?> otherTree = (BinaryTree<?>)obj;
        return equals(root,otherTree.root);
    }

    private boolean equals(TreeNode<T> tree1,TreeNode<?> tree2){
        if(tree1 == tree2 && tree2 == null){
            return true;
        }
        if(tree1 != null && tree2 != null){
            return Objects.equals(tree1.data,tree2.data) && equals(tree1.left,tree2.left) && equals(tree1.right,tree2.right);
        }
        return false;
    }
}
