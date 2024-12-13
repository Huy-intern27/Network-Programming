// import UDP.Customer;
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
        int port = 2209;
        String studentCode = "B21DCCN467";
        String qCode = "FqUyOxva";
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
        
        byte[] requestIdBytes = new byte[8];
        System.arraycopy(receivePacket.getData(), 0, requestIdBytes, 0, 8);
        String requestId = new String(requestIdBytes);
        
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData(), 8, receivePacket.getLength() - 8);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Customer customer = (Customer) objectInputStream.readObject();
        
        String name = customer.getName();
        String newName = "";
        String[] tmp = name.trim().split("\\s+");
        newName += tmp[tmp.length - 1].toUpperCase();
        newName += ", ";
        for(int i = 0; i < tmp.length - 1; i++){
            newName += tmp[i].substring(0, 1).toUpperCase();
            newName += tmp[i].substring(1, tmp[i].length()).toLowerCase();
            newName += " ";
        }
        newName = newName.trim();
        customer.setName(newName);
        
        String dayOfBirth = customer.getDayOfBirth();
        String newDay = "";
        tmp = dayOfBirth.split("-");
        newDay += tmp[1];
        newDay += "/";
        newDay += tmp[0];
        newDay += "/";
        newDay += tmp[2];
        customer.setDayOfBirth(newDay);
        
        tmp = name.trim().split("\\s+");
        String newUserName = "";
        for(int i = 0; i < tmp.length; i++){
            if(i != tmp.length - 1){
                newUserName += tmp[i].substring(0, 1).toLowerCase();
            }
            else{
                newUserName += tmp[i].toLowerCase();
            }
        }
        customer.setUserName(newUserName);
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(requestId.getBytes());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(customer);
        
        sendData = byteArrayOutputStream.toByteArray();
        sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(IP), port);
        socket.send(sendPacket);
        socket.close();
        System.out.println("Complete");
    }
    
}
