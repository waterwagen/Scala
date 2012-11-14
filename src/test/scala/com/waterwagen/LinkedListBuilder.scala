package com.waterwagen

object LinkedListBuilder 
{
	def aLinkedListStartingWith(value : Int) = 
	{
		new LinkedListBuilder(new DoublyLinkedListNode(value))
	}
}

class LinkedListBuilder(new_head : DoublyLinkedListNode)
{
	var head : DoublyLinkedListNode = new_head
		
	def withValue(value : Int) =
	{
		head.appendToTail(value)
		this
	}
	
	def end() = 
	{
		head
	}
}