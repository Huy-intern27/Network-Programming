import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2208;
        String studentCode = "B21DCCN440";
        String qCode = "Bg9AgyIu";
        String message = studentCode + ";" + qCode;
        
        Socket socket = new Socket(IP, port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write(message);
        writer.newLine();
        writer.flush();
        
        String responseServer = reader.readLine();
        String normal = "", special = "";
        for(char c:responseServer.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                normal += c;
            }
            else{
                special += c;
            }
        }
        writer.write(normal);
        writer.newLine();
        writer.flush();
        
        writer.write(special);
        writer.newLine();
        writer.flush();
        
        socket.close();
    }
    
}
