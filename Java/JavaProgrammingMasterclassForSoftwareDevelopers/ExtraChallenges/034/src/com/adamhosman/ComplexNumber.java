package com.adamhosman;

public class ComplexNumber {

    private double real;

    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        ComplexNumber other = new ComplexNumber(real, imaginary);
        add(other);
    }

    public void add(ComplexNumber other) {
        this.real += other.getReal();
        this.imaginary += other.getImaginary();
    }

    public void subtract(double real, double imaginary) {
        ComplexNumber other = new ComplexNumber(real, imaginary);
        subtract(other);
    }

    public void subtract(ComplexNumber other) {
        this.real -= other.getReal();
        this.imaginary -= other.getImaginary();
    }

}
