package com.example;

import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    private int id = 0;
    private LocalDate date;
    private LocalTime time;

    public ClientHandler(Socket s, int cli) {
        this.s = s;
        id = cli;
        try {
            pr = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    String opt;

    public void run() {
        try {
            System.out.println(br.readLine());
            pr.println("Ciao come ti chimai?"); 
            String nome = br.readLine(); 
            System.out.println("Utente " + nome);
            id++;
            String nomeUp = nome.toUpperCase();
            pr.println("Benvenuto " + nomeUp + " sei l'utente numero " + id); 
            pr.println("Inserisci uno dei segenti comandi 'data - ora - nome - id - fine'");

            boolean inizofine = true;
            while(inizofine){
                opt = br.readLine();
                switch (opt) {
                    case ("data"):{
                            date = LocalDate.now();
                            pr.println("data: " + date);
                        }break;
                    case ("ora"):{
                            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
                            pr.println("ora "+ time.format(LocalTime.now()));
                        }break;
                    case ("nome"):{
                            pr.println("nome: " + nome);
                        }break;
                    case ("id"):{
                            pr.println("id: " + id);
                        }break;
                    case ("fine"):{
                        pr.print("fine");
                            inizofine = false;
                        }break;
                    default:
                            pr.println("comando non valido");
                }
            }
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
