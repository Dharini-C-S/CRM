package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	@Test
	public void m1() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals("B", "A");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test
	public void m2()
	{
	
		int exp =10;
		int act =10;
		
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void m3() {
		int exp =10;
		int act =20;
		
		Assert.assertEquals(exp, act, "Assert failed");
		System.out.println("Assert passed");
	}
	
	@Test
	public void m4() {
		String act = "Qspiders";
		String exp = "Qspiders";
		
		Assert.assertNotEquals(act, exp, "Both are equal");
	}
	
	@Test
	public void m5() {
		String act = "Qspiders";
		String exp = "Qspiders ";//Observe the space
		
		Assert.assertTrue(act.equalsIgnoreCase(exp), "Assert failed");
		System.out.println("Assert Passed");
	}
	
	@Test
	public void m6() {
		
			String act = "Qspiders";
			String exp = "Qspiders ";//Observe the space
			
			Assert.assertFalse(act.equalsIgnoreCase(exp), "Assert passed");
			System.out.println("Assert Failed");
	}
	
	@Test
	public void m7() {
		String s = null;
		
		Assert.assertNull(s, "Value is not null");
		System.out.println("Value is null, Assert Passed");
	}
	
	@Test
	public void m8() {
		int act =10;
		int exp =10;
		
		Assert.assertSame(act, exp, "Not same values");
		System.out.println("Same values");
	}
}
