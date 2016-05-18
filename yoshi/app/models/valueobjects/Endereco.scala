package models.valueobjects

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Json, Reads, Writes}

/**
  * Created by USER on 03/05/2016.
  */

//objeto de valor Endereco. Sua maior característica é ser
case class Endereco(initialRua: String, initialNumero: Int, initialCidade: String){

  private var _rua = initialRua
  def getRua = _rua
  def setRua(rua: String) = _rua = rua

  private var _numero = initialNumero
  def getNumero = _numero
  def setNumero(numero: Int) = _numero = numero

  private var _cidade = initialCidade
  def getCidade = _cidade
  def setCidade(cidade: String) = _cidade = cidade

}

object Endereco {

  implicit val jsonReads: Reads[Endereco] = (
      (JsPath \ "rua").read[String] and
      (JsPath \ "numero").read[Int] and
      (JsPath \ "cidade").read[String]
    )(Endereco.apply _)

  implicit val jsonWrites = new Writes[Endereco] {

    def writes(endereco: Endereco) = Json.obj(
      "rua" -> endereco.getRua,
      "numero" -> endereco.getNumero,
      "cidade" -> endereco.getCidade
    )
  }
}
