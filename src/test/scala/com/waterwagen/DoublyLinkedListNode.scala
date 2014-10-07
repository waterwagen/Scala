package com.waterwagen

class DoublyLinkedListNode(data: Int) {
  val value: Int = data
  var next: DoublyLinkedListNode = null
  var prev: DoublyLinkedListNode = null

  def appendToTail(value: Int) {
    val tail = new DoublyLinkedListNode(value)
    var n = this
    while (n.next != null)
      n = n.next
    n.next = tail
    tail.prev = n
  }
}