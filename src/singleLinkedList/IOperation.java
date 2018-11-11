package singleLinkedList;

import java.util.Map;

public interface IOperation {

	int getLength(ListNode listNode);
    int getLengthRecursive(ListNode listNode, int lengthCounter);
    void printSLL(ListNode head);
    ListNode insertBeforeHead(ListNode head, ListNode newNode);
    void insertAfterTail(ListNode head, ListNode newNode);
    void insertNewNodeAfterNodePassedInArgument(ListNode nodeAfterWhichNewNodeToBeInserted, ListNode newNode);
    void insertAtMiddle(ListNode head, ListNode newNode);
    ListNode getMiddleNode(ListNode head);
    ListNode getNthNodeFromEnd(ListNode head, int n);
    boolean isCyclic(ListNode head);
    ListNode getStartNodeOfCycleIfCyclic(ListNode head);
    ListNode insertNewNodeInSortedLL(ListNode head, ListNode newNode);
    ListNode printInReverseOrder(ListNode head);
    ListNode reverse(ListNode node, ListNode previousNode);
    ListNode reverseLinkedList(ListNode head);
    ListNode reverseLinkedListRecursively(ListNode currentNode, ListNode previousNode);
    void reverseLinkedListRecursive(ListNode currentNode);
    ListNode reverseLinkedListRecursive2(ListNode currentNode);
    ListNode reverseLinkedListRecursive3(ListNode currentNode, ListNode previousNode);
    ListNode getMergeNode(ListNode head1, ListNode head2);
    ListNode mergeTwoSortedLinkedListNewLinkedList(ListNode head1, ListNode head2);
    ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2);
    boolean searchElement(Integer data, ListNode head);
    boolean isLinkedListPalindrome(ListNode head);
    void removeDuplicateElementFromUnsortedLinkedList(ListNode head);
    ListNode pairwiseSwapElements(ListNode head);
    void deleteAlternateNodes(ListNode head);
    void alternatingSplitOfGivenSinglyLinkedList(ListNode head);
    ListNode reverseALinkedListInGroupsOfGivenSize(ListNode head, int groupSize);
    ListNode reverseALinkedListInGroupsOfGivenSizeRecursive(ListNode head, int groupSize);
    ListNode segregateEvenAndOddNodes(ListNode head);
    ListNode addTwoLinkedListsTwoNodesAtATime(ListNode currentNode1, ListNode currentNode2);
    ListNode createResultLinkedList(Integer resultData, ListNode resultLinkedListTail);
    ListNode insertionSort(ListNode head);

	//Merge two sorted linked lists such that merged list is in reverse order
	ListNode mergeTwoSortedLinkedListInReverseOrder(ListNode list1, ListNode list2);
	
	// Sort linked list which is already sorted on absolute values
	// Time complexity O(n)
	// Space complexity O(1)
	ListNode sortLinkedListAlreadySortedOnAbsoluteValues(ListNode head);
	
	
	//In-place Merge two linked lists without changing links of first list
	// Time Complexity - O(mn)
	// Space complexity - O(1)
	void inPlaceMergeTwoLinkedListsWithoutChangingLinks(ListNode list1, ListNode list2);
	
	//Decimal Equivalent of Binary Linked List
	// Time complexity - O(n)
	Map decimalEquivalentOfBinaryLinkedList(ListNode list, Map map);
	int decimalEquivalentOfBinaryLinkedList2(ListNode list, int sum);

}
