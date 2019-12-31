package utils

import java.io.{BufferedWriter, FileWriter, File}

import play.api.libs.json.{JsArray, JsObject, JsValue, Json}

import scala.io.Source

object Test extends App {

//  val filePath = "/Users/iraj.hedayati/Documents/Paytm/signals/mobile-device-signals/dt=2019-12-22/1_0_00000000017995193195"
  val filePath = "/Users/iraj.hedayati/Documents/Paytm/signals/mobile-device-signals/dt=2019-12-22/location_events.json"
  val source = Source.fromFile(filePath)
  val values: Iterator[JsValue] = source.getLines().map(Json.parse)
  val classified = JsonClassification.groupByKeys(JsArray(values.toSeq), "payload")
  writeFile("keys", classified.keys.map(_.toSeq.sorted).map(_.mkString(",")).toSeq.zipWithIndex.map(pair => s"${pair._2},${pair._1}"))
  classified.zipWithIndex.foreach(t => writeFile(s"${t._2}.json", t._1._2.toString()))
  val schema = AvroSchema(JsArray(values.toSeq), "MobileDeviceLocationEventSignal", "com.paytmlabs")
  val idl: String = new AvroSchemaToIdl(schema, "Protocol").convert()
  writeFile("location_event-value.avdl", idl)
  source.close()

  def writeFile(filename: String, lines: Seq[String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    for (line <- lines) {
      bw.write(line)
      bw.newLine()
    }
    bw.close()
  }
  def writeFile(filename: String, s: String): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(s)
    bw.close()
  }
}
