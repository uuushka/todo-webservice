package self.yurchenko.sergey

import cats.effect.{ExitCode, IO, IOApp}

/**
 * Point of entry to app
 */
object MainApp extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = TodoServer.create()
}
