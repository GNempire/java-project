package test;

public class test {
	private String private_data="private data";
	public String public_data="public data";
	public void Test_public(){
		System.out.println("This is public data : "+public_data);
	}
	public void Test_private(){
		System.out.println("This is private data : "+private_data);
	}
	protected void Test_protected(){
		System.out.println("This is a protected void");
	}
	void Test_default(){
		System.out.println("This is a default void");
	}
}
