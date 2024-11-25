
package tree;
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{

    @Override
    public void insert(T data) {
        this.root = insert(data, root);
    }

   
    protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
        // method used for the insertion in a tree, takes in data and the current node
        if (curNode == null) {
             return new TreeNode<T>(data);
             // if the current node is null, a new node will be returned as the node to insert

        } if (data.compareTo(curNode.data) < 0) {
            curNode.left = insert(data, curNode.left);
            // using the compareTo method this if statement and the following if else statement
            // are used to shift the node that is being inserted either to the left or right subtree
            // with each recursive call the node will move further down the subtrees until a null value is reached
            // the node will then be inserted
        } else if (data.compareTo(curNode.data) > 0){
            curNode.right = insert(data, curNode.right);
        }
        //returns the node
        return curNode;
    }


    /**
     * Returns a boolean (true of false) if the element was found in a BST
     */
    @Override
    public boolean find(T data) {
        return find(data, root);
    }

    // Helper method
    private boolean find(T data, TreeNode<T> curNode) {
        // essentially this method will traverse the tree recursively looking for the node with the same data,
        // will return either true or false of whether or not the data is found inside of the tree
        if (curNode == null) {
            return false;
            // if curNode is null - the node is not found
        }
        if(data.compareTo(curNode.data) == 0) {
            return true;
            // if the data in both nodes is the same true will be returned
        }
        else if (data.compareTo(curNode.data) < 0) {
                return find(data, curNode.left);
                // traverses the left subtree
            }
        else {
                return find(data, curNode.right);
                // traverses the right subtree
            }
    }


    /**
     * Returns the max item in the given subtree
     */
    public T findMax() {
        return findMax(this.root);
    }

    // Helper method
    private T findMax(TreeNode<T> curNode) {
        // will recursively traverse the tree to find the maximum value
        if(curNode == null ) return null; //curNode == null -> no max -> returns null
        else if(curNode.right == null){
            return curNode.data;
        } else{
            return findMax(curNode.right);
            // goes to the right subtree - the idea behind this is BST's are in numeric order -> the child attached on the right will always be larger
        }
    }

    //-----------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU: (Don't change anything!)
    //WE HAVE IMPLEMENTED THE REMOVE METHOD FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE AND TRY YOUR BEST TO UNDERSTAND IT
    //-----------------------------------------------------------------------------

    @Override
    public void remove(T data) {
        this.root = remove(data, root); // Call remove at the root of the tree
    }

    protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
        /* Note the use of compareTo() in the solution! */

        if(curNode == null) return curNode;
            // if item I want to remove is smaller than the data of the current node...
        else if (data.compareTo(curNode.data) < 0) {
            curNode.left = remove(data, curNode.left); // recursively call remove on LEFT subtree
        }
        // if item I want to remove is larger than the data of the current node...
        else if (data.compareTo(curNode.data) > 0) {
            curNode.right = remove(data, curNode.right); // recursively call remove on RIGHT subtree
        }
        else { /* Found it, time to remove */
            if(curNode.left == null && curNode.right == null)		return null;
            else if(curNode.left != null && curNode.right == null)	return curNode.left;
            else if(curNode.left == null && curNode.right != null)	return curNode.right;
            else {
                T toDel = findMax(curNode.left);
                curNode.data = toDel;
                curNode.left = remove(toDel, curNode.left);
                return curNode;
            }
        }
        return curNode;
    }


}
