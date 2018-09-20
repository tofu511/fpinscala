package fpinscala.gettingstarted

import org.scalatest.FunSuite

class MyModuleTest extends FunSuite {

  case class Fixture(param: Int, result: Int)

  val fixtures = Seq(
    Fixture(0, 0),
    Fixture(1, 1),
    Fixture(2, 1),
    Fixture(3, 2),
    Fixture(4, 3),
    Fixture(5, 5)
  )
  fixtures.foreach { f =>
    test(s"fib(${f.param}) returns ${f.result}") {
      assert(MyModule.fib(f.param) === f.result)
    }
  }
}
