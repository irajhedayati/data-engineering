package utils

import org.apache.avro.Schema

import scala.collection.mutable
import scala.jdk.CollectionConverters._

class AvroSchemaToIdl(schema: Schema, protocol: String) {

  import AvroSchema._
  val records: mutable.Stack[Schema] = mutable.Stack[Schema]()

  def convert(): String = {
    records.push(schema)
    var recordsInString = ""
    while(records.nonEmpty) recordsInString = recordsInString + "\n" + recordToIdl()
    return s"""@namespace("${schema.getNamespace}")
              |protocol $protocol {
              |$recordsInString
              |}
              |""".stripMargin
    ""
  }

  def recordToIdl(): String = {
    val schema: Schema = records.pop()
    val fields = schema.getFields.asScala
      .map(field => fieldToIdl(field))
      .mkString("\n")

    s"""
       |  record ${schema.getName} {
       |$fields
       |  }
       |""".stripMargin
  }

  def fieldToIdl(field: Schema.Field): String = s"    ${schemaTypeInIdl(field.schema())} ${field.name()};"

  def schemaTypeInIdl(field: Schema): String = field match {
    case _ if field.isUnion && field.isNullable =>
      s"union { ${field.getTypes.asScala.map(schemaTypeInIdl).mkString(", ")} }"
    case _ if field.isRecord =>
      records.push(field)
      field.getName
    case _ if field.isArray => s"array<${schemaTypeInIdl(field.getElementType)}>"
    case _ => field.getType.toString.toLowerCase
  }
}
