package models

import models.User
import models.valueobjects.Endereco
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserTableDef(tag: Tag) extends Table[User](tag, "UserTableDef") {

  def id = column[Long]("id_user", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def cpfcnpj = column[String]("Cpfcnpj")
  def age = column[Int]("age")
  def endereco = column[String]("adress")

  //def * =
    //(name, cpfcnpj, age, endereco) <>((User.apply _).tupled, User.unapply)
  override def * =
    (name, cpfcnpj, age, endereco) <>((User.apply _).tupled, User.unapply)
}

object Users {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  val users = TableQuery[UserTableDef]

  def add(user: User): Future[String] = {
    dbConfig.db.run(users += user).map(res => "Usuário adicionado com sucesso!").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Long): Future[Int] = {
    dbConfig.db.run(users.filter(_.id === id).delete)
  }

  def get(id: Long): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[User]] = {
    dbConfig.db.run(users.result)
  }
}
