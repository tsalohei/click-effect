package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import clicker.sovelluslogiikka.OmaLaskuri;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Laskuri laskuri;
    
    public Kayttoliittyma(){
        this.laskuri = new OmaLaskuri();
    }
    
    @Override
    public void run() {
        frame = new JFrame("The Effect");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JLabel lukema = new JLabel(Integer.toString(this.laskuri.annaArvo()));
        JButton nappi = new JButton("Click!");
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(this.laskuri, lukema);
        nappi.addActionListener(kuuntelija);
        
        container.add(lukema);
        container.add(nappi, BorderLayout.SOUTH);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
