import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class TcpServer {
	public static void main(String[] argv) throws Exception  {
		ServerSocket socket = new ServerSocket(6789);
		while (true) {
			System.out.printf("Listening at port %d\n", 6789);
			Socket connection = socket.accept();
			BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream())); 
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			String message = in.readLine();
			System.out.printf("Received message: %s\n", message);
			message = message.toUpperCase()+'\n';
			out.writeBytes(message);
			System.out.printf("Sent message: %s", message);
		}
	}
}