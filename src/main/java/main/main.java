package main;


import modal.LogFile;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main( String[] args ) throws IOException {
        String extName;
        LogFile logFile=new LogFile();
        BufferedReader brLogs = new BufferedReader(new FileReader(new File("log.dat")));
        if(logFile.isValid(brLogs))
        {
            Map<String, Integer> uniqueExtList=new HashMap<>();
            int count;

            for (String fnm: logFile.getFilenameList() ) {
                extName=fnm.substring(fnm.indexOf(".")+1);
                count = uniqueExtList.get(extName)== null ?0:uniqueExtList.get(extName);
                uniqueExtList.put(extName, ++count);
            }

            uniqueExtList.forEach((k,v)->{
                System.out.println(k +": "+v);
            });

        }


    }





}