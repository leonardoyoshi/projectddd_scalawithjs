package services

/**
  * Created by USER on 03/05/2016.
  */
object Validator {

  def isValidCPFCNPJ(input: String): Boolean = {
    val pattern = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})".r

    pattern.findFirstIn(input).isDefined
  }
}
