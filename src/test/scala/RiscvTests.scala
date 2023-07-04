package ituki

import chisel3._

import org.scalatest.flatspec.AnyFlatSpec
import chiseltest._

class RiscvTest extends AnyFlatSpec with ChiselScalatestTester {
  it should "work through hex" in {
    test(new Top("test/hex/rv32ui-p-add.hex")) { c =>
      while (!c.io.exit.peek().litToBoolean) {
        c.clock.step(1)
      }
      c.io.gp.expect(1.U)
    }
  }
  
}
