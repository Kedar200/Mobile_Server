
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.JSONObject;

public class Server {
    public int port = 1983;
    public ServerSocket serverSocket;

    Server(int port) {
        this.port = port;
    }

    public void start_server() throws Exception {

        serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new connection(clientSocket)).start();
        }
    }
}

class connection implements Runnable {
    Socket clientSocket;

    connection(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        creaelog c = new creaelog();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String incomingdata;

            while (true) {
                incomingdata = in.readLine();
                if (incomingdata == null) {
                    break;
                }
                JSONObject obj = new JSONObject(incomingdata);

                functions.Action(obj, out);
            }
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            c.createlog(e.toString());
            e.printStackTrace();
        }
    }
}