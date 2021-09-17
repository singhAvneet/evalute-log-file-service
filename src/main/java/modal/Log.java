package modal;

public class Log{

    private long ts;//:  timestamp
    private int pt;//:  processing time
    private String si;//:  session ID
    private String uu;//:  user UUID
    private String bg;//:  business UUID
    private String sha;//: sha256 of the file
    private String nm;//:  file name
    private String ph;//:  path
    private byte dp;//:  disposition (valid values: MALICIOUS (1), CLEAN (2), UNKNOWN (3))

    public boolean isValid(){

        return String.valueOf(getTs()).matches("[+]?[0-9]{10}")
                &&  String.valueOf(getPt()).matches("[+]?[0-9]{2}")
                &&  getSi().matches("^#?([a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12})$")
                &&  getUu().matches("^#?([a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12})$")
                &&  getBg().matches("^#?([a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12})$")
                &&  getSha().matches("^#?([a-f0-9]{64})$")
                &&  getNm().matches(".*")
                &&  getPh().matches("^[^/]*/[^/].*$")
                &&  String.valueOf(getDp()).matches("[+]?[1-3]{1}")
                && getNm().contains(getPh().substring(getPh().lastIndexOf("/")+1))
                && getDp()==2;

    }

    public boolean inNotEmpty(){
        return  getPh()!=null || getBg()!=null || getDp()!=0 ||
                getNm()!=null || getPt()!=0 || getTs()!=0 ||
                getUu()!=null || getSha()!=null || getSi()!=null;
    }

    public long getTs() {
        return ts;
    }

    public int getPt() {
        return pt;
    }

    public String getSi() {
        return si;
    }

    public String getUu() {
        return uu;
    }

    public String getBg() {
        return bg;
    }

    public String getSha() {
        return sha;
    }

    public String getNm() {
        return nm;
    }

    public String getPh() {
        return ph;
    }

    public byte getDp() {
        return dp;
    }
}
