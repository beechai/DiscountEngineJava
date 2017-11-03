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