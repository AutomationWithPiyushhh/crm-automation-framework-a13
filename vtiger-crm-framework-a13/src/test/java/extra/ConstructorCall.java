package extra;

class A {

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
		A a = new A("Awasthi");
		a.add();
	}
}
