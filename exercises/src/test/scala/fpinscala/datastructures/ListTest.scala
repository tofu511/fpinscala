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

  test("setHead") {
    List.setHead(intList, 10) should be (Cons(10, Cons(2, Cons(3, Nil))))
    List.setHead(Nil, 10) shouldBe Nil
  }

  test("drop") {
    List.drop(intList, -1) should be (intList)
    List.drop(intList, 1) should be (Cons(2, Cons(3, Nil)))
    List.drop(intList, 2) should be (Cons(3, Nil))
  }

  test("dropWhile") {
    val f: Int => Boolean = x => x < 2
    List.dropWhile(intList, f) should be (Cons(2, Cons(3, Nil)))
  }

  test("init") {
    List.init(intList) should be (Cons(1, Cons(2, Nil)))
    List.init(Cons(1, Cons(2, Cons(3, Cons(4, Nil))))) should be (Cons(1, Cons(2, Cons(3, Nil))))
  }

  test("length") {
    List.length(intList) should be (3)
    List.length(Cons(1, Cons(2, Nil))) should be (2)
  }

  test("foldLeft") {
    List.foldLeft(intList, 0)(_ + _) should be (6)
    List.foldLeft(intList, 1)(_ * _) should be (6)
  }

  test("sum3") {
    List.sum3(intList) should be (6)
    List.sum3(Cons(10, Cons(50, Nil))) should be (60)
  }

  test("product3") {
    List.product3(intList) should be (6)
    List.product3(Cons(10, Cons(50, Nil))) should be (500)
  }

  test("length2") {
    List.length2(intList) should be (3)
    List.length2(Cons(1, Cons(2, Cons(3, Cons(4, Nil))))) should be (4)
  }

  test("reverse") {
    List.reverse(intList) should be (Cons(3, Cons(2, Cons(1, Nil))))
    List.reverse(Cons("a", Cons("b", Cons("c", Nil)))) should be (Cons("c", Cons("b", Cons("a", Nil))))
  }

  test("append2") {
    val l = Cons(4, Cons(5, Cons(6, Nil)))
    List.append2(intList, l) should be (Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Cons(6, Nil)))))))
  }

  test("add1") {
    List.add1(Cons(1, Cons(2, Nil))) should be (Cons(2, Cons(3, Nil)))
    List.add1(Cons(5, Cons(10, Nil))) should be (Cons(6, Cons(11, Nil)))
  }

  test("doubleToString") {
    List.doubleToString(doubleList) should be (Cons("1.0", Cons("2.0", Cons("3.0", Nil))))
  }

  test("map") {
    List.map(intList)(x => x + 1) should be (Cons(2, Cons(3, Cons(4, Nil))))
    List.map(intList)(x => x * x) should be (Cons(1, Cons(4, Cons(9, Nil))))
  }

  test("filter") {
    List.filter(intList)(x => x % 2 == 0) should be (Cons(2, Nil))
    List.filter(intList)(x => x % 2 != 0) should be (Cons(1, Cons(3, Nil)))
  }

}
