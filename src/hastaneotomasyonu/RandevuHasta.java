
package hastaneotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.*;
import static hastaneotomasyonu.Poliklinikler.*;


public class RandevuHasta extends JFrame implements ActionListener{
    ArrayList poltf = new ArrayList<>();
    ArrayList arasinavlartf = new ArrayList<>();
    ArrayList finallertf = new ArrayList<>();
    ArrayList harfnotlarıtf = new ArrayList<>();
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
    JLabel arasınavl = new JLabel("Şikayet");
    JLabel arasınav1 = new JLabel();
    JLabel arasınav2 = new JLabel();
    JLabel arasınav3 = new JLabel();
    JLabel arasınav4 = new JLabel();
    JLabel arasınav5 = new JLabel();
    JLabel arasınav6 = new JLabel();
    JLabel arasınav7 = new JLabel();
    JLabel arasınav8 = new JLabel();
    JLabel arasınav9 = new JLabel();
    JLabel arasınav10 = new JLabel();
    JLabel finall = new JLabel("Tanı");
    JLabel final1 = new JLabel();
    JLabel final2 = new JLabel();
    JLabel final3 = new JLabel();
    JLabel final4 = new JLabel();
    JLabel final5 = new JLabel();
    JLabel final6 = new JLabel();
    JLabel final7 = new JLabel();
    JLabel final8 = new JLabel();
    JLabel final9 = new JLabel();
    JLabel final10 = new JLabel();
    JLabel harfnotul = new JLabel("Reçete");
    JLabel harfnotu1 = new JLabel();
    JLabel harfnotu2 = new JLabel();
    JLabel harfnotu3 = new JLabel();
    JLabel harfnotu4 = new JLabel();
    JLabel harfnotu5 = new JLabel();
    JLabel harfnotu6 = new JLabel();
    JLabel harfnotu7 = new JLabel();
    JLabel harfnotu8 = new JLabel();
    JLabel harfnotu9 = new JLabel();
    JLabel harfnotu10 = new JLabel();
    JButton anamenu = new JButton("Ana Menü");
    Font selam = new Font("selam", Font.BOLD, 15);
    Poliklinikler d = new Poliklinikler();
    int a = 50;
    RandevuHasta(){
        Poliklinikler.ArraylereAt();
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
        this.add(harfnotul);
        this.add(anamenu);
        
        poltf.clear();
        poltf.add(ders1);
        poltf.add(ders2);
        poltf.add(ders3);
        poltf.add(ders4);
        poltf.add(ders5);
        poltf.add(ders6);
        poltf.add(ders7);
        poltf.add(ders8);
        poltf.add(ders9);
        poltf.add(ders10);
        
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
        
        harfnotlarıtf.clear();
        harfnotlarıtf.add(harfnotu1);
        harfnotlarıtf.add(harfnotu2);
        harfnotlarıtf.add(harfnotu3);
        harfnotlarıtf.add(harfnotu4);
        harfnotlarıtf.add(harfnotu5);
        harfnotlarıtf.add(harfnotu6);
        harfnotlarıtf.add(harfnotu7);
        harfnotlarıtf.add(harfnotu8);
        harfnotlarıtf.add(harfnotu9);
        harfnotlarıtf.add(harfnotu10);
        
        derslerl.setVisible(true);
        derslerl.setBounds(50,10,100,50);
        derslerl.setFont(selam);
        
        arasınavl.setVisible(true);
        arasınavl.setBounds(200,10,100,50);
        arasınavl.setFont(selam);
        
        finall.setVisible(true);
        finall.setBounds(350,10,100,50);
        finall.setFont(selam);
        
        harfnotul.setVisible(true);
        harfnotul.setBounds(550,10,100,50);
        harfnotul.setFont(selam);
        
        anamenu.setVisible(true);
        anamenu.addActionListener(this);
        anamenu.setBounds(275,600,150,65);
        
        for(int j=0; j<poltf.size();j++){
            if(str[j].equals("t")){
                this.add((JLabel)poltf.get(j));
                this.add((JLabel)arasinavlartf.get(j));
                this.add((JLabel)finallertf.get(j));
                this.add((JLabel)harfnotlarıtf.get(j));
                
                
                ((JLabel)poltf.get(j)).setVisible(true);
                ((JLabel)arasinavlartf.get(j)).setVisible(true);
                ((JLabel)finallertf.get(j)).setVisible(true);
                ((JLabel)harfnotlarıtf.get(j)).setVisible(true);
                ((JLabel)poltf.get(j)).setBounds(50,a,100,50);
                ((JLabel)arasinavlartf.get(j)).setBounds(230,a,100,50);
                ((JLabel)finallertf.get(j)).setBounds(365,a,100,50);
                ((JLabel)harfnotlarıtf.get(j)).setBounds(580,a,100,50);
                ((JLabel)arasinavlartf.get(j)).setText(str3[j]);
                ((JLabel)finallertf.get(j)).setText(str4[j]);
                ((JLabel)harfnotlarıtf.get(j)).setText(str5[j]);
                
                if(((JLabel)arasinavlartf.get(j)).getText().equals("-")||((JLabel)finallertf.get(j)).getText().equals("-")){
                    
                }else{
                    int vize = parseInt(str3[j]);
                    int finalint = parseInt(str4[j]);
                    int ort = (vize*3)/10 + (finalint*7)/10;
                    if(ort < 30){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Parol");
                    }else if(ort < 45){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Oroferon");
                    }else if (ort < 50){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Apidra");
                    }else if (ort < 55){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Lantus");
                    }else if (ort < 70){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Thyromazol");
                    }else if (ort < 80){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Katarin");
                    }else if (ort < 90){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Majezik");
                    }else if(ort <= 100){
                        ((JLabel)harfnotlarıtf.get(j)).setText("Xanax");
                    }
                }
                a+=50;  
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == anamenu){
            this.dispose();
            new MainMenuHasta11();
        }
    }
}
