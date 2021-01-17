import java.net.ServerSocket
import java.net.Socket

fun main() {
    val clientSocket = Socket("localhost",5050)
    val client = Client(clientSocket)
    client.sync_time()
}