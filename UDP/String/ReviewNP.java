import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;


public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        String IP = "203.162.10.109";
        int port = 2208;
        String studentCode = "B21DCCN440";
        String qCode = "2y35YQB1";
        String message = ";" + studentCode + ";" + qCode;
        
        DatagramSocket socket = new DatagramSocket();
        
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(IP), port);
        socket.send(sendPacket);
        System.out.println("Send Success");
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivPacket = new DatagramPacket(receiveData, 0, receiveData.length);
        socket.receive(receivPacket);
        System.out.println("Receive Success");
        
        String responseServer = new String(receivPacket.getData(), 0, receivPacket.getLength());
        String[] tmp = responseServer.split(";");
        String requestId = tmp[0];
        String data = tmp[1];
        System.out.println(requestId +" "+ data);
        
        String ans = "";
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        for(char c: data.toCharArray()){
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c) + 1);
            }
            else{
                mp.put(c, 1);
            }
        }
        for(Character c:mp.keySet()){
            ans += mp.get(c);
            ans += c;
        }
        ans = requestId + ";" + ans;
        System.out.println(ans);
        
        byte[] sendAns = ans.getBytes();
        DatagramPacket packetAns = new DatagramPacket(sendAns, sendAns.length, InetAddress.getByName(IP), port);
        socket.send(packetAns);
        socket.close();
        
        System.out.println("Complete");
    }
    
}
