package ilijhttp;

public class Kontroler {

    public static void main(String[] args) throws Exception{
        
        for (int i = 0; i < args.length; i++) {
           Httphead zaglavlje = new Httphead(args[i]);
           zaglavlje.UcitajZaglavlje();
        }
    }
}
