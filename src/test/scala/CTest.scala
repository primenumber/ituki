package ituki

import chisel3._

import org.scalatest.flatspec.AnyFlatSpec
import chiseltest._

class CTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ituki"
  it should "work through hex" in {
    test(new Top("src/hex/ctest.hex", None)) { c =>
      while (!c.io.exit.peek().litToBoolean) {
        c.clock.step(1)
      }
    }
  }
}

