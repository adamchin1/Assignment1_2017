// Adam Chin CHNADA002
// 2017-04-02
// CSC2001F Assignment 1 2017 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchIt {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
    
        BinarySearchTree bst = new BinarySearchTree();
        bst = bst.populate();
        System.out.println("BST Search");
        System.out.println("Searching...\n");
        Scanner sc = new Scanner(new File("Query.txt"));
        while (sc.hasNext()) {
            bst.find(sc.nextLine());
        }
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nRun Time: "+totalTime+"ms");
    }
}
