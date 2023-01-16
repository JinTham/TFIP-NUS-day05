package tfip;

import java.util.Date;

public class BankAccount {
    private final String accountNo;
    private String fullName;
    private Float balance = 0.0f;
    private boolean isActive = true;
    private Date accountStartDate;
    private Date accountEndDate;
    //Constructors
    public BankAccount(String accountNo) {
        this.accountNo = accountNo;
    }
    public BankAccount(String accountNo, String fullName) {
        this.accountNo = accountNo;
        this.fullName = fullName;
    }
    public BankAccount(String accountNo, Float balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    public BankAccount(String accountNo, String fullName, Float balance) {
        this.accountNo = accountNo;
        this.fullName = fullName;
        this.balance = balance;
    }
    //Getters & Setters
    public String getAccountNo() {
        return accountNo;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Float getBalance() {
        return balance;
    }
    public void setBalance(Float balance) {
        this.balance = balance;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public Date getAccountStartDate() {
        return accountStartDate;
    }
    public void setAccountStartDate(Date accountStartDate) {
        this.accountStartDate = accountStartDate;
    }
    public Date getAccountEndDate() {
        return accountEndDate;
    }
    public void setAccountEndDate(Date accountEndDate) {
        this.accountEndDate = accountEndDate;
    }
    public void showAccount(){
        System.out.printf("Account No: %s\n",this.accountNo);
        System.out.printf("Fullname: %s\n",this.fullName);
        System.out.printf("Balance: %s\n",this.balance);
    }
    @Override
    public String toString() {
        return "BankAccount [accountNo=" + accountNo + ", fullName=" + fullName + ", balance=" + balance + ", isActive="
                + isActive + ", accountStartDate=" + accountStartDate + ", accountEndDate=" + accountEndDate + "]";
    }
    //Methods
    public void deposit(Float amount){
        if (!isActive){
            throw new IllegalArgumentException("You cannot deposit to a closed account");
        }
        if (amount<0){
            throw new IllegalArgumentException("You cannot make negative deposit");
        }
        this.balance += amount;
    }
    public void withdraw(Float amount){
        if (!isActive){
            throw new IllegalArgumentException("You cannot withdraw from a closed account");
        }
        if (amount<0){
            throw new IllegalArgumentException("You cannot make negative withdrawal");
        }
        if (amount>balance){
            throw new IllegalArgumentException("Your account balance is than "+amount);
        }
        this.balance -= amount;
    }
}
