package ilijhttp;

import java.net.*;
import java.io.*;
import java.util.*;

public class Httphead {
    
    Parametri parametri = new Parametri();
    
    public Httphead(String urlStringStranica){
        parametri.setURL(urlStringStranica);
    }
    
    public void UcitajZaglavlje() throws Exception{
        
        try {
            URL urlStranica = new URL(parametri.getURL());
            URLConnection conn = urlStranica.openConnection();
        
        
            for (int i = 0; ; i++) {
            
                String name = conn.getHeaderFieldKey(i); 
                String value = conn.getHeaderField(i);
            
                if (name == null && value == null) {
                    break;
                }
                if (name == null) {
                    parametri.setLinija(value);
                }
                else{
                    parametri.setZaglavlje(name, value);
                }
            }
        
        } catch(Exception e)
        {
            System.out.println("Greska : public void UcitajStranicu()");
        }
        
        zapisiZaglavlje();
    }
    
    private void zapisiZaglavlje() {
        
        try
        {
            Hashtable zaglavljeParametri = parametri.getZaglvalje();
            Enumeration kljucevi = zaglavljeParametri.keys();
            zapisiDatoteka("-------------------------------------------------------------------");
            zapisiDatoteka(parametri.getURL() + "\n");
            zapisiDatoteka("-------------------------------------------------------------------");
            zapisiDatoteka(parametri.getLinija() + "\n");
            
            while(kljucevi.hasMoreElements())
            {
                String kljuc = (String) kljucevi.nextElement();
                zapisiDatoteka(kljuc + " = " + zaglavljeParametri.get(kljuc) + "\n");
            }
        
        } catch (Exception e) {
            System.out.println("Error : private void zapisiZaglavlje()");
        }
    }
    
    private void zapisiDatoteka(String text){
        
        try{
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                                        "output.txt"), true));
                        bw.write(text);
                        bw.newLine();
                        bw.close();
            
        } catch(Exception e) {}
    }
}
