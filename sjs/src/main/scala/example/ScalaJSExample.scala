package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import org.shared.CommonLib

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    val paragraph = dom.document.createElement("p")
    val lib = new CommonLib
    val sqr = lib.square(2)
    paragraph.innerHTML = s"Hey: <strong>It works! 2^2 = $sqr</strong>"
    dom.document.getElementById("playground").appendChild(paragraph)
  }
}
