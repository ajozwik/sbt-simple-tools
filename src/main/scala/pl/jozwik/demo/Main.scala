package pl.jozwik.demo

import com.typesafe.scalalogging.StrictLogging


object Main extends App with StrictLogging {
  logger.debug(s"""Hello world ${args.mkString(",")}""")
  val a = 3
  val b = 4
  logger.debug(s"""$a + $b = ${Demo.add(a, b)}""")
}
