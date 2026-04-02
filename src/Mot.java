// VOUS POUVEZ MODIFIER CE FICHIER

import java.util.Arrays;

public class Mot {
    private char[] lettres;
    private int nbLettres;

    public Mot suivant = null;

    public Mot() {
        lettres = new char[0];
        nbLettres = 0;
    }

    public Mot(String str) {
        assert str.indexOf(' ') == -1 : "Un mot ne peut contenir d'espaces";
        lettres = str.toCharArray();
        nbLettres = str.length();
    }

    // AJOUTEZ VOTRE CODE CI-DESSOUS

    public int getLongueur() {
        return this.nbLettres;
    }

    public char getLettre(int index) {
        if (index < 0 || index >= this.nbLettres) {
            return '\0';
        }
        return this.lettres[index];
    }

    public void ajouter(char c) {
        char[] newLettres = new char[this.nbLettres + 1];
        for (int i = 0; i < this.nbLettres; i++) {
            newLettres[i] = this.lettres[i];
        }
        newLettres[this.nbLettres] = c;
        this.lettres = newLettres;
        this.nbLettres++;
    }


    public boolean inserer(char c, int index) {
        if (index < 0 || index > this.nbLettres) {
            return false;
        }

        char[] newLettres = new char[this.nbLettres + 1];

        for (int i = 0; i < index; i++) {
            newLettres[i] = this.lettres[i];
        }

        newLettres[index] = c;

        for (int i = index; i < this.nbLettres; i++) {
            newLettres[i + 1] = this.lettres[i];
        }

        this.lettres = newLettres;
        this.nbLettres++;

        return true;
    }

    @Override
    public String toString() {
        String resultat = "";

        for (int i = 0; i < lettres.length; i++) {
            resultat += lettres[i];
        }

        return resultat;
    }
}
