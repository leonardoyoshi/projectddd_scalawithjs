package models

import play.api.libs.json.{Json, Writes, JsPath, Reads}
import play.api.libs.functional.syntax._

case class Product(id: Option[Long], name: String, price: Int, category: String)

//case class ProductForm(name: String, price: Int, category: String)

object Product{

  implicit val jsonReads: Reads[Product] = (
      (JsPath \ "id").readNullable[Long] and
      (JsPath \ "name").read[String] and
      (JsPath \ "price").read[Int] and
      (JsPath \ "category").read[String]
    )(Product.apply _)

  implicit val jsonWrites = new Writes[Product] {

    def writes(product: Product) = Json.obj(
      "id" -> product.id,
      "name" -> product.name,
      "price" -> product.price,
      "category" -> product.category
    )
  }
}