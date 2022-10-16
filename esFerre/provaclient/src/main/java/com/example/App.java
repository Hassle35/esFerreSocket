package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Socket s = new Socket("localhost", 3000);
        
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(br.readLine());

        System.out.print(br.readLine());
        pr.println(tastiera.readLine());
           
        System.out.print(br.readLine());
        pr.println(tastiera.readLine());

        System.out.println(br.readLine());

        s.close();
    }
}
