package games;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Main{
    public static void main(String[] args)
    {
        Mer mer= new Mer(1,2);
        mer.listeJoueurCase=mer.InitMer(mer.flotteJoueur);
        mer.InitMer(mer.flotteJoueurRand);

        while(!mer.isOver())
        {
            System.out.println(mer.AffichageMer());
            mer.SaisieJoueur();
            
        }
        System.out.println(mer.AffichageMer());
        mer.winner();
        //Fenetre F = new Fenetre ();
        

    }
}