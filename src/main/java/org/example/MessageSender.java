package org.example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageSender implements Runnable {

  private DataInputStream in;
  private DataOutputStream out;
  private BufferedReader reader;

  public MessageSender(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
    System.out.println("Message sender is created...");
  }

  public void sendMessage() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String msg = reader.readLine();
      if (!msg.isEmpty()) {
        out.writeUTF("Server: " + msg + "\n");
      }
    }
  }

  @Override
  public void run() {
    System.out.println("Message sender is started...");
    try {
      sendMessage();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
