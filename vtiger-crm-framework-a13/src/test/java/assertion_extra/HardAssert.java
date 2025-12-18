package assertion_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void case1() {
		System.out.println("hey there....");

		boolean status1 = true;
		boolean status2 = false;

		Assert.assertTrue(status1);
		Assert.assertFalse(status2);

		String a = "abc";
		String b = "xyz";
		String c = "abc";

		Assert.assertEquals(a, b);
		Assert.assertEquals(a, c);

		Assert.assertNotEquals(a, b);
		Assert.assertNotEquals(a, c);

		Object obj1 = null;
		Object obj2 = new Object();

		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);

		System.out.println("How are you ???");
	}

}
