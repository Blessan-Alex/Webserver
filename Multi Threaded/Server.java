import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.net.Socket;

public class Server {

    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try {
                
            } catch (IOException ex) {
                // TODO: handle exception
            }
        }
    }




    public static void main(String[] args) {
        int port = 8010;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port:"+port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread();
                
            }

        }
    }
    
}
