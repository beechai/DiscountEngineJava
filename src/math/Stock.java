package math;

public class Stock 
{
	public String strCode;
	public String strDescription;
	public int iDiscount;
	public double dPrice;
	
	public Stock()
	{
		strCode="";		
		strDescription="";
		iDiscount=0;
		dPrice=0;
	}
	
	public Stock(String pStr, String pStrDesc, int pDiscount, double pPrice)
	{
		strCode=pStr;
		strDescription=pStrDesc;
		iDiscount=pDiscount;
		dPrice=pPrice;		
	}
}
