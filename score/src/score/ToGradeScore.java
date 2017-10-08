package score;

public class ToGradeScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []score={100,95,90,85,80,75,70,65,60,55,50,45,40,35,30,25,20,15,10,5};
		for (int i=0;i<score.length;i++){
			if (score[i]>=90 && score[i]<=100)
			{
				System.out.println(score[i]+"   优");
			}
			if (score[i]>=80 && score[i]<90)
			{
				System.out.println(score[i]+"   良");
			}
			if (score[i]>=70 && score[i]<80)
			{
				System.out.println(score[i]+"   中");
			}
			if (score[i]>=60 && score[i]<70)
			{
				System.out.println(score[i]+"   及格");
			}
			if (score[i]<60)
			{
				System.out.println(score[i]+"   不及格");
			}
		}
	}

}
