package test;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t=new test();
		t.Test_private();
		t.Test_public();
		System.out.println("This is public data used in main : "+t.public_data);
		t.Test_protected();
		t.Test_default();
	}

}
