package com.company;

public class Loan {
    private String customerName;
    private int accountNumber;
    private double loanBalance;
    private double monthlyPayment;
    private double interestRate;
    private int numberOfMonthlyPayments;
    private static int numberOfLoans = 0;
    Loan(String inputName,double inputAmount,double inputRate,int inputMonths){
        customerName = inputName;
        loanBalance =inputAmount;
        interestRate = inputRate;
        numberOfMonthlyPayments = inputMonths;
        ++numberOfLoans;
        accountNumber = numberOfLoans;
    }
    static int getNumberOfLoans(){
        return numberOfLoans;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public double getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getNumberOfMonthlyPayments() {
        return numberOfMonthlyPayments;
    }
    public void setNumberOfMonthlyPayments(int numberOfMonthlyPayments) {
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
    }
    public static void decreaseNumberOfLoans(){
        numberOfLoans--;
    }
    public void calculateMonthlyPayment(){
        monthlyPayment = (((interestRate * .01) * loanBalance)/(1-(Math.pow((1+(interestRate * .01)), numberOfMonthlyPayments * -1))));
    }

    @Override
    public String toString() {
        return
                "customer name: " + getCustomerName() +
                ", Account number: " + getAccountNumber() +
                ", Loan balance: " + getLoanBalance() +
                ", Interest rate: " + getInterestRate() +
                ", Number of monthly payments: " + getNumberOfMonthlyPayments()
               ;
    }
}
