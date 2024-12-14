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
import TCP.Product;


public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2209;
        String message = "B21DCCN440;TTVxdyuj";
        
        Socket socket = new Socket(IP, port);
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        out.writeObject(message);
        out.flush();
        System.out.println("Send success");
        
        Product product = (Product) in.readObject();
        System.out.println("Receive Success");
        
        String price = product.getPrice() + "";
        int newDiscount = 0;
        for(char c:price.toCharArray()){
            if(c != '.'){
                newDiscount += (c - '0');
            }
            else break;
        }
        product.setDiscount(newDiscount);
        
        out.writeObject(product);
        out.flush();
        socket.close();
        System.out.println("Complete");
    } 
}
