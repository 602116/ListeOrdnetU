package no.hvl.dat102.listeklient;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrdnetListeADT<Person> kjedet = new KjedetOrdnetListe<>();
        OrdnetListeADT<Person> tabell = new TabellOrdnetListe<>();

        Person anne = new Person("Anne", "Vik", 1996);
        Person ole = new Person("Ole", "Vik", 1996);
        Person bendik = new Person("Bendik", "Vik", 1996);

        kjedet.leggTil(anne);
        kjedet.leggTil(ole);
        kjedet.leggTil(bendik);

        tabell.leggTil(anne);
        tabell.leggTil(ole);
        tabell.leggTil(bendik);

//        for (int i = 0; i < 0; i++) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Fornavn, Etternavn, Aor");
//            Person person = new Person(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
//            kjedet.leggTil(person);
//            tabell.leggTil(person);
//
//        }
        System.out.println("Kjedet");
        int prints = kjedet.antall();;
        for (int i = 0; i < prints; i++) {
            System.out.println(kjedet.siste());
            kjedet.fjernSiste();


        }
        System.out.println("Tabell");
        for (int i = 0; i < prints; i++) {
            System.out.println(tabell.siste());
            tabell.fjernSiste();

        }



    }

}
