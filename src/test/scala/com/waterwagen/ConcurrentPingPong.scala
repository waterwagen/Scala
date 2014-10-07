package com.waterwagen

import scala.actors.Actor._
import scala.actors._

object ConcurrentPingPong extends App {

  case class Message(msg: String)

  case class Shutdown()

  val actor1 = actor {
    var running = true
    while (running) {
      receive {
        case msg: Message => println(msg.msg); Actor.sender ! new Message("pong")
        case msg: Shutdown => running = false
        case _ => println("Unknown message type received.")
      }
    }
  }
  actor1.start()

  val actor2 = actor {
    var running = true
    while (running) {
      actor1 ! new Message("ping")
      receive {
        case msg: Message => println(msg.msg); if (msg.msg == "pong") actor1 ! new Shutdown(); running = false;
        //				case msg:Shutdown => running = false
        case _ => println("Unknown message type received.")
      }
    }
  }
  actor2.start()
}