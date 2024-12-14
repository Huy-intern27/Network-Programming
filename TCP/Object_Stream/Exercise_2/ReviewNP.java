import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import TCP.Student;

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2209;
        String message = "B21DCCN239;biAtJHwG";
        
        Socket socket = new Socket(IP, port);
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        out.writeObject(message);
        out.flush();
        System.out.println("Send Success");
        
        Student student = (Student) in.readObject();
        System.out.println("Receive Success");
        
        float gpa = student.getGpa();
        if(gpa>= 0 && gpa < 1.0){
            student.setGpaLetter("F");
        }
        else if(gpa >= 1.0 && gpa < 2.0){
            student.setGpaLetter("D");
        }
        else if(gpa >= 2.0 && gpa < 3.0){
            student.setGpaLetter("C");
        }
        else if(gpa >= 3.0 && gpa < 3.7){
            student.setGpaLetter("B");
        }
        else{
            student.setGpaLetter("A");
        }
        out.writeObject(student);
        out.flush();
        socket.close();
        System.out.println("Complete");
    }
    
}
