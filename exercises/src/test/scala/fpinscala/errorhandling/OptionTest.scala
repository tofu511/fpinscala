package fpinscala.errorhandling

import org.scalatest.FunSuite

class OptionTest extends FunSuite {

  test("None map2 None should be None") {
    val result = Option.map2(None, None)((a:Int, b:Int) => a + b)
    assert(result === None)
  }

  test("Option(2) map2 None should be None") {
    val result = Option.map2(Some(2), None)((a:Int, b:Int) => a + b)
    assert(result === None)
  }

  test("None map2 Option(2) should be None") {
    val result = Option.map2(None, Some(2))((a:Int, b:Int) => a + b)
    assert(result === None)
  }

  test("Option(3) map2 Option(2) should apply function") {
    val result = Option.map2(Some(3), Some(2))((a:Int, b:Int) => a + b)
    assert(result === Some(5))
  }

  test("sequence") {
    assert(Option.sequence(List(Some(1), Some(2))) === Some(List(1,2)))
    assert(Option.sequence(List(None)) === None)
  }
}
