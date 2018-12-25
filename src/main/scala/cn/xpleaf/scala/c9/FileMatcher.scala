package cn.xpleaf.scala.c9

import java.io.File

/**
  * @author xpleaf 
  * @date 2018/12/20 9:03 PM
  */
object FileMatcher {

    private def filesHere = new java.io.File(".").listFiles()

    private def filesMatching(matcher: String => Boolean)=
        for(file <- filesHere if matcher(file.getName)) yield file

    def filesEnding(query: String): Array[File] =
        filesMatching(_.endsWith(query))

    def filesContaining(query: String): Array[File] =
        filesMatching(_.contains(query))

    def filesRegex(query: String): Array[File] =
        filesMatching(_.matches(query))
}
