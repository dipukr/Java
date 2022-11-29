import java.io.*;
import java.net.*;

public class UdpServer {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData  = new byte[1024];
		while (true) { 
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());	
			InetAddress ipaddr = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipaddr, port);
			serverSocket.send(sendPacket); 
		}
	}
}