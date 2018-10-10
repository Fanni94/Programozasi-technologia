package konyvtarmanager.modell;

public enum BuntetesTipus {
    NINCS, EGYHETES, KETHETES;
    
    public static BuntetesTipus parse(int k){
        switch(k){
            case 0 : return NINCS;
            case 1 : return EGYHETES;
            case 2 : return KETHETES;
            default : return null;
        }
    }
    
    public String toString(){
        switch(this){
            case NINCS : return "Nincs büntetés";
            case EGYHETES : return "Egy hetes büntetés";
            case KETHETES : return "Két hetes büntetés";
            default : return null;
        }
    }
    
   public String toDbString(){
        switch(this){
            case NINCS : return "0";
            case EGYHETES : return "1";
            case KETHETES : return "2";
            default : return null;
        }
    } 
}
