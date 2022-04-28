package cjava;

import java.io.*;
import java.net.*;
  
class client {
  
    public static void main(String args[])
        throws Exception
    {
  
        // Create client socket
        Socket s = new Socket("localhost", 888);
  
        // to send data to the server
        DataOutputStream dos
            = new DataOutputStream(
                s.getOutputStream());
  
        // to read data coming from the server
        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // to read data from the keyboard
        BufferedReader kb
            = new BufferedReader(
                new InputStreamReader(System.in));
        String str, str1;
  
        // repeat as long as exit
        // is not typed at client
        while (!(str = kb.readLine()).equals("exit")) {
  
            // send to the server
            dos.writeBytes(str + "\n");
  
            // receive from the server
            str1 = br.readLine();
  
            System.out.println(str1);
        }
  
        // close connection.
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}