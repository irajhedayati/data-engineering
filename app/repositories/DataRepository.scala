package repositories

import javax.inject.Singleton
import models.Movie
import play.api.libs.json.JsValue

import scala.io.Source

@Singleton
class DataRepository {

  val pageSize: Int = 5

  private val movies: List[Movie] = Source.fromResource("files/movie.csv").getLines()
    .map(movie => {
      val fields: Array[String] = movie.split(",", -1)
      Movie(fields(0).toInt, fields(1), fields(2).toInt, if (fields(3).trim == "") None else Some(fields(3)))
    })
    .toList

  def getMovie(mId: Int): Option[Movie] = movies.collectFirst {
    case m if m.mId == mId => m
  }

  def getMovies(page: Int): List[Movie] = movies.slice((page - 1) * 5, page * 5)

  def countMovies(): Int = movies.size

  def add(json: JsValue): Option[Movie] =
    Some(Movie(109, (json \ "title").get.as[String], (json \ "year").get.as[Int], Option((json \ "director").get.as[String])))

  def update(json: JsValue): Option[Movie] =
    Some(Movie((json \ "mid").get.as[Int], (json \ "title").get.as[String], (json \ "year").get.as[Int], Option((json \ "director").get.as[String])))

}
