package com.company;

public class AutoLoan extends Loan{
    private double downPayment;
    AutoLoan(String inputName, double inputAmount, double inputRate, int inputMonths, double inputDownPayment) {
        super(inputName, inputAmount, inputRate, inputMonths);
        downPayment = inputDownPayment;
    }
    public double getDownPayment() {
        return downPayment;
    }
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }
    @Override
    public void calculateMonthlyPayment() {
        setMonthlyPayment(((getInterestRate() * .01) * (getLoanBalance() - downPayment))/(1-(Math.pow((1+(getInterestRate() * .01)),(getNumberOfMonthlyPayments() * -1)))));
    }
    @Override
    public String toString() {
        return
                "customer name: " + getCustomerName()+
                ", Account number: " + getAccountNumber() +
                ", Loan balance: " + getLoanBalance() +
                ", Interest rate: " + getInterestRate() +
                ", Number of monthly payments: " + getNumberOfMonthlyPayments() +
                ", Monthly Payment: " + getMonthlyPayment() +
                ", Down payment: " + downPayment
                ;
    }
}
