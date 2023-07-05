package ituki

import chisel3._

import org.scalatest.flatspec.AnyFlatSpec
import chiseltest._
import common.Consts._

class RiscvTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ituki"
  val testData: List[String] = List[String](
    "test/hex/rv32mi-p-csr.hex",
    "test/hex/rv32ui-p-add.hex",
    "test/hex/rv32ui-p-addi.hex",
    "test/hex/rv32ui-p-and.hex",
    "test/hex/rv32ui-p-andi.hex",
    "test/hex/rv32ui-p-auipc.hex",
    "test/hex/rv32ui-p-beq.hex",
    "test/hex/rv32ui-p-bge.hex",
    "test/hex/rv32ui-p-bgeu.hex",
    "test/hex/rv32ui-p-blt.hex",
    "test/hex/rv32ui-p-bltu.hex",
    "test/hex/rv32ui-p-bne.hex",
    "test/hex/rv32ui-p-jal.hex",
    "test/hex/rv32ui-p-jalr.hex",
    "test/hex/rv32ui-p-lui.hex",
    "test/hex/rv32ui-p-lw.hex",
    "test/hex/rv32ui-p-or.hex",
    "test/hex/rv32ui-p-ori.hex",
    "test/hex/rv32ui-p-sll.hex",
    "test/hex/rv32ui-p-slli.hex",
    "test/hex/rv32ui-p-slt.hex",
    "test/hex/rv32ui-p-slti.hex",
    "test/hex/rv32ui-p-sltiu.hex",
    "test/hex/rv32ui-p-sltu.hex",
    "test/hex/rv32ui-p-sra.hex",
    "test/hex/rv32ui-p-srai.hex",
    "test/hex/rv32ui-p-srl.hex",
    "test/hex/rv32ui-p-srli.hex",
    "test/hex/rv32ui-p-sub.hex",
    "test/hex/rv32ui-p-sw.hex",
    "test/hex/rv32ui-p-xor.hex",
    "test/hex/rv32ui-p-xori.hex",
  )
  it should "work through hex" in {
    testData.foreach { f =>
      test(new Top(f, Some(0x44.U(WORD_LEN.W)))) { c =>
        while (!c.io.exit.peek().litToBoolean) {
          c.clock.step(1)
        }
        c.io.gp.expect(1.U)
      }
    }
  }
}
