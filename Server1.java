/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataanalysis;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author eslam
 */
public class Server1 {
    
    public static void main(String[] args) {
        
        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println("Server is Running....");
            
            while (true) {                
                try {
                    Socket socket = server.accept();
                    ClientThread thread = new ClientThread((socket));
                    thread.start();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
