package sorts.test

import sorts.Heap
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HeapSuite extends FunSuite{
  trait TestVectores {
    val vector1 = Vector(8,3,4,6,2,5,7,9)
    val vector2 = Vector(7,4,3,1,15,4,2)
  }

  test("building the heap") {
    new TestVectores {
      val heap = new Heap(vector1)
      assert(Vector(9,8,7,6,2,4,5,3) === heap.heap)
      assert(Vector(15,7,4,1,4,3,2) === new Heap(vector2).heap)
    }
  }
}