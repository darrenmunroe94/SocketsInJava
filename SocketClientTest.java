import java.io.*;

import java.net.*;

import java.util.Scanner;

public class SocketClientTest{

    final static String TESTRESULTS = new String("Passed");

    public static void main(String[] args) throws Exception{

        //InetAddress ip = InetAddress.getLocalHost();
        InetAddress ip = InetAddress.getByName("168.28.58.173");
        theClientCreation(ip);

        System.out.printf("\nSokets Client test: %s\n", TESTRESULTS);
    }

    private static void theClientCreation(InetAddress address){

        System.out.printf("Client started.\n");

        try{

            //open the socket            String address   port#
            Socket theClient = new Socket(address, 1738);

            //use DataInputStream to receive data from server
            DataInputStream serverInput = new DataInputStream(theClient.getInputStream());

            //use DataOutputStream to send data to the server
            DataOutputStream sendData = new DataOutputStream(theClient.getOutputStream());

            //send Data
            sendData.writeUTF("A message from the client to the server.");
            //get Data
            System.out.print("From Server: " + serverInput.readUTF() + "\n");
        
            //close everything
            sendData.close();
            serverInput.close();
            theClient.close();
        }

        catch(IOException e){

            System.out.printf("\n" + e + "\n");
        }

    }

}