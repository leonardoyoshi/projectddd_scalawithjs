package models

import models.valueobjects.Endereco
import play.api.libs.json.{Json, Writes, JsPath, Reads}
import play.api.libs.functional.syntax._

class User(initialId: Option[Long], initialName: String, initialCpfcnpj: String, initialAge: Int, initialAdress: Endereco){

  private val _id = initialId
  def getId = _id

  private var _name = initialName
  def getName = _name
  def setName(name: String) = _name = name

  private var _cpfcnpj = initialCpfcnpj
  def getCpfcnpj = _cpfcnpj
  def setCpfcnpj(cpfcnpj: String) = _cpfcnpj = cpfcnpj

  private var _age = initialAge
  def getAge = _age
  def setAge(age: Int) = _age = age

  private val _adress = initialAdress
  def getAdress = _adress
}

object User {

  implicit val jsonReads: Reads[User] = (
      (JsPath \ "id").readNullable[Long] and
      (JsPath \ "name").read[String] and
      (JsPath \ "cpfcnpj").read[String] and
      (JsPath \ "age").read[Int] and
        (JsPath \ "endereco").read[Endereco]
    )(User.apply _)

  implicit val jsonWrites = new Writes[User] {

    def writes(user: User) = Json.obj(
      "id" -> user.getId,
      "name" -> user.getName,
      "cpfcnpj" -> user.getCpfcnpj,
      "age" -> user.getAge,
      "endereco" -> user.getAdress
    )
  }

  def apply(initialId: Option[Long], initialName: String, initialCpfcnpj: String, initialAge: Int, initialAdress: Endereco):
  User = new User(initialId, initialName, initialCpfcnpj, initialAge, initialAdress)
}