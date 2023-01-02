
package hastaneotomasyonu;

import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import hastaneotomasyonu.Poliklinikler;
import hastaneotomasyonu.PolsDoktor;
import hastaneotomasyonu.MainMenuHasta11;
import static hastaneotomasyonu.Poliklinikler.*;
import static hastaneotomasyonu.PolsDoktor.*;

class RandevuAlmaHasta extends JFrame implements ActionListener{
    static ArrayList saattf  = new ArrayList<>();
    static ArrayList poltf = new ArrayList<>();
    static ArrayList doktortf = new ArrayList<>();
    JCheckBox pol1 = new JCheckBox("Kardiyoloji",false);
    JCheckBox pol2 = new JCheckBox("Üroloji",false);
    JCheckBox pol3 = new JCheckBox("Endokrinoloji",false);
    JCheckBox pol4 = new JCheckBox("Cildiye",false);
    JCheckBox pol5 = new JCheckBox("KBB",false);
    JCheckBox pol6 = new JCheckBox("Göz",false);
    JCheckBox pol7 = new JCheckBox("Gastroenteroloji",false);
    JCheckBox pol8 = new JCheckBox("Genel Cerrahi",false);
    JCheckBox pol9 = new JCheckBox("Dahiliye",false);
    JCheckBox pol10 = new JCheckBox("Nefroloji",false);
    JLabel saatler = new JLabel();
    JLabel saat1 = new JLabel();
    JLabel saat2 = new JLabel();
    JLabel saat3 = new JLabel();
    JLabel saat4 = new JLabel();
    JLabel saat5 = new JLabel();
    JLabel saat6 = new JLabel();
    JLabel saat7 = new JLabel();
    JLabel saat8 = new JLabel();
    JLabel saat9 = new JLabel();
    JLabel saat10 = new JLabel();
    JLabel doktor1 = new JLabel();
    JLabel doktor2 = new JLabel();
    JLabel doktor3 = new JLabel();
    JLabel doktor4 = new JLabel();
    JLabel doktor5 = new JLabel();
    JLabel doktor6 = new JLabel();
    JLabel doktor7 = new JLabel();
    JLabel doktor8 = new JLabel();
    JLabel doktor9 = new JLabel();
    JLabel doktor10 = new JLabel();
    
    JLabel poliklinik1 = new JLabel("Poliklinikler");
    JLabel saatler1 = new JLabel("Saatler");
    JLabel doktor11 = new JLabel("Doktorlar"); 
    JButton kaydet = new JButton("Kaydet");
    JButton anamenü = new JButton("Ana Menü");
    Font selam = new Font("selam", Font.BOLD, 15);
    Poliklinikler d = new Poliklinikler();
    PolsDoktor ogretim;
    int a = 50;
    int b = 50;
    int toplamkredi = 0;
    RandevuAlmaHasta(){
        Poliklinikler.ArraylereAt();
        try {
            this.ogretim = new PolsDoktor();
        } catch (IOException ex) {
            Logger.getLogger(RandevuAlmaHasta.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Hasta Randevu Alma");
        this.add(kaydet);
        this.add(anamenü);
        this.add(poliklinik1);
        this.add(saatler1);
        this.add(doktor11);
        this.add(saatler);
       
        
        doktortf.clear();
        doktortf.add(doktor1);
        doktortf.add(doktor2);
        doktortf.add(doktor3);
        doktortf.add(doktor4);
        doktortf.add(doktor5);
        doktortf.add(doktor6);
        doktortf.add(doktor7);
        doktortf.add(doktor8);
        doktortf.add(doktor9);
        doktortf.add(doktor10);
        
        
        poltf.clear();
        poltf.add(pol1);
        poltf.add(pol2);
        poltf.add(pol3);
        poltf.add(pol4);
        poltf.add(pol5);
        poltf.add(pol6);
        poltf.add(pol7);
        poltf.add(pol8);
        poltf.add(pol9);
        poltf.add(pol10);
        
        saattf.clear();
        saattf.add(saat1);
        saattf.add(saat2);
        saattf.add(saat3);
        saattf.add(saat4);
        saattf.add(saat5);
        saattf.add(saat6);
        saattf.add(saat7);
        saattf.add(saat8);
        saattf.add(saat9);
        saattf.add(saat10);
        
    
        doktor11.setVisible(true);
        doktor11.setBounds(450,10,100,50);
        doktor11.setFont(selam);
        
        saatler1.setVisible(true);
        saatler1.setBounds(265,10,100,50);
        saatler1.setFont(selam);
        
        poliklinik1.setVisible(true);
        poliklinik1.setBounds(125,10,100,50);
        poliklinik1.setFont(selam);
        
        anamenü.setVisible(true);
        anamenü.addActionListener(this);
        anamenü.setBounds(455,600,150,65);
        
        kaydet.setVisible(true);
        kaydet.addActionListener(this);
        kaydet.setBounds(95,600,150,65);
        
        for(int j = 0; j < poltf.size(); j++){
            this.add((JCheckBox)poltf.get(j));
            ((JCheckBox)poltf.get(j)).setVisible(true);
            ((JCheckBox)poltf.get(j)).setBounds(100,a,200,50);
            if(str[j].equals("t")){
                ((JCheckBox)poltf.get(j)).setSelected(true);
            }
            else if(str[j].equals("f")){
                ((JCheckBox)poltf.get(j)).setSelected(false);
            }
            if(((JCheckBox)poltf.get(j)).isSelected()){
                toplamkredi = toplamkredi + parseInt(str2[j]);
            }
            a += 50;
        }
        for(int j=0; j<saattf.size(); j++){
            this.add((JLabel)saattf.get(j));
            ((JLabel)saattf.get(j)).setVisible(true);
            ((JLabel)saattf.get(j)).setBounds(300,b,100,50);
            ((JLabel)saattf.get(j)).setText(str2[j]);
            this.add((JLabel)doktortf.get(j));
            ((JLabel)doktortf.get(j)).setVisible(true);
            ((JLabel)doktortf.get(j)).setBounds(450,b,100,50);
            ((JLabel)doktortf.get(j)).setText(PolsDoktor.arrstr2[j]);
            b += 50;
        }
        
        saatler.setVisible(true);
        saatler.setBounds(300,550,100,50);
       
        saatler.setFont(selam);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == anamenü){
            this.dispose();
            new MainMenuHasta11();
        }
        
        if(e.getSource() == kaydet){
            toplamkredi=0;
            for(int j=0; j<poltf.size();j++){
                if(((JCheckBox)poltf.get(j)).isSelected()){
                toplamkredi = toplamkredi + parseInt(str2[j]);
            }
            }
         
           
                for(int j=0; j<poltf.size(); j++){
                    if(j<poltf.size()-1){
                        if(((JCheckBox)poltf.get(j)).isSelected()){
                            Poliklinikler.klinikler.add("t,");
                        }
                        else
                            Poliklinikler.klinikler.add("f,");
                    }
                    else{
                        if(((JCheckBox)poltf.get(j)).isSelected()){
                            Poliklinikler.klinikler.add("t");
                        }
                        else
                            Poliklinikler.klinikler.add("f");
                    }
                }
                try {    
                    d.DersSecGecici();
                } catch (IOException ex) {
                    Logger.getLogger(RandevuAlmaHasta.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    d.DersSec(Poliklinikler.klinikler);
                    JOptionPane.showMessageDialog(this, "Randevu Kaydı Başarılı!");
                    Poliklinikler.klinikler.clear();
                    this.dispose();
                    new RandevuAlmaHasta();

                } catch (IOException ex) {
                    Logger.getLogger(RandevuAlmaHasta.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    }
}
