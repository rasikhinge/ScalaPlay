package controllers

import javax.inject.Inject
import org.joda.time.DateTime
import play.api.mvc.{AbstractController, ControllerComponents}

class MyController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def getTime() = Action {

    val tm = DateTime.now()

    Ok(views.html.time(tm.toString))
  }
}
