
import modal.LogFile;
import main.main;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    public void testModals() throws IOException {
        String test = "{\"ts\":1551140353,\"pt\":55,\"si\":\"3380fb19-0bdb-46ab-8781-e4c5cd448074\",\"uu\":\"0dd24034-36d6-4b1e-a6c1-a52cc984f105\",\"bg\":\"77e28e28-745a-474b-a496-3c0e086eaec0\",\"sha\":\"abb3ec1b8174043d5cd21d21fbe3c3fb3e9a11c7ceff3314a3222404feedda52\",\"nm\":\"phkkrw.ext\",\"ph\":\"/efvrfutgp/expgh/phkkrw\",\"dp\":2}";
        BufferedReader brLogs = new BufferedReader( new StringReader(test));
        assertTrue(new LogFile().isValid(brLogs));
//        assertFalse(logFile.isValid(brLogs));
        }


    @Test
    public void tesMain() throws Exception {
        main.main(null);
    }



        }
