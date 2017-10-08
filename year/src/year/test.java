package year;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		for (int year=1990;year<=2007;year++){
			if (year%4==0 && year%100!=0){
				System.out.print(year+" ");
				num++;
			}
			if (year%400==0){
				System.out.print(year+" ");
				num++;
			}
			if (num==2){
				System.out.print("\n");
				num=0;
			}
		}
	}

}
