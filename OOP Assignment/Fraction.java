import java.util.Scanner;

public class Fraction{

    private int numerator;
    private int denominator;

    public Fraction(){
        this.numerator = 1;
        this.denominator = 2;
    }

    public Fraction(Fraction f){
        this.numerator = f.numerator;
        if(f.denominator == 0){
            System.out.println("Bruh!");
            f.denominator = 1;
        }
        this.denominator = f.denominator;
    }

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0){
            System.out.println("Bruh!");
            denominator = 1;
        }
        this.denominator = denominator;

    }

    public Fraction(String fraction){
        int slashindex = fraction.indexOf("/");
        String num = fraction.substring(0,slashindex);
        String den = fraction.substring(slashindex+1);
        this.numerator = Integer.parseInt(num);
        if(denominator == 0){
            System.out.println("Bruh!");
            denominator = 1;
        }
        if(den.length() == 1 && den.contains("0")){
            this.denominator = 1;
        }else{
            this.denominator = Integer.parseInt(den);   
        }
    }

    public int getDenominator(){
        return this.denominator;   
    }

    public int getNumerator(){
        return this.numerator;   
    }

    public String toString(){
        return this.numerator + "/" + this.denominator;  
    }

    public Double toDouble(){
        return (double)this.numerator/(double)this.denominator;   
    }

    public void setNum(int Num){
        this.numerator =  Num;  
    }

    public void setDenom(int Denom){
        this.denominator = Denom;   
    }

    public Fraction reduce(){
        this.numerator = this.numerator/GCF(this.numerator, this.denominator);
        this.denominator = this.denominator/GCF(this.numerator, this.denominator);
        return new Fraction(this.numerator, this.denominator);
    }

    public static Fraction multiply (Fraction a, Fraction b){
        int numerator = a.getNumerator() * b.getNumerator();
        int denominator = a.getDenominator() * b.getDenominator();
        Fraction answer = new Fraction (numerator, denominator);
        return answer.reduce();
    }

    public static Fraction divide(Fraction a, Fraction b){
        int numerator = a.getNumerator() * b.getDenominator();
        int denominator = a.getDenominator() * b.getNumerator();
        Fraction answer = new Fraction (numerator, denominator);
        return answer.reduce();
    }

    public static Fraction add(Fraction a, Fraction b){
        int numerator = (a.getNumerator()*b.getDenominator()) + (b.getNumerator()*a.getDenominator());
        int denominator = a.getDenominator()*b.getDenominator();
        Fraction answer = new Fraction (numerator, denominator);
        return answer.reduce();
    }

    public static Fraction subtract(Fraction a, Fraction b){
        int numerator = (a.getNumerator()*b.getDenominator())-(b.getNumerator()*a.getDenominator());
        int denominator = a.getDenominator()*b.getDenominator();
        Fraction answer = new Fraction (numerator, denominator);
        return answer.reduce();
    }

    private static int GCF(int a, int b){

        int A = Math.abs(a);
        int B = Math.abs(b);

        while(A != B){
            if(A > B){
                A = A - B; 
            }else{
                B = B - A;
            }
        }
        return A;
    }
}