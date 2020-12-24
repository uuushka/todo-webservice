package self.yurchenko.sergey.service
import self.yurchenko.sergey.dao.TodoDAO
import self.yurchenko.sergey.model.{Todo, TodoId}

class TodoServiceImpl extends TodoService {
  override def getAllTodos: Either[Throwable, List[Todo]] = Right(List(
    Todo(Some(1), "content", "Done", "Low"),
    Todo(Some(2), "content2", "Done2", "Low2"),
  ))

  override def getTodoById(id: TodoId): Either[Throwable, Todo] = ???

  override def createTodo(todo: Todo): Either[Throwable, Todo] = ???

  override def updateTodo(todo: Todo): Either[Throwable, Todo] = ???

  override def deleteTodoById(id: TodoId): Unit = ???
}
