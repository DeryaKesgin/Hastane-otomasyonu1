
package hastaneotomasyonu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static hastaneotomasyonu.RandevuAlmaHasta.poltf;
import static hastaneotomasyonu.Hasta.*;

class Poliklinikler {
    static ArrayList klinikler = new ArrayList<>();
    static ArrayList polsaat = new ArrayList<>();
    static ArrayList sikayet = new ArrayList<>();
    static ArrayList tani = new ArrayList<>();
    static File saatlerfile = new File("Saatler.txt");
    static File klinikfile = new File("Poliklinikler.txt");
    static String[] str = new String[10];
    static String[] str2 = new String[10];
    static String[] str3 = new String[10];
    static String[] str4 = new String[10];
    static String[] str5 = new String[10];
            
    Poliklinikler(){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(saatlerfile));
            String yazil = br1.readLine();
            str2 = yazil.split(",");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Poliklinikler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Poliklinikler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean DersSec(ArrayList a)throws IOException{
        
        randevular_hasta.set(Hasta.i, a.get(0));
        PrintWriter writer = new PrintWriter(Hasta.dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(Hasta.dersfile, true);
        for (int j = 0; j < randevular_hasta.size(); j++) {
            out.write(randevular_hasta.get(j).toString().getBytes());
            out.write(Hasta.z.getBytes());
        }
        String[] str = ((String)randevular_hasta.get(Hasta.i)).split(",");
        return true;
    }
    public void DersSecGecici()throws IOException{
        FileOutputStream out = new FileOutputStream(dersfile, true);
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        for (int j = 0; j < klinikler.size(); j++) {
            out.write(klinikler.get(j).toString().getBytes());
        }
        klinikler.clear();
        BufferedReader br1 = new BufferedReader(new FileReader("Poliklinikler.txt"));
        while(true){
            String yazi1 = br1.readLine();
            if (yazi1 != null){
                klinikler.add(yazi1);
            }
            else
                break;
        }   
    }
    static public void NotlarGirildi(int k)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Hasta Şikayet.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Hasta Tanı.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("Poliklinikler.txt"));
        PrintWriter writer = new PrintWriter(dersfile);
        writer.print("");
        writer.close();
        FileOutputStream out = new FileOutputStream(dersfile, true);
        for(int j=0; j<str3.length;j++){
            if(j<str3.length-1){
                out.write(str3[j].getBytes());
                out.write(",".getBytes());
            }
            else
                out.write(str3[j].getBytes());
        }
        DoktorReçeteGir.vizeler.set(k, br3.readLine());
        PrintWriter writer2 = new PrintWriter("Hasta Şikayet.txt");
        writer2.print("");
        writer2.close();
        FileOutputStream oat = new FileOutputStream("Hasta Şikayet.txt", true);
        for(int j=0; j<DoktorReçeteGir.vizeler.size();j++){
            oat.write(DoktorReçeteGir.vizeler.get(j).toString().getBytes());
            oat.write("\n".getBytes());
        }
        writer.print("");
        writer.close();
        for(int j=0; j<str4.length;j++){
            if(j<str4.length - 1){
                out.write(str4[j].getBytes());
                out.write(",".getBytes());
            }
            else
                out.write(str4[j].getBytes());
        }
        DoktorReçeteGir.finaller.set(k, br3.readLine());
        PrintWriter writer3 = new PrintWriter("Hasta Tanı.txt");
        writer3.print("");
        writer3.close();
        FileOutputStream oet = new FileOutputStream("Hasta Tanı.txt", true);
        for(int j=0;j<DoktorReçeteGir.finaller.size();j++){
            oet.write(DoktorReçeteGir.finaller.get(j).toString().getBytes());
            oet.write("\n".getBytes());
        }
    }
    static public void ArraylereAt(){
        str = ((String)randevular_hasta.get(Hasta.i)).split(",");
        str3 = ((String)sikayet_hasta.get(Hasta.i)).split(",");
        str4 = ((String)tani_hasta.get(Hasta.i)).split(",");
        str5 = ((String)ilaclar_hasta.get(Hasta.i)).split(",");
    }
    static public void ArraylereAtNot(int k){
        str3 = ((String)DoktorReçeteGir.vizeler.get(k)).split(",");
        str4 = ((String)DoktorReçeteGir.finaller.get(k)).split(",");
    }
}
