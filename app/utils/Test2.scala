package utils

import scala.io.Source

object Test2 extends App {

  val source = Source.fromFile("keys")
  val lines = source.getLines().toSeq.map(_.split(","))
  for {
    x <- lines
    y <- lines
  } {
    val idx = JsonClassification.dscIndex(x.tail.toSet,y.tail.toSet)
    if (idx < 1 && idx > 0.97)
      println(s"${x.head} and ${y.head} with index of $idx")
  }
  source.close()
}
