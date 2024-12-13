import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2207;
        String studentCode = "B21DCCN239";
        String qCode = "RAOrtn0b";
        String message = ";" + studentCode + ";" + qCode;
        
        DatagramSocket socket = new DatagramSocket();
        
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(IP), port);
        socket.send(sendPacket);
        System.out.println("Send Success");
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, 0, receiveData.length);
        socket.receive(receivePacket);
        System.out.println("Receive Success");
        
        String responeServer = new String(receivePacket.getData(), 0, receivePacket.getLength());
        String[] tmp = responeServer.trim().split(";");
        String requestId = tmp[0].trim();
        int n = Integer.parseInt(tmp[1].trim());
        String[] array = tmp[2].trim().split(",");
        int[] count = new int[101];
        for(String x : array){
            int number = Integer.parseInt(x);
            count[number] = 1;
        }
        
        String ans = requestId + ";";
        for(int i = 1; i<= n; i++){
            if(count[i] != 1){
                ans += i;
                ans += ",";
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        sendData = ans.getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(IP), port);
        socket.send(sendPacket);
        socket.close();
        System.out.println("Complete");
    }
    
}
