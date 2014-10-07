package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import com.waterwagen.LinkedListBuilder._

object DeleteDuplicatesInLinkedListNoDataStructures extends App {
  def linkedlistToString(node: DoublyLinkedListNode): String = {
    val builder = new StringBuilder()
    builder append "["
    var curr_node = node
    while (curr_node != null) {
      builder append curr_node.value append ","
      curr_node = curr_node.next
    }
    builder deleteCharAt builder.length - 1
    builder append "]"

    builder toString
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
    withValue(7).
    withValue(3).
    withValue(4).end()

  println("Linked list before duplicates removed: " + linkedlistToString(head))
  new DeleteDuplicatesInLinkedListNoDataStructures().deleteDuplicates(head)
  println("Linked list after duplicates removed: " + linkedlistToString(head))
}

class DeleteDuplicatesInLinkedListNoDataStructures {
  def deleteDuplicates(head: DoublyLinkedListNode) = {
    sortList(head)
    var node = head
    while (node.next != null) {
      if (node.next.value == node.value) {
        if (node.next.next != null)
          node.next.next.prev = node
        node.next = node.next.next
      }
      else
        node = node.next
    }
  }

  def sortList(head: DoublyLinkedListNode) {
    var changes_made = false
    do {
      changes_made = false
      var node = findHead(head)
      while (node.next != null) {
        if (node.next.value < node.value) {
          //					println("swapping " + node.value + " and " + node.next.value)
          swapNodes(node, node.next)
          //					node = node.prev
          changes_made = true
        }
        else
          node = node.next
        //				println("node now = " + node.value)
        //				println("Current list state: " + DeleteDuplicatesInLinkedListNoDataStructures.linkedlistToString(findHead(node)))

      }
    }
    while (changes_made)
  }

  def swapNodes(node1: DoublyLinkedListNode, node2: DoublyLinkedListNode) {
    val node1_prev = node1.prev
    val node2_next = node2.next
    node1.next = node2.next
    node1.prev = node2
    node2.next = node1
    node2.prev = node1_prev
    if (node1_prev != null)
      node1_prev.next = node2
    if (node2_next != null)
      node2_next.prev = node1
  }

  def findHead(node: DoublyLinkedListNode): DoublyLinkedListNode = {
    var curr_node = node
    while (curr_node.prev != null)
      curr_node = curr_node.prev
    curr_node
  }
}