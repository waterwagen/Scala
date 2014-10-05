package com.waterwagen

import scala.reflect.BeanProperty
import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import scala.collection.mutable.HashSet

class TreeNode(init_value : Int)
{
	var right : TreeNode = _
	var left : TreeNode = _
	val value : Int = init_value
	
	def insert(new_val : Int) 
	{
		if(new_val > value)
		{
			if(right == null)
				right = TreeNode(new_val)
			else
				right.insert(new_val)
		}
		else
		{
			if(left == null)
				left = TreeNode(new_val)
			else
				left.insert(new_val)
		}
	}
	
	case class MetaNode(node : TreeNode, level : Int, position : Int)
	def printTreeVisual() 
	{
		val node_queue = new Queue[MetaNode]()
		var prev_level = -1
		val val_line = new StringBuilder()
		val connector_line = new StringBuilder()
		val pos_pad = 1
		
		node_queue += MetaNode(this, 0, 16)
		while(!node_queue.isEmpty)
		{
			var meta = node_queue.dequeue()
//			println(meta.node.value + " " + meta.level + " " + meta.position)
			if(meta.node.left != null)
				node_queue += MetaNode(meta.node.left, meta.level + 1, meta.position - 2) 
			if(meta.node.right != null)
				node_queue += MetaNode(meta.node.right, meta.level + 1, meta.position + 2) 
			
			// printing
			if(meta.level > prev_level)
			{
				println(val_line toString)
				println(connector_line toString)
				val_line.clear()
				connector_line.clear()
			}
			val positionPadStr = (line_builder : StringBuilder, position : Int) => if(position > line_builder.length) " " * (position - line_builder.length) else "" 
			val_line append positionPadStr(val_line, meta.position) append meta.node.value
			connector_line append positionPadStr(connector_line, meta.position) append "/" 
			connector_line append positionPadStr(connector_line, meta.position + 1) append "\\"
				
			prev_level = meta.level
		}
		println(val_line toString)
		println(connector_line toString)
	}
	def printTreeTextualDepthFirst()
	{
		def printTree(node : TreeNode, parent : TreeNode)
		{
			if(node != null)
			{
				val parent_value = if(parent != null) parent.value; else "none"
				printf("%s child of %s\n", node.value, parent_value)
				printTree(node.right, node)
				printTree(node.left, node)
			}
		}
		printTree(this, null)
	}
	def printTreeTextualBreadthFirst()
	{
		case class MetaNode(node : TreeNode, parent : TreeNode)
		val queue = scala.collection.mutable.Queue[MetaNode]()
		queue += MetaNode(this, null)
		
		while(!queue.isEmpty)
		{
			val metanode = queue.dequeue()
			val parent_value = if(metanode.parent != null) metanode.parent.value; else "none"
			printf("%s child of %s\n", metanode.node.value, parent_value)
			
			if(metanode.node.left != null) queue += MetaNode(metanode.node.left, metanode.node)
			if(metanode.node.right != null) queue += MetaNode(metanode.node.right, metanode.node)
		}
	}
	
//	def printTree() 
//	{
//		val padcount = 4
//		
//		val queue = new Queue[TreeNode]()
//		
//		queue += this
//		while(!queue.isEmpty)
//		{
//			val node = queue.dequeue()
//			println(" " * padcount + node.value)
//			val builder = new StringBuilder(" " * (padcount - 1))
//			if(node.left != null)
//			{
//				builder append "/"
//				queue += node.left
//			}
//			else
//				builder append " "
//			if(node.right != null)
//			{
//				builder append "\\"
//				queue += node.right
//			}
//			print(builder toString)
//		}
//		
//		
//		println(" " * tabcount + value)
//		if(left != null)
//		{
//			println(" " * (tabcount - 1) + "/")
//			left.printTree(tabcount - 1)
//		}
//		if(right != null)
//		{
//			println(" " * (tabcount + 1) + "\\")
//			right.printTree(tabcount + 1)
//		}
//	}
}

object TreeNode
{
	def apply(init_value : Int) =
	{
		new TreeNode(init_value)
	}
}