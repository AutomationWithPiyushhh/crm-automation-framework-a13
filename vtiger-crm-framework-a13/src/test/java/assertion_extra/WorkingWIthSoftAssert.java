package assertion_extra;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWIthSoftAssert {
	@Test
	public void case1() {
		System.out.println("hey there....");

		boolean status1 = true;
		boolean status2 = false;

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status2);
		sa.assertFalse(status1);

		String a = "abc";
		String b = "xyz";
		String c = "abc";

		sa.assertEquals(a, b);
		sa.assertEquals(c, b);

		sa.assertAll();

		sa.assertNotEquals(c, c);
		sa.assertNotEquals(a, c);

		Object obj1 = null;
		Object obj2 = new Object();

		sa.assertNull(obj2);
		sa.assertNotNull(obj1);

		System.out.println("How are you ???");

	}

}
