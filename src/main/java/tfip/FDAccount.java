package tfip;

public class FDAccount extends BankAccount{
    public static Float interest = 3.0f;
    public static Float duration = 6.0f;

    public FDAccount(String accountNo, Float balance){
        super(accountNo, balance);
    }
    public FDAccount(String accountNo, String fullName, Float balance){
        super(accountNo, fullName, balance);
    }

    @Override
    public void deposit(Float amount){
        System.out.println("No deposit operation");
    }
    @Override
    public void withdraw(Float amount){
        System.out.println("No withdrawal operation");
    }
    @Override
    public void showAccount(){
        System.out.printf("Account No: %s\n",this.getAccountNo());
        System.out.printf("Fullname: %s\n",this.getFullName());
        System.out.printf("Balance: %s\n",this.getBalance());
    }
}
