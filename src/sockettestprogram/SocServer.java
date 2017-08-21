package sockettestprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
  public static void main(String[] args) throws Exception {
    
    System.out.println("S: Server has started");
    
    ServerSocket ss = new ServerSocket(9999);
    System.out.println("S: Server is waiting for client requst");
    
    Socket s = ss.accept();
    System.out.println("S: Client connected");
    
    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    String str = br.readLine();
    
    System.out.println("S: Client data: " + str);
    
    String nickName = str.substring(0, 3);
    
    OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
    PrintWriter out = new PrintWriter(os);
    out.write(nickName);
    out.flush();
    System.out.println("S: Data sent from server to client");
  }
}
