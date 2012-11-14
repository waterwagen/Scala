package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import scala.collection.mutable.HashSet
import scala.collection.mutable.Set

import org.junit.Assert._
import org.junit.Before

import org.hamcrest.Matchers._
import org.hamcrest.MatcherAssert.assertThat

import com.waterwagen.LinkedListBuilder._

object PartitionLinkedList extends App 
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
	
	val head = aLinkedListStartingWith(7).
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
	
	def findHead(node : DoublyLinkedListNode) : DoublyLinkedListNode =
	{
		var curr_node = node
		while(curr_node.prev != null)
			curr_node = curr_node.prev
		curr_node
	}
	
	def partition(head : DoublyLinkedListNode, x : Int) : DoublyLinkedListNode =
	{	
		val headIsBoundary : Boolean = {if(head.value >= x) true; else false}
		var insertAfterNode : DoublyLinkedListNode = null
		var new_head : DoublyLinkedListNode = head
		
		var node = head
		while(node.next != null)
		{
			var prev = node
			node = node.next
			if(node.value >= x)
			{	
				if(!headIsBoundary && insertAfterNode == null)
					insertAfterNode = prev
			}	
			else
			{
				if(headIsBoundary)
				{
					prev.next = node.next
					node.next = new_head
					new_head = node
					node = prev
				}
				else if(insertAfterNode != null)
				{
					prev.next = node.next
					node.next = insertAfterNode.next
					insertAfterNode.next = node
					node = prev
				}
			}
		}
		new_head
	}
	
	val x : Int = 6
	printf("Linked list before partitioning on value %s.\n", x)
	printList(head)
	val new_head = partition(head, x)
	printf("Linked list after partitioning on value %s.\n", x)
	printList(new_head)
}