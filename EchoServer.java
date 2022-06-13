import java.io.*;

import java.net.*;

public class EchoServer{

    //private feilds
    private ServerSocket simpleEchoServer; // y null?
    private Socket clientSocket; // ditto

    private DataInputStream clientInput;
    private DataOutputStream serverOutput;

    private int port; // Server port

    private String reply;

    //constructors
    public EchoServer(){

        setPort(1738);
        createSimpleEchoServer();
    }

    public EchoServer(int desiredPort){

        setPort(desiredPort);
        createSimpleEchoServer();
    }

    //getters(accessors)
    public String getReply(){

        return(this.reply);
    }

    public int getPort(){

        return(this.port);
    }

    //setters(mutators)
    public void setReply(String reply){

        this.reply = reply;
    }

    public void setPort(int port){

        this.port = port;
    }

    //instance methods
    public void createSimpleEchoServer(){

        try{

            this.simpleEchoServer = new ServerSocket(getPort());
            this.clientSocket = this.simpleEchoServer.accept();

            clientInput = new DataInputStream(this.clientSocket.getInputStream());
            serverOutput = new DataOutputStream(this.clientSocket.getOutputStream());

            while(true){

                setReply(clientInput.readUTF());

                serverOutput.writeUTF(this.reply);
            }

            //clientInput.close();
            //serverOutput.close();
            //simpleEchoServer.close();

        }

        catch(IOException e){

            System.out.print(""/*"Error: " + e + "\n"*/);
        }
    }

}