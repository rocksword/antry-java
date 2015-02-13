package com.an.antry.java.jpie;

public class Complex {
    private final double real;
    private final double imaginary;

    public Complex(final double r, final double i) {
        this.real = r;
        this.imaginary = i;
    }

    public Complex add(final Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // hashCode omitted for brevity
    public boolean equals2(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Complex complex = (Complex) o;
        if (Double.compare(complex.imaginary, this.imaginary) != 0)
            return false;
        if (Double.compare(complex.real, this.real) != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        final Complex expected = new Complex(6, 2);
        final Complex a = new Complex(8, 0);
        final Complex b = new Complex(-2, 2);
        if (a.add(b).equals(expected)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}
