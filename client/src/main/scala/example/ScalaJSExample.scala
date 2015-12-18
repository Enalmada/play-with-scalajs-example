package example

import org.querki.jquery._
import org.scalajs.dom.Element
import scala.scalajs.js

object ScalaJSExample extends js.JSApp {

  def main(): Unit = {

    $("body").on("click", ".clickMe", js.undefined, { (elem:Element, evt:JQueryEventObject) =>
      println("clicked")
    })

  }
}