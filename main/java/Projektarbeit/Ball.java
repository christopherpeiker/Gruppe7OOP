package Projektarbeit;

public class Ball {
    private int size;
    private String farbe;
    private String ballart;
    private int anzahl;
    private double preis;

    // Konstruktor
    public Ball(int size, String farbe, String ballart, int anzahl, double preis) {
        this.size = size;
        this.farbe = farbe;
        this.ballart = ballart;
        this.anzahl = anzahl;
        this.preis = preis;
    }

    public String getFarbe(){
        return this.farbe;
    }

    // Ausgabe des Balls als String
    @Override
    public String toString() {
        return "Ballgröße: " + size +
                ", Farbe: " + farbe +
                ", Ballart: " + ballart +
                ", Anzahl: " + anzahl +
                ", Preis: " + String.format("%.2f", preis) + " EUR";
    }


    public double berechneGesamtpreis() {
        return this.preis;
    }

    }

