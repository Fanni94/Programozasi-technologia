package konyvtarmanager.modell;

public class Konyv {
    private String szerzo, cim, ISBNszam;
    private int kiadaseve, peldanyszam, kikolcsonzesSzam;
    private boolean zarolte;

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getISBNszam() {
        return ISBNszam;
    }

    public void setISBNszam(String ISBNszam) {
        this.ISBNszam = ISBNszam;
    }

    public int getKiadaseve() {
        return kiadaseve;
    }

    public void setKiadaseve(int kiadaseve) {
        this.kiadaseve = kiadaseve;
    }

    public int getPeldanyszam() {
        return peldanyszam;
    }

    public void setPeldanyszam(int peldanyszam) {
        this.peldanyszam = peldanyszam;
    }
    
    public boolean getZarolte() {
        return zarolte;
    }

    public void setZarolte(boolean zarolte) {
        this.zarolte = zarolte;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.szerzo).append(" - ").append(this.cim);
        return sb.toString();
    }

    public int getKikolcsonzesSzam() {
        return kikolcsonzesSzam;
    }

    public void setKikolcsonzesSzam(int kikolcsonzesSzam) {
        this.kikolcsonzesSzam = kikolcsonzesSzam;
    }
}
