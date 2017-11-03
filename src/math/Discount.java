package math;

import java.util.ArrayList;
import java.util.Collections;


public class Discount 
{
	public Stock sStock;
	public ArrayList<Stock> arrStocks;
	public ArrayList<Stock> shoppingCart;
	
	public Discount()
	{		
		System.out.println("Discount Constructor");

		arrStocks=new ArrayList<Stock>();
		shoppingCart=new ArrayList<Stock>();
		
		sStock=new Stock("SKM000003", "T-Shirt", 0, 30);
		arrStocks.add(sStock);
		
		sStock=new Stock("SKM000001", "T-Shirt", 0, 10);
		arrStocks.add(sStock);

		sStock=new Stock("SKM000002", "T-Shirt", 0, 20);
		arrStocks.add(sStock);

		Sort(arrStocks);
		printArr(arrStocks);
	}
	
	public void addShopping(String stockSKU){
		
		Stock sStock = new Stock();
		sStock = getItem(stockSKU);
		if (sStock.strCode!="")
		{
			shoppingCart.add(sStock);
		}
		
		
	}
	public void printCart()
	{
		System.out.println("Print Cart Start");
		printArr(shoppingCart);
		System.out.println("Total Cost: "+ printTotal(shoppingCart));
		System.out.println("Print Cart End");
	}	
	public void Sort(ArrayList<Stock> arrStock)
	{
		int a=0;
		int b=0;
		Stock sA, sB;
		
		System.out.println("Sort");
		
		for (a=0; a<arrStock.size()-1;a++)
		{
			for (b=a+1;b<arrStock.size();b++)
			{   
				sA=arrStock.get(a);
				sB=arrStock.get(b);
				if ( sA.strCode.compareToIgnoreCase(sB.strCode)>0 )
				{
					System.out.println("Swap");
				    Collections.swap(arrStock,  a,  b);
				}
				
			}
			
		}
		return;
	}
		
	public void printArr(ArrayList<Stock> pArr)
	{
		int a=0;
		Stock tmp;
		
		for (a=0; a<pArr.size(); a++)
		{
			tmp=pArr.get(a);
			System.out.println("Stock [" + a + "][" + tmp.strDescription+ "][" + tmp.strCode + "][" + tmp.iDiscount + "][" + tmp.dPrice +"]");
		}
		return;
	}
	
	public double printTotal(ArrayList<Stock> pArr)
	{
		double price=0;
		Stock tmp;
		
		for (int a=0; a<pArr.size(); a++)
		{
			tmp=pArr.get(a);
			price = price + tmp.dPrice;
			
		}
		return price;
	}

	
	double computeTotal(ArrayList<Stock>  pArr)
	{
		double dTotal=0;
		Stock tmp,tmpStock;
		String [] strArr;
		int count=0;
		String strOld="";
		
		System.out.println("computeTotal");
		Sort(pArr);

		
		System.out.println("Start processing");
		for (int a=0; a<pArr.size();a++)
		{
			count++;
			tmp=pArr.get(a);
			strArr=tmp.strCode.split("-");

			tmpStock=find(strArr[0]);
			
			if (strOld.compareToIgnoreCase(strArr[0])!=0)
			{
				strOld=strArr[0];
				System.out.println("Reset");
				count=1;
			}

			
			if ( tmp.strCode.compareToIgnoreCase("")!=0 )
			{
				System.out.println("Count[" + count + "]");
				if ( (count%2)==0 )
				{
					tmp.iDiscount=30;
					tmp.dPrice=tmpStock.dPrice*0.70;
					dTotal+=(tmpStock.dPrice*0.70);
				}
				else
				{
					tmp.iDiscount=0;
					tmp.dPrice=tmpStock.dPrice;
				    dTotal+=tmpStock.dPrice;
				}
				System.out.println("Current Total [" + dTotal +"]");
			}
			System.out.println("Stock[" + tmp.strCode + "][" + strArr[0] + "]["+tmpStock.strCode + "][" + tmpStock.dPrice + "]");
		}
		return dTotal;
	}
	
	Stock find(String pStr)
	{
		Stock tmp;
		Stock sRet=new Stock();

		for (int a=0; a<arrStocks.size();a++)
		{
			tmp=arrStocks.get(a);
			
			if ( tmp.strCode.compareToIgnoreCase(pStr) == 0 )
			{
				sRet=tmp;
				break;
			}
		}
		return sRet;
	}
	
	public Stock getItem(String pStr)
	{
		Stock sRet=new Stock();
		
		sRet=find(pStr);
		printStock(sRet);
		return sRet;
	}
	
	public void printStock(Stock pStock)
	{
		System.out.println("Stock [" + pStock.strCode + "]");		
		System.out.println("strDescription [" + pStock.strDescription + "]");		
		System.out.println("iDiscount [" + pStock.iDiscount + "]");		
		System.out.println("dPrice [" + pStock.dPrice + "]");		
	}
	
	public void printStocks()
	{
		printArr(arrStocks);
	}
	

	public int printOne()
	{
		return 1;
	}
}
