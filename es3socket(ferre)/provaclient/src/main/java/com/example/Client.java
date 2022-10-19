package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");
        System.out.println(br.readLine()); 
        pr.println(tastiera.readLine()); 
        System.out.println(br.readLine()); 

        boolean fine = true; 
        String in;
        
        System.out.println(br.readLine()); 
        do{
            pr.println(tastiera.readLine());
            in = br.readLine();
            if(in.equals("fine")) fine = false;
            else System.out.println(in);
        }while(fine); 
        s.close();
    }
}
