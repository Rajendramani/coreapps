
public class CreditCard 
{
	//long for # [8 bytes]
	private long _ccNum;
	//double for balance [8 bytes]
	private double _balance;
	
	public CreditCard()
	{
		//do nothing
	}
	
	public CreditCard(long ccNum, double balance)
	{
		_ccNum = ccNum;
		_balance = balance;
	}
	
	public long getCreditCardNumber()
	{
		return _ccNum;
	}
	
	public void setCreditCardNumber(long num)
	{
		_ccNum = num;
	}
	
	public double getBalance()
	{
		return _balance;
	}
	
	public void setBalance(double bal)
	{
		_balance = bal;
	}
	
	public String toString()
	{
		return String.format("Credit Card Number: %d\tBalance $%.2f"
				, getCreditCardNumber()
				, getBalance());
	}
}
