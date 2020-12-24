package self.yurchenko.sergey.service

import cats.effect._
import org.http4s._
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder
import org.http4s.dsl.io._
import org.http4s.implicits._

class TodoRoutes(implicit service: TodoService) {

  val routes = HttpRoutes.of[IO] {
    case GET -> Root / "service" / "todos" => {
      val result = service.getAllTodos
      result match {
        case Left(ex) => NotFound(ex.getMessage)
        case Right(value) => Ok(value)
      }
    }


    case GET -> Root / "service" / "todos" / id =>
      Ok(s"get todo by id=[$id]")

    case req@POST -> Root / "service" / "todos" =>
      Ok(s"create todo with req =[${req.body}]")

    case req@PUT -> Root / "service" / "todos" =>
      Ok(s"update todos")

    case DELETE -> Root / "service" / "todos" / id =>
      Ok(s"delete todos $id")
  }.orNotFound


}