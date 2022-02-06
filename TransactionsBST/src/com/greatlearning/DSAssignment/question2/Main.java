package com.greatlearning.DSAssignment.question2;

import com.greatlearning.DSAssignment.question2.Driver.Node;

public class Main {
	static Node lastNode = null;
	static Node headNode = null;

	public Node skewedTree(Node root, int value) {
		if (root == null) {
			return null;
		}

		if (value > 0) {
			skewedTree(root.right, value);
		} else {
			skewedTree(null, root.left.value);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			lastNode = root;
		} else {
			lastNode.right = root;
			root.left = null;
			lastNode = root;
		}

		if (value > 0) {
			skewedTree(leftNode, value);
		} else {
			skewedTree(rightNode, value);
		}
		return headNode;
	}

	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		traverseRightSkewed(root.right);
	}
}