package utils

import org.apache.avro.SchemaBuilder
import org.scalatestplus.play.PlaySpec

class AvroSchemaTest extends PlaySpec {

  import AvroSchema._

  "Avro schema merger" must {
    "return same schema if both are equivalent" in {
      val a = SchemaBuilder.builder().stringType()
      val b = SchemaBuilder.builder().stringType()
      a mergeWith b mustBe a
    }

    "Two records when one has no fields" in {
      val a = SchemaBuilder.record("ConfigData").fields().endRecord()
      val b = SchemaBuilder.record("ConfigData").fields()
        .name("daily_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()

      a mergeWith b mustBe b
      b mergeWith a mustBe b
    }

    "Two nullable records when one has no fields" in {
      val a = SchemaBuilder.record("ConfigData").fields().endRecord().makeNullable
      val b = SchemaBuilder.record("ConfigData").fields()
        .name("daily_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()
        .makeNullable

      a mergeWith b mustBe b
      b mergeWith a mustBe b
    }

    "Two records with no matching fields" in {
      val a = SchemaBuilder.record("ConfigData").fields()
        .name("monthly_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()
      val b = SchemaBuilder.record("ConfigData").fields()
        .name("daily_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()

      val merged = SchemaBuilder.record("ConfigData").fields()
        .name("monthly_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("daily_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()

      a mergeWith b mustBe merged
      b mergeWith a mustBe merged
    }

    "two records of same fields without complex types" in {
      val a = SchemaBuilder.record("Actions").fields()
        .name("ruleName").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("ruleStatus").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("extraOptions").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("children").`type`(SchemaBuilder.builder().array().items(SchemaBuilder.builder().nullType()).makeNullable).withDefault(null)
        .name("timeout").`type`(SchemaBuilder.builder().booleanType().makeNullable).withDefault(null)
        .name("ruleResult").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("tags").`type`(SchemaBuilder.builder().array().items(SchemaBuilder.builder().nullType()).makeNullable).withDefault(null)
        .endRecord()
      val b = SchemaBuilder.record("Actions").fields()
        .name("ruleName").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("ruleStatus").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("extraOptions").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("children").`type`(SchemaBuilder.builder().array().items(SchemaBuilder.builder().nullType()).makeNullable).withDefault(null)
        .name("timeout").`type`(SchemaBuilder.builder().booleanType().makeNullable).withDefault(null)
        .name("ruleResult").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("tags").`type`(SchemaBuilder.builder().array().items(SchemaBuilder.builder().nullType()).makeNullable).withDefault(null)
        .endRecord()

      a mergeWith b mustBe a
      b mergeWith a mustBe b
    }

    "Array of null and array of nullable" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().nullType())
      val b = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)

      a mergeWith b mustBe b
      b mergeWith a mustBe b
    }

    "Nested types" in {
      val a = SchemaBuilder
        .array().items(
        SchemaBuilder.record("ActionMessagesList").fields()
          .name("messageType").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
          .name("actionMessages").`type`(SchemaBuilder.builder().array().items(SchemaBuilder.builder().nullType()).makeNullable).withDefault(null)
          .endRecord()
          .makeNullable
      )
        .makeNullable
      val b = SchemaBuilder
        .array().items(
        SchemaBuilder.record("ActionMessagesList").fields()
          .name("messageType").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
          .name("actionMessages").`type`(SchemaBuilder.builder().array().items(
          SchemaBuilder.builder().record("ActionMessages").fields()
            .name("action").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
            .name("message").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
            .endRecord()
            .makeNullable
        ).makeNullable
        ).withDefault(null)
          .endRecord()
          .makeNullable
      )
        .makeNullable
    }
  }


  "Avro schema extract types not null" must {
    "return the main schema of a nullable type" in {
      val nullableString = SchemaBuilder.unionOf().nullType().and().stringType().endUnion()
      nullableString.getTypesWithoutNull mustBe SchemaBuilder.builder().stringType()
    }
    "return the schema if it's not nullable" in {
      val notNullSchema = SchemaBuilder.builder().stringType()
      notNullSchema.getTypesWithoutNull mustBe notNullSchema
    }
  }

  "Avro schema" must {
    "Make the input schema nullable" in {
      val result = SchemaBuilder.builder().stringType().makeNullable
      result.isUnion mustBe true
      result.isNullable mustBe true
    }
  }

  "Avro IDL" must {
    "generate proper schema" in {
      val idl =
        """
          |@namespace("null")
          |protocol AvroSchemaTool {
          |
          |  record TestObject {
          |    TestObject2 name;
          |  }
          |  record TestObject2 {
          |    int age;
          |  }
          |
          |}
          |""".stripMargin
      println(AvroSchema.idlToSchema(idl))
    }
  }
}
