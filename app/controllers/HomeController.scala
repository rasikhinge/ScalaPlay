package controllers

import javax.inject._
import model.Person
import org.apache.log4j.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  val logger = Logger.getLogger(this.getClass.getName)

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def hello() = Action {
    Ok(views.html.hello())
  }

  def helloName(name: String) = Action {
    Ok(views.html.helloName(name))
  }

  def helloCity(city: String) = Action {
    Ok(views.html.pathVariable(city))
  }

  val personForm: Form[Person] = Form {
    mapping(
      "name" -> text,
      "age" -> number
    )(Person.apply)(Person.unapply)
  }

  def addPerson() = Action { implicit request =>
    val person = personForm.bindFromRequest().get
    logger.info("person = " + person)
    Redirect(routes.HomeController.helloCity(person.name))
  }

  def getPerson(name: String) = Action {
    Ok(views.html.pathVariable(name))
  }
}
