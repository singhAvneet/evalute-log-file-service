package main;

import com.google.gson.Gson;
import modal.Log;

import java.io.*;

public class main {


    public static void main( String[] args ) throws FileNotFoundException {

        File file = new File("log.dat");
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                Log log = gson.fromJson(line, Log.class);
                System.out.println(log.getPh());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}