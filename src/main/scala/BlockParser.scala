import java.util.UUID
import io.circe._
import io.circe.syntax._

object BlockParser extends App {
  // example json minipulation
  def jsonMinip(): Unit = {
    // basic json object
    val jsonObj = Json.obj(
      "foo" -> "bar".asJson
    )

    // object with nested values
    val complexObj = Json.obj("nested" -> jsonObj)

    // transformed object
    val transObj = complexObj.hcursor.downField("nested")
      .downField("foo")
      .withFocus(_.mapString(_.reverse))
      .top
      .map(_.spaces2)

    println(transObj)
  }

  def encoding(): Unit = {

    // article
    case class Article(id: UUID, title: String, content: String, author: String)

    // test article
    val article = Article(
      UUID.randomUUID(),
      title = "The Zipper",
      content =
        "there's some content in here somewhere but to be honest to lazy to give a fuck right now",
      author = "Huet"
    )

    // encoder
    implicit val articleEncoder: Encoder[Article] = article => Json.obj(
      "id" -> article.id.asJson,
      "title" -> article.title.asJson,
      "content" -> article.content.asJson,
      "author" -> article.author.asJson
    )

    /*
     * you get
     * Encoder[List[Article]]
     * Encoder[Option[Article]]
     * etc. for free because these are just impl. by circe
     */

    // create a list of articles
    val list = List.fill(5)(article)
    println(list.asJson.spaces2)
  }

  // jsonMinip()
  encoding()
}
