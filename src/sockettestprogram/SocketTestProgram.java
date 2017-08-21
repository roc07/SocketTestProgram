package sockettestprogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTestProgram {

  public static void main(String[] args) throws Exception {   
    String ip = "localhost";
    int port = 9999;
    Socket s = new Socket(ip, port);
    String str = "Item ready";
    OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
    PrintWriter out = new PrintWriter(os);
    out.write(str);
    os.flush();
    
    
    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    String nickName = br.readLine();
    
    System.out.println("C: " + nickName);
    
    
    os.close();
  }
  
}
