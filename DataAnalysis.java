/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataanalysis;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author eslam
 */
public class DataAnalysis {

    int index;
    // Get the longest word
    public String longestWord(String[] content) {
        index = 0;
        String longest = content[0];
        for (int i = 0; i < content.length-1; i++) {
            if (longest.length() < content[index+1].length()) {
                longest = content[index+1];
            }
            index++;
            // System.out.println(index);
        }
        return longest;
    }
    
    // Get the shortest word
    public String shortestWord(String[] content) {
        index = 0;
        String shortest = content[0];
        for (int i = 0; i < content.length-1; i++) {
            if (shortest.length() > content[index+1].length()) {
                shortest = content[index+1];
            }
            index++;
        }
        return shortest;
    }
    
    // Get number of letters
    public int numOfLetters(String[] content) {
        int num = 0;
        for (String str : content) {
            num += str.length();
        }
        return num;
    }
    
    // Get number of word repetition
    public Hashtable<String, Integer> numOfRepetition (String[] content) {
        
        Map<String, Integer> table = new Hashtable<>();
        for (String str : content) {
            if (table.containsKey(str)) {
                table.put(str, table.get(str) + 1);
            }
            else {
                table.put(str, 1);
            }
        }
        return (Hashtable<String, Integer>) table;
    }
    
    
    public static void main(String[] args) {
        DataAnalysis da = new DataAnalysis();
        
        String[] content = {"eslam", "ali", "ebraheim", "momo", "eslam", "ali", "ebraheim", "ennnnn", "momo", "ali", "ai", "eslaaaaaaaaaaaaaaaaaaaaam"};
       // System.out.println(content.length+1);
        
        String longest = da.longestWord(content);
        String shortest = da.shortestWord(content);
        int num = da.numOfLetters(content);
        
        Hashtable<String, Integer> result = new Hashtable<>();
        result = da.numOfRepetition(content);
        String words = result.toString();
        words = words.replaceAll("[{}]", "");
        String[] word = words.split(", ");
        for (String str : word) {
            System.out.println(str);
        }
//        System.out.println(longest);
//        System.out.println(shortest);
//        System.out.println(num);
//        for (Map.Entry<String, Integer> entry : result.entrySet()) {
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//            
//            System.out.println("word: " + key + " | value: " + val);
//        }


    }
}
