import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2206;
        String message = "B21DCCN239;H0v8LqTl";
        
        Socket socket = new Socket(IP, port);
        
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(message.getBytes());
        out.flush();
        System.out.println("Send Success");
        
        byte[] receiveData = new byte[1024];
        int leng = in.read(receiveData);
        String responseServer = new String(receiveData, 0, leng);
        System.out.println("Receive Success");
        
        int sum = 0;
        String[] tmp = responseServer.trim().split("\\|");
        for(String x:tmp){
            sum += Integer.parseInt(x);
        }
        out.write(Integer.toString(sum).getBytes());
        out.flush();
        socket.close();
        
        System.out.println("Complete");
    }
    
}
