package com.waterwagen

//import scala.actors.Actor._
//import scala.actors._
import scala.collection.JavaConversions._
import scala.collection.mutable.HashSet
import scala.collection.mutable.Set
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import org.junit.Assert._
import org.junit.Before
import org.hamcrest.Matchers._
import org.hamcrest.MatcherAssert.assertThat
import com.waterwagen.LinkedListBuilder._
import java.util.TimeZone
import java.awt.datatransfer._
import scala.collection.mutable.Buffer

object TreeStudy extends App
{
	val root = TreeNode(9)

	root.insert(8)
	root.insert(4)
	root.insert(7)
	root.insert(12)
	root.insert(11)
	root.insert(15)
//	root.left = TreeNode(8)
//	root.left.left = TreeNode(4)
//	root.left.right = TreeNode(7)
//
//	root.right = TreeNode(12)
//	root.right.left = TreeNode(11)
//	root.right.right = TreeNode(15)
	
//	root.printTreeVisual()
//	root.printTreeTextualDepthFirst()
	root.printTreeTextualBreadthFirst()

	println("-" * 80)
	def size(node : TreeNode) : Int = if(node == null) 0; else 1 + size(node.left) + size(node.right)
	printf("%s nodes in tree.", size(root))
}