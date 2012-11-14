package com.waterwagen

import scala.actors.Actor._
import scala.actors._

object Concurrency extends App 
{
	// Try some concurrency features
	//Mesage types
	case class RunningStateMessage(shouldRun:Boolean)
	case class PrintStringMessage(str:String)
	class MyFirstActor extends Actor
	{
		def act()
		{
			var running = true
			while(running)
			{
				receive
				{
					case msg:Boolean => println("Received boolean " + msg)
					case msg:String => println("Received string " + msg)
					case msg:RunningStateMessage => println("Received running state message " + msg); running = msg.shouldRun
					case msg:PrintStringMessage => println("Received print string message. String is " + msg.str)
					case _ => println("Unknown message type received.")
				}
			}
		}
	}
	val first_actor = new MyFirstActor()
	first_actor.start
	// send messages to the actor
	first_actor ! "This is a message."
	first_actor ! "This is also a message."
	first_actor ! true
	first_actor ! false
	first_actor ! new PrintStringMessage("I want to print this message.")
	first_actor ! "stop"
	first_actor ! List(1,2,3)
	first_actor ! RunningStateMessage(false) // new keyword is optional (only for case classes?)
	first_actor ! "This message should not be received because the actor was stopped"
	
	// try a shortcut for creating actors
	case class PrintMessage(toPrint:String)
	case class StopMessage()
	val receiving_actor = actor
	{
		var running = true
		while(running)
		{
			receive
			{
				case msg:PrintMessage => println(msg.toPrint)
				case msg:StopMessage => running = false
				case _ => println("Unknown message received.")
			}
		}
	}
	receiving_actor.start()
	val sending_actor = actor 
	{
		receiving_actor ! PrintMessage("Yo!")
		receiving_actor ! PrintMessage("Yo, again!")
		receiving_actor ! StopMessage()
	}
	sending_actor.start()

	// Try some of the Actor methods
	// try an Actor's loop
	val looping_actor = actor
	{
		var counter = 1;
		loop
		{
			if(counter > 5)
				exit()
			println("Loop counter=" + counter)
			counter += 1
		}
	}
	looping_actor.start()
	
	// try and Actor's loopWhile and receiveWithin
	case class StandardMessage(str:String)
	val timeout_actor = actor
	{
		var running = true
		loopWhile(running)
		{
			receiveWithin(2000)
			{
				case msg:StandardMessage => println(msg.str)
				case TIMEOUT => running = false
				case _ => "Unknown message!"
			}
		}
	}
	timeout_actor.start()
	for(counter <- 1 to 3)
		timeout_actor ! StandardMessage("Message " + counter)
	Thread.sleep(3000)
	timeout_actor ! StandardMessage("This message should not be received!")
}