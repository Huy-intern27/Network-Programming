
import java.io.BufferedReader;import java.io.BufferedWriter;
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

public class ReviewNP {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String IP = "203.162.10.109";
        int port = 2207;
        String message = "B21DCCN440;MZVIjDhK";
        
        Socket socket = new Socket(IP, port);
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(message);
        out.flush();
        
        int n = in.readInt();
        List<Integer> arr = new ArrayList<>();
        for(int i =1; i<= n; i++){
            arr.add(in.readInt());
        }
        int[] cnt = new int[7];
        for(int x:arr){
            cnt[x] = 0;
        }
        for(int x:arr){
            cnt[x]++;
        }
        List<Float> ans = new ArrayList<>();
        for(int i = 1; i<= 6; i++){
            float tmp = (float) cnt[i] / n;
            ans.add(tmp);
        }
        for(float x:ans){
            out.writeFloat(x);
            out.flush();
        }
        socket.close();
    }
}
