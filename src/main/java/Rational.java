public class Rational {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational sum(Rational r){
        Rational temp = new Rational(0,0); // Create a new Rational object so that current object is not affected.
        temp.numerator = (numerator * r.denominator) + (r.numerator + denominator);  // Calculate the numerator
        temp.denominator = (denominator * r.denominator) ;   // Calculate the denominator
        return temp;  // return the new Rational object
    }
}