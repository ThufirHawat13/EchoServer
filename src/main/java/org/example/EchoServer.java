package org.example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class EchoServer
{
    public static void main( String[] args )
    {
//        Socket socket = null;
//        try(ServerSocket serverSocket = new ServerSocket(8189)) {
//            System.out.println("Server started... Wait for connection...");
//            socket = serverSocket.accept();
//            System.out.println("Client connected");
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            while (true) {
//                String serverMsg = reader.readLine();
//                String clientMsg = in.readUTF();
//                if (clientMsg.equals("/end")) {
//                    break;
//                }
//                out.writeUTF("Client: " + clientMsg);
//                System.out.println("Client: " + clientMsg);
//
//                if (!(serverMsg == null)) {
//                    out.writeUTF("Server: " + serverMsg);
//                }
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ServerThread serverThread = new ServerThread();

    }
}
