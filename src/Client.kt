import java.io.DataInputStream
import java.io.OutputStream
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.Charset
import java.time.Duration
import java.time.Instant
import java.util.*

class Client(socket: Socket) {
    private val client: Socket = socket
    private val reader: Scanner = Scanner(client.getInputStream())
    private val writer: OutputStream = client.getOutputStream()
    private var t_client: Instant = Instant.now()

    fun sync_time() {
        val t0 = Instant.now()
        writer.write(("request" + '\n').toByteArray(Charset.defaultCharset()))
        val t_string = reader.nextLine()
        val t_server = Instant.parse(t_string)
        val t1 = Instant.now()
        val res = Duration.between(t1, t0).dividedBy(2)
        t_client = t_server.plus(res)
        System.out.println(t_client.toString())
    }

    private fun write(message: String) {
        writer.write((message + '\n').toByteArray(Charset.defaultCharset()))
    }
}