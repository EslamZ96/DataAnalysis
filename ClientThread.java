/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataanalysis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;

/**
 *
 * @author eslam
 */
public class ClientThread extends Thread{
    
    Socket socket;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new
                DataInputStream(socket.getInputStream());
            
            DataOutputStream dos = new 
                DataOutputStream(socket.getOutputStream());
            
            // Read file from client
                String fileContent = dis.readUTF();
                // Convert file content to array of strings
                String[] contentWords = fileContent.split(" ");
                
                DataAnalysis da = new DataAnalysis();
                
                String longestWord = da.longestWord(contentWords);
                String shortestWord = da.shortestWord(contentWords);
                int numOfWords = contentWords.length+1;
                int numOfLetters = da.numOfLetters(contentWords);
                
                // Write analysis' results to client
                dos.writeUTF(longestWord);
                dos.writeUTF(shortestWord);
                dos.writeInt(numOfWords);
                dos.writeInt(numOfLetters);
                
                // hashtable to store each word with its number of repetition
                Hashtable<String, Integer> table = new Hashtable<>();
                table = da.numOfRepetition(contentWords);
                
                // Convert the repetition table to string
                String repenTable = table.toString();
                repenTable = repenTable.replaceAll("[{}]", "");
                
                // Write repetition table to client
                dos.writeUTF(repenTable);
            
        } catch(IOException ex) {
            System.out.println("Server Error" + ex.getMessage());
        }
    }
}
