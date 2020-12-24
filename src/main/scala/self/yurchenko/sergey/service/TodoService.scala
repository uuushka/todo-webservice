package self.yurchenko.sergey.service

import self.yurchenko.sergey.model.{Todo, TodoId}

import scala.concurrent.Future

trait TodoService {

  def getAllTodos: Either[Throwable, List[Todo]]

  def getTodoById(id: TodoId): Either[Throwable, Todo]

  def createTodo(todo: Todo): Either[Throwable, Todo]

  def updateTodo(todo: Todo): Either[Throwable, Todo]

  def deleteTodoById(id: TodoId): Unit
}
