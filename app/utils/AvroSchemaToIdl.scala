package utils

import org.apache.avro.Schema

import scala.collection.mutable
import scala.jdk.CollectionConverters._

class AvroSchemaToIdl(schema: Schema, protocol: String) {

  import AvroSchema._
  private val recordsToProcessStack: mutable.Stack[Schema] = mutable.Stack[Schema]()
  /** A set of records already processed. It is in form of `namespace.name` */
  private val records: mutable.Set[String] = mutable.Set()

  def convert(): String = {
    recordsToProcessStack.push(schema)
    var recordsInString = ""
    while(recordsToProcessStack.nonEmpty) recordsInString = recordsInString + "\n" + recordToIdl()
    return s"""@namespace("${schema.getNamespace}")
              |protocol $protocol {
              |$recordsInString
              |}
              |""".stripMargin
    ""
  }

  def recordToIdl(): String = {
    val schema: Schema = recordsToProcessStack.pop()
    val recordName = "${schema.getNamespace}.${schema.getName}"
    if (records.contains(recordName)) ""
    else {
      val fields = schema.getFields.asScala
        .map(field => fieldToIdl(field))
        .mkString("\n")
      records.add(recordName)
      s"""
         |  record ${schema.getName} {
         |$fields
         |  }
         |""".stripMargin
    }
  }

  def fieldToIdl(field: Schema.Field): String = s"    ${schemaTypeInIdl(field.schema())} ${field.name()};"

  def schemaTypeInIdl(field: Schema): String = field match {
    case _ if field.isUnion && field.isNullable =>
      s"union { ${field.getTypes.asScala.map(schemaTypeInIdl).mkString(", ")} }"
    case _ if field.isRecord =>
      recordsToProcessStack.push(field)
      field.getName
    case _ if field.isArray => s"array<${schemaTypeInIdl(field.getElementType)}>"
    case _ => field.getType.toString.toLowerCase
  }
}
