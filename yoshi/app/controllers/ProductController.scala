package controllers

import models.{Product}
import play.api.libs.json.Json
import play.api.mvc.{Action, BodyParsers, Controller}

import scala.collection.mutable

class ProductController extends Controller {

  //0L -> L para o compilador entender que é Long
  var index: Long = 0L
  //map: estrutura chave , valor [c,v]
  val products: scala.collection.mutable.Map[Long, Product] = new mutable.HashMap

  def addProduct = Action(BodyParsers.parse.json){ request =>
    request.body.validate[Product].fold(
      errors => {
        BadRequest.withHeaders("Access-Control-Allow-Origin"->"*")
      },
      product => {

          index += 1

          val newProduct = new Product(Option(index), product.name, product.price, product.category)
          products += (index -> newProduct)
          Created(Json.toJson(newProduct)).withHeaders("Access-Control-Allow-Origin"->"*")
      }
    )
  }


  /*def listProduct() = Action{
    Ok(Json.toJson(products.to/Seq))
  } */


  def getProduct(id: Long) = Action{
    if(products.isDefinedAt(id)){
      //o primeiro get pega do mapa, enquanto o segundo get é uma Option
      Ok(Json.toJson(products.get(id).get)).withHeaders("Access-Control-Allow-Origin"->"*")

      /* Para entendermos melhor:
      val productOption = products.get(id)
      //o primeiro get pega do mapa, enquanto o segundo get é uma Option
      Ok(productOption.get)
      * */
    } else{
      NotFound.withHeaders("Access-Control-Allow-Origin"->"*")
    }
  }
}
