package com.knoldus

object Driver extends App {
    val url = "https://www.mywebsite.com/home"
    val extractorObject = Extractors(url)
    val result: String = extractorObject match {
      case Extractors(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
      case _ => "Invalid URL"
    }
    println(result)
}
