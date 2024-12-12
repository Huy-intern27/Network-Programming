import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        String ip = "203.162.10.109";
        int port = 2207;
        String studentCode = "B21DCCN440";
        String qCode = "qa8wCBma";
        String message = ";" + studentCode + ";" + qCode;
        
        DatagramSocket socket = new DatagramSocket();
        
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(ip), port);
        socket.send(sendPacket);
        System.out.println("Send success");
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        System.out.println("Receive success");
        
        String responeServer = new String(receivePacket.getData(), 0, receivePacket.getLength());
        
        String[] tmp = responeServer.split(";");
        String requestID = tmp[0];
        String number = tmp[1];
        int sum = 0;
        for(char c : number.toCharArray()){
            sum += (c - '0');
        }
        
        String resultMessage = requestID + ";" + sum;
        byte[] sendData1 = resultMessage.getBytes();
        DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, InetAddress.getByName(ip), port);
        socket.send(sendPacket1);
        socket.close();
        System.out.println("Complete");
    }
    
}