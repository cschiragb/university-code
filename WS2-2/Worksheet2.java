/**
 * @author <Chirag Bhatti> (CBX937)
 * @version 01/02/2020
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 * negateAll is a method that takes a tree of integers, and returns a tree of integers with all the integers negated
	 * @param t, is the integer tree to be negated
	 * @return the negated integer tree
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {

		if (t.isEmpty()) {
			return new Tree<Integer>();
		}

		else {
			return new Tree<Integer>(-(t.getValue()), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	// Exercise 2

	/**
	 * allEven is a method that takes a tree of integers and confirms whether all the elements stored within it are even
	 * numbers
	 * @param a, is the integer tree to be checked
	 * @return true if all the elements are even numbers, otherwise false
	 */
	static boolean allEven(Tree<Integer> a) {

		if (a.isEmpty()) {
			return true;
		}

		else if (a.getValue() % 2 == 0) {
			return allEven(a.getLeft()) && allEven(a.getRight());
		}

		else {
			return false;
		}
	}

	// Exercise 3

	/**
	 * depth is a method that takes a tree of integers and checks at what depth an integer may be stored
	 * @param a, is the integer tree to be checked 
	 * @param x, is the integer to be checked for in the tree
	 * @return an integer of the depth the integer is at in the tree. If found at the root the depth is 0,
	 * if the integer isn't in the tree the depth is given as -1, otherwise a depth > 0 is given.
	 */
	static int depth(Tree<Integer> a, int x) {

		if (a.isEmpty()) {
			return -1;
		}

		else if (a.getValue() == x) {
			return 0;
		}

		else {
			int checkLeft 	= depth(a.getLeft(), x);
			int checkRight 	= depth(a.getRight(), x);

			if (checkLeft == -1 && checkRight == -1) {
				return -1;
			}

			else {
				return 1 + Math.max(checkLeft, checkRight);
			}
		}
	}

	// Exercise 4

	/**
	 * preorder is a method that takes a generic tree and returns its elements in preorder in a list. That is for 
	 * every node, its own value should be listed first, followed by all the values in its left subtree followed
	 * by those in the right subtree
	 * @param <E> is the generic type of the tree
	 * @param a, is the tree containing the generic elements to be listed in preorder
	 * @return a generic list with the elements listed in preorder, in the head to tail direction
	 */
	static <E> List<E> preorder(Tree<E> a) {

		if (a.isEmpty()) {
			return new List<E>();
		}

		else {
			/* Take the top node of the tree and make this the head of the list, make the tail of the list by appending
			 * the left nodes to the right nodes in order to satisfy preorder traversal
			 */
			return new List<E>(a.getValue(), appendSubsToAList(preorder(a.getLeft()), preorder(a.getRight()))); 
		}
	}

	/**
	 * appendSubsToAList is a helper method for the preorder method above. The method takes two generic lists
	 * and appends the second list onto the end of the first list.
	 * @param <E> is the generic type of the tree
	 * @param a, is the generic list to be appended to
	 * @param b, is the generic list to append onto a
	 * @return the generic list containing elements of a followed by elements of b
	 */
	static <E> List<E> appendSubsToAList(List<E> a, List<E> b) {

		if (a.isEmpty()) {
			return b;
		} 

		else {
			return new List<E>(a.getHead(), appendSubsToAList(a.getTail(), b));
		}
	}	


	// Exercise 5

	/**
	 * isSearchTree is a method that takes an integer tree and ascertains if it meets the Binary Search Tree (BST) properties. 
	 * That is:
	 * - all values stored in the left subtree of the node are less than the value at the node
	 * - all values stored in the right subtree of the node are more than the value at the node
	 * The method makes some simple base case checks for an empty tree or a tree with a single root node, if the tree does not meet
	 * these base cases then it initialises the helper method to recursively check through the binary tree for BST properties, using
	 * initial min max limits of those permissible for integer numbers in Java.
	 * @param a, is the integer tree to be checked for BST property
	 * @return true if the tree is a BST, otherwise false
	 */
	static boolean isSearchTree(Tree<Integer> a) {

		if (a.isEmpty()) {
			return true;
		}
		
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
			return true;
		}
		
		else {
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			return checkSearchTree(a, min, max);
		}
	}
	
	/**
	 * checkSearchTree is a helper method to isSearchTree, that takes an integer tree and an initial min, max, and recursively
	 * checks through the tree's integers to ensure they meet the conditions necessary to satisfy the BST properties.
	 * The conditions are:
	 * - The value at a node is not less than the allowable minimum or greater than the allowable maximum.
	 * The method assumes there are no duplicates in the integer binary tree being checked.
	 * @param a, is the tree of integers to be checked
	 * @param min, is the minimum value a node cannot be less than
	 * @param max, is the maximum value a node cannot be greater than
	 * @return true if the search tree is a binary search tree, otherwise false.
	 */
	static boolean checkSearchTree(Tree<Integer> a, int min, int max) {
		
		if (a.isEmpty()) {
			return true;
		}

		else if (a.getValue() < min || a.getValue() > max) {
			return false;
		}

		else {
			return checkSearchTree(a.getLeft(), min, a.getValue()) && checkSearchTree(a.getRight(), a.getValue(), max);
		}
		
	}

	// Exercise 6

	/**
	 * printDescending takes a Binary Search Tree of integers and prints the values stored within it in descending order. 
	 * @param a, is the BST tree of integers to be printed
	 */
	static void printDescending(Tree<Integer> a) {

		if (a.isEmpty()) {
			return;
		}

		else {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());
		}
	}

	// Exercise 7

	/**
	 * max is a method that takes a binary search tree of integers and finds the maximum integer within it
	 * @param a, is the BST tree of integers to be checked
	 * @return an integer that is the maximum integer in the BST
	 */
	static int max(Tree<Integer> a) {

		if (a.isEmpty()) {
			throw new IllegalArgumentException("Cannot find max value in an empty tree");
		}

		else if (a.getRight().isEmpty()) {
			return a.getValue();
		}

		else {
			return max(a.getRight());
		}
	}

	// Exercise 8

	/**
	 * delete is a method that takes a binary search tree of integers and removes a given integer from it
	 * @param a, is the BST of integers to be checked
	 * @param x, is the integer to be removed from the BST
	 * @return a tree of integers that still retains the BST property. If the integer to be removed is not
	 * in the tree, the same tree, param a, is returned.
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {

		if (a.isEmpty()) {
			return new Tree<Integer>();
		}

		else if (x < a.getValue()) {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		}

		else if (x > a.getValue()) {
			return new Tree<Integer>(a.getValue(), a.getLeft(), delete(a.getRight(), x)); 
		}

		else { 
			/* The code considers possible cases when the integer to be deleted equals the top node */

			/* If the right subtree of the node to be deleted is empty, we replace the deleted node
			 * with the left subtree
			 */
			if (a.getRight().isEmpty()) {
				return a.getLeft();
			}

			/* Likewise if the left subtree of the node to be deleted is empty, we replace the deleted
			 * node with the right subtree
			 */
			else if (a.getLeft().isEmpty()) {
				return a.getRight();
			}

			else {
				/* If both subtrees are NOT empty, as a convention we take the max of the left subtree 
				 * to be the value of the top node, we then remove this max value from the left subtree 
				 * and make this the left subtree, and retain the same right subtree. 
				 */
				return new Tree<Integer>( max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
			}
		}
	}

	// Exercise 9

	/**
	 * isHeightBalanced is a method that takes a generic tree and checks it for the height balance property.
	 * That is:
	 * - No nodes have a balance factor < -1 or > +1
	 * - The balance factor is taken as the height of the right subtree - the height of the left subtree
	 * @param <E> is the generic type of the tree
	 * @param a, is the generic tree to be checked
	 * @return true if the tree is height balanced, otherwise false
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {

		if (a.isEmpty()) {
			return true;
		}

		else if (balanceFactorChecker(a) >= -1 && balanceFactorChecker(a) <= 1) {
			return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
		}

		else {
			return false;
		}
	}
	
	/**
	 * balanceFactorChecker is a generic helper method that takes a generic type tree and computes the
	 * balance factor at the root node
	 * @param <E> is the generic type of the tree
	 * @param a, is the generic tree to be checked for the balance factor
	 * @return an integer of the balance factor at the root node
	 */
	static <E> int balanceFactorChecker(Tree<E> a) {
		
		return a.getRight().getHeight() - a.getLeft().getHeight();
	}

	// Exercise 10
	
	/**
	 * insertHB is a method that takes a tree of integers and insert an integer into it. Upon insertion, the 
	 * method ensures the tree's height balanced / AVL property is retained.
	 * @param a, is the tree of integers the integer is to be inserted into
	 * @param x, is the integer to be inserted into the tree
	 * @return an AVL tree with the integer inserted it. If the integer already exists in the tree, 
	 * the same tree is simply returned.
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {

		if (a.isEmpty()) {
			return new Tree<>(x);
		}

		else if (x < a.getValue()) {
			return treeRebalancer(new Tree<>(a.getValue(), insertHB(a.getLeft(), x), a.getRight()));
		
		}

		else if (x > a.getValue()) {
			return treeRebalancer(new Tree<>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x)));
		}

		else {
			return a;
		}
			
	}

	/**
	 * deleteHB is a method that takes a tree of integers and deletes an integer from it. Upon deletion, the
	 * method ensures the tree's height balanced / AVL property is retained.
	 * @param a, is the tree of integers the integer is to be removed from
	 * @param x, is the integer to be removed from the tree
	 * @return an AVL tree with the integer removed from it. If the integer doesn't exist in the tree, the 
	 * same tree is simply returned.
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {

		if (a.isEmpty()) {
			return new Tree<Integer>();
		}

		else if (x < a.getValue()) {
			return treeRebalancer(new Tree<Integer>(a.getValue(), deleteHB(a.getLeft(), x), a.getRight()));
		}

		else if (x > a.getValue()) {
			return treeRebalancer(new Tree<Integer>(a.getValue(), a.getLeft(), deleteHB(a.getRight(), x)));
		}

		else {
			/* The code considers possible cases when the integer to be deleted equals the top node */

			/* If the right subtree of the node to be deleted is empty, we replace the deleted node
			 * with the left subtree
			 */
			if (a.getRight().isEmpty()) {
				return a.getLeft();
			}

			/* Likewise if the left subtree of the node to be deleted is empty, we replace the deleted
			 * node with the right subtree
			 */
			else if (a.getLeft().isEmpty()) {
				return a.getRight();
			}

			else {
				/* If both subtrees are NOT empty, as a convention we take the max of the left subtree 
				 * to be the value of the top node, we then remove this max value from the left subtree 
				 * and make this the left subtree, and retain the same right subtree. 
				 */
				int leftMax = max(a.getLeft());
				return treeRebalancer(new Tree<Integer>(leftMax, deleteHB(a.getLeft(), leftMax), a.getRight()));
			}
		}
	}

	/**
	 * treeRebalancer is a helper method that takes a tree of integers and checks if the tree needs height
	 * balancing. If the tree does not require balancing, the same tree is returned.
	 * Otherwise the method identifies the type of rotation needed to rebalance the tree and calls the
	 * relevant rotation helper methods to do so.
	 * @param a, the tree of integers that may or may not require balancing
	 * @return a tree of integers that is height balanced
	 */
	static Tree<Integer> treeRebalancer(Tree<Integer> a) {

		if (a.isEmpty()) {
			return a;
		}

		else if (isHeightBalanced(a)) {
			return a;
		}

		else {
			if (a.getRight().getHeight() - a.getLeft().getHeight() == -2 && 
					a.getLeft().getLeft().getHeight() > a.getRight().getHeight()) {
				
				return llCaseRotation(a);
			}

			else if (a.getRight().getHeight() - a.getLeft().getHeight() == -2 && 
					a.getLeft().getRight().getHeight() > a.getRight().getHeight()) {
				
				return lrCaseRotation(a);
			}

			else if (a.getRight().getHeight() - a.getLeft().getHeight() == 2 && 
					a.getRight().getRight().getHeight() > a.getLeft().getHeight()) {
				
				return rrCaseRotation(a);
			}

			else if (a.getRight().getHeight() - a.getLeft().getHeight() == 2 && 
					a.getRight().getLeft().getHeight() > a.getLeft().getHeight()) {
				
				return rlCaseRotation(a);
			}

			else {
				
				throw new IllegalArgumentException("The tree is more unbalanced than it should be");
			}
		}
	}
	
	/**
	 * llCaseRotation is a helper method that takes a tree of integers and does a right rotation of the top node 
	 * @param a, is the tree of integers to be rotated
	 * @return an integer tree with the nodes rotated
	 */
	static Tree<Integer> llCaseRotation (Tree<Integer> a){
		
		return new Tree<Integer>(a.getLeft().getValue(), 
				new Tree<Integer>(a.getLeft().getLeft().getValue(), a.getLeft().getLeft().getLeft(), a.getLeft().getLeft().getRight()),
				new Tree<Integer>(a.getValue(), a.getLeft().getRight(), a.getRight()));
	}
	
	/**
	 * lrCaseRotation is a helper method that takes a tree of integers and does a left rotation of the bottom node
	 * and then a right rotation of the top node
	 * @param a, is the tree of integers to be rotated
	 * @return an integer tree with the nodes rotated
	 */
	static Tree<Integer> lrCaseRotation (Tree<Integer> a){
		
		return new Tree<Integer>(a.getLeft().getRight().getValue(), 
				new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
				new Tree<Integer>(a.getValue(), a.getLeft().getRight().getRight(), a.getRight()));
	}
	
	/**
	 * rrCaseRotation is a helper method that takes a tree of integers and does a left rotation of the top node 
	 * @param a, is the tree of integers to be rotated
	 * @return an integer tree with the nodes rotated
	 */
	static Tree<Integer> rrCaseRotation (Tree<Integer> a){
		
		return new Tree<Integer>(a.getRight().getValue(),
				new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft()),
				new Tree<Integer>(a.getRight().getRight().getValue(), a.getRight().getRight().getLeft(), a.getRight().getRight().getRight()));
	}
	
	/**
	 * rlCaseRotation is a helper method that takes a tree of integers and does a right rotation of the bottom node
	 * and then a left rotation of the top node 
	 * @param a, is the tree of integers to be rotated
	 * @return an integer tree with the nodes rotated
	 */
	static Tree<Integer> rlCaseRotation (Tree<Integer> a) {
		
		return new Tree<Integer>(a.getRight().getLeft().getValue(), 
				new Tree<Integer>(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
				new Tree<Integer>(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight()));
	}
	
}
