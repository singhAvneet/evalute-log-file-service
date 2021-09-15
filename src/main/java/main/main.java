package main;

import java.io.*;

public class main {


    public static void main( String[] args ) throws FileNotFoundException {

        File file = new File("log.dat");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}