package konyvtarmanager.modell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kolcsonzes {
    private Date kolcsonzesdatuma, visszahozasdatuma;
    private Tag tag;
    private Konyv konyv;

    public Date getKolcsonzesdatuma() {
        return kolcsonzesdatuma;
    }

    public void setKolcsonzesdatuma(Date kolcsonzesdatuma) {
        this.kolcsonzesdatuma = kolcsonzesdatuma;
    }

    public Date getVisszahozasdatuma() {
        return visszahozasdatuma;
    }

    public void setVisszahozasdatuma(Date visszahozasdatuma) {
        this.visszahozasdatuma = visszahozasdatuma;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Konyv getKonyv() {
        return konyv;
    }

    public void setKonyv(Konyv konyv) {
        this.konyv = konyv;
    }
    
    public String toString(){
        DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
        StringBuilder sb = new StringBuilder();
        if(visszahozasdatuma == null){
            sb.append(this.konyv).append(" - ").append(formazo.format(kolcsonzesdatuma)).append(" - Nincs visszahozva");
        }
        else{
            sb.append(this.konyv).append(" - ").append(formazo.format(kolcsonzesdatuma)).append(" - ").append(formazo.format(visszahozasdatuma));
        }
        return sb.toString();
    }
}
