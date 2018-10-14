package singleLinkedList;

import java.util.HashMap;
import java.util.Map;

public class SLLOperations implements IOperation{
	
	public ListNode constructSLLandReturnHead(){


		//ListNode<Integer> node06 = new ListNode<Integer>(60, null);
		ListNode<Integer> node05 = new ListNode<Integer>(90, null);
		ListNode<Integer> node04 = new ListNode<Integer>(70, node05);
		ListNode<Double> node03 = new ListNode<Double>(0.0, null);
		ListNode<Double> node02 = new ListNode<Double>(0.0, node03);
		ListNode<Double> node01 = new ListNode<Double>(1.0, node02);
		
		
		//ListNode<Integer> node11 = new ListNode<Integer>(110, null);
/*		ListNode<Integer> node10 = new ListNode<Integer>(101, null);
		ListNode<Integer> node09 = new ListNode<Integer>(91, node10);
		ListNode<Integer> node08 = new ListNode<Integer>(8, node09);
		ListNode<Integer> node07 = new ListNode<Integer>(7, node08);
		ListNode<Integer> node06 = new ListNode<Integer>(6, node07);
		ListNode<Integer> node05 = new ListNode<Integer>(6, null);
		ListNode<Integer> node04 = new ListNode<Integer>(4, node05);
		ListNode<Integer> node03 = new ListNode<Integer>(9, node04);
		ListNode<Integer> node02 = new ListNode<Integer>(5, node03);
		ListNode<Integer> node01 = new ListNode<Integer>(7, node02);*/
		
		// Making cyclic
		//node10.setNext(node05);
		return node01;
	}
	
	
	public ListNode constructSLLandReturnHead2(){
		ListNode<Integer> node10 = new ListNode<Integer>(1000, null);
		ListNode<Integer> node09 = new ListNode<Integer>(99, node10);
		ListNode<Integer> node08 = new ListNode<Integer>(80, node09);
		ListNode<Integer> node07 = new ListNode<Integer>(75, node08);
		ListNode<Integer> node06 = new ListNode<Integer>(100, null);
		ListNode<Integer> node05 = new ListNode<Integer>(95, node06);
		ListNode<Integer> node04 = new ListNode<Integer>(80, node05);
		ListNode<Integer> node03 = new ListNode<Integer>(60, node04);
		ListNode<Integer> node02 = new ListNode<Integer>(40, node03);
		ListNode<Integer> node01 = new ListNode<Integer>(20, node02);
		
		// Making cyclic
		//node10.setNext(node05);
		return node01;
	}
	
	// Get length of LinkedList
	@Override
	public int getLength(ListNode listNode){
		int count = 0;
		while(listNode != null){
			count ++;
			listNode = listNode.getNext();
		}
		return count;
	}
	
	// Get length Recursively
	// Pass head node and lengthCounter = 0 in argument
    @Override
	public int getLengthRecursive(ListNode listNode, int lengthCounter){
		if(listNode == null)
			return lengthCounter;
		
		return getLengthRecursive(listNode.getNext(), ++lengthCounter);
	}
	
	
	// Print Single LinkedList
    @Override
	public void printSLL(ListNode head){
		while(head != null){
			System.out.println(head.getData());
			head = head.getNext();
		}
	}
	
	// Insert before head
    @Override
	public ListNode insertBeforeHead(ListNode head, ListNode newNode){
		newNode.setNext(head);
		return newNode;
	}
	
	// insert neNode after tail
    @Override
	public void insertAfterTail(ListNode head, ListNode newNode){
		while(head.getNext() != null)
			head = head.getNext();
		head.setNext(newNode);
	}
	
	// insert NewNode After Node Passed In Argument. NewNode and nodeAfterWhichNewNodeToBeInserted passed in argument
    @Override
	public void insertNewNodeAfterNodePassedInArgument(ListNode nodeAfterWhichNewNodeToBeInserted, ListNode newNode){
		newNode.setNext(nodeAfterWhichNewNodeToBeInserted.getNext());
		nodeAfterWhichNewNodeToBeInserted.setNext(newNode);
	}
	
	// Insert NewNode at middle position of LinkedList
    @Override
	public void insertAtMiddle(ListNode head, ListNode newNode){
		if(this.getLength(head) < 2){
			System.out.print("Middle is not possible");
			return;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while(fastPointer.getNext()!= null){
			fastPointer = fastPointer.getNext();
			if(fastPointer.getNext() == null){
				insertNewNodeAfterNodePassedInArgument(slowPointer, newNode);
				return;
			}
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
			if(fastPointer.getNext() == null){
				insertNewNodeAfterNodePassedInArgument(slowPointer, newNode);
				return;
			}
		}
	}
	
	// Find the middle node of LinkedList
    @Override
	public ListNode getMiddleNode(ListNode head){
		if(head == null)
			return null;
		
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer.getNext()!= null){
			fastPointer = fastPointer.getNext();
			if(fastPointer.getNext() == null)
				return slowPointer;
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
		}
		
		return slowPointer;
	}
	
	// Find Nth node from end of LinkedList. N is provided in argument
    @Override
	public ListNode getNthNodeFromEnd(ListNode head, int n){
		if(head == null)
			return null;
			
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		int count = 1;
		while(count < n){
			if(fastPointer.getNext() == null){
				System.out.println("Not possible");
				return null;
			}
			fastPointer = fastPointer.getNext();
			count++;
		}

		while(fastPointer.getNext() != null){
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
		}
		return slowPointer;
	}
	
	// If LinkedList is cyclic
    @Override
	public boolean isCyclic(ListNode head){
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer.getNext()!= null){
			fastPointer = fastPointer.getNext();
			if(fastPointer.getNext() == null)
				break;
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
			if(slowPointer == fastPointer)
				return true;
		}
		return false;
	}
	
	// If LinkedList is cyclic, find the start node of cycle
    @Override
	public ListNode getStartNodeOfCycleIfCyclic(ListNode head){
		if(head == null)
			return null;
		
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer.getNext()!= null){
			fastPointer = fastPointer.getNext();
			if(fastPointer.getNext() == null)
				return null;
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
			if(slowPointer == fastPointer)
				break;
		}
		
		if(fastPointer.getNext() == null)
			return null;
		
		slowPointer = head;
		int lengthOfTheLoop = 0;  // To get Length of cycle
		while(slowPointer != fastPointer){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
			lengthOfTheLoop++;  // Get length of cycle
		}
		return slowPointer;
	}
	
	// Insert newNode in sorted LinkedList. NewNode is passed in argument
    @Override
	public ListNode insertNewNodeInSortedLL(ListNode head, ListNode newNode){
		
		ListNode currentNode = head;
		ListNode previousNode = head;
		while(currentNode != null){
			if((Integer)currentNode.getData() > (Integer)newNode.getData()){
				// newNode data is less than head node
				if(previousNode == head){
					newNode.setNext(head);
					return newNode;
				}
				previousNode.setNext(newNode);
				newNode.setNext(currentNode);
				return head;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		// Insert at tail
		previousNode.setNext(newNode);
		return head;
	}
	
	// Print LinkedList in reverse order
    @Override
	public ListNode printInReverseOrder(ListNode head){
		if(head.getNext() != null)
			printInReverseOrder(head.getNext());
		System.out.println(head.getData());
		return head;
	}
	
	//Reverse LinkedList.. Iterative
    @Override
	public ListNode reverseLinkedList(ListNode head){
		ListNode previousNode = null;
		ListNode currentNode = head;
		ListNode nextNode;
		while(currentNode != null){
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}
	
	// Reverse LinkedList Recursive - pass in argument :-  head as currentNode and null as previousNode
    @Override
	public ListNode reverseLinkedListRecursively(ListNode currentNode, ListNode previousNode){
		if(currentNode != null){
			ListNode nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			reverseLinkedListRecursively(nextNode, currentNode);
		}
		System.out.println("previousNode" + previousNode.getData());
		return previousNode;
	}
	
	// Reverse LinkedList Recursive -- pass head as argument
	// Set headAfterReverse as global variable. This would be head for ReversedListedList
	static ListNode headAfterReverse;
	@Override
	public void reverseLinkedListRecursive(ListNode currentNode){
		if(currentNode == null || currentNode.getNext() == null){
			headAfterReverse = currentNode;
			return;
		}
		ListNode nextNode = currentNode.getNext();
		reverseLinkedListRecursive(nextNode);
		nextNode.setNext(currentNode);
		currentNode.setNext(null);
	}
	
	
	//Reverse LinkedList without setting Global variable -- pass head as argument -- return head of reversedLinkedList
	// https://www.youtube.com/watch?v=Ip4y7Inx7QY
    @Override
	public ListNode reverseLinkedListRecursive2(ListNode currentNode){
		if(currentNode == null || currentNode.getNext() == null){
			return currentNode;
		}
		
		ListNode restNode = reverseLinkedListRecursive2(currentNode.getNext());
		currentNode.getNext().setNext(currentNode);
		currentNode.setNext(null);
		//System.out.println("dfds" + nextNode.getData());
		
		return restNode;
	}
	
	// Reverse SLL - pass in argument :-  head as currentNode and null as previousNode
    @Override
	public ListNode reverseLinkedListRecursive3(ListNode currentNode, ListNode previousNode){
		ListNode lastNode;
		if(currentNode.getNext() != null){
			lastNode = reverseLinkedListRecursive3(currentNode.getNext(), currentNode);
			currentNode.setNext(previousNode);
			return lastNode;
		} else {
			currentNode.setNext(previousNode);
			return currentNode;
		}
	}
	
	// Find merge point of two LinkedLists List1 and List2, having length l1 and l2 respectively
	// where l1 < or > or = l2
	// Passing heads of both LinkedLists  -- returns merging node
    @Override
	public ListNode getMergeNode(ListNode head1, ListNode head2){
		int differenceInLengthsOfTwoLinkedLists = 0;
		ListNode shorterLinkedList = null;
		ListNode current1 = head1;
		ListNode current2 = head2;
		while(current1 != null && current2 != null){
			current1 = current1.getNext();
			current2 = current2.getNext();
		}
		
		if(current1 == null && current2 != null){
			shorterLinkedList = head1;
			while(current2!= null){
				current2 = current2.getNext();
				differenceInLengthsOfTwoLinkedLists ++;
			}
		}
		
		if(current2 == null && current1 != null){
			shorterLinkedList = head2;
			while(current1 != null){
				current1 = current1.getNext();
				differenceInLengthsOfTwoLinkedLists ++;
			}
		}
		
		//Reset pointers back to head
		current1 = head1;
		current2 = head2;
		
		for(int i = 0; i<differenceInLengthsOfTwoLinkedLists; i++){
			if(shorterLinkedList == head1)
				current1 = current1.getNext();
			if(shorterLinkedList == head2)
				current2 = current2.getNext();
		}
		
		while(current1 != null && current2 != null && current1 != current2){
			current1 = current1.getNext();
			current2 = current2.getNext();
		}
			
		
		return current1; // OR  return current2; 
	}
	
	// Merge two sorted LinkedLists to new sorted LinkedList. 
	// We are creating new LinkedList without disturbing existing LinkedLists
	// passing heads of two sorted LinkedLists and return head of merged LinkedList
    @Override
	public ListNode mergeTwoSortedLinkedListNewLinkedList(ListNode head1, ListNode head2){
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		ListNode resultHeadNode = null;
		ListNode resultPreviousNode = null;
		
		while(head1 != null || head2 != null){
			ListNode node = new ListNode();
			if(head1 != null && head2!= null){
				if((Integer)head1.getData() < (Integer)head2.getData()){
					node.setData(head1.getData());
					head1 = head1.getNext();
				}
				else {
					node.setData(head2.getData());
					head2 = head2.getNext();
				}
			}
			
			else if(head1 == null && head2 != null){
				node.setData(head2.getData());
				head2 = head2.getNext();
			}
			
			else if(head2 == null && head1 != null){
				node.setData(head1.getData());
				head1 = head1.getNext();
			}
			
			if(resultPreviousNode == null){
				resultHeadNode = node;
			}
			else 
				resultPreviousNode.setNext(node);

			resultPreviousNode = node;
		}

		if(resultPreviousNode != null)
			resultPreviousNode.setNext(null);
		
		return resultHeadNode;
	}
	
	// Merge two sorted LinkedLists to Single sorted LinkedList. 
	// We are NOT creating new LinkedList. Existing LinkedLists's links would be adjusted. Existing LinkedLists would be lost.
	// passing heads of two sorted LinkedLists and return head of merged LinkedList
    @Override
	public ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		ListNode result;
		if((Integer)head1.getData() < (Integer)head2.getData()){
			result = head1;
			mergeTwoSortedLinkedList(head1.getNext(), head2);
		}
		return null;
	}
	
	
	//Search a element and return boolean
	// element and headNode would be passed in argument
    @Override
	public boolean searchElement(Integer data, ListNode head){
		if(head == null)
			return false;
		
		if(head.getData() == data)
			return true;
		
		return searchElement(data, head.getNext());
	}
	
	//Swap nodes in a linked list without swapping data
	//
	//http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
/*	Examples :- Input:  10->15->12->13->20->14,  x = 12, y = 20
			Output: 10->15->20->13->12->14

			Input:  10->15->12->13->20->14,  x = 10, y = 20
			Output: 20->15->12->13->10->14

			Input:  10->15->12->13->20->14,  x = 12, y = 13
			Output: 10->15->13->12->20->14*/
/*	public ListNode swapNodesInLinkedListWithoutSwappingData(ListNode head, int a, int b){
		if(a == b) return head;
		
		ListNode currentNode = head;
		ListNode previousNode = null;
		
		ListNode firstNode = null;
		ListNode nodeBeforeFirstNode = null;
		boolean isFirstNodeHead = false;
		
		ListNode secondNode = null;
		ListNode nodeBeforeSecondNode = null;
		boolean isSecondNodeHead = false;
		
		while(currentNode != null && (firstNode == null || secondNode == null)){
			if((Integer)currentNode.getData() == a){
				firstNode = currentNode;
				if(previousNode == null){
					isFirstNodeHead = true;
					//head = currentNode.getNext(); // remove FirstNode
				}
				else {
					nodeBeforeFirstNode = previousNode;
					//nodeBeforeFirstNode.setNext(currentNode.getNext()); // Remove firstNode
				}
			}
			
			else if((Integer)currentNode.getData() == b){
				secondNode = currentNode;
				if(previousNode == null){
					isSecondNodeHead = true;
					//head = currentNode.getNext(); // Remove SecondNode	
				}
				else {
					nodeBeforeSecondNode = previousNode;
					//nodeBeforeSecondNode.setNext(currentNode.getNext()); // Remove SecondNode	
				}
			}
			
			previousNode = currentNode;
		}
		
		if(firstNode == null || secondNode == null)
			return head;
		
		boolean areNodesAreAdjacent = false;
		if(firstNode.getNext() == secondNode){
			areNodesAreAdjacent = true;
			if(isFirstNodeHead) {
				firstNode.setNext(secondNode.getNext());
				secondNode.setNext(firstNode);
				head = secondNode;
			} else {
				nodeBeforeFirstNode.setNext(secondNode);
				ListNode temp = secondNode.getNext();
				secondNode.setNext(firstNode);
				firstNode.setNext(temp);
			}
			

		
		} else if(secondNode.getNext() == firstNode){
			areNodesAreAdjacent = true;
		}
			
		
		
		//Remove FirstNode and replace with SecondNode
		if(isFirstNodeHead){
			secondNode.setNext(firstNode.getNext());
			head = secondNode;
		} else {
			
		}
		
		// Remove SecondNode and replace with firstNode
		if(isSecondNodeHead){
			firstNode.setNext(secondNode.getNext());
			head = firstNode;
		} else {
			
		}
	
		
		
		return null;
	}*/
	
	// Check if LinkedList is Palindrome
    @Override
	public boolean isLinkedListPalindrome(ListNode head){
		ListNode middleNode = this.getMiddleNode(head);
		System.out.println("MiddleNode :- " + middleNode.getData());
		ListNode secondHalfReverseHead = this.reverseLinkedListRecursive2(middleNode.getNext());
		middleNode.setNext(secondHalfReverseHead);

		ListNode firstHalfPointer = head;
		ListNode secondHalfPointer = secondHalfReverseHead;
		while(secondHalfPointer != null){
			if(secondHalfPointer.getData() != firstHalfPointer.getData())
				return false;
			secondHalfPointer = secondHalfPointer.getNext();
			firstHalfPointer = firstHalfPointer.getNext();
		}
		return true;
	}
	
	//Remove duplicate data from unsorted LinkedList
    @Override
	public void removeDuplicateElementFromUnsortedLinkedList(ListNode head){
		
		ListNode outerLoopPointer = head;
		while(outerLoopPointer != null){
			ListNode previousNodeForInnerLoop = outerLoopPointer;
			ListNode innerLoopPointer = outerLoopPointer.getNext();
			while(innerLoopPointer != null){
				if(outerLoopPointer.getData() == innerLoopPointer.getData()){
					previousNodeForInnerLoop.setNext(innerLoopPointer.getNext());
					innerLoopPointer = previousNodeForInnerLoop;
				} 
				previousNodeForInnerLoop = innerLoopPointer;
				innerLoopPointer = innerLoopPointer.getNext();
			}
			outerLoopPointer = outerLoopPointer.getNext();
		}
	}
	
	// Pairwise swap elements of a given linked list
    @Override
	public ListNode pairwiseSwapElements(ListNode head){
		ListNode currentNode = head;
		ListNode previousBlockLastElement = null;
		while(currentNode != null && currentNode.getNext() != null){
			ListNode nextNode = currentNode.getNext();
			currentNode.setNext(nextNode.getNext());
			nextNode.setNext(currentNode);
			if(previousBlockLastElement != null)
				previousBlockLastElement.setNext(nextNode);
			else
				head = nextNode;
			
			previousBlockLastElement = currentNode;
			currentNode = currentNode.getNext();
		}
		return head;
	}
	
	
	// Delete alternate nodes of a Linked List
    @Override
	public void deleteAlternateNodes(ListNode head){
		int nodeNumber = 0;
		ListNode previousNode = null;
		ListNode currentNode = head;
		while(currentNode != null){
			nodeNumber ++;
			if(nodeNumber % 2 == 0 && previousNode != null)
				previousNode.setNext(currentNode.getNext());
			else
				previousNode = currentNode;
			
			currentNode = currentNode.getNext();
		}
	}
	
	// Alternating split of a given Singly Linked List
    @Override
	public void alternatingSplitOfGivenSinglyLinkedList(ListNode head){
		int nodeNumber = 0;
		ListNode previousOddNode = null;
		ListNode previousEvenNode = null;
		ListNode oddHead = null;
		ListNode evenHead = null;
		ListNode currentNode = head;
		while(currentNode != null){
			nodeNumber++;
			if(nodeNumber % 2 == 0){
				if(previousEvenNode != null)
					previousEvenNode.setNext(currentNode);
				else
					evenHead = currentNode;
				
				previousEvenNode = currentNode;
			}
			else {
				if(previousOddNode != null)
					previousOddNode.setNext(currentNode);
				else
					oddHead = currentNode;
				
				previousOddNode = currentNode;
			}
			
			currentNode = currentNode.getNext();
		}
		
		System.out.println("Print Odd SLL");
		this.printSLL(oddHead);
		System.out.println();
		System.out.println("Print Even SLL");
		this.printSLL(evenHead);
	}
	
	// Reverse a Linked List in groups of given size
	// Iterative
    @Override
	public ListNode reverseALinkedListInGroupsOfGivenSize(ListNode head, int groupSize){
		ListNode previousBlockLastNode = null;
		ListNode currentNode = head;
		while(currentNode != null){
			int innerNodeNumber = 1;
			ListNode innerNode = currentNode;
			while(innerNodeNumber < groupSize && innerNode.getNext()!= null){
				innerNode = innerNode.getNext();
				innerNodeNumber ++;
			}
			
			ListNode nextBlockBeginNode = innerNode.getNext();
			innerNode.setNext(null);
			ListNode innerNodeHeadAfterReverse = this.reverseLinkedListRecursive2(currentNode);
			if(previousBlockLastNode != null)
				previousBlockLastNode.setNext(innerNodeHeadAfterReverse);
			else
				head = innerNodeHeadAfterReverse;
			
			previousBlockLastNode = currentNode;
			currentNode.setNext(nextBlockBeginNode);
			currentNode = currentNode.getNext();
		}
		return head;
	}
	
	// Reverse a Linked List in groups of given size
	// Recursive call for each block. Means, every block of given size, would be called recursively
    @Override
	public ListNode reverseALinkedListInGroupsOfGivenSizeRecursive(ListNode head, int groupSize){
		ListNode previousNode = null;
		ListNode currentNode = head;
		ListNode nextNode = null;
		int nodeNumber = 0;
		while(currentNode != null && nodeNumber < groupSize){
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
			nodeNumber ++;
		}
		
		if(currentNode != null)
			head.setNext(reverseALinkedListInGroupsOfGivenSizeRecursive(currentNode, groupSize));
		return previousNode;
	}
	
	// Segregate even and odd nodes in a Linked List
    @Override
	public ListNode segregateEvenAndOddNodes(ListNode head){
		ListNode evenHead = null;
		ListNode oddHead = null;
		ListNode previousEvenNode = null;
		ListNode previousOddNode = null;
		ListNode currentNode = head;
		while(currentNode != null){
			if((Integer)currentNode.getData() % 2 == 0){
				if(previousEvenNode != null)
					previousEvenNode.setNext(currentNode);
				else {
					evenHead = currentNode;
				}
				previousEvenNode = currentNode;
			}else {
				if(previousOddNode != null)
					previousOddNode.setNext(currentNode);
				else {
					oddHead = currentNode;
				}
				previousOddNode = currentNode;
			}
			currentNode = currentNode.getNext();
		}
		
		if(previousEvenNode != null)
		 previousEvenNode.setNext(oddHead);
		if(previousOddNode != null)
			previousOddNode.setNext(null);
		
		if(evenHead == null)
			return oddHead;
		return evenHead;
	}
	
	// Add two numbers represented by linked lists
	// http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
/*	
	Input:
		  First List: 7->5->9->4->6  // represents number 64957
		  Second List: 8->4 //  represents number 48
		Output
		  Resultant list: 5->0->0->5->6  // represents number 65005
		  
		  **********************************
		  Input:
			  First List: 5->6->3  // represents number 365
			  Second List: 8->4->2 //  represents number 248
			Output
			  Resultant list: 3->1->6  // represents number 613
		  
		  */
    @Override
	public ListNode addTwoLinkedListsTwoNodesAtATime(ListNode currentNode1, ListNode currentNode2){
		int carryForward = 0;
		ListNode resultLinkedListHead = null;
		ListNode resultLinkedListTail = null;
		while(currentNode1 != null || currentNode2 != null || carryForward != 0){
			int node1Value = 0;
			int node2Value = 0;
			if(currentNode1 != null){
				node1Value = (Integer)currentNode1.getData();
				currentNode1 = currentNode1.getNext();
			}
			if(currentNode2 != null){
				node2Value = (Integer)currentNode2.getData();
				currentNode2 = currentNode2.getNext();
			}
			
			int resultData = (node1Value + node2Value + carryForward) % 10;
			carryForward = (node1Value + node2Value + carryForward) / 10;
			
			resultLinkedListTail = createResultLinkedList(resultData, resultLinkedListTail);
			if(resultLinkedListHead == null)
				resultLinkedListHead = resultLinkedListTail;

		}
		return resultLinkedListHead;
	}

	@Override
	public ListNode createResultLinkedList(Integer resultData, ListNode resultLinkedListTail){
		ListNode newTailNode = new ListNode(resultData, null);
		if(resultLinkedListTail != null)
			resultLinkedListTail.setNext(newTailNode);
		
		return newTailNode;
	}
	
	//Insertion Sort for Singly Linked List
    @Override
	public ListNode insertionSort(ListNode head){
		ListNode sortedListHead = head;
		ListNode currentNode = head.getNext();
		while(currentNode != null){
			sortedListHead = insertNodeInSortedLinkedList(sortedListHead, currentNode);
			currentNode = currentNode.getNext();
		}
		return sortedListHead;
	}
	
	private ListNode insertNodeInSortedLinkedList(ListNode sortedLinkedListHead, ListNode listNodeToInsert){
		if((Integer)sortedLinkedListHead.getData() > (Integer)listNodeToInsert.getData()){
			listNodeToInsert.setNext(sortedLinkedListHead);
			return listNodeToInsert;
		}
		
		ListNode currentNode = sortedLinkedListHead;
		while(currentNode.getNext() != null && (Integer)currentNode.getNext().getData() < (Integer)listNodeToInsert.getData()){
			currentNode = currentNode.getNext();
		}
		
		listNodeToInsert.setNext(currentNode.getNext());
		currentNode.setNext(listNodeToInsert);
		return sortedLinkedListHead;
		
	}
	
	//Merge two sorted linked lists such that merged list is in reverse order
	// Time Complexity O( sum of length of List1 and List2)
	// Space Complexity O(1)  -- No extra space taken, except for variable lastNodeProcessed
	@Override
	public ListNode mergeTwoSortedLinkedListInReverseOrder(ListNode list1, ListNode list2){
		ListNode lastNodeProcessed = null;
		while(list1 != null && list2 != null){
			if((Integer)list1.getData() < (Integer)list2.getData()){
				ListNode processingNode = list1;
				list1 = list1.getNext();
				processingNode.setNext(lastNodeProcessed);
				lastNodeProcessed = processingNode;
			} else {
				ListNode processingNode = list2;
				list2 = list2.getNext();
				processingNode.setNext(lastNodeProcessed);
				lastNodeProcessed = processingNode;
			}
		}
		
		while(list1 != null && list2 == null){
			ListNode processingNode = list1;
			list1 = list1.getNext();
			processingNode.setNext(lastNodeProcessed);
			lastNodeProcessed = processingNode;
		}
		
		while(list1 == null && list2 != null){
			ListNode processingNode = list2;
			list2 = list2.getNext();
			processingNode.setNext(lastNodeProcessed);
			lastNodeProcessed = processingNode;
		}
		
		return lastNodeProcessed;
	}
	
	// Sort linked list which is already sorted on absolute values
	// Time complexity O(n)
	// Space complexity O(1)
	@Override
	public ListNode sortLinkedListAlreadySortedOnAbsoluteValues(ListNode head){
		ListNode currentNode = head;
		ListNode previousNode = null;
		while(currentNode != null){
			if(previousNode == null){
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			
			if((Integer)currentNode.getData() < 0){
				previousNode.setNext(currentNode.getNext());
				currentNode.setNext(head);
				head = currentNode;
				currentNode = previousNode.getNext();
				
			} else {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		
		return head;
	}
	
	//In-place Merge two linked lists without changing links of first list
	// Time Complexity - O(mn)
	// Space complexity - O(1)
	@Override
	public void inPlaceMergeTwoLinkedListsWithoutChangingLinks(ListNode list1, ListNode list2){
		while(list1 != null ){
			if((Integer)list1.getData() < (Integer)list2.getData()){
				list1 = list1.getNext();
				continue;
			}
			
			Integer list1Value = (Integer)list1.getData();
			list1.setData(list2.getData());
			list1 = list1.getNext();
			list2 = insertList1ValueInSortedOrder(list2, list1Value);
		}
	}
	
	private ListNode insertList1ValueInSortedOrder(ListNode list2, Integer value){
		ListNode temp = list2;

		while(list2 != null && list2.getNext() != null && (Integer)list2.getNext().getData() < value){
			list2.setData(list2.getNext().getData());
			list2 = list2.getNext();
		}
		list2.setData(value);
		return temp;
	}
	
	//Decimal Equivalent of Binary Linked List
/*	   Input  : 0->0->0->1->1->0->0->1->0
	   Output : 50   

	   Input  : 1->0->0
	   Output : 4*/
    @Override
	public Map decimalEquivalentOfBinaryLinkedList(ListNode list, Map map){
		if(list == null)
			return null;
		
		map = decimalEquivalentOfBinaryLinkedList(list.getNext(), map);
		if(map == null){
			map = new HashMap<String, Double>();
			map.put("Position", 0.0);
			map.put("Sum", (Double)list.getData());
		} else {
			map.put("Position", (Double)map.get("Position") + 1 );
			map.put("Sum", (Double)map.get("Sum") + 
					(Double)list.getData() * Math.pow(2.0, (double) map.get("Position")));
		}
		return map;
	}
	
	//Decimal Equivalent of Binary Linked List
	static int position = 0;
	@Override
	public int decimalEquivalentOfBinaryLinkedList2(ListNode list, int sum){
		if(list == null)
			return 0;
		
		sum = decimalEquivalentOfBinaryLinkedList2(list.getNext(), sum);
		sum = (int) (sum + (double)list.getData() * Math.pow(2, position ++));
		return sum;
	}

	public static void main(String arg[]){
		SLLOperations operations = new SLLOperations();
		ListNode head1 = operations.constructSLLandReturnHead();
		//ListNode head2 = operations.constructSLLandReturnHead2();
		operations.printSLL(head1);
		//operations.printSLL(head2);
		
		System.out.println(" Break ");
		//Map map = operations.decimalEquivalentOfBinaryLinkedList(head1, null);
		int sum = operations.decimalEquivalentOfBinaryLinkedList2(head1, 0);
		System.out.println(sum);
		//System.out.println(map.get("Sum"));
		//operations.printSLL(head1);
		//operations.printSLL(head2);
		
		//System.out.println("Sorting");
		//head = operations.insertionSort(head);
		//operations.printSLL(head);
		//operations.printSLL(head);
		//reverseLinkedListRecursive3;
	}

}
