package at.spengergasse;

public class Pirat {
    private String name;
    private int gesundheit;
    private boolean holzbein;

    // Konstruktor
    public Pirat(String name, int gesundheit, boolean holzbein) {
        this.name = name;
        this.gesundheit = gesundheit;
        this.holzbein = holzbein;
    }

    // Getter und Setter-Methoden
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Arrgh! Keinen Namen fuer den alten Seebaeren uebergeben!");
        } else {
            this.name = name;
        }
    }

    public int getGesundheit() {
        return gesundheit;
    }

    public void setGesundheit(int gesundheit) {
        if (gesundheit >= 0 && gesundheit <= 100) {
            this.gesundheit = gesundheit;
        } else {
            System.out.println("Yo-ho-ho - Gueltiger Bereich fuer die Gesundheit: 0 bis 100 Prozent");
        }
    }

    public boolean getHolzbein() {
        return holzbein;
    }

    public void setHolzbein(boolean holzbein) {
        this.holzbein = holzbein;
    }

    // Weitere Methoden
    public void trinken(char getraenk) {
        switch (getraenk) {
            case 'w':
                gesundheit = Math.max(0, gesundheit - 10);
                break;
            case 'g':
                gesundheit = Math.min(100, gesundheit + 10);
                break;
            case 'r':
                gesundheit = Math.min(100, gesundheit + 20);
                break;
        }

        if (gesundheit == 0) {
            System.out.println("Haudegen " + name + " ging ueber die Planken.");
        } else if (gesundheit == 100) {
            System.out.println("Haudegen " + name + " erfreut sich voller Gesundheit");
        }
    }

    public void kielholen() {
        int schaden = holzbein ? 95 : 90;
        gesundheit = Math.max(0, gesundheit - schaden);

        if (gesundheit == 0) {
            System.out.println("Pirat " + name + " stieg in Davy Jone’s Kiste");
        }
    }

    public String toString() {
        String gesundheitInfo;
        if (gesundheit >= 11) {
            gesundheitInfo = gesundheit + "%";
        } else if (gesundheit >= 1) {
            gesundheitInfo = gesundheit + "% - hisst den Yellow Jack";
        } else {
            gesundheitInfo = "X - in der Kiste";
        }

        String holzbeinInfo = holzbein ? "Holzbeiner" : "Zweifüßer";

        return "`Aye` - Trunkenbold " + name + " meldet sich an Board!\n" +
                gesundheitInfo + ", " + holzbeinInfo;
    }

    public void print() {
        System.out.println(toString());
    }
}
