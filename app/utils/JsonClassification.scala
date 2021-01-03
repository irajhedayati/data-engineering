package utils

import play.api.libs.json._

object JsonClassification {

  /**
    * Groups the elements of an array using the set of keys in each record.
    *
    * @param array      input array
    * @param fieldName  the key to use for classification
    * @return a map from the set of keys to array of records
    */
  def groupByKeys(array: JsArray, fieldName: String): Map[Set[String], JsArray] = {
    array.value
      .map(_ \ fieldName) // extract payload
      .map(_.as[JsObject]) // cast to JSON object
      .groupBy(getJsonKeysToCompare)
      .map { case (keys, records) => keys -> JsArray(records) }
  }

  def dscIndex(l: Set[String], r: Set[String]): Double = {
    if (l.isEmpty || r.isEmpty) return 0
    val i: Double = l.intersect(r).size
    ((2 * i) / (l.size + r.size)).rounded(2)
  }

  implicit class ExtendedDouble(n: Double) {
    def rounded(x: Int): Double = {
      val w = scala.math.pow(10, x)
      (n * w).round / w.toDouble
    }
  }

  def jsonSimilarityByKey(l: JsObject, r: JsObject): Double = {
    dscIndex(getJsonKeysToCompare(l), getJsonKeysToCompare(r))
  }

  def getJsonKeysToCompare(jsObject: JsObject): Set[String] =
    jsObject.fields
      .map {
        case (k, _: JsString)                                                                           => s"string_$k"
        case (k, v: JsNumber) if ca.dataedu.savro.AvroSchema.FloatingPointPattern.matches(v.toString()) => s"float_$k"
        case (k, v: JsNumber) if v.value.isValidInt                                                     => s"int_$k"
        case (k, _: JsNumber)                                                                           => s"long_$k"
        case (k, _: JsBoolean)                                                                          => s"boolean_$k"
        case (k, _: JsObject)                                                                           => s"record_$k"
        case (k, _: JsArray)                                                                            => s"array_$k"
        case (k, _)                                                                                     => s"null_$k"
      }
      .sorted
      .toSet

}
