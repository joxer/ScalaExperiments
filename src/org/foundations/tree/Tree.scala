package org.foundations.tree

import scala.collection.mutable.Queue
import scala.util.Random

/**
 * Created by joxer on 04/10/15.
 */
class TreeNode[T] {

  var value : T = None.asInstanceOf[T];
  var leftLeaf: TreeNode[T] = null
  var rightLeaf: TreeNode[T] = null

  def this(value: T) = {
    this();
    this.value = value;
  }

  def this(left: TreeNode[T], right: TreeNode[T]) = {
    this()
    leftLeaf = left
    rightLeaf = right
  }



  def greaterThan(node: TreeNode[T]): Boolean = {

    if( value.isInstanceOf[Double]){

      val v : Double = value.asInstanceOf[Double];
      val ov : Double = node.value.asInstanceOf[Double];
      if(v > ov){
        true
      }
      else{
        false;
      }
    }

    false;
  }

  override def toString() : String = {

    "value: "+value

  }

}

class BinarySearchTree[T] {

  var root : TreeNode[T] = null;

  def this(root: TreeNode[T]) = {
    this();
    this.root = root;
  }

  def addNode(node: TreeNode[T]) : Unit = {

    var currentLeaf: TreeNode[T] = root;
    var added: Boolean = false;
    while(!added) {
      if (currentLeaf.greaterThan(node)) {
        if (currentLeaf.leftLeaf == null) {
          currentLeaf.leftLeaf = node;
          added = true;
        }
        else {
          currentLeaf = currentLeaf.leftLeaf;

        }
      }
      else {
        if (currentLeaf.rightLeaf == null) {
          currentLeaf.rightLeaf = node;
          added = true;
        }
        else {
          currentLeaf = currentLeaf.rightLeaf;
        }
      }
    }
  }

  def addNode(value: T) : Unit = {
    val currentNode = new TreeNode[T]()
    currentNode.value = value;
    addNode(currentNode);
  }

  def searchBFD(root: TreeNode[T], value: T): TreeNode[T] = {

    if(root.value.equals(value)){
      return root;
    }

    if(root.leftLeaf != null){
      val node : TreeNode[T] = searchBFD(root.leftLeaf, value);
      if(node != null){
        return node;
      }
    }
    if(root.rightLeaf != null){
      val node : TreeNode[T] = searchBFD(root.rightLeaf, value);
      if(node != null){
        return node;
      }
    }

    return null;
  }

  def traverse(): Unit = {

    val que = new Queue[TreeNode[T]]();

    que.enqueue(root)

    while(!que.isEmpty){
      val currentNode : TreeNode[T] = que.dequeue;
      println(currentNode.toString());
      if(currentNode.leftLeaf != null ){
        que.enqueue(currentNode.leftLeaf);
      }
      if(currentNode.rightLeaf != null){
        que.enqueue(currentNode.rightLeaf);
      }
    }
  }

}

object TreeTest {


  def main(args: Array[String]): Unit ={

    val root = new TreeNode[Integer]();
    root.value = 100;

    val tree = new BinarySearchTree[Integer](root);

    for( x <- (1 to 200)){
      tree.addNode(new TreeNode[Integer](Random.nextInt(200)))
    }

    tree.traverse();

  }

}