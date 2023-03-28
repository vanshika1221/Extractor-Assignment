package com.knoldus
import org.scalatest.funsuite.AnyFunSuite
class ExtractorsTest extends AnyFunSuite {
  test("To test Valid URL") {
    val url = "https://www.mywebsite.com/home"
    val result = Some("https","www.mywebsite.com","home")
    assert(Extractors.unapply(Extractors(url)) === result)
  }
  test("To test Invalid URL") {
    val url ="1234"
    val result = None
    assert(Extractors.unapply(Extractors(url)) === result)
  }
  test("To test Incomplete URL") {
    val url = "https://www.mywebsite.com"
    val result = None
    assert(Extractors.unapply(Extractors(url)) === result)
  }
}
