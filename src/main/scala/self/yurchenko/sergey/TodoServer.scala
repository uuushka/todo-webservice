package self.yurchenko.sergey

import cats.effect.{ContextShift, ExitCode, IO, Timer}
import org.http4s.server.blaze.BlazeServerBuilder
import self.yurchenko.sergey.service.{TodoRoutes, TodoServiceImpl}

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

/**
 *
 */
object TodoServer {
  /**
   * Create web server with configs
   *
   * @return
   */
  def create(): IO[ExitCode] = {

    implicit val cs: ContextShift[IO] = IO.contextShift(global)
    implicit val timer: Timer[IO] = IO.timer(global)

    implicit val service = new TodoServiceImpl

    val ioEC = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

    BlazeServerBuilder[IO](ioEC)
      .bindHttp(8070, "localhost")
      .withHttpApp(new TodoRoutes().routes)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
  }

}
