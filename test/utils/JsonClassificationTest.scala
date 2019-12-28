package utils

import org.scalatest.FunSuite

class JsonClassificationTest extends FunSuite {

  test("testDscIndex") {
    val a = Set("array_gdr_prod_cat_name","string_screenName","string_event","array_gdr_prod_name",
      "string_gdr_user_id","array_gdr_prod_cat_id", "array_gdr_prod_id","string_gdr_referrer","int_gdr_total_value",
      "string_gdr_chkout_amount")
    val b = Set("array_gdr_prod_cat_name","string_screenName","array_gdr_prod_name","string_gdr_user_id",
      "array_gdr_prod_cat_id","array_gdr_prod_id","string_gdr_referrer","int_gdr_total_value","string_gdr_chkout_amount")

    assert(JsonClassification.dscIndex(a, Set()) == 0)
    assert(JsonClassification.dscIndex(Set(), a) == 0)
    assert(JsonClassification.dscIndex(a, a) == 1)
    assert(JsonClassification.dscIndex(a, b) == 0.95)
  }

}
