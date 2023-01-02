
package hastaneotomasyonu;

import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


class Doktor extends Üye implements İnsan{
    static int i = 0;
    static boolean kayıth = true;
    static ArrayList idler = new ArrayList<>();
    static ArrayList sifreler = new ArrayList<>();
    static ArrayList isimler = new ArrayList<>();
    static ArrayList soyisimler = new ArrayList<>();
    static ArrayList klinikler_doktor = new ArrayList<>();
    static File idfile = new File("Doktor ID.txt");
    static File şifrefile = new File("Doktor Şifre.txt");
    static File isimfile = new File("Doktor İsim.txt");
    static File soyisimfile = new File("Doktor Soyisim.txt");
    static File klinikfile = new File("Doktor Klinik.txt");
    static String z = "\n";
    static String aldıalmadı = "f,f,f,f,f,f,f,f,f,f";
    Doktor()throws IOException{
        FileOutputStream out = new FileOutputStream(idfile,true);
        FileOutputStream oat = new FileOutputStream(şifrefile,true);
        FileOutputStream oet = new FileOutputStream(isimfile,true);
        FileOutputStream oit = new FileOutputStream(soyisimfile,true);
        FileOutputStream opt = new FileOutputStream(klinikfile,true);
        BufferedReader br4 = new BufferedReader(new FileReader(klinikfile));
        BufferedReader br2 = new BufferedReader(new FileReader("Doktor İsim.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("Doktor Soyisim.txt"));
        klinikler_doktor.clear();
        while (true) {
            String yazil = br4.readLine();
            if (yazil != null) {
                klinikler_doktor.add(yazil);
            } else {
                break;
            }
        }
        isimler.clear();
        while (true) {
            String yazi1 = br2.readLine();
            if (yazi1 != null) {
                isimler.add(yazi1);
            } else {
                break;
            }
        }
        soyisimler.clear();
        while (true) {
            String yazi1 = br3.readLine();
            if (yazi1 != null) {
                soyisimler.add(yazi1);
            } else {
                break;
            }

        }
    }
    @Override
    public boolean giriş(String a, String b) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Doktor ID.txt"));
        BufferedReader br1 = new BufferedReader(new FileReader("Doktor Şifre.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("Doktor İsim.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("Doktor Soyisim.txt"));
        BufferedReader br4 = new BufferedReader(new FileReader(klinikfile));
        
        idler.clear();
        while (true) {
	    String yazi = br.readLine();
	    if (yazi != null) {
		idler.add(yazi);
	    }
            else{
                break;
            }
	}
        sifreler.clear();
        while (true) {
	    String yazi1 = br1.readLine();
	    if (yazi1 != null) {
		sifreler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        isimler.clear();
        while (true) {
	    String yazi1 = br2.readLine();
	    if (yazi1 != null) {
		isimler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        soyisimler.clear();
        while (true) {
	    String yazi1 = br3.readLine();
	    if (yazi1 != null) {
		soyisimler.add(yazi1);
	    }
            else{
                break;
            }
            
	}
        klinikler_doktor.clear();
        while(true){
            String yazil = br4.readLine();
            if (yazil != null){
                klinikler_doktor.add(yazil);
            }
            else
                break;
        }
        for(i=0;i<idler.size();i++){
            if(idler.get(i).equals(a)){
                if(sifreler.get(i).equals(b)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean şifreDeğiştir(String şifre, String şifrey) throws IOException{
        if (sifreler.get(i).equals(şifre)) {
            sifreler.set(i, şifrey);
            PrintWriter writer = new PrintWriter(şifrefile);
            writer.print("");
            writer.close();
            FileOutputStream oat = new FileOutputStream(şifrefile, true);
            for (int j = 0; j < sifreler.size(); j++) {
                oat.write(sifreler.get(j).toString().getBytes());
                oat.write(z.getBytes());
                }
            return true;
            }
        return false;
    }
    @Override
    public boolean kayıt(String a,String b, String c, String d) throws IOException{
        kayıth = true;
        idler.clear();
        FileOutputStream out = new FileOutputStream(idfile,true);
        FileOutputStream oat = new FileOutputStream(şifrefile,true);
        FileOutputStream oet = new FileOutputStream(isimfile,true);
        FileOutputStream oit = new FileOutputStream(soyisimfile,true);
        FileOutputStream opt = new FileOutputStream(klinikfile,true);
        FileOutputStream oşt = new FileOutputStream("Tüm IDler.txt",true);
        BufferedReader br = new BufferedReader(new FileReader("Tüm IDler.txt"));
        BufferedReader br1 = new BufferedReader(new FileReader(klinikfile));
        BufferedReader br2 = new BufferedReader(new FileReader(idfile));
        ArrayList tümidler = new ArrayList<>();
        tümidler.clear();
        while(true)
        {
            String yazi1 = br.readLine();
	    if (yazi1 != null) {
		tümidler.add(yazi1);
	    }
            else{
                break;
            }
        }
        for(i=0;i<tümidler.size();i++)
        {
            if(tümidler.get(i).toString().equals(a))
            {       
                kayıth=false;
                break;
            }
        }
        if(kayıth==true){
            oat.write(b.getBytes());
            oat.write(z.getBytes());
            out.write(a.getBytes());
            out.write(z.getBytes());
            oet.write(c.getBytes());
            oet.write(z.getBytes());
            oit.write(d.getBytes());
            oit.write(z.getBytes());
            opt.write(aldıalmadı.getBytes());
            opt.write(z.getBytes());
            oşt.write(a.getBytes());
            oşt.write(z.getBytes());
        }
        klinikler_doktor.clear();
        while(true){
            String yazil = br1.readLine();
            if (yazil != null){
                klinikler_doktor.add(yazil);
            }
            else
                break;
        }
        while(true)
        {
            String yazi1 = br2.readLine();
	    if (yazi1 != null) {
		idler.add(yazi1);
	    }
            else{
                break;
            }
        }
        i = idler.size()-1;
        
        return kayıth;
    }
}