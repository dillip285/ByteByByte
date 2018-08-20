package com.dillip.practice.solutions;

import java.util.LinkedList;

import com.dillip.practice.BaseStructure;

public class PrintLinkedListInReverseOrder extends BaseStructure {
	private Node linkedList;

	@Override
	public void prepareInput() {
		Node head = new Node();
		linkedList = head;
		for (int i = 1; i <= 10; i++) {
			head.data = i;
			head.next = new Node();
			head = head.next;

		}

	}

	@Override
	public void execute() {
		prepareInput();
		System.out.println("*********Recursively***********");
		printUsingRecursion(linkedList);
		System.out.println("*********Iteratively***********");
		printIteratively(linkedList);
	}
	
	private void printIteratively(Node node) {
		LinkedList<Node> stack= new LinkedList<>();
		
		while(node.next!=null) {
			stack.push(node);
			node=node.next;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}
	}

	private void printUsingRecursion(Node node) {

		if (node.next != null) {

			printUsingRecursion(node.next);
			System.out.println(node.data);

		}

	}

	private class Node {
		int data;
		Node next;
	}

}
