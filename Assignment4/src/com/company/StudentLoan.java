package com.company;

public class StudentLoan extends Loan {
    private boolean isDeferred;
    StudentLoan(String inputName, double inputAmount, double inputRate, int inputMonths, boolean inputIsDeferred) {
        super(inputName, inputAmount, inputRate, inputMonths);
        isDeferred = inputIsDeferred;
    }
    public boolean getIsDeferred() {
        return isDeferred;
    }
    public void setIsDeferred(boolean inputIsDeferred){
        isDeferred = inputIsDeferred;
    }

    @Override
    public void calculateMonthlyPayment() {
        if (this.isDeferred){
            setMonthlyPayment(0);
        }else {
            setMonthlyPayment(((getInterestRate() * .01) * getLoanBalance())/(1-(Math.pow((1+(getInterestRate() * .01)),(getNumberOfMonthlyPayments() * -1)))));
        }
    }

    @Override
    public String toString() {
        return
                "customer name: " + getCustomerName() +
                ", Account number: " + getAccountNumber() +
                ", Loan balance: " + getLoanBalance() +
                ", Interest rate: " + getInterestRate() +
                ", Number of monthly payments: " + getNumberOfMonthlyPayments() +
                        ", Monthly Payment: " + getMonthlyPayment() +
                ", Is deferred: " + isDeferred
                ;
    }
}
