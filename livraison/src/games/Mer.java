package games;
import java.util.*;

public class Mer {

    private final static int [] valeurCase = {0,1,2,3};
    protected int [][] flotteJoueurRand;
    protected int [][] flotteJoueur;
    private int JoueurCourrant;
    private int Joueur;
    private int JoueurRandom;
    //Nombre de case bateau 
    private int caseBateauJoueur=17; 
    private int caseBateauRand=17;
    protected ArrayList<Integer> listeJoueurCase = new ArrayList<Integer> ();
    protected ArrayList<Integer> listeMeilleur = new ArrayList<Integer> ();
    protected Aleatoire A = new Aleatoire();
    

    public Mer(int Joueur,int JoueurRandom)
    {
        this.Joueur=Joueur;
        this.JoueurRandom=JoueurRandom;
        this.JoueurCourrant=Joueur;
        this.flotteJoueurRand = new int [10][10];
        this.flotteJoueur = new int [10][10];

    }

    public int getJoueurCourrant()
    {
        return this.JoueurCourrant;
    }
    public int getOtherJoueur()
    {
        if(this.JoueurCourrant==this.JoueurRandom)
        {
            return this.Joueur;
        }
        return this.JoueurRandom;
    }
    public void ChangeJoueurCourrant()
    {
        if(JoueurCourrant==this.Joueur)
        {
            this.JoueurCourrant=this.JoueurRandom;
        }
        else {
            this.JoueurCourrant=this.Joueur;
        }
    }
    public String getName(int joueur)
    {
        if(joueur==1)
        {
            return " Joueur ";
        }
        return " Random ";
    }

    public void setFlotte(int valeur,int ligne,int colonne,int [][]flotte)
    {
        flotte[ligne][colonne]=valeur;
    }

    //Met la valeur en parametre dans la flotte du joueur choisi
    public void setFlotteJoueur(int valeur,int ligne,int colonne,int joueur)
    {
        if(joueur==this.Joueur)
        {
            setFlotte(valeur,ligne,colonne,this.flotteJoueur);
        }
        else {
            setFlotte(valeur,ligne,colonne,this.flotteJoueurRand);
        }
    }

    public int getValeurFlotte(int ligne,int colonne,int [][]flotte)
    {
        return flotte[ligne][colonne];
    }
    // Retourn la valeur de la flotte du joueur choisi
    public int getFlotte(int ligne,int colonne,int joueur)
    {
        if(joueur==this.Joueur)
        {
            return getValeurFlotte(ligne,colonne,this.flotteJoueur);
        }

        return getValeurFlotte(ligne,colonne,this.flotteJoueurRand);
        
    }

    public int getcaseBateauJoueur()
    {
        return this.caseBateauJoueur;
    }

    public int getcaseBateauRand()
    {
        return this.caseBateauRand;
    }

    public void setcaseBateau(int joueur)
    {
        if(joueur==this.Joueur)
        {
            this.caseBateauJoueur--;
        }
        else {
            this.caseBateauRand--;
        }
    }


    public ArrayList<Integer> listemeilleurCoup(int depart,int taille,ArrayList<Integer> flotteJoueur)
    {
        ArrayList<Integer> liste = new ArrayList<Integer>();
        for(int i=depart;i<taille;i++)
        {
            liste.add(flotteJoueur.get(i));
        }
        return liste;
    }


   public ArrayList<Integer> getMeilleurCoup(int ligne,int colonne)
   {
       int cmptListe=0;
       ArrayList<Integer> liste = new ArrayList<Integer> ();
       for(int i=0;i<5;i++)
       {
        
            int nbBat=A.nbBateau[i]+cmptListe;
            for(int j=cmptListe;j<nbBat;j++)
            {
                if(A.Ligne(this.listeJoueurCase.get(j))==ligne && A.Colonne(this.listeJoueurCase.get(j))==colonne)
                {
                   liste=listemeilleurCoup(cmptListe,nbBat,this.listeJoueurCase);
                }
            }
            cmptListe=nbBat;
       }
       return liste;

   }

    public ArrayList<Integer> InitMer(int [][] flotte)
    {
        ArrayList<Integer> bateauCase= new ArrayList<Integer>();
        for(int i=0;i<5;i++)
        {
            int compteurBateau=A.nbBateau[i];
            int cmptListe=0;
            int nbalea=A.NombreAleatoire(99);
            int direction = A.NombreAleatoire(2);
            int ligne=A.Ligne(nbalea);
            int colonne=A.Colonne(nbalea);
          


            // Remplir horizontal
            if(direction==0)
            {
                //Test ne pas tirer une case deja tirer 
                 while(A.testBateauAdjacent(nbalea,ligne,colonne,flotte,colonne,compteurBateau,direction)==true || bateauCase.contains(nbalea))
                {
                    nbalea=A.NombreAleatoire(100);
                    ligne=A.Ligne(nbalea);
                    colonne=A.Colonne(nbalea);
                }
                A.TirageBateau(bateauCase,ligne,colonne,nbalea,flotte,colonne,compteurBateau,direction);
            }
            //Remplir vertical 
            if(direction==1)
            {
                //Test ne pas tirer une case deja tirer 
                while(A.testBateauAdjacent(nbalea,ligne,colonne,flotte,ligne,compteurBateau,direction)==true || bateauCase.contains(nbalea))
                {
                    nbalea=A.NombreAleatoire(100);
                    ligne=A.Ligne(nbalea);
                    colonne=A.Colonne(nbalea);
                }
                A.TirageBateau(bateauCase,ligne,colonne,nbalea,flotte,ligne,compteurBateau,direction);
            
            }
            //REMPLISSAGE DE LA FLOTTE DU JOUEUR EN PARAMETRE 
            for(int t = cmptListe;t<bateauCase.size();t++)
            {
                int place = bateauCase.get(t);
                flotte[A.Ligne(place)][A.Colonne(place)]=1;
            }
            cmptListe+=compteurBateau;
        }
        return bateauCase;
    }
   
    public boolean SortiePlateau(int ligne,int colonne)
    {
        if(ligne<0 || ligne >9  || colonne >9 || colonne <0)
        {
            return true;
        }
        return false;
        
    }
    
    public boolean isValid(int ligne,int colonne)
    {
        if(!SortiePlateau(ligne,colonne) && getFlotte(ligne,colonne,getOtherJoueur())!=2 && getFlotte(ligne,colonne,getOtherJoueur())!=3)
        {
            return true;
        }
        return false;
    }
    
    public void SaisieJoueur()
    {
            Scanner scanner=new Scanner(System.in);
            int ligne=0;
            int colonne=0;
            //Affichage saisie du coup 
            if(getJoueurCourrant()==1)
            {
                System.out.println(" \n " + "Joueur Saisir ligne à jouer : ");
                ligne=scanner.nextInt();
                System.out.println("Saisir colonne à jouer : ");
                colonne=scanner.nextInt();

                //Tant que coup non valide 
                while(!isValid(ligne,colonne))
                {
                    System.out.println("Erreur ! Saisir ligne à jouer : ");
                    ligne=scanner.nextInt();
                    System.out.println("Saisir colonne à jouer : ");
                    colonne=scanner.nextInt();
                }  
            }
            //SInon tirer une ligne et colonne pour random
            else {
                                
                ligne=A.NombreAleatoire(10);
                colonne=A.NombreAleatoire(10);
                while(!isValid(ligne,colonne))
                {
                    ligne=A.NombreAleatoire(10);
                    colonne=A.NombreAleatoire(10);
                }
               
                if(this.listeMeilleur.size()!=0)
                {
                    for(int i : this.listeMeilleur)
                    {
                        if(isValid(A.Ligne(i),A.Colonne(i)))
                        {
                            ligne=A.Ligne(i);
                            colonne=A.Colonne(i);
                        }
                    }
                }
                this.listeMeilleur=getMeilleurCoup(ligne,colonne);
            }
        play(ligne,colonne);
    }




    public void play(int ligne,int colonne)
    {
       
            //Case vide = 0 
            if(getFlotte(ligne,colonne,getOtherJoueur())==valeurCase[0])
            {
                setFlotteJoueur(valeurCase[2],ligne,colonne,getOtherJoueur());
                
            }
            //Case contenant bateau = 1
            else{
                setFlotteJoueur(valeurCase[3],ligne,colonne,getOtherJoueur());
                //decrementer 
                setcaseBateau(getOtherJoueur());
            }
        
        ChangeJoueurCourrant();
    }

    public int win()
    {
        // Retourner le joueur rand si le joueur n'a plu de bateau 
        if(getcaseBateauJoueur()==0)
        {
            return this.JoueurRandom;
        }
        else if (getcaseBateauRand()==0)
        {
            return this.Joueur;
        }
        // Partie en cours 
        return 0;
    }
    public void winner()
    {
        
        if(win()==1)
        {
            System.out.println("Vous avez gagné ! ");
        }
        else {
            System.out.println("Le joueur random à gagné ! ");
        }
        
    }
    public boolean isOver()
    {
        if(win()==0)
        {
            return false;
        }
        return true;
    }

    public String Affichage(int [][] flotte,int joueur)
    {
        String res = " ";
        int tmp=0;  

    for(int i=0;i<10;i++)
    { 
        res+=" " + i + " ";
    }
        for(int i=0;i<10;i++){
            
            res+=System.lineSeparator();
            res+=i;
            
        for(int j=0;j<10;j++){

                if(flotte[i][j]==valeurCase[0])
                {
                res+="   ";
                }
                if(flotte[i][j]==valeurCase[1])
                {
                    if(joueur==this.Joueur)
                    {
                        res+=" - ";
                    }
                    else {
                        res +="   ";
                    }
                }
                if(flotte[i][j]==valeurCase[2])
                {
                    res+=" ! ";
                }
                if(flotte[i][j]==valeurCase[3])
                {
                    res+=" X ";
                }
                
                tmp++;
        }
    }

    return res;
    }

    public String AffichageMer()
    {
        String res="Mer Joueur " + System.lineSeparator();
        res+=Affichage(this.flotteJoueur,this.Joueur);
        res+=System.lineSeparator()+" Mer Joueur Random " + System.lineSeparator();
        res+=Affichage(this.flotteJoueurRand,this.JoueurRandom);
        return res;
    }
}