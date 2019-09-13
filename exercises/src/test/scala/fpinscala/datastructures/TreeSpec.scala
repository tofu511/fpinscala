package fpinscala.datastructures

import org.scalatest.{FunSpec, Matchers}

class TreeSpec extends FunSpec with Matchers {

  val t = Branch(Branch(Leaf(100), Leaf(20)), Leaf(3))

  describe("Tree") {
    describe("size2") {
      it("should return node's size") {
        Tree.size2(t) should be (3)
        Tree.size2(Leaf(2)) should be (1)
      }
    }

    describe("maximum2") {
      it("should return maximum value") {
        Tree.maximum2(t) should be (100)
        Tree.maximum2(Leaf(5)) should be (5)
      }
    }

    describe("depth2") {
      it("should return deepest path") {
        Tree.depth2(t) should be (2)
        Tree.depth2(Leaf(5)) should be (0)
      }
    }

    describe("map2") {
      Tree.map2(t)(x => x + 1) should be (Branch(Branch(Leaf(101), Leaf(21)), Leaf(4)))
      Tree.map2(t)(x => x * x) should be (Branch(Branch(Leaf(10000), Leaf(400)), Leaf(9)))
    }

  }
}
