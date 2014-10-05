package com.waterwagen

import com.waterwagen.LinkedListBuilder._

import scala.collection.mutable.ArrayBuffer

object AdditionByLinkedListReversedNumbers extends App
{
	def stringValueOf(node : DoublyLinkedListNode) =
	{
		val builder = new StringBuilder()
		builder append "["
		var curr_node = node
		while(curr_node != null)
		{
			builder append curr_node.value append ","
			curr_node = curr_node.next
		}
		builder deleteCharAt builder.length - 1
		builder append "]"
		
		builder toString
	}

  // this is in com.waterwagen.LinkedListBuilder, which is in the test folder
	val head1 = aLinkedListStartingWith(7).
				withValue(3).
				withValue(2).
				withValue(4).end()
	val head2 = aLinkedListStartingWith(4).
				withValue(6).
				withValue(8).end()
	
	def hasValue(node : DoublyLinkedListNode) : Boolean =
	{
		node != null && node.value != null
	}
	
	def reverse(node : DoublyLinkedListNode) : DoublyLinkedListNode =
	{
		var head : DoublyLinkedListNode = node
		var curr_node : DoublyLinkedListNode = head
		var list = ArrayBuffer[DoublyLinkedListNode]()
		list += curr_node
		while(curr_node.next != null)
		{
			list += curr_node.next
			curr_node = curr_node.next
		}
		list = list.reverse
		var prev : DoublyLinkedListNode = null
		for(next_node <- list)
		{
			if(prev != null)
			{
				prev.next = next_node
				next_node.next = null
			}
			prev = next_node		
		}
		
		list.head
	}
	
	def add(head1 : DoublyLinkedListNode, head2 : DoublyLinkedListNode, left_to_right : Boolean) : DoublyLinkedListNode =
	{	
		var result_head : DoublyLinkedListNode = null

		var my_head1 = head1
		var my_head2 = head2
		if(left_to_right) { my_head1 = reverse(my_head1); my_head2 = reverse(my_head2) }
		printf("after reverse check 1=%s 2=%s\n", stringValueOf(my_head1), stringValueOf(my_head2))
		var carry = false
		var node1 = my_head1
		var node2 = my_head2
		var result_tail : DoublyLinkedListNode = null
		while(node1 != null || node2 != null || carry)
		{
			var sum = 	{if(hasValue(node1)) node1.value else 0} + 
						{if(hasValue(node2)) node2.value else 0} +
						{if(carry) {carry = false; 1} else 0}
			if(sum >= 10)
			{
				carry = true
				sum = sum - 10
			}
			
			val new_node = new DoublyLinkedListNode(sum)
			if(result_tail != null)	result_tail.next = new_node
			else result_head = new_node
			result_tail = new_node
			
			if(node1 != null) node1 = node1.next
			if(node2 != null) node2 = node2.next
		}
		
		if(left_to_right) { result_head = reverse(result_head) }
		
		result_head
	}
	
	printf("Before adding: linked list 1=%s linked list 2=%s\n", stringValueOf(head1), stringValueOf(head2))
	val result = add(head1, head2, true)
	printf("Linked list result after adding: %s\n", stringValueOf(result))
}