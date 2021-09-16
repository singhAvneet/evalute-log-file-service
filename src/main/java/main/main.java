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
        Log logEntry;
        boolean isValid = false;
        Gson gson = new Gson();
        Set<String> filenameList=new HashSet<>();
       BufferedReader br = new BufferedReader(new FileReader(new File("log.dat")));


            while ((line = br.readLine()) != null) {
                try{
                    logEntry = gson.fromJson(line, Log.class);

                    if(logEntry.isValid() && logEntry.inNotEmpty()) {
                        filenameList.add(logEntry.getNm());
                        isValid=true;
                    }else {
                        System.out.println("JSON entries in line " + line + " is invalid.");
                        isValid=false;
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid Log File");
                    System.out.println("Error in "+line+". Error: "+ e.getMessage());
                    isValid=false;
                    break;
                }
            }

        if(isValid)
        {
            Map<String, Integer> uniqueList=new HashMap<>();
            int count;
            for (String fnm: filenameList ) {
               line=fnm.substring(fnm.indexOf(".")+1);
                count = uniqueList.get(line)== null ?0:uniqueList.get(line);
                uniqueList.put(line, ++count);
            }

            uniqueList.forEach((k,v)->{
                System.out.println(k +": "+v);
            });

        }

    }


}