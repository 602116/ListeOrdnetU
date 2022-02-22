package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

    private final static int STDK = 100;
    private final static int IKKE_FUNNET = -1;
    private int bak;
    private T[] liste;

    public TabellOrdnetListe() {
        this(STDK);
    }

    public TabellOrdnetListe(int startKapasitet) {
        bak = 0;
        liste = (T[]) (new Comparable[startKapasitet]);
    }

    @Override
    public T fjernSiste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return fjern(siste());
    }

    @Override
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return fjern(foerste());
    }

    @Override
    public T foerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");


        return liste[0];
    }

    @Override
    public T siste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");


        return liste[bak - 1];
    }

    @Override
    public boolean erTom() {
        return (bak == 0);
    }

    @Override
    public int antall() {
        return bak;
    }

    @Override
    public void leggTil(T element) {
        int i = 0;
        if (bak == liste.length) utvid();
        if (erTom()) {
            liste[bak] = element;
        } else {
            while (i < bak && element.compareTo(liste[i]) > 0) {
                i++;
            }
            for (int j = bak; j > i; j--) {
                liste[j] = liste[j - 1];
            }
            liste[i] = element;

        }
        bak++;
    }

    @Override
    public boolean inneholder(T element) {
        return (finn(element) != IKKE_FUNNET);
    }

    @Override
    public T fjern(T element) {

        if (inneholder(element)) {
            for (int i = finn(element); i < bak ; i++) {
                liste[i] = liste [i+1];
            }

            bak--;

            return element;
        } else {
            return null;
        }


    }

    private int finn(T el) {

        for (int i = 0; i < bak; i++) {
            if (liste[i] == null) {
                return IKKE_FUNNET;
            }
            if (liste[i].equals(el)) return i;

        }
        return IKKE_FUNNET;
    }

    public String toString() {
        String resultat = "";

        for (int i = 0; i < bak; i++) {
            resultat = resultat + liste[i].toString() + "\n";
        }
        return resultat;
    }

    private void utvid() {
        T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

        for (int i = 0; i < liste.length; i++) {
            hjelpeTabell[i] = liste[i];
        }

        liste = hjelpeTabell;
    }

}// class
