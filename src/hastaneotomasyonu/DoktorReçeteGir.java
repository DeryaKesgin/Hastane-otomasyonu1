
package hastaneotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static hastaneotomasyonu.Poliklinikler.str3;
import static hastaneotomasyonu.Poliklinikler.str4;
import static hastaneotomasyonu.PolsDoktor.arrstrdoldur;


class DoktorReçeteGir extends JFrame implements ActionListener{
    ArrayList dersleral = new ArrayList<>();
    static ArrayList vizeler = new ArrayList<>();
    static ArrayList finaller = new ArrayList<>();
    ArrayList derslertf = new ArrayList<>();
    ArrayList arasinavlartf = new ArrayList<>();
    ArrayList finallertf = new ArrayList<>();
    JLabel derslerl = new JLabel("Poliklinikler");
    JLabel ders1 = new JLabel("Kardiyoloji");
    JLabel ders2 = new JLabel("Üroloji");
    JLabel ders3 = new JLabel("Endokrinoloji");
    JLabel ders4 = new JLabel("Cildiye");
    JLabel ders5 = new JLabel("KBB");
    JLabel ders6 = new JLabel("Göz");
    JLabel ders7 = new JLabel("Gastroenteroloji");
    JLabel ders8 = new JLabel("Genel Cerrahi");
    JLabel ders9 = new JLabel("Dahiliye");
    JLabel ders10 = new JLabel("Nefroloji");
    JLabel arasınavl = new JLabel("Tanı");
    JTextField arasınav1 = new JTextField();
    JTextField arasınav2 = new JTextField();
    JTextField arasınav3 = new JTextField();
    JTextField arasınav4 = new JTextField();
    JTextField arasınav5 = new JTextField();
    JTextField arasınav6 = new JTextField();
    JTextField arasınav7 = new JTextField();
    JTextField arasınav8 = new JTextField();
    JTextField arasınav9 = new JTextField();
    JTextField arasınav10 = new JTextField();
    JLabel finall = new JLabel("Reçete");
    JTextField final1 = new JTextField();
    JTextField final2 = new JTextField();
    JTextField final3 = new JTextField();
    JTextField final4 = new JTextField();
    JTextField final5 = new JTextField();
    JTextField final6 = new JTextField();
    JTextField final7 = new JTextField();
    JTextField final8 = new JTextField();
    JTextField final9 = new JTextField();
    JTextField final10 = new JTextField();
    JButton anamenu = new JButton("Ana Menü");
    JButton kaydet = new JButton("Kaydet");
    Font selam = new Font("selam", Font.BOLD, 15);
    PolsDoktor ogretim;
    Poliklinikler dersler;
    String[] arasinavstr = new String[10];
    String[] finalstr = new String[10];
    String[] ogrenciderslerstr = new String[10];
    String s = null;
    int a = 50;
    int sayim = 0;
    DoktorReçeteGir(){
        try {
            this.ogretim = new PolsDoktor();
            BufferedReader br = new BufferedReader(new FileReader("Hasta Poliklinik.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("Hasta Tanı.txt"));
            BufferedReader br3 = new BufferedReader(new FileReader("Hasta Şikayet.txt"));
            dersleral.clear();
            vizeler.clear();
            finaller.clear();
            while (true) {
	               String yazi = br.readLine();
                if (yazi != null) {
                    dersleral.add(yazi);
                } else {
                    break;
                }
            }   
            while (true) {
	               String yazi = br2.readLine();
                if (yazi != null) {
                    finaller.add(yazi);
                } else {
                    break;
                }
            } 
            while (true) {
	               String yazi = br3.readLine();
                if (yazi != null) {
                    vizeler.add(yazi);
                } else {
                    break;
                }
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoktorReçeteGir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoktorReçeteGir.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Reçete");
        this.add(derslerl);
        this.add(arasınavl);
        this.add(finall);
        this.add(anamenu);
        this.add(kaydet);
        
        derslertf.clear();
        derslertf.add(ders1);
        derslertf.add(ders2);
        derslertf.add(ders3);
        derslertf.add(ders4);
        derslertf.add(ders5);
        derslertf.add(ders6);
        derslertf.add(ders7);
        derslertf.add(ders8);
        derslertf.add(ders9);
        derslertf.add(ders10);
        
        arasinavlartf.clear();
        arasinavlartf.add(arasınav1);
        arasinavlartf.add(arasınav2);
        arasinavlartf.add(arasınav3);
        arasinavlartf.add(arasınav4);
        arasinavlartf.add(arasınav5);
        arasinavlartf.add(arasınav6);
        arasinavlartf.add(arasınav7);
        arasinavlartf.add(arasınav8);
        arasinavlartf.add(arasınav9);
        arasinavlartf.add(arasınav10);
        
        finallertf.clear();
        finallertf.add(final1);
        finallertf.add(final2);
        finallertf.add(final3);
        finallertf.add(final4);
        finallertf.add(final5);
        finallertf.add(final6);
        finallertf.add(final7);
        finallertf.add(final8);
        finallertf.add(final9);
        finallertf.add(final10);
        
        derslerl.setVisible(true);
        derslerl.setBounds(50,10,100,50);
        derslerl.setFont(selam);
        
        arasınavl.setVisible(true);
        arasınavl.setBounds(200,10,100,50);
        arasınavl.setFont(selam);
        
        finall.setVisible(true);
        finall.setBounds(350,10,100,50);
        finall.setFont(selam);
        
        anamenu.setVisible(true);
        anamenu.addActionListener(this);
        anamenu.setBounds(500,600,150,65);
        
        kaydet.setVisible(true);
        kaydet.addActionListener(this);
        kaydet.setBounds(50,600,150,65);
        
        ogrenciderslerstr = ((String)dersleral.get(DoktorReçeteGirHastaSeç.sıra)).split(",");
        
        for(int j=0; j<derslertf.size();j++){
            if(arrstrdoldur()[j].equals("t")&&ogrenciderslerstr[j].equals("t")){
                this.add((JLabel)derslertf.get(j));
                this.add((JTextField)arasinavlartf.get(j));
                this.add((JTextField)finallertf.get(j));
                
                ((JLabel)derslertf.get(j)).setVisible(true);
                ((JTextField)arasinavlartf.get(j)).setVisible(true);
                ((JTextField)finallertf.get(j)).setVisible(true);
                ((JLabel)derslertf.get(j)).setBounds(50,a,100,50);
                ((JTextField)arasinavlartf.get(j)).setBounds(220,a+14,30,25);
                ((JTextField)finallertf.get(j)).setBounds(355,a+14,30,25);
                sayim++;
                a+=50;  
            }else if(j == derslertf.size()-1 && sayim == 0){
                this.dispose();
                JOptionPane.showMessageDialog(this,"Bu Hastayı Tedavi Etmiyorsunuz.");
                new DoktorReçeteGirHastaSeç();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==anamenu){
            this.dispose();
            new MainMenuDoktor();
        }
        if(e.getSource()==kaydet){
            for(int j=0;j<derslertf.size();j++){
                if (arrstrdoldur()[j].equals("t")) {
                    if (((JTextField) arasinavlartf.get(j)).getText().isEmpty()) {
                        arasinavstr[j] = "-";
                    }
                    else{
                        if(isNumeric(((JTextField)arasinavlartf.get(j)).getText())){
                            if(parseInt(((JTextField)arasinavlartf.get(j)).getText()) < 0 || parseInt(((JTextField)arasinavlartf.get(j)).getText()) > 100){
                                JOptionPane.showMessageDialog(this,"Lütfen 0 ile 100 arasında bir değer giriniz!");
                                this.dispose();
                                new DoktorReçeteGir();
                                return;
                            }else{
                                arasinavstr[j] = ((JTextField) arasinavlartf.get(j)).getText();
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Lütfen Geçerli Bir Değer Giriniz!");
                            this.dispose();
                            new DoktorReçeteGir();
                            return;
                        }
                    }
                    if (((JTextField) arasinavlartf.get(j)).getText().isEmpty()) {
                        arasinavstr[j] = "-";
                    }
                    if (((JTextField) finallertf.get(j)).getText().isEmpty()) {
                        finalstr[j] = "-";
                    }
                    else{
                        if(isNumeric(((JTextField)finallertf.get(j)).getText())){
                            if(parseInt(((JTextField)finallertf.get(j)).getText()) < 0 || parseInt(((JTextField)finallertf.get(j)).getText())> 100){
                                JOptionPane.showMessageDialog(this,"Lütfen 0 ile 100 arasında bir değer giriniz!");
                                this.dispose();
                                new DoktorReçeteGir();
                                return;
                            }else{
                                finalstr[j] = ((JTextField) finallertf.get(j)).getText();
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Lütfen Geçerli Bir Değer Giriniz!");
                            this.dispose();
                            new DoktorReçeteGir();
                            return;
                        }
                    }
                    if (((JTextField) finallertf.get(j)).getText().isEmpty()) {
                        finalstr[j] = "-";
                    }
                }
            }
            Poliklinikler.ArraylereAtNot(DoktorReçeteGirHastaSeç.sıra);
            for (int k = 0; k < arasinavstr.length; k++) {
                if (arasinavstr[k] != null) {
                    str3[k] = arasinavstr[k];
                }
                if (finalstr[k] != null) {
                    str4[k] = finalstr[k];
                }
            }
            try {
                Poliklinikler.NotlarGirildi(DoktorReçeteGirHastaSeç.sıra);
            } catch (IOException ex) {
                Logger.getLogger(DoktorReçeteGir.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this,"Başarıyla Not Girildi!");
            this.dispose();
            new DoktorReçeteGirHastaSeç();
            
        }
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
