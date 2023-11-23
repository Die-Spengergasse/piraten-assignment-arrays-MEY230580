package at.spengergasse;

import java.util.ArrayList;

public class Schiff {
    private int kanonen;
    private char typ;
    private Pirat kapitaen;
    private Pirat pirat2;
    private Pirat pirat3;
    private Pirat pirat4;
    private Pirat pirat5;
    private Pirat pirat6;

    // Konstruktor
    public Schiff(char typ) {
        setTyp(typ);
        kanonenKlarmachen();
    }

    // Getter und Setter-Methoden
    public int getKanonen() {
        return kanonen;
    }

    public char getTyp() {
        return typ;
    }

    public void setTyp(char typ) {
        if (typ == 's' || typ == 'b' || typ == 'f' || typ == 'g') {
            this.typ = typ;
        } else {
            System.out.println("Harr! Der Schiffstyp " + typ + " ist zu raeudig!");
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

    // Methode zum Anheuern eines Piraten
    public void anheuern(Pirat pirat) {
        if (kapitaen == null) {
            kapitaen = pirat;
        } else if (pirat2 == null) {
            pirat2 = pirat;
        } else if (pirat3 == null) {
            pirat3 = pirat;
        } else if (pirat4 == null) {
            pirat4 = pirat;
        } else if (pirat5 == null) {
            pirat5 = pirat;
        } else if (pirat6 == null) {
            pirat6 = pirat;
        } else {
            System.out.println("Arrg! Kein Grog mehr fuer den neuen Trunkenbold! Voll besetzt! Typ= " + typ);
        }
    }

    // Methode zur Ausgabe der Informationen über das Schiff und die Besatzung
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("******************************************\n");
        result.append("Crew ").append(getSchiffBezeichnung()).append(": ").append("(").append(getMaxBesatzung()).append(")\n");
        result.append("-----------------------\n");
        result.append(kapitaen.toString()).append("\n");
        if (pirat2 != null) result.append(pirat2.toString()).append("\n");
        if (pirat3 != null) result.append(pirat3.toString()).append("\n");
        if (pirat4 != null) result.append(pirat4.toString()).append("\n");
        if (pirat5 != null) result.append(pirat5.toString()).append("\n");
        if (pirat6 != null) result.append(pirat6.toString()).append("\n");
        result.append("******************************************");
        return result.toString();
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
