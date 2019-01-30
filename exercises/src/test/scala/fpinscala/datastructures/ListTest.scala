package fpinscala.datastructures

import org.scalatest.{FunSuite, Matchers}

class ListTest extends FunSuite with Matchers {

  val intList = Cons(1, Cons(2, Cons(3, Nil)))
  val doubleList = Cons(1.0, Cons(2.0, Cons(3.0, Nil)))

  test("sum list") {
    List.sum(intList) should be (6)
  }

  test("sum Nil") {
    List.sum(Nil) should be (0)
  }

  test("product list") {
    List.product(doubleList) should be (6.0)
  }

  test("product list with zero") {
    val listIncludeZero: List[Double] = Cons(1.0, Cons(2.0, Cons(0.0, Nil)))
    List.product(listIncludeZero) should be (0.0)
  }

  test("product Nil") {
    List.product(Nil) should be (1.0)
  }

  test("apply Int value") {
    List.apply(1) should be (Cons(1, Nil))
  }

  test("apply String value") {
    List.apply("foo") should be (Cons("foo", Nil))
  }

  test("apply Nil") {
    List.apply(Nil) should be (Cons(Nil, Nil))
  }

  test("append list of Int value") {
    val l = Cons(4, Cons(5, Cons(6, Nil)))
    List.append(intList, l) should be (Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Cons(6, Nil)))))))
  }

  test("append list to Nil") {
    List.append(Nil, intList) should be (intList)
  }

  test("sum with foldRight") {
    List.foldRight(intList, 0){ _ + _ } should be (6)
  }

  test("multiply with foldRight") {
    List.foldRight(intList, 1){_ * _} should be (6)
  }

  test("foldRight Nil") {
    List.foldRight(Nil: List[Int], 0) {_ + _} should be (0)
  }

  test("sum2") {
    List.sum2(intList) should be (6)
  }

  test("product2") {
    List.product2(doubleList) should be (6.0)
  }

  test("tail") {
    List.tail(intList) should be (Cons(2, Cons(3, Nil)))
  }
}
