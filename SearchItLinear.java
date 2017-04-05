// Adam Chin CHNADA002
// 2017-04-02
// CSC2001F Assignment 1 2017 


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchItLinear {

    public static void main(String[] args) throws IOException { 
        long startTime = System.currentTimeMillis();
        
        Scanner data = new Scanner(new File("testdata.txt")); 
        Scanner query = new Scanner(new File("Query.txt")); 
        ArrayList<Person> personArray = new ArrayList<>();
        System.out.println("Linear Search");
        System.out.println("Searching...\n");
        while (data.hasNext()) {
                String[] parts = data.nextLine().split("\\|");
                Person p = new Person(null, null, null);
                p.name = parts[2];
                p.number = parts[1];
                p.adress = parts[0];
                personArray.add(p);
        } 
        
        while (query.hasNext()) {
            String s = query.nextLine();
            for (int i = 0; i < 10000; i++) {
                if (i == 9999 && !s.equals(personArray.get(i).name)){
                    System.out.println("Not Found: " + s);}
                if (s.equals(personArray.get(i).name)){
                    System.out.println(personArray.get(i).toString());
                    i =0;
                    if (query.hasNext()) {
                        s = query.nextLine();}
                    else{i=9999;}
                        
                }

            }
        } 
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nRun Time: "+totalTime+"ms");   
    }
        
}
