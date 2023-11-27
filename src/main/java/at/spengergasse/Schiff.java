package at.spengergasse;

import java.util.ArrayList;

public class Schiff {
    private int kanonen;
    private char typ;
    private Pirat kapitaen;
    private Pirat[] piraten;


    // Konstruktor
    public Schiff(char typ) {
        setTyp(typ);
    }

    // Getter und Setter-Methoden
    public char getTyp() {
        return typ;
    }

    public void setTyp(char typ) {
        if (typ == 's' || typ == 'b' || typ == 'f' || typ == 'g') {
            this.typ = typ;
        } else {
            throw new IllegalArgumentException("Harr! Der Schiffstyp " + typ + " ist zu raeudig!");
        }
    }

    // Methode zur Initialisierung der Kanonen abhängig vom Schiffstyp
    private void kanonenKlarmachen() {
        switch (typ) {
            case 's':
                kanonen = 1;
                break;
            case 'b':
                kanonen = 2;
                break;
            case 'f':
                kanonen = 5;
                break;
            case 'g':
                kanonen = 8;
                break;
            default:
                System.out.println("Arrgh! Schaebige Schnigge vom Typ \"" + typ + "\" ist nicht wuerdig gesegelt zu werden!");
        }
    }



    public int getKanonen() {
        return this.kanonen;
    }

    // Methode zum Anheuern eines Piraten
    public void anheuern(Pirat pirat) {
        if (kapitaen == null) {
            this.kapitaen = pirat;
            this.kapitaen.setSchiff(this);
            return;
        }
        for (int i = 0; i < piraten.length; i++) {
            if (piraten[i] == null) {
                piraten[i] = pirat;
                piraten[i].setSchiff(this);
                return;
            }
        }
        throw new IllegalArgumentException("Arrg! Kein Grog mehr fuer den neuen Trunkenbold! Voll besetzt! Typ= " + typ);
    }

    // Methode zur Ausgabe der Informationen über das Schiff und die Besatzung
    public String toString() {
        String rw;
        switch (this.getTyp()) {
            case 's' -> rw = "Crew Schaluppe (3): " + "\n" + "______________________" + "\n";
            case 'b' -> rw = "Brigg (4): " + "\n" + "______________________" + "\n";
            case 'f' -> rw = "Frigatte (5): " + "\n" + "______________________" + "\n";
            case 'g' -> rw = "Galeone (6): " + "\n" + "______________________" + "\n";
            default -> throw new IllegalArgumentException("Falsche Bezeichnung!");
        } ;
        rw += this.kapitaen.toString() + "\n";
        for (int i = 0; i < piraten.length; i++) {
            rw += piraten[i].toString();
        }
        return rw;
    }

    // Methode zur Ausgabe der Schiffsinformationen
    private String getSchiffBezeichnung() {
        switch (typ) {
            case 's':
                return "Schaluppe";
            case 'b':
                return "Brigg";
            case 'f':
                return "Fregatte";
            case 'g':
                return "Galeone";
            default:
                return "";
        }
    }

    // Methode zur Ausgabe der maximalen Besatzung des Schiffstyps
    private int getMaxBesatzung() {
        switch (typ) {
            case 's':
                return 3;
            case 'b':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            default:
                return 0;
        }
    }

    // Methode zur Ausgabe des Getränkeüberblicks
    public static void printGetraenkeueberblick() {
        System.out.println("Getränkeüberblick");
        System.out.println("w Wasser - Vermindert die Gesundheit um 10 Prozent");
        System.out.println("g Grog (Mischung aus Wasser und Rum) - Erhöht die Gesundheit um 10 Prozent");
        System.out.println("r Rum - Erhöht die Gesundheit um 20 Prozent");
    }

    public void print() {
        System.out.println(toString());
    }
}
