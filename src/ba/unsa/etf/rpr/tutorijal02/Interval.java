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

    


}
