package org.example;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {

  private Socket socket;
  private ServerSocket serverSocket;
  private DataInputStream in;
  private DataOutputStream out;

  public ServerThread() {
    try {
      startServer();
    } catch (IOException e) {
      e.printStackTrace();
    }
    new Thread(new MessageSender(in, out)).start();
    new Thread(new MessageAccepter(in, out)).start();
  }

  public void startServer() throws IOException {
    serverSocket = new ServerSocket(8189);
    System.out.println("Server started... Wait connection...");
    socket = serverSocket.accept();
    System.out.println("Client connected...");
    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());
  }
}
