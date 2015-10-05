package org.foundations.List

/**
 * Created by joxer on 05/10/15.
 */
class ListNode[T] {

  var value: T = None.asInstanceOf[T]
  var next : ListNode[T] = null

  def this(value: T, next: ListNode[T]) = {
    this()
    this.value = value
    this.next = next
  }
}

class DoubleLinkedListNode[T] extends ListNode[T] {

  var previous : ListNode[T] = null;

  def this(value: T, next: ListNode[T], previous: ListNode[T]) = {
    this(value,previous)
    this.previous = previous
  }
}

class LinkedList[T] {

  var root : ListNode[T] = null

  def this(root : ListNode[T]) = {
    this()
    this.root = root;
  }

  def traverse(function : ListNode[T] => Unit) = {

    var tmpRoot = root;

    while(tmpRoot.next != null){
      function(tmpRoot);
      tmpRoot = tmpRoot.next;
    }
  }

  def addToPosition(node: ListNode[T], position: Integer ) = {
    var tmpRoot = root
    var i = 0
    while(i != position && tmpRoot.next != null){
     tmpRoot = tmpRoot.next
      i += 1
    }

    if(i < position) {
      throw new Exception()
    }
    else{
      var tmpNextRoot : ListNode[T]= null;
      if(tmpRoot.next != null){
        tmpNextRoot = tmpRoot.next
      }
      tmpRoot.next = node
      node.next = tmpNextRoot
    }
  }

  def removeToPosition(position: Integer) = {
    var tmpRoot = root
    var i = 0;
    while(i != position-1 && tmpRoot.next != null){
      tmpRoot = tmpRoot.next
      i += 1
    }

    if(i == position) {
      if(tmpRoot.next != null && tmpRoot.next.next != null) {
        val tmp = tmpRoot.next.next
        tmpRoot.next.next = null
        tmpRoot.next = tmp
      }
    }
  }
}