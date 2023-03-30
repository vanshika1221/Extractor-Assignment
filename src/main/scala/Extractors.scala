package com.knoldus
import scala.util.{Try, Success, Failure}

class Extractors(val urlParser: String)

//Companion object
object Extractors {
  def apply(url: String): Extractors = new Extractors(url)

  // creating unapply method
  def unapply(urlString: Extractors): Option[(String, String, String)] = {
    val url = urlString.urlParser
    //extracting the protocol from url
    val protocol = Try(url.substring(0, url.indexOf(":"))) match {
      case Success(value) => value
      case Failure(_) => return None
    }
    val domainaAndPath = url.substring(url.indexOf(":") + 3)
    val domain = Try(domainaAndPath.substring(0, domainaAndPath.indexOf("/"))) match {
      case Success(value) => value
      case Failure(_) => return None
    }
    val path = Try(domainaAndPath.substring(domainaAndPath.indexOf("/") + 1)) match {
      case Success(value) => value
      case Failure(_) => return None
    }
    Some(protocol, domain, path)
  }
}
