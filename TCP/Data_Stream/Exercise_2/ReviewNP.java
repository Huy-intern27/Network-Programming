import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ReviewNP {

    public static int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    public static int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2207;
        String message = "B21DCCN239;BoNVKCrU";
        
        Socket socket = new Socket(IP, port);
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(message);
        out.flush();
        System.out.println("Send Success");
        
        int a = in.readInt();
        int b = in.readInt();
        System.out.println("Receive Success");
        
        int uc = gcd(a, b);
        int bc = lcm(a, b);
        int sum = a + b;
        int multiple = a * b;
        
        out.writeInt(uc);
        out.flush();
        out.writeInt(bc);
        out.flush();
        out.writeInt(sum);
        out.flush();
        out.writeInt(multiple);
        out.flush();
        
        socket.close();
        System.out.println("Complete");
    }
    
}
