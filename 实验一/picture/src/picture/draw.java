package picture;

public class draw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=7;
		for (int i=1;i>0;){
			for (int j=1;j<=(7-i)/2;j++){
				System.out.print(" ");
			}
			for (int k=1;k<=i;k++){
				System.out.print("*");
			}
			System.out.print("\n");
			if (i<num)
			{
				i=i+2;
			}
			else if (i==num)
			{
				i=i-2;
				num=num-2;
			}
		}
	}

}
