package pl.jozwik.demo

import com.typesafe.scalalogging.StrictLogging
import org.scalatest._
import org.scalatest.prop.Checkers

trait AbstractSpecScalaCheck extends AbstractSpec with Checkers

trait AbstractSpec extends WordSpecLike with Matchers with StrictLogging

class DemoSpec extends AbstractSpec {

  "Demo " should {
    "Add two integers " in {
      val a = 4
      val b = 5
      Demo.add(a, b) shouldBe (a + b)

    }

  }

}

class DemoSpecScalaCheck extends AbstractSpecScalaCheck {

  "Demo " should {
    "Add two integers " in {
      check {
        (a: Int, b: Int) =>
          //logger.debug(s"$a + $b")
          Demo.add(a, b) === (a + b)
      }
    }
  }
}
