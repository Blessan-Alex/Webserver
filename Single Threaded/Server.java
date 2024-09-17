import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public void run() throws IOException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true) {
            try{
                System.out.println("Server is listening on port "+port);
                Socket acceptedConnection = socket.accept(); //Code stops here till connection is establish, till timeout
                System.out.println("Connection accepted from client "+acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream()); //Outputs to Client, the text send by us as bytes
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream())); //Inputs from Client bytes, combines and forms results
                toClient.println("Hello from the server");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();


            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String [] args){
        Server server = new Server();
        try {
            server.run();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}