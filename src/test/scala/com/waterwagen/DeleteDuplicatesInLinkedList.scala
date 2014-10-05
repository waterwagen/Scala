package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import com.waterwagen.LinkedListBuilder._

import scala.collection.mutable.{HashSet, Set}

object DeleteDuplicatesInLinkedList extends App 
{
	val printList = (node : DoublyLinkedListNode) =>
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
		
		println(builder toString)
	}
	
	val head = aLinkedListStartingWith(1).
				withValue(3).
				withValue(2).
				withValue(2).
				withValue(10).
				withValue(2).
				withValue(7).
				withValue(8).
				withValue(7).
				withValue(3).
				withValue(4).end()
	
	def deleteDuplicates(head : DoublyLinkedListNode) : Unit =
	{	
		val found : Set[Int] = new HashSet[Int]
		found.add(head.value)
		if(head.next == null)
			return
		var curr_node = head
		do
		{
			curr_node = curr_node.next
			if(found(curr_node.value))
			{	
				curr_node.prev.next = curr_node.next
				if(curr_node.next != null)
					curr_node.next.prev = curr_node.prev
			}
			else
			{
				found.add(curr_node.value)
			}
		}
		while(curr_node.next != null)
		println("found: " + found)
	}
	
	println("Linked list before duplicates removed")
	printList(head)
	deleteDuplicates(head)
	println("Linked list after duplicates removed")
	printList(head)
}