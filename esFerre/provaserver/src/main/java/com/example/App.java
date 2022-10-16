package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    { 
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
    
                PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                pr.println("Cliente *** sei stato conesso");

                pr.println("Inserisci il tuo peso: ");
                String peso = br.readLine();
        
                pr.println("Inserisci la tua altezza: ");
                String altezza = br.readLine();
        
                double bmi = Double.parseDouble(peso) / ((Double.parseDouble(altezza)) * (Double.parseDouble(altezza)));
                bmi = Math.round( bmi * 100.0) / 100.0;
                pr.println("Il tuo Bmi è " + bmi);
                pr.flush();
        
                s.close();
                ss.close();
            }       
            public class ClientHandler extends Thread{
            
}}