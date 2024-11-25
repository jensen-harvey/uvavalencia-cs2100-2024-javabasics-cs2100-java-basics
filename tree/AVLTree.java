
package tree;
import java.lang.Math;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{

	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		if (curNode == null) {
			return new TreeNode<T>(data);
			// if the current node is null, a new node will be returned as the node to insert
		}
		// recursively insert data into the tree based on the comp. with the current node's data
		curNode = super.insert(data, curNode);
		// update the height of the current node
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		// If necessary, balances the tree
		return balance(curNode);
	}


	@Override
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);

		/* Handle the case when remove returns null */
		if(curNode == null) return null;

		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;

		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);

		return curNode;
	}


	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {

		if(balanceFactor(curNode) == 2 && balanceFactor(curNode.left) == -1){
			// Right-Left rotation is required
			curNode.left = rotateLeft(curNode.left);
			return rotateRight(curNode);
		}
		else if(balanceFactor(curNode) == 2 && balanceFactor(curNode.left) == 1){
			// right-rotation is required
			return rotateRight(curNode);
		}
		else if(balanceFactor(curNode) == -2 && balanceFactor(curNode.right) == 1){
			// Left-Right rotation is required
			curNode.right = rotateRight(curNode.right);
			return rotateLeft(curNode);
		}
		else if(balanceFactor(curNode) == -2 && balanceFactor(curNode.right) == -1){
			// rotates tree left
			return rotateLeft(curNode);
		}
		return curNode;
	}

	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		TreeNode<T> leftChild = curNode.left;
		// creates a dummy node as the current nodes left child
		curNode.left = leftChild.right;
		// updates left child of curNode to be the right child of leftChild
		leftChild.right = curNode;
		// Updates the right child of the left to be the current node

		// updates the height after the right rotation
		curNode.height = Math.max(height(curNode.left), height(curNode.right));
		leftChild.height = Math.max(height(leftChild.left), height(leftChild.right));
		return leftChild;
	}

	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> rightChild = curNode.right;
		// creates a dummy node as the current nodes right child
		curNode.right = rightChild.left;
		// updates right child of curNode to be the left child of rightChild
		rightChild.left = curNode;
		// Updates the left child of the rightRight to be the current node

		// updates the height after the left rotation
		curNode.height = Math.max(height(curNode.left), height(curNode.right));
		rightChild.height = Math.max(height(rightChild.left), height(rightChild.right));
		return rightChild;
	}

	private int balanceFactor(TreeNode<T> node) {
		// height(left) - height(right) <= 1
		// if the balance factor is greater than this then the tree must be balanced
		if(node == null){
			return -1;
			// if the value of the node is null meaning it has no children the height difference will be -1
		}
		int bFact = height(node.left) - height(node.right);
		// returns the height of the left node - the height of the right node
		return bFact;
	}


}
