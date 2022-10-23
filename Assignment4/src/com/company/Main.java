package com.company;

import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static void addLoan(ArrayList<Loan> LoanArrayList){
        System.out.println("Enter Loan Type (1 – Student, 2 – Auto):");
        int loanType = scan.nextInt();
        System.out.println("Enter Customer Name:");
        String customerName = scan.next();
        System.out.println("Enter Loan Amount:");
        float loanAmount = scan.nextFloat();
        System.out.println("Enter Interest Rate:");
        float interestRate = scan.nextFloat();
        System.out.println("Enter Number of Monthly Payments:");
        int monthlyPayments = scan.nextInt();
        if (loanType == 1){
            System.out.println("Is Loan Deferred? (Y or N):");
            String deferred = scan.next();
            if(Objects.equals(deferred, "Y")){
                LoanArrayList.add(new StudentLoan(customerName,loanAmount,interestRate,monthlyPayments,true)) ;
            }else {
                LoanArrayList.add(new StudentLoan(customerName,loanAmount,interestRate,monthlyPayments,false)) ;
            }
        } else if (loanType == 2){
            System.out.println("Enter Amount of Down Payment:");
            float downPayment = scan.nextFloat();
            LoanArrayList.add(new AutoLoan(customerName,loanAmount,interestRate,monthlyPayments,downPayment));
        }
    }
    public static void deleteLoan(ArrayList<Loan> LoanArrayList){
        System.out.println("Enter Customer Name: ");
        String customerName = scan.next();
        for (int i = 0; i < LoanArrayList.size(); i++) {
            if(Objects.equals(customerName, LoanArrayList.get(i).getCustomerName())){
                LoanArrayList.remove(i);
                Loan.decreaseNumberOfLoans();
            }
        }
    }
    public static void calculateMonthlyLoanPayment(ArrayList<Loan> LoanArrayList){
        for (Loan loan : LoanArrayList){
            loan.calculateMonthlyPayment();
        }
    }
    public static void printLoans(ArrayList<Loan> LoanArrayList){
        for (Loan loan : LoanArrayList){
            System.out.println(loan.toString());
        }
    }



    public static void main(String[] args) {
        ArrayList<Loan> loanArrayList = new ArrayList<Loan>();
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
    while (cont){
        System.out.println("1 – Add Loan\n" +
                "2 – Delete Loan\n" +
                "3 – Calculate Monthly Payments\n" +
                "4 – Print Loans\n" +
                "5 – Exit\n" +
                "Enter Choice:");
        switch (scan.nextInt()){
            case 1:
                addLoan(loanArrayList);
                break;
            case 2:
                deleteLoan(loanArrayList);
                break;
            case 3:
                calculateMonthlyLoanPayment(loanArrayList);
                break;
            case 4:
                printLoans(loanArrayList);
                break;
            case 5:
                cont = false;
                break;
            default:
                System.out.println("Error: Please enter valid input");
        }
    }

}
}
