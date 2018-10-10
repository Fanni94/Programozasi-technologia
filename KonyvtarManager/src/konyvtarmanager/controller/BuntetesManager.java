package konyvtarmanager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import konyvtarmanager.modell.BuntetesTipus;
import konyvtarmanager.modell.Kolcsonzes;
import konyvtarmanager.modell.Tag;

public class BuntetesManager extends Thread{
    
    private KonyvtarManager manager;
    
    public BuntetesManager() {
        manager = new KonyvtarManager();
    }
    
    public void run(){
       try {
        while(true){
            // 1. lépés
            // összes kölcsönzés lekérése
            ArrayList<Kolcsonzes> kolcsonzesLista = manager.getKolcsonzesLista();
            
            ArrayList<Kolcsonzes> kesesLista = new ArrayList<>();
            // 1.5 lépés
            //ahol a (visszahozás dátuma null és kikölcsönzés dáruma +7 > most) vagy ((visszahozás dátum - kikölcszés dátum > 7) és kikölcsönzés dátuma >= most -30)
            for(Kolcsonzes k : kolcsonzesLista){
                Date kikolcsonzesPlus7 = new Date(k.getKolcsonzesdatuma().getTime() + (1000 * 60 * 60 * 24 * 7));
                Date mostMinusz30 = new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 30));
                if(k.getVisszahozasdatuma() == null && kikolcsonzesPlus7.before(new Date())){
                    kesesLista.add(k);
                }
                else if(k.getVisszahozasdatuma() != null && kikolcsonzesPlus7.before(k.getVisszahozasdatuma()) && mostMinusz30.before(k.getKolcsonzesdatuma())){
                    kesesLista.add(k);
                }
            }
            
            // 2. lépés
            HashMap<Integer, Integer> tagKesesek = new HashMap<Integer, Integer>();
            // emberek szerint számoljuk h hányszor szerepel
            for(Kolcsonzes k : kesesLista){
                Integer kesesTagKjsz = k.getTag().getKonyvtarjegyszam();
                if(!tagKesesek.containsKey(kesesTagKjsz))
                {
                    tagKesesek.put(kesesTagKjsz, 1);
                }
                else{
                    tagKesesek.put(kesesTagKjsz, tagKesesek.get(kesesTagKjsz) + 1);
                }
            }
            
            // 3. lépés 
            // ha >=5 szerepel egy ember, akkor egy hetes bünti beállítása a tagnál, a mostani büntetés kezdete dátummal, ha már van bümtetése akkor a büntetés kezdetét aktualizáljuk
            for(Entry<Integer, Integer> entry : tagKesesek.entrySet()) {
                Integer kesesekSzama = entry.getValue();
                Tag kesesTag = manager.getTag(entry.getKey());
                if(kesesekSzama >= 5) {
                    kesesTag.setBuntetesKezdete(new Date());
                    manager.buntetesBeallitasa(kesesTag, BuntetesTipus.EGYHETES);
                }
            }
            for(Kolcsonzes k : kolcsonzesLista) {
                Tag kesesTag = k.getTag();
                Date mostMinusz7 = new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 7));
                Date mostMinusz14 = new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 14));
                // 4. lépés
                // ha van büntetése és a büntetés kezdete <= most -7, akkor átállítjuka büntetés típusát két hetesre, ha nem két hetes büntetése van
                if(kesesTag.getBuntetes() == BuntetesTipus.EGYHETES && kesesTag.getBuntetesKezdete().before(mostMinusz7)) {
                    manager.buntetesBeallitasa(kesesTag, BuntetesTipus.KETHETES);
                }
                // 5. lépés 
                // ha van büntetése és a büntetés kezdete <= most -14, akkor büntetés = nincs és büntetés kezdete null
                else if(kesesTag.getBuntetes() == BuntetesTipus.KETHETES && kesesTag.getBuntetesKezdete().before(mostMinusz14)) {
                    kesesTag.setBuntetesKezdete(null);
                    manager.buntetesBeallitasa(kesesTag, BuntetesTipus.NINCS);
                }
            }
            // sleep 5 min
            Thread.sleep(1000 * 60 * 5);

        }
       } catch (InterruptedException ex) {
        
        Logger.getLogger(BuntetesManager.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
