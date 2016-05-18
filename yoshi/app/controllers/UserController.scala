package controllers

import models.User
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{Action, BodyParsers, Controller}
import services.Validator

import scala.collection.immutable.HashMap

class UserController extends Controller {

  var index : Long = 0L
  //Map - [chave, valor]
  var users: Map[Long, User] = new HashMap

  def addUser = Action(BodyParsers.parse.json){ request =>
    //aqui vai parsear um json
    request.body.validate[User].fold(
      //se der algum erro, dá BadRequest
      errors => {
      BadRequest
    },

    user => {
      //aqui faz uma verificação do serviço "Validator" incluso na entidade User

      //se for digitado erradamente
      if(!Validator.isValidCPFCNPJ(user.getCpfcnpj)){

        Logger.error("BadRequest")
        BadRequest("CPF ou CNPJ inválido!!")
      } else {
        //senao
        index += 1
        //option nesse contexto significa opcional.
        val newUser = new User(Option(index), user.getName, user.getCpfcnpj, user.getAge, user.getAdress)

        users += (index -> newUser)
        Logger.info(s"Novo usuario ${Json.toJson(newUser).toString()}")
        Created(Json.toJson(newUser))
      }
     }
    )
  }

  //CRIANDO O GET
  def getUser(id: Long) = Action{
    if(users.isDefinedAt(id)){
      //o primeiro get pega do mapa, enquanto o segundo get é uma Option
      Ok(Json.toJson(users.get(id).get))

    } else{
      NotFound
    }
  }
}
