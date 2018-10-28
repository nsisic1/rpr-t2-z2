package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    Interval(double pocetna, double krajnja, boolean pocetnaPri, boolean krajnjaPri) {
        if (pocetna > krajnja)
            throw new IllegalArgumentException("Pocetna tacka je veca od krajnje");
        else if (Double.compare(pocetna, krajnja) == 0 && pocetnaPri != krajnjaPri)
            throw new IllegalArgumentException("Tacka pripada i ne pripada intervalu");

        pocetnaTacka = pocetna;
        pocetnaPripada = pocetnaPri;
        krajnjaTacka = krajnja;
        krajnjaPripada = krajnjaPri;
    }

    Interval() {
        pocetnaTacka = 0;
        pocetnaPripada = false;
        krajnjaTacka = 0;
        krajnjaPripada = false;
    }

    boolean isNull() {
        return (Double.compare(pocetnaTacka, krajnjaTacka) == 0 && !pocetnaPripada);
    }

    boolean isIn(double tacka) {
        if (tacka > pocetnaTacka && tacka < krajnjaTacka)
            return true;
        else if (Double.compare(tacka, pocetnaTacka) == 0 && pocetnaPripada)
            return true;
        else if (Double.compare(tacka, krajnjaTacka) == 0 && krajnjaPripada)
            return true;
        else
            return false;
        // TODO: zapisati simplifikaciju u algos
    }

    




}
