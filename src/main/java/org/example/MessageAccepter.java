package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageAccepter implements Runnable {

  private DataInputStream in;
  private DataOutputStream out;


  public MessageAccepter(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
    System.out.println("Message accepter is created...");
  }

  public void acceptMessage() throws IOException {

    while (true) {
      String clientMsg = in.readUTF();
      if (clientMsg.equals("/end")) {
        break;
      }
      if (clientMsg != null) {
        out.writeUTF("Client: " + clientMsg + "\n");
        System.out.println("Client: " + clientMsg);
      }
    }
  }


  @Override
  public void run() {
    System.out.println("Message accepter is started...");
    try {
      acceptMessage();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
