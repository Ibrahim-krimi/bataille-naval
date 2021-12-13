package games;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Fenetre extends JFrame{
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2= new JPanel();
    private GridLayout grid = new GridLayout(10,10);


  public Fenetre(){
    this.setTitle("Bataille-Navale");
    //Taille fenetre et quitter fenetre quand cliquer 
    this.setSize(1200, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Centrer la fentre 
    this.setLocationRelativeTo(null);
  
     Container cp=this.getContentPane();
      //Fond blanc 
    cp.setBackground(Color.white);
    jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel1.setLayout(grid);
    jPanel1.setBackground(Color.white);        
    for(int i=0;i<100;i++)
    {
      JButton bouton = new JButton();
      bouton.setBackground(Color.white);
      jPanel1.add(bouton);      
      
    }
    JButton suivant = new JButton("suivant");
    cp.setLayout(new BorderLayout());
    cp.add(suivant,BorderLayout.NORTH);
    cp.add(jPanel1,BorderLayout.WEST);
    cp.add(jPanel2,BorderLayout.EAST);  
    //Trois lignes sur deux colonnes
    //jPanel1.setLayout(new GridLayout(3, 2));
    //this.pack();
    this.setVisible(true);
 
  } 
}