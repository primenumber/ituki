package common

import chisel3._
import chisel3.util._

object Instructions {
  val LW = BitPat("b????_????_????_????_?010_????_?000_0011")
  val SW = BitPat("b????_????_????_????_?010_????_?010_0011")
}
