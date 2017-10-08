package flower;

public abstract class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=0;
		int c=0;
		for (int number=100;number<1000;number++)
		{
			a=number/100;
			b=(number-a*100)/10;
			c=number%10;
			if (a*a*a+b*b*b+c*c*c==number)
			{
				System.out.println(number);
			}
		}
	}

}
