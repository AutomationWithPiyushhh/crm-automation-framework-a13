package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class A {

//	@Test
//	public void test() {
//		WebDriver driver = new ChromeDriver();
//	}
	
	
	String lastName = "Devesh";

	A(String lastName) {
		this.lastName = lastName;
		System.out.println(lastName);
	}

	void add() {
		System.out.println(lastName);
	}
}

public class ConstructorCall {

	public static void main(String[] args) {
//		A a = new A("Awasthi");
//		a.add();
		WebDriver driver = new ChromeDriver();

	}
}
