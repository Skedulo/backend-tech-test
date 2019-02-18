package com.skedulo.music

import java.io.{File, PrintWriter}
import java.time.ZonedDateTime

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import io.circe.java8.time._

import scala.io.Source

case class Performance(band: String, start: ZonedDateTime, finish: ZonedDateTime, priority: Int)

object Scheduler extends App {

  if (args.length != 1) {
    println(s"Please supply the input file name as an argument")
    System.exit(1)
  }

  val inFile = args(0)
  val outFile = inFile.replace(".json", ".optimal.json")

  val fileSource = Source.fromFile(inFile)
  val performancesJson = fileSource.getLines.mkString
  fileSource.close

  val perfs = decode[Seq[Performance]](performancesJson)

  val schedule: Seq[Performance] = optimalSchedule(perfs.right.get)

  val scheduleJson = schedule.toArray.asJson.spaces2
  val pw = new PrintWriter(new File(outFile))
  pw.write(scheduleJson)
  pw.close()


  def optimalSchedule(performances: Seq[Performance]): Seq[Performance] = {
    // TODO: Create the optimal schedule
    performances
  }
}