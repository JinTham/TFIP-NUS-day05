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
    public BankAccount(String accountNo, String fullName, Float balance) {
        this.accountNo = accountNo;
        this.fullName = fullName;
        this.balance = balance;
    }
    public BankAccount(String accountNo, String fullName) {
        this.accountNo = accountNo;
        this.fullName = fullName;
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
}
