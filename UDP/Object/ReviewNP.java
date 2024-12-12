// import UDP.Student;
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
        String studentCode = "B21DCCN440";
        String qCode = "SVWf6CPD";
        String message = ";" + studentCode + ";" + qCode;
        
        DatagramSocket socket = new DatagramSocket();
        
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(IP), port);
        socket.send(sendPacket);
        System.out.println("Send Success");
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, 0, receiveData.length);
        socket.receive(receivePacket);
        System.out.println("Recieve Success");
        
        byte[] requestIdbytes = new byte[8];
        System.arraycopy(receivePacket.getData(), 0, requestIdbytes, 0, 8);
        String requestId = new String(requestIdbytes).trim();
        
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData(), 8, receivePacket.getLength() - 8);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Student student = (Student) objectInputStream.readObject();
        
        String name = student.getName();
        String email = student.getId();
        String newName = "";
        String[] tmp = name.trim().split("\\s+");
        for(String subName:tmp){
            subName = subName.toLowerCase();
            newName += Character.toUpperCase(subName.charAt(0));
            newName += subName.substring(1, subName.length());
            newName += " ";
        }
        newName = newName.trim();
        student.setName(newName);
        
        String[] tmp2 = newName.split("\\s+");
        String newMail = tmp2[tmp2.length - 1];
        for(int i = 0; i< tmp2.length - 1; i++){
            newMail += tmp2[i].charAt(0);
        }
        newMail += "@ptit.edu.vn";
        student.setEmail(newMail.toLowerCase());
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(requestId.getBytes());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student);
        
        byte[] updatedData = byteArrayOutputStream.toByteArray();
        DatagramPacket updatedPacket = new DatagramPacket(updatedData, updatedData.length, InetAddress.getByName(IP), port);
        socket.send(updatedPacket);
        socket.close();
        
        System.out.println("Complete");
    }
    
}
