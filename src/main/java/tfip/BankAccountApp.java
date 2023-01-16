package tfip;

import java.util.Random;
import java.util.UUID;

public class BankAccountApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Banking");

        int n = 3;
        BankAccount bankAccount[] = new BankAccount[n];
        //Generate account
        for (int i=0;i<bankAccount.length;i++){
            String uuid = UUID.randomUUID().toString();
            Float max = 10000.00f;
            Float min = 1000.00f;
            Random randomNum = new Random();
            Float initialBalance = min + randomNum.nextFloat(max);
            bankAccount[i] = new FDAccount(uuid, String.format("JohnDoe%d",i), initialBalance);
        }
        //Print out all accounts
        for (BankAccount account : bankAccount){
            account.showAccount();
        }
        //Perform deposit
        bankAccount[0].deposit(2000.0f);
        bankAccount[1].deposit(4000.0f);
        bankAccount[2].deposit(6000.0f);
        //Print out all accounts
        for (BankAccount account : bankAccount){
            account.showAccount();
        }
        //Perform withdrawal
        bankAccount[0].withdraw(2000.0f);
        bankAccount[1].withdraw(10000.0f);
        bankAccount[2].withdraw(6000.0f);
        //Print out all accounts
        for (BankAccount account : bankAccount){
            account.showAccount();
        }
        //Close an account
        bankAccount[0].setActive(false);
        //Perform deposit
        bankAccount[0].deposit(2000.0f);
    }
}
