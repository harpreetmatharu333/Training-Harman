package assignment_2;

abstract class Account {
	private String name;
	private String accountNumber;
	private double accountBalance;
	
	public String getName() {
		return name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Account(String name, String accountNumber, double accountBalance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	public void deposit(double amount) {
		accountBalance+=amount;
	}

	public abstract void withdraw(double amount);
	@Override
	public String toString() {
		return "Account [name=" + name + ","
				+ " accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ "]";
	}
		
}

 class SavingsAccount extends Account {
	private double interest=5.0;
	private double maxWithdrawAmountLimit;
	private double minimumBalance;

	public SavingsAccount(String name, String accountNumber, double accountBalance, 
			double interest,double minimumBalance) {
		super(name, accountNumber, accountBalance);
		this.interest=interest;
		this.minimumBalance=minimumBalance;
		
		this.maxWithdrawAmountLimit=accountBalance-minimumBalance;
	}
	
	public double getBalance() {
		return getAccountBalance()*(100+interest)/100;
	}
	
	public void withdraw(double amount) {
		if(amount<=maxWithdrawAmountLimit) {
			setAccountBalance(getAccountBalance()-amount);
			System.out.println("amount "+ amount+" is withdrawn");
		}else
			System.out.println("You can not withdraw as min balance required ...");
	}

	@Override
	public String toString() {
		return super.toString()+ 
				" interest=" + interest + ","
				+ " maxWithdrawAmountLimit=" + maxWithdrawAmountLimit
				+ ", minimumBalance=" + minimumBalance + "]";
	}
	
}
 
 
class CurrentAccount extends Account {

		private String tradeLicenseNumber;
		private double overdraft;

		public CurrentAccount(String name, String accountNumber, double accountBalance,
				String tradeLicenseNumber,double overdraft) {
			super(name, accountNumber, accountBalance);
			this.tradeLicenseNumber = tradeLicenseNumber;
			this.overdraft = overdraft;
		}

		public void withdraw(double amount) {
			double allowedWithdrawal= getAccountBalance()+ overdraft;
			
			if(allowedWithdrawal<=amount) {
				setAccountBalance(getAccountBalance()-amount);
				System.out.println("amount "+ amount+" is withdrawn");
			}else
				System.out.println("You can not withdraw, dont have sufficient balance and overdraft limit  ...");
		}

		@Override
		public String toString() {
			return super.toString()+
					"CurrentAccount [tradeLicenseNumber=" + tradeLicenseNumber + ", "
					+ "overdraft=" + overdraft + "]";
		}

		
	}
 
 
 

public class Q3 {
	
public static void main(String[] args) {
		
		Account account=new
				SavingsAccount("ravi", "4343433434", 30000, 5, 1000);
		
		String name = account.getName();
		
		name = name + ".";
	
		
		Account account2=new 
			CurrentAccount("rajiv", "543545445", 500000, "AB1234", 50000);
		
      String name2 = account2.getName();
		
		name2 = name2 + ".";
		
	}

}
