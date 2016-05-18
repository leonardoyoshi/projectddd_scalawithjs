import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Users Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/user/1")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "send 201 on a post request" in  {
      val body = "{\"name\":\"Teste\",\"cpfcnpj\":\"12345678910\",\"age\":22,\"endereco\":{\"rua\":\"das Ilusões\",\"numero\":1400,\"cidade\":\"sp\"}}"
      route(app,
        FakeRequest(POST, "/user")
          .withTextBody(body).withHeaders("Content-Type" -> "application/json")
      ).map(status(_)) mustBe Some(CREATED)
    }

    "send 200 on a good request" in  {
      val body = "{\"name\":\"Teste\",\"cpfcnpj\":\"12345678910\",\"age\":22,\"endereco\":{\"rua\":\"das Ilusões\",\"numero\":1400,\"cidade\":\"sp\"}}"
      route(app,
        FakeRequest(POST, "/user")
          .withTextBody(body).withHeaders("Content-Type" -> "application/json")
      ).map(status(_)) mustBe Some(CREATED)

      route(app, FakeRequest(GET, "/user/1")).map(status(_)) mustBe Some(OK)
    }
  }

  "Products Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/product/1")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "send 201 on a post request" in {
      val body = "{\"name\":\"Lamen\",\"price\":3,\"category\":\"food\"}"
      route(app,
        FakeRequest(POST, "/product")
          .withTextBody(body).withHeaders("Content-Type" -> "application/json")
      ).map(status(_)) mustBe Some(CREATED)
    }

    "send 200 on a good request" in  {
      val body = "{\"name\":\"Lamen\",\"price\":3,\"category\":\"food\"}"
      route(app,
        FakeRequest(POST, "/product")
          .withTextBody(body).withHeaders("Content-Type" -> "application/json")
      ).map(status(_)) mustBe Some(CREATED)

      route(app, FakeRequest(GET, "/product/1")).map(status(_)) mustBe Some(OK)
    }
  }
}
