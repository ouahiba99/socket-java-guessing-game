package cjava;

import java.io.*;
import java.net.*;
import java.util.Random;
  
class server {
  
    public static void main(String args[])
        throws Exception
    {
  
        // Create server Socket
        ServerSocket ss = new ServerSocket(888);
  
        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");
  
        // to send data to the client
        PrintStream ps
            = new PrintStream(s.getOutputStream());
  
        // to read data coming from the client
        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // to read data from the keyboard
        BufferedReader kb
            = new BufferedReader(
                new InputStreamReader(System.in));
  
        // server executes continuously
        while (true) {
        	 
             int rand = (int)(1 + Math.random() * 100);
            String str;
  
            // repeat as long as the client
            // does not send a null string
  
            // read from client
            while ((str = br.readLine()) != null) {
            	int dnum = Integer.parseInt(str);
                   if(dnum == rand)
                   {
                // send to client added rand just to check if the code is right
                ps.println("you right"+ rand);
                }
                else 
                	if (dnum < rand) {
                		ps.println("your number is lower then the right num"+ rand);
                	} else ps.println("your number is higher then the right num"+ rand);
                	}
  
            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();
  
            // terminate application
            System.exit(0);
  
        } // end of while
    }
}