package ituki

import chisel3._

import org.scalatest.freespec.AnyFreeSpec
import chiseltest._

class HexTest extends AnyFreeSpec with ChiselScalatestTester {
  "ituki should work through hex" in {
    test(new Top) { c =>
      while (!c.io.exit.peek().litToBoolean) {
        c.clock.step(1)
      }
    }
  }
  
}
