package ilijhttp;

import java.util.*;

public class Parametri {
    
    private Hashtable httpZaglavlje = new Hashtable();
    
    public void setZaglavlje(String kljuc, String vrijednost){
        
        httpZaglavlje.put(kljuc, vrijednost);
    }

    public Hashtable getZaglvalje(){
        
        return httpZaglavlje;
    }
    
    private String prvaLinija;
    
    public void setLinija(String linija){
       
        prvaLinija = linija;
    }
    
    public String getLinija(){
        
        return prvaLinija;
    }
    
    private String urlStranica;
    
    public void setURL(String urlStranica){
        
        this.urlStranica = urlStranica;
    }
    
    public String getURL(){
        
        return urlStranica;
    }
    
}
