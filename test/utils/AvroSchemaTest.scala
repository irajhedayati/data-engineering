package utils

import org.apache.avro.{Schema, SchemaBuilder}
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.{JsObject, Json}
import scala.jdk.CollectionConverters._

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
        .name("daily_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("monthly_count").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
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

    "A record with a union where union has a record of same type" in {
      val recordA = SchemaBuilder.record("Product").fields()
        .name("Category_ID_Tree").`type`(SchemaBuilder.builder().stringType().makeNullable).noDefault()
        .endRecord()
      val unionWithRecordA = SchemaBuilder.unionOf()
        .record("Product").fields()
        .name("AB_Experiment__Product_").`type`(SchemaBuilder.builder().stringType().makeNullable).noDefault()
        .endRecord()
        .and()
        .array().items().nullType()
        .endUnion()

      val expected = SchemaBuilder.unionOf()
        .record("Product").fields()
        .name("AB_Experiment__Product_").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .name("Category_ID_Tree").`type`(SchemaBuilder.builder().stringType().makeNullable).withDefault(null)
        .endRecord()
        .and()
        .array().items().nullType()
        .endUnion()

      recordA mergeWith unionWithRecordA mustBe expected
      unionWithRecordA mergeWith recordA mustBe expected
    }

    "Array of null and array of nullable" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().nullType())
      val b = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)

      a mergeWith b mustBe b
      b mergeWith a mustBe b
    }

    "Array with nonArray and not nullable and not union" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)
      val b = SchemaBuilder.builder().stringType()

      a mergeWith b mustBe SchemaBuilder.unionOf().`type`(a).and().`type`(b).endUnion()
      b mergeWith a mustBe SchemaBuilder.unionOf().`type`(b).and().`type`(a).endUnion()
    }

    "Array with nonArray and     nullable and not union" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)
      val b = SchemaBuilder.builder().nullType()

      a mergeWith b mustBe a.makeNullable
      b mergeWith a mustBe a.makeNullable
    }

    "Array with nonArray and     nullable and     union" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)
      val b = SchemaBuilder.unionOf().stringType().and().intType().endUnion().makeNullable
      val expected = Schema.createUnion((Seq(a) ++ b.getTypesWithoutNull.getTypes.asScala).asJava).makeNullable
      val expectedReverted = Schema.createUnion((b.getTypesWithoutNull.getTypes.asScala ++ Seq(a)).asJava).makeNullable

      a mergeWith b mustBe expected
      b mergeWith a mustBe expectedReverted
    }

    "Array with nonArray and not nullable and     union" in {
      val a = SchemaBuilder.array().items(SchemaBuilder.builder().stringType().makeNullable)
      val b = SchemaBuilder.unionOf().stringType().and().intType().endUnion()
      val expected = Schema.createUnion((Seq(a) ++ b.getTypes.asScala).asJava)
      val expectedReverted = Schema.createUnion((b.getTypes.asScala ++ Seq(a)).asJava)

      a mergeWith b mustBe expected
      b mergeWith a mustBe expectedReverted
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

    "Union of union and non-Union" must {
      "If non-Union is a record and a record of same type is in the list, should merge them" in {
        val unionType = SchemaBuilder.unionOf()
          .stringType().and()
          .intType().and()
          .record("Event_label").fields().endRecord()
          .endUnion()
        val nonUnionType = SchemaBuilder.record("Event_label").fields()
          .name("filters").`type`(Schema.create(Schema.Type.STRING).makeNullable).withDefault(null)
          .name("type").`type`(Schema.create(Schema.Type.STRING).makeNullable).withDefault(null)
          .endRecord()
        AvroSchema.unionOfUnionAndNonUnion(unionType, nonUnionType) mustBe SchemaBuilder.unionOf()
          .stringType().and()
          .intType().and()
          .`type`(nonUnionType)
          .endUnion()
      }
    }

    "Create record" must {
      "If thre is an empty key, ignore it" in {
        val json = Json.parse(
          """
            |{
            |  "": "",
            |  "event": "savings_account_tab_clicked",
            |  "screenName": "/bank/savings-account"
            |}
            |""".stripMargin)
        AvroSchema.createRecord(json.as[JsObject], "Payload") mustBe SchemaBuilder.record("Payload")
          .fields()
          .name("event").`type`(Schema.create(Schema.Type.STRING).makeNullable).withDefault(null)
          .name("screenName").`type`(Schema.create(Schema.Type.STRING).makeNullable).withDefault(null)
          .endRecord()
      }
    }
  }
}
