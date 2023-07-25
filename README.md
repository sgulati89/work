# work
import akka.actor.ActorSystem
import akka.http.scaladsl.{Http, HttpsConnectionContext}
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._

object RestApiExample {

  // Assuming the server's certificate is trusted by the JVM's default trust store
  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.dispatcher

  // Replace these with your actual values
  val apiEndpoint = "https://your-api-endpoint.com"
  val apiKey = "your-api-key"

  def main(args: Array[String]): Unit = {
    val requestBody = """{"key": "value"}""" // Your JSON payload as a string

    val postRequest = HttpRequest(
      method = HttpMethods.POST,
      uri = apiEndpoint,
      entity = HttpEntity(ContentTypes.`application/json`, requestBody)
    ).addHeader(Authorization(OAuth2BearerToken(apiKey)))

    val responseFuture = Http().singleRequest(postRequest, connectionContext = HttpsConnectionContext())

    val response = Await.result(responseFuture, 10.seconds)
    val responseBody = Unmarshal(response.entity).to[String]
    println(s"Status: ${response.status}")
    println(s"Response: ${Await.result(responseBody, 10.seconds)}")
    system.terminate()
  }
}





### another example

import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.util.ByteString
import akka.stream.ActorMaterializer
import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._

object RestApiExample {

  // Assuming the server's certificate is trusted by the JVM's default trust store
  implicit val system: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.executionContext

  // Replace these with your actual values
  val apiEndpoint = "https://your-api-endpoint.com"
  val username = "your-username"
  val password = "your-password"

  def main(args: Array[String]): Unit = {
    val requestBody = """{"key": "value"}""" // Your JSON payload as a string

    val authHeader = headers.Authorization(BasicHttpCredentials(username, password))

    val postRequest = HttpRequest(
      method = HttpMethods.POST,
      uri = apiEndpoint,
      entity = HttpEntity(ContentTypes.`application/json`, ByteString(requestBody))
    ).addHeader(authHeader)

    val responseFuture = Http().singleRequest(postRequest)

    val response = Await.result(responseFuture, 10.seconds)
    val responseBody = Unmarshal(response.entity).to[String]
    println(s"Status: ${response.status}")
    println(s"Response: ${Await.result(responseBody, 10.seconds)}")
    system.terminate()
  }
}
