package ca.dataedu

import sttp.tapir._

object AvroAPI {

  private val AvroBasePath = "avro" / "api" / "v1"

  lazy val AvroFromJsonEndpoint: PublicEndpoint[String, String, String, Any] =
    endpoint
      .name("Infer Avro schema from JSON")
      .post
      .in(AvroBasePath / "json-doc-to-avro")
      .in(stringJsonBody)
      .out(stringJsonBody)
      .errorOut(plainBody[String])

  lazy val AvroToIdlEndpoint: PublicEndpoint[String, String, String, Any] =
    endpoint
      .name("Convert Avro schema to Avro IDL")
      .post
      .in(AvroBasePath / "avro-to-idl")
      .in(stringJsonBody)
      .out(plainBody[String])
      .errorOut(plainBody[String])

  lazy val IdlToAvroEndpoint: PublicEndpoint[String, String, String, Any] =
    endpoint
      .name("Convert Avro IDL to Avro schema")
      .post
      .in(AvroBasePath / "idl-to-avro")
      .in(plainBody[String])
      .out(stringJsonBody)
      .errorOut(plainBody[String])

  lazy val AvroToHiveEndpoint: PublicEndpoint[String, String, String, Any] =
    endpoint
      .name("Generate Hive DDL from Avro schema")
      .post
      .in(AvroBasePath / "avro-to-hive")
      .in(stringJsonBody)
      .out(plainBody[String])
      .errorOut(plainBody[String])

  lazy val FlatAvroEndpoint: PublicEndpoint[String, String, String, Any] =
    endpoint
      .name("Flattens a nested Avro schema")
      .post
      .in(AvroBasePath / "flat-avro")
      .in(stringJsonBody)
      .out(stringJsonBody)
      .errorOut(plainBody[String])

}
