package main;

import com.google.gson.Gson;
import modal.Log;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class main {


    public static void main( String[] args ) throws IOException {
        String line;
        Log logEntry = new Log();
        Gson gson = new Gson();
        Map<String, Integer> uniqueList=new HashMap<String, Integer>();
       BufferedReader br = new BufferedReader(new FileReader(new File("log.dat")));


            while ((line = br.readLine()) != null) {
                try{
                    logEntry = gson.fromJson(line, Log.class);

                    if(logEntry.isValid()){
                        System.out.println(logEntry.isValid());
                    }else{
                        System.out.println("JSON entries in line "+line+" is invalid.");break;
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid Log File");
                    System.out.println("Error in "+line+". Error: "+ e.getMessage());break;
                }



            }




    }


}