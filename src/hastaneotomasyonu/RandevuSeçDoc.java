
package hastaneotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static hastaneotomasyonu.PolsDoktor.*;
import static hastaneotomasyonu.KayitDoktor.*;


class RandevuSeçDoc extends JFrame implements ActionListener{
    ArrayList derslertf = new ArrayList<>();
    JButton geri = new JButton("Geri Dön");
    JButton kayıt = new JButton("Kaydet");
    JLabel derslerl = new JLabel("Poliklinikler");
    JCheckBox ders1 = new JCheckBox("Kardiyoloji", false);
    JCheckBox ders2 = new JCheckBox("Üroloji", false);
    JCheckBox ders3 = new JCheckBox("Endokrinoloji", false);
    JCheckBox ders4 = new JCheckBox("Cildiye", false);
    JCheckBox ders5 = new JCheckBox("KBB", false);
    JCheckBox ders6 = new JCheckBox("Göz", false);
    JCheckBox ders7 = new JCheckBox("Gastroenteroloji", false);
    JCheckBox ders8 = new JCheckBox("Genel Cerrahi", false);
    JCheckBox ders9 = new JCheckBox("Dahiliye", false);
    JCheckBox ders10 = new JCheckBox("Nefroloji", false);
    Font selam = new Font("selam", Font.BOLD, 15);
    String a = null,b = null,c = null,d = null;
    int e = 50;
    Doktor ogretim;
    PolsDoktor derslerc;
    RandevuSeçDoc(){
        try {
            this.ogretim = new Doktor();
        } catch (IOException ex) {
            Logger.getLogger(RandevuSeçDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.derslerc = new PolsDoktor();
        } catch (IOException ex) {
            Logger.getLogger(RandevuSeçDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Doktor Kayıt");
        this.add(derslerl);
        this.add(kayıt);
        this.add(geri);
        
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
        
        derslerl.setVisible(true);
        derslerl.setBounds(100,10,100,50);
        derslerl.setFont(selam);
        
        kayıt.setVisible(true);
        kayıt.setBounds(300,575,100,25);
        kayıt.addActionListener(this);
        
        geri.setVisible(true);
        geri.setBounds(300,610,100,25);
        geri.addActionListener(this);
        
        for(int j=0; j<derslertf.size();j++){
            this.add((JCheckBox)derslertf.get(j));
            ((JCheckBox)derslertf.get(j)).setVisible(true);
            ((JCheckBox)derslertf.get(j)).setBounds(100,e,150,50);
            e+=50;
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == kayıt){
            for (int j = 0; j < derslertf.size(); j++) {
                if (j < derslertf.size() - 1) {
                    if (((JCheckBox) derslertf.get(j)).isSelected()) {
                        dersler.add("t,");
                    } else {
                        dersler.add("f,");
                    }
                } else {
                    if (((JCheckBox) derslertf.get(j)).isSelected()) {
                        dersler.add("t");
                    } else {
                        dersler.add("f");
                    }
                }
            }
            try {
                derslerc.DersSecGecici();
                ogretim.kayıt(a, b, c, d);
                if(Doktor.kayıth){
                    derslerc.DersSecOgretim(dersler);
                    JOptionPane.showMessageDialog(this, "Ders Seçme Başarılı!");
                    dersler.clear();
                }else{
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(KayitHasta.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Doktor.kayıth) {
                JOptionPane.showMessageDialog(this, "Kayıt Başarılı!");
            } else {
                JOptionPane.showMessageDialog(this, "Varolan ID ile kayıt olunamaz", "Kayıt Başarısız!", HEIGHT);
            }
            this.dispose();
            new MainMenuPersonel();
        }
        if(e.getSource() == geri){
            this.dispose();
            new KayitDoktor();
        }
    }
}
