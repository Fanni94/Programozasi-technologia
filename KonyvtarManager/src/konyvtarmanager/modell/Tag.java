package konyvtarmanager.modell;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tag {
    private String nev, cim;
    private int konyvtarjegyszam;
    private BuntetesTipus buntetes;
    private Date bunteteskezdete;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getKonyvtarjegyszam() {
        return konyvtarjegyszam;
    }

    public void setKonyvtarjegyszam(int konyvtarjegyszam) {
        this.konyvtarjegyszam = konyvtarjegyszam;
    }

    public BuntetesTipus getBuntetes() {
        return buntetes;
    }
    
    public int getBuntetesInt(){
        switch(buntetes){
            case NINCS : return 0;
            case EGYHETES : return 1;
            case KETHETES : return 2;
            default : return -1;
        }
    }

    public void setBuntetes(BuntetesTipus buntetes) {
        this.buntetes = buntetes;
    }   

    public Date getBuntetesKezdete() {
        return bunteteskezdete;
    }
    
    public String getBuntetesKezdeteString(){
        if(bunteteskezdete == null) return "NULL";
        DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
        return formazo.format(bunteteskezdete);
    }

    public void setBuntetesKezdete(Date bunteteskezdete) {
        this.bunteteskezdete = bunteteskezdete;
    }
    public void setBuntetesKezdeteString(String bunteteskezdete) throws ParseException {
        if(bunteteskezdete != null && !bunteteskezdete.equals("null")){
            DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
            this.bunteteskezdete = formazo.parse(bunteteskezdete);
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nev).append(" - ").append(this.konyvtarjegyszam);
        return sb.toString();
    }
}
