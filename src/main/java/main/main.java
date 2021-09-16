package main;

import com.google.gson.Gson;
import modal.Log;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class main {


    public static void main( String[] args ) throws IOException {
        String line;
        int count;
        Log logEntry ;
        Gson gson = new Gson();
        Map<String, Integer> uniqueList=new HashMap<>();
       BufferedReader br = new BufferedReader(new FileReader(new File("log.dat")));


            while ((line = br.readLine()) != null) {
                try{
                    logEntry = gson.fromJson(line, Log.class);


                    if(logEntry.inNotEmpty()){
                        count = uniqueList.get(logEntry.getNm())== null ?0:uniqueList.get(logEntry.getNm());
                        uniqueList.put(logEntry.getNm(), ++count);
                    }


                    if(!logEntry.isValid()) {
                        System.out.println("JSON entries in line " + line + " is invalid.");
                    }


                }
                catch(Exception e){
                    System.out.println("Invalid Log File");
                    System.out.println("Error in "+line+". Error: "+ e.getMessage());break;
                }



            }


        System.out.println(uniqueList.toString());

    }


}