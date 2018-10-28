package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    Interval(double pocetna, double krajnja, boolean pocetnaPri, boolean krajnjaPri) {
        if (pocetna > krajnja)
            throw new IllegalArgumentException("Pocetna tacka je veca od krajnje");
        else if (pocetna == krajnja && pocetnaPri != krajnjaPri)
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
        return (pocetnaTacka == krajnjaTacka && !pocetnaPripada);
    }

    boolean isIn(double tacka) {
        if (tacka > pocetnaTacka && tacka < krajnjaTacka)
            return true;
        else if (tacka == pocetnaTacka && pocetnaPripada)
            return true;
        else if ((tacka == krajnjaTacka && krajnjaPripada))
            return true;
        else
            return false;
    }

    Interval intersect(Interval drugiInter) {

        // U slucaju intervala koji se ne preklapaju (i null intervala) vratice se null interval
        if ((this.isNull() || drugiInter.isNull()) ||
            (this.pocetnaTacka > drugiInter.krajnjaTacka || this.krajnjaTacka < drugiInter.pocetnaTacka)) {
            return new Interval();
        }

        Interval intersection = new Interval(0, 0, false, false);
        if (this.pocetnaTacka == drugiInter.krajnjaTacka)
        {
            intersection.pocetnaTacka = intersection.krajnjaTacka = this.pocetnaTacka;
            intersection.pocetnaPripada = intersection.krajnjaPripada =
                    this.pocetnaPripada && drugiInter.krajnjaPripada;
        } else if (this.krajnjaTacka == drugiInter.pocetnaTacka)
        {
            intersection.pocetnaTacka = intersection.krajnjaTacka = this.krajnjaTacka;
            intersection.pocetnaPripada = intersection.krajnjaPripada = this.krajnjaPripada && drugiInter.pocetnaPripada;
        } else {
            intersection.postaviPocetnu(this, drugiInter);
            intersection.postaviKrajnju(this, drugiInter);
        }

        return intersection;
    }

    private void postaviPocetnu(Interval prvi, Interval drugi) {
        if (prvi.pocetnaTacka < drugi.pocetnaTacka)
        {
            pocetnaTacka = drugi.pocetnaTacka;
            pocetnaPripada = drugi.pocetnaPripada;
        } else if (prvi.pocetnaTacka == drugi.pocetnaTacka)
        {
            pocetnaTacka = prvi.pocetnaTacka;
            pocetnaPripada = prvi.pocetnaPripada;
        } else // jednake pocetne
        {
            pocetnaTacka = prvi.pocetnaTacka;
            pocetnaPripada = prvi.pocetnaPripada && drugi.pocetnaPripada;
        }
    }

    private void postaviKrajnju(Interval prvi, Interval drugi) {
        if (prvi.krajnjaTacka < drugi.krajnjaTacka)
        {
            krajnjaTacka = prvi.krajnjaTacka;
            krajnjaPripada = prvi.krajnjaPripada;
        } else if (prvi.krajnjaTacka > drugi.krajnjaTacka)
        {
            krajnjaTacka = drugi.krajnjaTacka;
            krajnjaPripada = drugi.krajnjaPripada;
        } else // jednake krajnje
        {
            krajnjaTacka = prvi.krajnjaTacka;
            krajnjaPripada = prvi.krajnjaPripada && drugi.krajnjaPripada;
        }
    }

    static Interval intersect(Interval prvi, Interval drugi) {
        return prvi.intersect(drugi);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Interval))
            throw new IllegalArgumentException("Argument nije interval");
        Interval i = (Interval) other;
        return (this.pocetnaTacka == i.pocetnaTacka && this.pocetnaPripada == i.pocetnaPripada &&
                this.krajnjaTacka == i.krajnjaTacka && this.krajnjaPripada == i.krajnjaPripada);
    }

    @Override
    public String toString() {
        if (this.isNull())
            return "()";

        String result = "";
        if (this.pocetnaPripada)
            result += "[";
        else
            result += "(";

        result += pocetnaTacka + "," + krajnjaTacka;
        if (this.krajnjaPripada)
            result += "]";
        else
            result += ")";

        return result;
    }

}
