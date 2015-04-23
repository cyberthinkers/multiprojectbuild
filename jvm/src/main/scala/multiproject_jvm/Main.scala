package multiproject_jvm
import org.shared.CommonLib

object Main {
  def main(args: Array[String]): Unit = {
    val lib = new CommonLib
    println(lib.square(2))
    println(lib.cubed(3))
    println(lib.square(3))
  }
}