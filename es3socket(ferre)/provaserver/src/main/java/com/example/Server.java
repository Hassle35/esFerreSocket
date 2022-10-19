package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(3000);
    System.out.println("Server in ascolto sulla porta 3000");
    boolean running = true;
    int cli = 0;
    while (running) {
      Socket s = ss.accept();
      System.out.println("Client connesso");
      ClientHandler client = new ClientHandler(s, cli);
      cli ++;
      client.start();
    }
    ss.close();
  }
}
