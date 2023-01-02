
package hastaneotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static hastaneotomasyonu.Poliklinikler.klinikfile;
import static hastaneotomasyonu.Doktor.klinikler_doktor;
import static hastaneotomasyonu.Doktor.i;


public class PolsDoktor {
    static ArrayList dersler = new ArrayList<>();
    static File dersfile = new File("Saatler.txt");
    static String[] arrstr = new String[10];
    static String[] arrstr2 = new String[10];
    int k=0;
    PolsDoktor()throws IOException{
        for(int j=0; j<arrstr.length;j++){
            arrstr2[j] = "-";
        }
        Doktor hoca = new Doktor();
        for(k=0;k<Doktor.klinikler_doktor.size();k++){
            arrstr = ((String)klinikler_doktor.get(k)).split(",");
            for(int l=0; l<arrstr.length;l++){
                if(arrstr[l].equals("t")){
                    arrstr2[l] = (((String)Doktor.isimler.get(k))+" "+((String)Doktor.soyisimler.get(k)));
                }
            }
        }
//        arrstr = ((String)dersler_ogretim.get(i)).split(",");
    }
    public void DersSecGecici()throws IOException{
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(dersfile, true);
        for (int j = 0; j < dersler.size(); j++) {
            out.write(dersler.get(j).toString().getBytes());
        }
        dersler.clear();
        BufferedReader br1 = new BufferedReader(new FileReader(dersfile));
        while(true){
            String yazi1 = br1.readLine();
            if (yazi1 != null){
                dersler.add(yazi1);
            }
            else
                break;
        }
    }
    public boolean DersSecOgretim(ArrayList a)throws IOException{
        klinikler_doktor.set(Doktor.i, dersler.get(0));
        PrintWriter writer = new PrintWriter(Doktor.klinikfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(Doktor.klinikfile, true);
        for (int j = 0; j < klinikler_doktor.size(); j++) {
            out.write(klinikler_doktor.get(j).toString().getBytes());
            out.write(Doktor.z.getBytes());
        }
        return true;
    }
    public static String[] arrstrdoldur(){
        arrstr = ((String)klinikler_doktor.get(i)).split(",");
        return arrstr;
    }
}
