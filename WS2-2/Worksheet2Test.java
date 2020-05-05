import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** 
 * @author <Chirag Bhatti> (CXB937)
 * @version 01/02/2020
 * 
 * This class contains the test cases for Worksheet2 solutions.
 */

public class Worksheet2Test {

	// Ex1 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex1 TestA - Checks negating an empty tree returns an empty tree
	 */
	@Test
	public void Ex1TestA() {

		Tree<Integer> t = new Tree<Integer>();
		
		Tree<Integer> resultA 	= Worksheet2.negateAll(t);
		Tree<Integer> correctA 	= new Tree<Integer>();

		assertEquals(correctA, resultA);
	}
		
	/**
	 * Ex1 TestB - Checks negating a tree with a single positive root node returns a single negative root node
	 */
	@Test
	public void Ex1TestB() {

		Tree<Integer> t = new Tree<Integer>(1);
		
		Tree<Integer> resultB 	= Worksheet2.negateAll(t);
		Tree<Integer> correctB 	= new Tree<Integer>(-1);

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex1 TestC - Checks negating a tree with a single negative root node returns a single positive root node
	 */
	@Test
	public void Ex1TestC() {

		Tree<Integer> t = new Tree<Integer>(-1);
		
		Tree<Integer> resultC 	= Worksheet2.negateAll(t);
		Tree<Integer> correctC 	= new Tree<Integer>(1);

		assertEquals(correctC, resultC);
	}
	
	/**
	 * Ex1 TestD - Checks negating a tree with a single zero root node returns a single zero node
	 */
	@Test
	public void Ex1TestD() {

		Tree<Integer> t = new Tree<Integer>(0);
		
		Tree<Integer> resultD 	= Worksheet2.negateAll(t);
		Tree<Integer> correctD 	= new Tree<Integer>(0);

		assertEquals(correctD, resultD);
	}
	
	/**
	 * Ex1 TestE - Checks negating a tree with a mixture of zero, positive and negative nodes returns a tree with 
	 * the correctly negated nodes
	 */
	@Test
	public void Ex1TestE() {

		Tree<Integer> t = new Tree<Integer>(1, 
				new Tree<Integer>(-2, new Tree<Integer>(8), new Tree<Integer>(3)), 
				new Tree<Integer>(0, new Tree<Integer>(-6), new Tree<Integer>(-10)));
		
		Tree<Integer> resultE 	= Worksheet2.negateAll(t);
		Tree<Integer> correctE 	= new Tree<Integer>(-1, 
				new Tree<Integer>(2, new Tree<Integer>(-8), new Tree<Integer>(-3)), 
				new Tree<Integer>(0, new Tree<Integer>(6), new Tree<Integer>(10)));

		assertEquals(correctE, resultE);
	}
	
	// Ex2 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex2 TestA - Checks an empty tree is true (vacuous) for all even
	 */
	@Test
	public void Ex2TestA() {

		Tree<Integer> t = new Tree<Integer>();
		
		boolean resultA 	= Worksheet2.allEven(t);
		boolean correctA 	= true;

		assertEquals(correctA, resultA);
	}
	
	/**
	 * Ex2 TestB - Checks a tree with a mixture of zero, even, negative and positive elements is true for all even numbers
	 */
	@Test
	public void Ex2TestB() {

		Tree<Integer> t = new Tree<Integer>(2, 
				new Tree<Integer>(8, new Tree<Integer>(22), new Tree<Integer>(4)), 
				new Tree<Integer>(-10, new Tree<Integer>(-6), new Tree<Integer>(0)));
		
		boolean resultB 	= Worksheet2.allEven(t);
		boolean correctB 	= true;

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex2 TestB - Checks a tree with a mixture of zero, ODD, even, negative and positive elements is false for all even numbers
	 */
	@Test
	public void Ex2TestC() {

		Tree<Integer> t = new Tree<Integer>(2, 
				new Tree<Integer>(-7, new Tree<Integer>(8, new Tree<Integer>(0), new Tree<Integer>()), new Tree<Integer>(3)), 
				new Tree<Integer>(-10, new Tree<Integer>(12), new Tree<Integer>(13)));
		
		boolean resultC 	= Worksheet2.allEven(t);
		boolean correctC 	= false;

		assertEquals(correctC, resultC);
	}
	
	// Ex3 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex3 TestA - Tests trying to find the depth of an element in an empty tree gives -1
	 */
	@Test
	public void Ex3TestA() {

		Tree<Integer> t = new Tree<Integer>();
		
		int resultA 	= Worksheet2.depth(t, 14);
		int correctA 	= -1;

		assertEquals(correctA, resultA);
	}
	
	/**
	 * Ex3 TestB - Tests trying to find the depth of an element in a tree with a single root node is 0 when the root node matches
	 */
	@Test
	public void Ex3TestB() {

		Tree<Integer> t = new Tree<Integer>(14);
		
		int resultB		= Worksheet2.depth(t, 14);
		int correctB 	= 0;

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex3 TestC - Tests trying to find a variety of numbers in a substantial tree that are and aren't present gives the correct depths
	 */
	@Test
	public void Ex3TestC() {

		Tree<Integer> t = new Tree<Integer>(2, 
				new Tree<Integer>(8, new Tree<Integer>(22), new Tree<Integer>(4)), 
				new Tree<Integer>(-10, new Tree<Integer>(-6), new Tree<Integer>(0)));
		
		int resultC;
		int correctC;
		
		resultC		= Worksheet2.depth(t, 5); 
		correctC 	= -1;
		assertEquals(correctC, resultC);
		
		resultC		= Worksheet2.depth(t, 2);
		correctC 	= 0;
		assertEquals(correctC, resultC);
		
		resultC		= Worksheet2.depth(t, 8);
		correctC 	= 1;
		assertEquals(correctC, resultC);
		
		resultC		= Worksheet2.depth(t, -6);
		correctC 	= 2;
		assertEquals(resultC, correctC);
		
	}
	
	// Ex4 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex4 TestA - Tests preorder of an empty tree returns an empty list
	 */
	@Test
	public void Ex4TestA() {

		Tree<Integer> t = new Tree<>();
		
		List<Integer> resultA 	= Worksheet2.preorder(t);
		List<Integer> correctA 	= new List<>();
		
		assertEquals(correctA, resultA);

	}
	
	/**
	 * Ex4 TestA - Tests preorder of a single element tree gives a list with a single element
	 */
	@Test
	public void Ex4TestB() {

		Tree<Integer> t = new Tree<>(2);
		
		List<Integer> resultB 	= Worksheet2.preorder(t);
		List<Integer> correctB 	= new List<>(2, new List<>());
		
		assertEquals(correctB, resultB);

	}
	
	/**
	 * Ex4 TestC - Tests preorder of a substantial tree with a mixture of zero, negative and positive integer elements
	 * gives the correct list
	 */
	@Test
	public void Ex4TestC() {

		Tree<Integer> t = new Tree<>(2, 
				new Tree<>(8, new Tree<>(22), new Tree<>(4)), 
				new Tree<>(-10, new Tree<>(-6), new Tree<>(0)));
		
		List<Integer> resultC 	= Worksheet2.preorder(t);
		List<Integer> correctC 	= new List<>(2, new List<>(8, new List<>(22, new List<>(4, new List<>(-10, new List<>(-6, new List<>(0, new List<>())))))));
		
		assertEquals(correctC, resultC);

	}
	
	/**
	 * Ex4 TestD - Tests preorder of a tree that has no left subtree from its root node gives the correct list
	 */
	@Test
	public void Ex4TestD() {

		Tree<Integer> t = new Tree<>(2, 
				new Tree<>(), 
				new Tree<>(-10, new Tree<>(-6), new Tree<>(0)));
		
		List<Integer> resultD 	= Worksheet2.preorder(t);
		List<Integer> correctD 	= new List<>(2, new List<>(-10, new List<>(-6, new List<>(0, new List<>()))));
		
		assertEquals(correctD, resultD);

	}
	
	// Ex5 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex5 TestA - Tests an empty tree for BST property is true (vacuous)
	 */
	@Test
	public void Ex5TestA() {

		Tree<Integer> t = new Tree<Integer>();
		
		boolean resultA 	= Worksheet2.isSearchTree(t);
		boolean correctA 	= true;

		assertEquals(correctA, resultA);
	}

	/**
	 * Ex5 TestB - Tests a tree with just a root node for the BST property is true
	 */
	@Test
	public void Ex5TestB() {

		Tree<Integer> t = new Tree<Integer>(2);
		
		boolean resultB 	= Worksheet2.isSearchTree(t);
		boolean correctB 	= true;

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex5 TestC - Tests a substantial tree for BST property is true
	 */
	@Test
	public void Ex5TestC() {

		Tree<Integer> t = new Tree<>(100,
		new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
		new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
				
		boolean resultC 	= Worksheet2.isSearchTree(t);
		boolean correctC 	= true;

		assertEquals(correctC, resultC);
	}
	
	/**
	 * Ex5 TestD - Tests a substantial tree for BST property is false due to left node being higher than its parent node
	 */
	@Test
	public void Ex5TestD() {

		Tree<Integer> t = new Tree<>(100,
		new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
		new Tree<>(150, new Tree<>(130, new Tree<>(135, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
		//Element 135 in the tree instantiation above violates the BST property
		
		boolean resultD 	= Worksheet2.isSearchTree(t);
		boolean correctD 	= false;

		assertEquals(correctD, resultD);
	}
	
	/**
	 * Ex5 TestE - Tests another tree for BST property is false due to a node being higher than the root node, but is correct higher
	 * than its parent node as it is to its right
	 */
	@Test
	public void Ex5TestE() {

		Tree<Integer> t = new Tree<>(15,
	            new Tree<>(10, new Tree<>(5), new Tree<>(20)),
	            new Tree<>(25, new Tree<>(), new Tree<>(30))); 
		// Element 20 in the tree instantiation above violates the BST property
		
		boolean resultE 	= Worksheet2.isSearchTree(t);
		boolean correctE 	= false;
		
		assertEquals(resultE, correctE);
	}
	
	// Ex6 Tests NOT REQUIRED ---------------------------------------------------------------------------------------
	
	// Ex7 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex7 TestA - Tests trying to find the maximum integer in an empty tree throws an illegal argument exception
	 */
	@Test (expected = IllegalArgumentException.class)
	public void Ex7TestA() {

		Tree<Integer> t = new Tree<>();
		Worksheet2.max(t);

	}
	
	/**
	 * Ex7 TestB - Tests finding the maximum value in a BST with just a single root node
	 */
	@Test
	public void Ex7TestB() {

		Tree<Integer> t = new Tree<>(14);
		
		int resultB 	= Worksheet2.max(t);
		int correctB 	= 14;

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex7 TestC - Tests finding the maximum in a BST where the max node has a left subtree
	 */
	@Test
	public void Ex7TestC() {

		Tree<Integer> t = new Tree<>(10, new Tree<>(2), new Tree<>(20, new Tree<>(15), new Tree<>()));
		
		int resultC 	= Worksheet2.max(t);
		int correctC 	= 20;

		assertEquals(correctC, resultC);
	}
	
	/**
	 * Ex7 TestD - Tests finding the maximum in a BST where the max is in the bottom right corner
	 * and this max node has no subtrees
	 */
	@Test
	public void Ex7TestD() {

		Tree<Integer> t = new Tree<>(10, new Tree<>(2), new Tree<>(20, new Tree<>(15), new Tree<>(30)));
		
		int resultD 	= Worksheet2.max(t);
		int correctD	= 30;

		assertEquals(correctD, resultD);
	}
	
	/**
	 * Ex7 TestE - Tests finding the maximum in a BST with negative numbers where the max node has a left
	 * subtree
	 */
	@Test
	public void Ex7TestE() {

		Tree<Integer> t = new Tree<>(-10, new Tree<>(-20, new Tree<>(-30), new Tree<>(-15)), new Tree<>(-2, new Tree<>(-5), new Tree<>()));
		
		int resultE		= Worksheet2.max(t);
		int correctE	= -2;

		assertEquals(correctE, resultE);
	}
	
	/**
	 * Ex7 TestF - Tests finding the maximum in a BST where there is no right subtree from the root node, and the max node is 
	 * the root node even though it has a left subtree which has its own further subtrees
	 */
	@Test
	public void Ex7TestF() {

		Tree<Integer> t = new Tree<>(10, new Tree<>(6, new Tree<>(4), new Tree<>(8)), new Tree<>());
		
		int resultF		= Worksheet2.max(t);
		int correctF	= 10;

		assertEquals(correctF, resultF);
	}
	
	// Ex8 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex8 TestA - Tests deleting an integer from an empty tree returns an empty tree
	 */
	@Test
	public void Ex8TestA() {

		Tree<Integer> t = new Tree<>();
		
		Tree<Integer> resultA 	= Worksheet2.delete(t, 14);
		Tree<Integer> correctA 	= new Tree<>();

		assertEquals(correctA, resultA);
	}
	
	/**
	 * Ex8 TestB - Tests deleting the value stored at the root node from a tree with a single root node element gives 
	 * an empty tree
	 */
	@Test
	public void Ex8TestB() {

		Tree<Integer> t = new Tree<>(14);
		
		Tree<Integer> resultA 	= Worksheet2.delete(t, 14);
		Tree<Integer> correctA 	= new Tree<>();

		assertEquals(correctA, resultA);
	}
	
	/**
	 * Ex8 TestC - Tests deleting an integer from a BST (with just a single root node element) that is not in the BST, 
	 * just returns the same tree of integers
	 */
	@Test
	public void Ex8TestC() {

		Tree<Integer> t = new Tree<>(4);
		
		Tree<Integer> resultC 	= Worksheet2.delete(t, 14);
		Tree<Integer> correctC 	= new Tree<>(4);

		assertEquals(correctC, resultC);
	}
	
	/**
	 * Ex8 TestD - Tests deleting the integer 130 contained in a substantial BST returns the correct tree.
	 * Deleting 130 requires the method to have found the max value in the left subtree and replace the deleted node with this value, 
	 * and remove the max value from the left subtree. The right subtree must also be retained.
	 */
	@Test
	public void Ex8TestD() {
		
		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
		
		Tree<Integer> resultD 	= Worksheet2.delete(t, 130);
		
		Tree<Integer> correctD = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(120, new Tree<>(110, new Tree<>(108), new Tree<>()), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 

		
		assertEquals(correctD, resultD);
	}
	
	/**
	 * Ex8 TestE - Tests deleting an integer at a node whose right subtree is empty and should therefore return the left subtree as the result of the deletion
	 */
	@Test
	public void Ex8TestE() {
		
		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10), new Tree<>(60)),
				new Tree<>()); 
		
		Tree<Integer> resultE 	= Worksheet2.delete(t, 100); // Deletes a node with left and right subtrees, thereby requiring the code to do more tasks for deletion
		
		Tree<Integer> correctE = new Tree<>(20, new Tree<>(10), new Tree<>(60));

		
		assertEquals(correctE, resultE);
	}
	
	/**
	 * Ex8 TestF - Tests deleting an integer at a node whose right subtree is empty and should therefore return the left subtree as the result of the deletion
	 */
	@Test
	public void Ex8TestF() {
		
		Tree<Integer> t = new Tree<>(100,
				new Tree<>(),
				new Tree<>(150, new Tree<>(130), new Tree<>(160))); 
		
		Tree<Integer> resultF 	= Worksheet2.delete(t, 100); // Deletes a node with left and right subtrees, thereby requiring the code to do more tasks for deletion
		
		Tree<Integer> correctF = new Tree<>(150, new Tree<>(130), new Tree<>(160));

		
		assertEquals(correctF, resultF);
	}
	
	// Ex9 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex9 TestA - Tests an empty tree is true for height balance
	 */
	@Test
	public void Ex9TestA() {

		Tree<Integer> t = new Tree<>();
		
		boolean resultA 	= Worksheet2.isHeightBalanced(t);
		boolean correctA 	= true;

		assertEquals(correctA, resultA);
	}
	
	/**
	 * Ex9 TestB - Tests a tree with a single root node element is true for height balance
	 */
	@Test
	public void Ex9TestB() {

		Tree<Integer> t = new Tree<>(14);
		
		boolean resultB		= Worksheet2.isHeightBalanced(t);
		boolean correctB 	= true;

		assertEquals(correctB, resultB);
	}
	
	/**
	 * Ex9 TestC - Tests a tree without a right subtree and a left subtree of height 2 is not height balanced
	 */
	@Test
	public void Ex9TestC() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10), new Tree<>(60)),
				new Tree<>()); 
		
		boolean resultC 	= Worksheet2.isHeightBalanced(t);
		boolean correctC 	= false;

		assertEquals(correctC, resultC);
	}
	
	/**
	 * Ex9 TestD - Tests a substantial tree for height balance property is true
	 */
	@Test
	public void Ex9TestD() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
		
		boolean resultD		= Worksheet2.isHeightBalanced(t);
		boolean correctD 	= true;

		assertEquals(correctD, resultD);
	}

	/**
	 * Ex9 TestE - Tests a substantial tree for the height balance property is false due to an imbalance between the right and left subtrees of the root node. 
	 * Integer 106 is in this right subtree of the root node at a height of 5, compared to the height of the left subtree which is 3.
	 */
	@Test
	public void Ex9TestE() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108, new Tree<>(106), new Tree<>()), 
						new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
				
		boolean resultE		= Worksheet2.isHeightBalanced(t);
		boolean correctE 	= false;

		assertEquals(correctE, resultE);
	}
	
	/**
	 * Ex9 TestF - Tests a substantial tree for height balance property is false due to an imbalance within the left subtree of the root node itself.
	 * Integers 72 and 74 in this left subtree belong to the right subtree of integer 70 which has a height of 2 and its left subtree of which is empty.
	 */
	@Test
	public void Ex9TestF() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70, 
						new Tree<>(), new Tree<>(72, new Tree<>(), new Tree<>(74))))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), 
						new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
				
		boolean resultF		= Worksheet2.isHeightBalanced(t);
		boolean correctF	= false;

		assertEquals(correctF, resultF);
	}
	
	// Ex10 Tests ----------------------------------------------------------------------------------------------------

	//Test for InsertHB method
	
	/**
	 * Ex10 TestA - Tests the insert method on an empty tree returns a tree with a single root node containing the integer
	 */
	@Test
	public void Ex10TestA() {

		Tree<Integer> t = new Tree<>();
		
		Tree<Integer> resultA	= Worksheet2.insertHB(t, 1);
		Tree<Integer> correctA 	= new Tree<>(1);

		assertEquals(correctA, resultA);
		assertEquals(true, Worksheet2.isHeightBalanced(resultA));
		assertEquals(true, Worksheet2.isSearchTree(resultA));
	}
	
	/**
	 * Ex10 TestB - Tests the insert method on a AVL with a single root node inserts correctly to the left
	 */
	@Test
	public void Ex10TestB() {

		Tree<Integer> t = new Tree<>(2);
		
		Tree<Integer> resultB	= Worksheet2.insertHB(t, 1);
		Tree<Integer> correctB 	= new Tree<>(2, new Tree<>(1), new Tree<>());

		assertEquals(correctB, resultB);
		assertEquals(true, Worksheet2.isHeightBalanced(resultB));
		assertEquals(true, Worksheet2.isSearchTree(resultB));

	}
	
	/**
	 * Ex10 TestC - Tests the insert method on a AVL with a single root node inserts correctly to the right
	 */
	@Test
	public void Ex10TestC() {

		Tree<Integer> t = new Tree<>(2);
		
		Tree<Integer> resultC	= Worksheet2.insertHB(t, 3);
		Tree<Integer> correctC 	= new Tree<>(2, new Tree<>(), new Tree<>(3));

		assertEquals(correctC, resultC);
		assertEquals(true, Worksheet2.isHeightBalanced(resultC));
		assertEquals(true, Worksheet2.isSearchTree(resultC));
	}
	
	/**
	 * Ex10 TestD - Tests the insert method on a AVL with two elements leads to an LL case needing rotation
	 */
	@Test
	public void Ex10TestD() {

		Tree<Integer> t = new Tree<>(3, new Tree<>(2), new Tree<>());
		
		Tree<Integer> resultD	= Worksheet2.insertHB(t, 1);
		Tree<Integer> correctD 	= new Tree<>(2, new Tree<>(1), new Tree<>(3));

		assertEquals(correctD, resultD);
		assertEquals(true, Worksheet2.isHeightBalanced(resultD));
		assertEquals(true, Worksheet2.isSearchTree(resultD));
}
	
	/**
	 * Ex10 TestE - Tests the insert method on a AVL with two elements leads to an LR case needing rotation
	 */
	@Test
	public void Ex10TestE() {

		Tree<Integer> t = new Tree<>(4, new Tree<>(2), new Tree<>());
		
		Tree<Integer> resultE	= Worksheet2.insertHB(t, 3);
		Tree<Integer> correctE 	= new Tree<>(3, new Tree<>(2), new Tree<>(4));

		assertEquals(correctE, resultE);
		assertEquals(true, Worksheet2.isHeightBalanced(resultE));
		assertEquals(true, Worksheet2.isSearchTree(resultE));
}
	
	/**
	 * Ex10 TestF - Tests the insert method on a AVL with two elements leads to an RR case needing rotation
	 */
	@Test
	public void Ex10TestF() {

		Tree<Integer> t = new Tree<>(1, new Tree<>(), new Tree<>(2));
		
		Tree<Integer> resultF	= Worksheet2.insertHB(t, 3);
		Tree<Integer> correctF 	= new Tree<>(2, new Tree<>(1), new Tree<>(3));

		assertEquals(correctF, resultF);
		assertEquals(true, Worksheet2.isSearchTree(resultF));
		assertEquals(true, Worksheet2.isHeightBalanced(resultF));
	}
	
	/**
	 * Ex10 TestG - Tests the insert method on a AVL with two elements leads to an RL case needing rotation
	 */
	@Test
	public void Ex10TestG() {

		Tree<Integer> t = new Tree<>(1, new Tree<>(), new Tree<>(3));
		
		Tree<Integer> resultG	= Worksheet2.insertHB(t, 2);
		Tree<Integer> correctG 	= new Tree<>(2, new Tree<>(1), new Tree<>(3));

		assertEquals(correctG, resultG);
		assertEquals(true, Worksheet2.isHeightBalanced(resultG));
		assertEquals(true, Worksheet2.isSearchTree(resultG));
}
	
	/**
	 * Ex10 TestH - Tests the insert method on a substantial AVL. We add the element 106 which causes a LL type
	 * imbalance at the node 130 (left of 150) in the right subtree of the root node, making the method do a right rotation 
	 * to rebalance the tree. The rebalanced tree must again form the left subtree of the node holding integer 150.
	 */
	@Test
	public void Ex10TestH() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
		
		Tree<Integer> resultH	= Worksheet2.insertHB(t, 106);
		
		Tree<Integer> correctH = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(110, new Tree<>(108, new Tree<>(106), new Tree<>()), new Tree<>(130, new Tree<>(120), new Tree<>(141))), 
						new Tree<>(160, new Tree<>(153), new Tree<>(170))));

		assertEquals(resultH, correctH);
		assertEquals(true, Worksheet2.isHeightBalanced(resultH));
		assertEquals(true, Worksheet2.isSearchTree(resultH));
	}
	
	
	/**
	 * Ex10 TestI - Tests the insert method on a substantial AVL. We add the element 122 which causes a LR type
	 * imbalance at the node 130 (left of 150) in the right subtree of the root node, making the method do a left
	 * the right rotation to rebalance the tree. The rebalanced tree must again form the left subtree of the node 
	 * holding integer 150.
	 */
	@Test
	public void Ex10TestI() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
	
		Tree<Integer> resultI	= Worksheet2.insertHB(t, 122);
		
		Tree<Integer> correctI = new Tree<>(100,
				new Tree<>(20, 
						new Tree<>(10, new Tree<>(7), new Tree<>(19)), 
						new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, 
						new Tree<>(120, new Tree<>(110, new Tree<>(108), new Tree<>()), new Tree<>(130, new Tree<>(122), new Tree<>(141))), 
						new Tree<>(160, new Tree<>(153), new Tree<>(170))));
		
		assertEquals(resultI, correctI);
		assertEquals(true, Worksheet2.isHeightBalanced(resultI));
		assertEquals(true, Worksheet2.isSearchTree(resultI));
	}
	
	//Test for DeleteHB method
	
	/**
	 * Ex10 TestJ - Tests trying to delete from an empty search tree gives an empty search tree.
	 */
	@Test
	public void Ex10TestJ() {

		Tree<Integer> t = new Tree<>();
				
		Tree<Integer> resultJ	= Worksheet2.deleteHB(t, 14);
		
		Tree<Integer> correctJ = new Tree<>();
		
		assertEquals(resultJ, correctJ);
		assertEquals(true, Worksheet2.isHeightBalanced(resultJ));
		assertEquals(true, Worksheet2.isSearchTree(resultJ));
	}
	
	/**
	 * Ex10 TestK - Tests deleting the integer at the root from a single root node AVL tree gives an empty tree
	 */
	@Test
	public void Ex10TestK() {

		Tree<Integer> t = new Tree<>(14);
				
		Tree<Integer> resultK	= Worksheet2.deleteHB(t, 14);
		
		Tree<Integer> correctK = new Tree<>();
		
		assertEquals(resultK, correctK);
		assertEquals(true, Worksheet2.isHeightBalanced(resultK));
		assertEquals(true, Worksheet2.isSearchTree(resultK));
	}
	
	/**
	 * Ex10 TestL - Tests deleting the integer at the root from a single root node AVL tree gives an empty tree
	 */
	@Test
	public void Ex10TestL() {

		Tree<Integer> t = new Tree<>(14);
				
		Tree<Integer> resultL	= Worksheet2.deleteHB(t, 14);
		
		Tree<Integer> correctL = new Tree<>();
		
		assertEquals(resultL, correctL);
		assertEquals(true, Worksheet2.isHeightBalanced(resultL));
		assertEquals(true, Worksheet2.isSearchTree(resultL));
	}
	
	/**
	 * Ex10 TestM - Tests deleting an integer from an AVL tree leaving an LL case returns an AVL tree due to rotation
	 */
	@Test
	public void Ex10TestM() {

		Tree<Integer> t = new Tree<>(3, new Tree<>(2, new Tree<>(1), new Tree<>()), new Tree<>(4));
				
		Tree<Integer> resultM	= Worksheet2.deleteHB(t, 4);
		
		Tree<Integer> correctM = new Tree<>(2, new Tree<>(1), new Tree<>(3));
		
		assertEquals(resultM, correctM);
		assertEquals(true, Worksheet2.isHeightBalanced(resultM));
		assertEquals(true, Worksheet2.isSearchTree(resultM));
	}
	
	/**
	 * Ex10 TestN - Tests deleting an integer from an AVL tree leaving an LR case returns an AVL tree due to rotation
	 */
	@Test
	public void Ex10TestN() {

		Tree<Integer> t = new Tree<>(4, new Tree<>(2, new Tree<>(), new Tree<>(3)), new Tree<>(5));
				
		Tree<Integer> resultN	= Worksheet2.deleteHB(t, 5);
		
		Tree<Integer> correctN = new Tree<>(3, new Tree<>(2), new Tree<>(4));
		
		assertEquals(resultN, correctN);
		assertEquals(true, Worksheet2.isHeightBalanced(resultN));
		assertEquals(true, Worksheet2.isSearchTree(resultN));
	}
	
	/**
	 * Ex10 TestO - Tests deleting an integer from an AVL tree leaving an RR case returns an AVL tree due to rotation
	 */
	@Test
	public void Ex10TestO() {

		Tree<Integer> t = new Tree<>(2, new Tree<>(1), new Tree<>(3, new Tree<>(), new Tree<>(4)));
				
		Tree<Integer> resultO	= Worksheet2.deleteHB(t, 1);
		
		Tree<Integer> correctO = new Tree<>(3, new Tree<>(2), new Tree<>(4));
		
		assertEquals(resultO, correctO);
		assertEquals(true, Worksheet2.isHeightBalanced(resultO));
		assertEquals(true, Worksheet2.isSearchTree(resultO));
	}
	
	/**
	 * Ex10 TestP - Tests deleting an integer from an AVL tree leaving an RL case returns an AVL tree due to rotation
	 */
	@Test
	public void Ex10TestP() {

		Tree<Integer> t = new Tree<>(3, new Tree<>(2), new Tree<>(5, new Tree<>(4), new Tree<>()));
				
		Tree<Integer> resultP	= Worksheet2.deleteHB(t, 2);
		
		Tree<Integer> correctP = new Tree<>(4, new Tree<>(3), new Tree<>(5));
		
		assertEquals(resultP, correctP);
		assertEquals(true, Worksheet2.isHeightBalanced(resultP));
		assertEquals(true, Worksheet2.isSearchTree(resultP));
	}
	
	/**
	 * Ex10 TestQ - Tests deleting an integer from an AVL tree leaving an RR case with subtrees returns an AVL tree 
	 * due to rotation
	 */
	@Test
	public void Ex10TestQ() {

		Tree<Integer> t = new Tree<>(60, new Tree<>(50), new Tree<>(70, new Tree<>(65), new Tree<>(80)));
				
		Tree<Integer> resultQ	= Worksheet2.deleteHB(t, 50);
		
		Tree<Integer> correctQ = new Tree<>(70, new Tree<>(60, new Tree<>(), new Tree<>(65)), new Tree<>(80));
		
		assertEquals(resultQ, correctQ);
		assertEquals(true, Worksheet2.isHeightBalanced(resultQ));
		assertEquals(true, Worksheet2.isSearchTree(resultQ));
	}
	
	/**
	 * Ex10 TestQ - Tests deleting the root node from a substantial AVL tree results in an AVL tree that didn't need
	 * rotation
	 */
	@Test
	public void Ex10TestR() {

		Tree<Integer> t = new Tree<>(100,
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>(70))),
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170)))); 
					
		Tree<Integer> resultR	= Worksheet2.deleteHB(t, 100);
		
		Tree<Integer> correctR = new Tree<>(70, 
				new Tree<>(20, new Tree<>(10, new Tree<>(7), new Tree<>(19)), new Tree<>(60, new Tree<>(52), new Tree<>())), 
				new Tree<>(150, new Tree<>(130, new Tree<>(110, new Tree<>(108), new Tree<>(120)), new Tree<>(141)), new Tree<>(160, new Tree<>(153), new Tree<>(170))));
		
		assertEquals(resultR, correctR);
		assertEquals(true, Worksheet2.isHeightBalanced(resultR));
		assertEquals(true, Worksheet2.isSearchTree(resultR));
	}
	
	/**
	 * Ex10 TestS - Tests deleting the integer 5 from an AVL tree, reading to an imbalance at the root node between the left and
	 * right subtrees (the right is heavier as it is +2 in height compared to the left). This requires two rotations to return an AVL
	 * tree.
	 */
	@Test
	public void Ex10TestS() {

		Tree<Integer> t = new Tree<>(9,
				new Tree<>(2, new Tree<>(1), new Tree<>(6, new Tree<>(5), new Tree<>())),
				new Tree<>(15, new Tree<>(13, new Tree<>(11, new Tree<>(10), new Tree<>(12)), new Tree<>(14)), new Tree<>(17, new Tree<>(16), new Tree<>(18)))); 
					
		Tree<Integer> resultS	= Worksheet2.deleteHB(t, 5);
		
		Tree<Integer> correctS = new Tree<>(13, 
				new Tree<>(9, new Tree<>(2, new Tree<>(1), new Tree<>(6)), new Tree<>(11, new Tree<>(10), new Tree<>(12))), 
				new Tree<>(15, new Tree<>(14), new Tree<>(17, new Tree<>(16), new Tree<>(18))));
		
		assertEquals(resultS, correctS);
		assertEquals(true, Worksheet2.isHeightBalanced(resultS));
		assertEquals(true, Worksheet2.isSearchTree(resultS));
	}
		
}
	
