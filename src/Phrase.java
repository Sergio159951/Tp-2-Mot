// VOUS POUVEZ MODIFIER CE FICHIER

public class Phrase {
    private Mot premier, dernier;
    private int nbMots;

    public Phrase() {
        // N'hésitez pas à modifier ce constructeur au besoin.
        // Vos changements seront automatiquement appliqués au constructeur ci-dessous.
        premier = dernier = null;
        nbMots = 0;
    }

    public Phrase(String str) {
        // Cette fonction initialise la phrase en ajoutant chaque mot de 'str' un par un.
        // Vous devrez coder la méthode ajouter(Mot mot) pour que cela fonctionne.
        this();
        String[] mots = str.split("\s");
        for (String mot : mots)
            ajouter(new Mot(mot));
    }

    public void ajouter(String str) {
        ajouter(new Phrase(str));
    }

    public boolean inserer(String str, int indexMot) {
        return inserer(new Phrase(str), indexMot);
    }

    // AJOUTEZ VOTRE CODE CI-DESSOUS

    public int getNbMots(){
        return nbMots;
    }

    public int getLongueur(){
        int tailleTotal = 0;
        Mot courant = premier;

        while(courant != null){
            tailleTotal += courant.getLongueur();
            if (courant.suivant == null){
                tailleTotal++;
            }
            courant = courant.suivant;
        }

        return tailleTotal;
    }

    public Mot getMot(int indexMot){
        Mot courant = premier;

        if(indexMot < 0 || indexMot >= nbMots){
            return null;
        }

        for(int i = 0; i < indexMot; i++){
            courant = courant.suivant;
        }

        return courant;
    }

    public char getLettre(int indexMot){
        if(indexMot < 0 || indexMot > getLongueur()){
            return '-';
        }
        Mot courant = premier;
        int position = 0;

        while(courant != null){
            if(indexMot < position + courant.getLongueur()){
                return courant.getLettre(indexMot - position);
            }
            position += courant.getLongueur();
            if(indexMot == position){
                return ' ';
            }
            position++;
            courant = courant.suivant;
        }
        return '-';
    }

    public char getLettre(int indexMot, int indexLettre){
        Mot mot = getMot(indexMot);
        if(mot != null){
            return mot.getLettre(indexLettre);
        }
        return '-';
    }

    public void ajouter(Mot mot) {
        Mot courant = premier;
        if(courant == null){
            premier = mot;
            dernier = mot;
            return;
        }else {
            dernier.suivant = mot;
            dernier = courant;
        }
        dernier.suivant = null;

        nbMots++;
    }

    public void ajouter(Phrase autre) {
        if (autre == null && autre.premier == null){
            return;
        }

        if(this.premier == null){
            this.premier = autre.premier;
            this.dernier = autre.dernier;
        }else {
            this.dernier.suivant = autre.premier;
            this.dernier = autre.dernier;
        }

        this.nbMots += autre.getNbMots();
    }

    public boolean inserer(Phrase autre, int indexMot) {
        if(autre == null || autre.premier == null){
            return false;
        }
        if(indexMot < 0 || indexMot >= nbMots){
            return false;
        }
        
        if(indexMot == 0){
            autre.dernier.suivant = premier;
            if(premier == null){
               dernier = autre.dernier;
            }
            premier = autre.premier;
        }else if (indexMot == nbMots) {
            dernier.suivant = autre.premier;
            dernier = autre.dernier;
        }else{
            Mot avant = getMot(indexMot - 1);
            autre.dernier.suivant = avant.suivant;
            avant.suivant = autre.premier;
        }
        nbMots += autre.nbMots;
        return true;
    }
}
