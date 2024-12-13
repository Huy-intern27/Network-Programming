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
        String studentCode = "B21DCCN440";
        String qCode = "p7IOWK4o";
        String message = studentCode + ";" + qCode;
        
        Socket socket = new Socket(IP, port);
        
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        os.write(message.getBytes());
        os.flush();
        System.out.println("Send Success");
        
        byte[] receiveData = new byte[1024];
        int leng = is.read(receiveData);
        String responseServer = new String(receiveData, 0, leng);
        System.out.println("Receive Success");
        
        String[] numbersStr = responseServer.trim().split(",");
        int maxValue = Integer.MIN_VALUE;
        for(String x:numbersStr){
            int number = Integer.parseInt(x);
            if(maxValue < number){
                maxValue = number;
            }
        }
        int ans = Integer.MIN_VALUE, idx = 0;
        for(int i = 0; i < numbersStr.length; i++){
            int number = Integer.parseInt(numbersStr[i]);
            if(ans < number && number != maxValue){
                ans = number;
                idx = i;
            }
        }
        String result = ans + "," + idx;
        os.write(result.getBytes());
        os.flush();
        socket.close();
        System.out.println("Complete");
    }
    
}
