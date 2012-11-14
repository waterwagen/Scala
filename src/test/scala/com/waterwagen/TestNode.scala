package com.waterwagen

import org.junit.Assert._
import org.junit.Test
import org.junit.Assert._
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers._
import org.junit.Before

class TestNode 
{
	var head : DoublyLinkedListNode = null
	var tail : DoublyLinkedListNode = null
	
	@Before
	def setUp()
	{
		head = new DoublyLinkedListNode(1)
		head.appendToTail(2)
		tail = head.next
	}
	
	@Test
	def testNodeHoldsValue()
	{
		assertThat(head.value, is(equalTo(1)))
	}

	@Test
	def testNodeHoldsNext()
	{
		assertThat(head.next, is(notNullValue()))
		assertThat(head.next.value, is(equalTo(2)))
	}

	@Test
	def testNodeHoldsPrevious()
	{
		assertThat(head.next.prev, is(notNullValue()))
		assertThat(head.next.prev, is(equalTo(head)))
	}
	
	@Test
	def testTailNextIsNull()
	{
		assertThat(tail.next, is(nullValue()))
	}
}