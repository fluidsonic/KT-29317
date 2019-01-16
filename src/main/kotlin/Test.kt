import io.ktor.application.ApplicationCall
import io.ktor.request.ApplicationReceiveRequest
import io.ktor.response.respond


interface AuthenticationService {

    suspend fun execute(request: AuthenticationCreationRequest): AuthenticationCreationResult
}

object AuthenticationCreationRequest
object AuthenticationCreationResult


suspend inline fun <reified Type : Any> ApplicationCall.receiveJSON(): Type {
    val type = Type::class
    val incomingContent = request.receiveChannel()
    val receiveRequest = ApplicationReceiveRequest(type, incomingContent)
    val transformed = request.pipeline.execute(this, receiveRequest).value

    @Suppress("UNCHECKED_CAST")
    return transformed as Type
}


suspend fun ApplicationCall.test(authenticationService: AuthenticationService) {
    respond(authenticationService.execute(receiveJSON()))
}
