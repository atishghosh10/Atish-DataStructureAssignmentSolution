package com.greatlearning.DSAssignment.question2;

public class Driver {
	public static Node node;

	static class Node {
		int value;
		Node left, right;

		Node(int i) {
			value = i;
			left = right = null;
		}

		public static void main(String[] args) {
			node = new Node(50);
			node.left = new Node(30);
			node.right = new Node(60);
			node.left.left = new Node(10);
			node.right.left = new Node(55);
			int value = 0;
			Main main = new Main();
			Node headNode = main.skewedTree(node, value);
			main.traverseRightSkewed(headNode);
		}
	}

}
