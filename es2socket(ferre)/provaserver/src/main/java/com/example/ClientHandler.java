package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;

    public ClientHandler(Socket s) {
        this.s = s;
        try {
            pr = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public void run() {
        try {
            int count = 0;
            System.out.println(br.readLine());
            pr.println("Ciao come ti chimai?"); 
            String nome = br.readLine(); 
            nome.toUpperCase();
            System.out.println("Utente " + nome);
            count++;
            pr.println("Benvenuto " + nome + " sei l'utente numero " + count); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
