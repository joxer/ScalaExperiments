package org.foundations.graph

import scala.collection.immutable.HashMap
import scala.util.Random

/**
 * Created by joxer on 04/10/15.
 */


class GraphNode[T] {


  private var vertices: Map[GraphNode[T], Integer] = HashMap();
  private var nodeValue: T = None.asInstanceOf[T];

  def addNode(value: T): GraphNode[T] = {
    val node = new GraphNode[T]()
    node.vertices += (this -> Random.nextInt());
    node
  }

  def getNearestVertex(): GraphNode[T] = {
    var ret: GraphNode[T] = None.asInstanceOf[GraphNode[T]];
    var max: Integer = -1;
    vertices.foreach( node => {

      if(node._2 < max || max == -1){
        max = node._2;
        ret = node._1;
      }

    })

    ret;
  }



}
