package modal;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LogFile {

    private Set<String> filenameList=new HashSet<>();

    public Set<String> getFilenameList() {
        return filenameList;
    }

    public boolean isValid(BufferedReader br) throws IOException {
         String line;
         Log logEntry;
         Gson gson = new Gson();
         boolean isValid=false;

        while ((line = br.readLine()) != null) {
            try{
                logEntry = gson.fromJson(line, Log.class);
                if(isValid=logEntry.isValid() && logEntry.inNotEmpty()) {
                    filenameList.add(logEntry.getNm());
                }else {
                    System.out.println("JSON entries in line " + line +" is invalid.");
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
        return isValid;
    }


}
