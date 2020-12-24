package self.yurchenko.sergey.model

import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}

case class Todo(
                 id: Option[Int],
                 content: String = "",
                 status: String = "", // enum
                 importance: String = "" // enum
               )

object Todo {
  implicit val encoderTodo: Encoder[Todo] = new Encoder[Todo] {
    override def apply(todo: Todo): Json = Json.obj(
      ("id", Json.fromInt(todo.id.getOrElse(-1))),
      ("content", Json.fromString(todo.content)),
      ("status", Json.fromString(todo.status)),
      ("importance", Json.fromString(todo.importance))
    )
  }

  implicit val decoderTodo: Decoder[Todo] = new Decoder[Todo] {
    override def apply(todo: HCursor): Result[Todo] =
      for {
        id <- todo.downField("id").as[Int]
        content <- todo.downField("content").as[String]
        status <- todo.downField("status").as[String]
        importance <- todo.downField("importance").as[String]
      } yield Todo(Option(id), content, status, importance)
  }
}