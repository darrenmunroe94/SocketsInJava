import java.net.*;
import java.io.*;

public class SocketServerTest{

    final static String TESTRESULTS = new String("Passed");

    public static void main(String[] args) throws Exception{

        theServerCreation();

        System.out.printf("\nSokets Server test: %s\n", TESTRESULTS);

    }

    private static void theServerCreation(){

        System.out.printf("Server started.\n");

        try{

            //open socket to create server            port#
            ServerSocket theServer = new ServerSocket(1738);

            //used to listen for and accept incoming connections
            Socket clientSocket = theServer.accept();

            //use DataInputStream to receive data from client
            DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());

            //DataOutputStream to send data to client
            DataOutputStream sendData = new DataOutputStream(clientSocket.getOutputStream());

            //send Data
            //sendData.writeChars("\n\tConnection Succesful!\n");
            sendData.writeUTF("connected");
            //get Data
            System.out.print("From client: " + clientInput.readUTF() + "\n");

            //close everything
            sendData.close();
            clientInput.close();
            theServer.close();
        }

        catch(IOException e){

            System.out.printf("\n" + e + "\n");
        }

    }

}