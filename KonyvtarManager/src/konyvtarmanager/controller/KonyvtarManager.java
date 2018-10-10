package konyvtarmanager.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import konyvtarmanager.modell.BuntetesTipus;
import konyvtarmanager.modell.Kolcsonzes;
import konyvtarmanager.modell.Konyv;
import konyvtarmanager.modell.Tag;

public class KonyvtarManager {
    public AdatbazisManager db;
    
    public KonyvtarManager(){
        db = AdatbazisManager.getInstance();
    }   
    
    private Konyv getKonyv(String ISBNszam){
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet konyv = stmt.executeQuery("SELECT * FROM Konyv WHERE ISBNszam = " + ISBNszam);
            
            konyv.next();
            
            Konyv k = new Konyv();
            k.setSzerzo(konyv.getString("Szerzo"));
            k.setCim(konyv.getString("Cim"));
            k.setISBNszam(konyv.getString("ISBNszam"));
            k.setKiadaseve(konyv.getInt("KiadasEve"));
            k.setPeldanyszam(konyv.getInt("OsszesPeldanyszam"));
            k.setZarolte(konyv.getBoolean("Zarolte"));
            k.setKikolcsonzesSzam(getKikolcsonzesSzamByISBN(k.getISBNszam()));
            return k;
        }
        catch(SQLException e){
		System.out.println("" + e.getStackTrace());
        }
        return null;
    }
    
    public Tag getTag(int Konyvtarjegyszam){
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet tag = stmt.executeQuery("SELECT * FROM Tag WHERE Konyvtarjegyszam = " + Konyvtarjegyszam);
            
            tag.next();
            
            Tag t = new Tag();
            t.setNev(tag.getString("Nev"));
            t.setCim(tag.getString("Cim"));
            t.setKonyvtarjegyszam(tag.getInt("Konyvtarjegyszam"));
            t.setBuntetes(BuntetesTipus.parse(tag.getInt("Buntetes")));
            t.setBuntetesKezdeteString(tag.getString("BuntetesKezdete"));
            return t;
        }
        catch(SQLException | ParseException e){
		System.out.println("" + e.getStackTrace());
        }
        return null;
    }
    
    public ArrayList<Tag> getTagByNev(String Nev){
        ArrayList<Tag> list = new ArrayList<>();
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet tag = stmt.executeQuery("SELECT * FROM Tag WHERE Lower(Nev) LIKE '%" + Nev + "%'");
            
            while(tag.next()){
                Tag t = new Tag();
                t.setNev(tag.getString("Nev"));
                t.setCim(tag.getString("Cim"));
                t.setKonyvtarjegyszam(tag.getInt("Konyvtarjegyszam"));
                t.setBuntetes(BuntetesTipus.parse(tag.getInt("Buntetes")));
                t.setBuntetesKezdeteString(tag.getString("BuntetesKezdete"));
                list.add(t);
            }
            return list;
            
        }
        catch(SQLException | ParseException e){
		System.out.println("" + e.getStackTrace());
        }
        return null;
    }
    
    public ArrayList<Konyv> getKonyvByNev(String Cim){
        ArrayList<Konyv> list = new ArrayList<>();
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet konyv = stmt.executeQuery("SELECT * FROM Konyv WHERE Lower(Cim) LIKE '%" + Cim + "%'");
            
            while(konyv.next()){
                Konyv k = new Konyv();
                k.setSzerzo(konyv.getString("Szerzo"));
                k.setCim(konyv.getString("Cim"));
                k.setISBNszam(konyv.getString("ISBNszam"));
                k.setKiadaseve(konyv.getInt("KiadasEve"));
                k.setPeldanyszam(konyv.getInt("OsszesPeldanyszam"));
                k.setZarolte(konyv.getBoolean("Zarolte"));
                k.setKikolcsonzesSzam(getKikolcsonzesSzamByISBN(k.getISBNszam()));
                list.add(k);
            }
            return list;
            
        }
        catch(SQLException e){
		System.out.println("" + e.getStackTrace());
        }
        return null;
    }
    
    public void setKonyv(Konyv konyv){
        try{
            Statement stmt = db.dbConnection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Konyv SET ");
            sb.append("Szerzo = '" + konyv.getSzerzo() + "'");
            sb.append(", Cim = '" + konyv.getCim() + "'");
            sb.append(", ISBNszam = " + konyv.getISBNszam());
            sb.append(", KiadasEve = " + konyv.getKiadaseve());
            sb.append(", OsszesPeldanyszam = " + konyv.getPeldanyszam());
            sb.append(", Zarolte = " + (konyv.getZarolte() ? 0 : 1));
            sb.append(" WHERE ISBNszam = " + konyv.getISBNszam());
            
            stmt.executeUpdate(sb.toString());
        }
        catch(SQLException e){
            System.out.println("" + e.getStackTrace());
        }
    }
    
    public void setTag(Tag tag){
        try{
            Statement stmt = db.dbConnection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Tag SET ");
            sb.append("Nev = '" + tag.getNev() + "'");
            sb.append(", Cim = '" + tag.getCim() + "'");
            sb.append(", Konyvtarjegyszam = " + tag.getKonyvtarjegyszam());
            sb.append(", Buntetes = " + tag.getBuntetesInt());
            sb.append(", BuntetesKezdete = '" + tag.getBuntetesKezdete() + "'");
            sb.append(" WHERE Konyvtarjegyszam = " + tag.getKonyvtarjegyszam());
            
            stmt.executeUpdate(sb.toString());
        }
        catch(SQLException e){
            System.out.println("" + e.getStackTrace());
        }
    }
    
    public boolean kolcsonzes(String ISBNszam, int Konyvtarjegyszam, boolean Visszahozatal){
        try{
            Date most = new Date();
            DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
            String now = formazo.format(most);
            
            if(Visszahozatal == true){
                Statement stmt = db.dbConnection.createStatement();
                StringBuilder sb = new StringBuilder();
                sb.append("UPDATE Kolcsonzes SET ");
                sb.append("VisszahozasDatuma = '" + now + "'");
                sb.append(" WHERE Konyvtarjegyszam = " + Konyvtarjegyszam + " AND ISBNszam = " + ISBNszam);
                stmt.executeUpdate(sb.toString());

            }
            else{
                Statement stmt = db.dbConnection.createStatement();
                ResultSet zarolt = stmt.executeQuery("SELECT Zarolte FROM Konyv WHERE ISBNszam = " + ISBNszam);
                
                zarolt.next();
                
                int zaroltInt = zarolt.getInt("Zarolte");
                
                if(zaroltInt == 1){
                    return false;
                }
                
                stmt = db.dbConnection.createStatement();
                ResultSet buntetes = stmt.executeQuery("SELECT Buntetes FROM Tag WHERE Konyvtarjegyszam = " + Konyvtarjegyszam);
                
                buntetes.next();
                
                BuntetesTipus bt = BuntetesTipus.parse(buntetes.getInt("Buntetes"));
                
                switch (bt) {
                    case NINCS:
                        stmt.executeUpdate("INSERT INTO Kolcsonzes(Konyvtarjegyszam, ISBNszam, KolcsonzesDatuma) VALUES(" + Konyvtarjegyszam + ", " + ISBNszam + ", '" + now + "')");
                        break;
                    case EGYHETES:
                        return false;
                    case KETHETES:
                        ResultSet kbuntetes = stmt.executeQuery("SELECT COUNT(*) osszes FROM Kolcsonzes WHERE Konyvtarjegyszam = " + Konyvtarjegyszam);
                        kbuntetes.next();
                        int osszesKolcsonzes = kbuntetes.getInt("osszes");
                        if(osszesKolcsonzes >= 2) {
                            return false;
                        }
                        else{
                            stmt.executeUpdate("INSERT INTO Kolcsonzes(Konyvtarjegyszam, ISBNszam, KolcsonzesDatuma) VALUES(" + Konyvtarjegyszam + ", " + ISBNszam + ", '" + now + "')");
                        }   break;
                    default:
                        break;
                }
            }
        }
        catch(SQLException e){
            System.out.println("" + e.getStackTrace());
        }
        return true;
    }
    
    public void tagTorles(int Konyvtarjegyszam){
        try{
            Statement stmt = db.dbConnection.createStatement();
            stmt.executeUpdate("DELETE FROM Tag WHERE Konyvtarjegyszam = " + Konyvtarjegyszam);
            stmt.executeUpdate("DELETE FROM Kolcsonzes WHERE Konyvtarjegyszam = " + Konyvtarjegyszam);
        }
        catch(SQLException e){
		System.out.println("" + e.getStackTrace());
        }
    }
    
    public void ujTag(String nev, String cim){
        try{
            Statement stmt = db.dbConnection.createStatement();
            stmt.executeUpdate("INSERT INTO Tag(Nev, Cim) VALUES('" + nev + "', '" + cim + "')");
        }
        catch(SQLException e){
		System.out.println("" + e.getStackTrace());
        }
    }
    
    public ArrayList<Kolcsonzes> getKolcsonzesListaByTag(int konyvtarjegyszam){
        ArrayList<Kolcsonzes> lista = new ArrayList<>();
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet kolcsonzes = stmt.executeQuery("SELECT * FROM Kolcsonzes WHERE Konyvtarjegyszam = " + konyvtarjegyszam);
            
            while(kolcsonzes.next()){
                Kolcsonzes k = new Kolcsonzes();
                DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
                
                String s = kolcsonzes.getString("VisszahozasDatuma");
                if(s != null){
                   k.setVisszahozasdatuma(formazo.parse(s)); 
                }
                k.setKolcsonzesdatuma(formazo.parse(kolcsonzes.getString("KolcsonzesDatuma")));
                k.setTag(getTag(konyvtarjegyszam));
                k.setKonyv(getKonyv(kolcsonzes.getString("ISBNszam")));
                
                lista.add(k);
            }
        }
        catch(SQLException | ParseException e){
		System.out.println("" + e.getStackTrace());
        }
        return lista;
    }
    
    private int getKikolcsonzesSzamByISBN(String ISBNszam){
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet kszam = stmt.executeQuery("SELECT COUNT(*) osszes FROM Kolcsonzes WHERE ISBNszam = " + ISBNszam);
            
            kszam.next();
            return kszam.getInt("osszes");
        }
        catch(SQLException e){
		System.out.println("" + e.getStackTrace());
        }
        return -1;
    }
    
    public void buntetesBeallitasa(Tag tag, BuntetesTipus bt){
        try{
            Statement stmt = db.dbConnection.createStatement();
            stmt.executeUpdate("UPDATE Tag SET Buntetes = " + bt.toDbString() + ", BuntetesKezdete = '" + tag.getBuntetesKezdeteString()+ "' WHERE Konyvtarjegyszam = " + tag.getKonyvtarjegyszam());
        }
        catch(SQLException e){
            System.out.println("" + e.getStackTrace());
        }
    }
   
    public ArrayList<Kolcsonzes> getKolcsonzesLista(){
        ArrayList<Kolcsonzes> lista = new ArrayList<>();
        try{
            Statement stmt = db.dbConnection.createStatement();
            ResultSet kolcsonzes = stmt.executeQuery("SELECT * FROM Kolcsonzes");
            
            while(kolcsonzes.next()){
                Kolcsonzes k = new Kolcsonzes();
                DateFormat formazo = new SimpleDateFormat("yyyy.MM.dd.");
                
                String s = kolcsonzes.getString("VisszahozasDatuma");
                if(s != null){
                   k.setVisszahozasdatuma(formazo.parse(s)); 
                }
                k.setKolcsonzesdatuma(formazo.parse(kolcsonzes.getString("KolcsonzesDatuma")));
                k.setTag(getTag(kolcsonzes.getInt("Konyvtarjegyszam")));
                k.setKonyv(getKonyv(kolcsonzes.getString("ISBNszam")));
                
                lista.add(k);
            }
        }
        catch(SQLException | ParseException e){
		System.out.println("" + e.getStackTrace());
        }
        return lista;
    }
}
