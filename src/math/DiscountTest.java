package math;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;
import math.Discount;

public class DiscountTest 
{

	@Test
	public void Initial() 
	{

		Discount d=new Discount();
		assertEquals(1, d.printOne());
		//fail("Not yet implemented");
	} 
	
	@Test
	public void printStock()
	{
		System.out.println("PrintStock");
		Discount d=new Discount();
		assertEquals(1, d.printOne());		
		d.printStocks();
		
	}
	
	@Test
	public void testGetItem()
	{
		Discount d=new Discount();
		Stock s=new Stock();
		
		
		System.out.println("testGetItem Start");
		s=d.getItem("SKM000001");
		System.out.println("testGetItem End");
		
		assertEquals(s.dPrice,10.0,0);
		assertEquals(s.iDiscount,0);
		assertEquals(s.strDescription,"T-Shirt");
		
		System.out.println("testGetItem Start");
		s=d.getItem("SKM000002");
		System.out.println("testGetItem End");
		
		assertEquals(s.dPrice,20.0,0);
		assertEquals(s.iDiscount,0);
		assertEquals(s.strDescription,"T-Shirt");
	}
	
	
	@Test
	public void testAddShopping()
	{
		
		System.out.println("Discount Constructor");
		Discount d=new Discount();
		d.addShopping("SKM000001");		
		assertEquals(1, d.shoppingCart.size());
		
		d.addShopping("SKM000002");		
		assertEquals(2, d.shoppingCart.size());		
	
	}
	
	@Test
	public void testPrintShopping()
	{
		Discount d=new Discount();
		d.addShopping("SKM000001");		
		assertEquals(1, d.shoppingCart.size());
		
		d.addShopping("SKM000002");		
		assertEquals(2, d.shoppingCart.size());	
		
		d.printCart();
	
	}
	
	@Test
	public void testCompute()
	{
		Discount d=new Discount();

		Stock sTmp;
		ArrayList<Stock> cart=new ArrayList<Stock>();
		
		sTmp=new Stock("SKM000001-B-S", "", 0, 0);
		cart.add(sTmp);
		sTmp=new Stock("SKM000001-B-M", "", 0, 0);
		cart.add(sTmp);
		sTmp=new Stock("SKM000001-B-XL", "", 0, 0);
		cart.add(sTmp);

		sTmp=new Stock("SKM000002-W-S", "", 0, 0);
		cart.add(sTmp);
		sTmp=new Stock("SKM000002-W-S", "", 0, 0);
		cart.add(sTmp);
		sTmp=new Stock("SKM000002-W-S", "", 0, 0);
		cart.add(sTmp);
		sTmp=new Stock("SKM000002-W-S", "", 0, 0);
		cart.add(sTmp);
		
		double dTotal=d.computeTotal(cart);
		System.out.println("TOTAL [" + dTotal + "]");
		assertEquals(95.0,dTotal,0);

	}

}