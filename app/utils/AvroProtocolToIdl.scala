package utils

import org.apache.avro.Protocol

import scala.jdk.CollectionConverters._

class AvroProtocolToIdl(protocol: Protocol) {
  def convert(): String = {
    val recordsInString = protocol.getTypes.asScala
      .map(schema => new AvroSchemaToIdl(schema, "").convertJustRecord())
      .mkString("\n")
    s"""@namespace("${protocol.getNamespace}")
       |protocol ${protocol.getName} {$recordsInString
       |}
       |""".stripMargin
  }
}
