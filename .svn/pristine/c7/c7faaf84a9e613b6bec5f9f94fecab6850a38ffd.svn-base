package games;
import java.util.*;
import java.awt.*;


public class Aleatoire
{
    protected int alea= NombreAleatoire(2);
    protected final static int [] nbBateau = {2,3,3,4,5};

    public Aleatoire()
    {
        
    }

    /////// Fonction aléatoire ////////
    // Tirer un nombre aleatoire
    public int NombreAleatoire(int alea)
    {
        int nombre=0;
        Random r = new Random();
        nombre=r.nextInt(alea);
        return nombre;
    }

    ////Convertis un entier en une ligne de la grille //////
    public int Ligne(int place)
    {
        int ligne=0;int i=0;int debut=0;
        int fin=10;
        // incrémenter les lignes de 0 jusqu'a 10 
        while(i!=10)
        {   
            // Tester si le coup est entre deux valeurs 
            if(place>=debut && place<fin)
            {
                ligne=i;
                return ligne;
            }
            i++;
            debut+=10;
            fin+=10;

        }
        return ligne;    
    }

         

    public int Colonne(int place)
    {
        int colonne=0;
        
        return colonne = place%10;

    }



    public boolean testcaseValide(int ligne,int colonne,int [][] flotte)
    {
        if(flotte[ligne][colonne]==0)
        {
            return true;
        }
        return false;
    }



// Incrementer l'indice retourner -1 si la case n'est pas vide 
public int testindice(int coup,int ligne,int colonne,int [][] flotte,int indice,int direction)
{
    ///Test de l'indice ligne ou colonne selon entrée ///
    int valeurdirection=direction*10;
    // indice plus petit que 4 incrementer la case
    if(indice<=4)
    {
        coup=coup+((valeurdirection-direction)+1);
    }
    if(indice>=5)
    {
        coup=coup-(valeurdirection);
        if(direction==0)
        {
            coup=coup-1;
        }
    }
     // Test qui retourne -1 si un coup est sur une case deja prise //    
    if(testcaseValide(ligne,Colonne(coup),flotte)!=true && indice==colonne && direction==0)
    {
        return -1;
    }
    if(testcaseValide(Ligne(coup),colonne,flotte)!=true && indice==ligne && direction==1)
    {
        return -1;
    }
return coup;
}

// Tester si des bateau se touche si -1 retourner vrai
public boolean testBateauAdjacent(int coup,int ligne,int colonne,int [][]flotte,int indice,int nbcase,int direction)
{
    
    for(int i=0;i<nbcase;i++)
    {
        coup=testindice(coup,ligne,colonne,flotte,indice,direction);
        if(coup==-1)
        {
            return true;
        }
    }
    return false;
}

    //TEST AVANT SI TESTBATEAUADJ == FALSE
    public void TirageBateau(ArrayList<Integer> bateauCase,int ligne,int colonne,int coup,int [][]flotte,int indice,int nbcase,int direction)
    {
     
        //ajouter les case de l'array liste
        for(int i=0;i<nbcase;i++)
        {
            bateauCase.add(coup);
            coup=testindice(coup,ligne,colonne,flotte,indice,direction);
        }

    }

       

/////////////////////////////////////////////////
}