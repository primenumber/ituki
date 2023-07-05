package ituki

import chisel3._
import chisel3.util._
import common.Consts._

class Top(memory_init_file: String, exit_pc: Option[UInt]) extends Module {
  val io = IO(new Bundle {
    val exit = Output(Bool())
    val gp = Output(UInt(WORD_LEN.W))
  })
  val core = Module(new Core(exit_pc))
  val memory = Module(new Memory(memory_init_file))

  core.io.imem <> memory.io.imem
  core.io.dmem <> memory.io.dmem

  io.exit := core.io.exit
  io.gp := core.io.gp
}
