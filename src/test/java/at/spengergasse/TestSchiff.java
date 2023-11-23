package at.spengergasse;

public class TestSchiff {

    public static void main(String[] args) {
        Schiff schaluppe = new Schiff('s');
        schaluppe.anheuern(new Pirat("Oneeye Joe", 100, false));
        schaluppe.anheuern(new Pirat("P2", 100, false));
        schaluppe.anheuern(new Pirat("P3", 100, false));

        schaluppe.print();
    }
}