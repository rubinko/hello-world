import java.lang.Math;
public class SystemOf2Eq implements ProblemGenerator{
	public Problem generateProblem()
	{
		String ques = "placeHolder";
		String ans = "placeHolder";
		double random = Math.random();
		if(random<.5)
		{
			int x =(int) (Math.random()*11);
			x = x+1;
			int y =(int) (Math.random()*5);
		    y = y-6;
			int a =(int) (Math.random()*5)+ 1;
			int b =(int) (Math.random()*7)+ 1;
			int c =(int) (Math.random()*6)+ 1;
			int d =(int) (Math.random()*8)+ 1;
			int e = a*x + b*y;
			int f = c*x - d*y;
			String eq1= a+"x + "+b+"y = "+e;
			String eq2= c+"x - "+d+"y = "+f;
			ans = "(x,y) is ("+ x+ ","+ y+ ")";
			if(Math.random()<.5)
				ques = eq1+ "\n"+ eq2;
			else
				ques= eq2+ "\n"+ eq1;
		}
		else
		{
			int x =(int) (Math.random()*5);
			x = x+1;
			int y =(int) (Math.random()*10);
		    y = y+1;
			int a =(int) (Math.random()*5)+ 1;
			int b =(int) (Math.random()*7)+ 1;
			int c =(int) (Math.random()*6)+ 1;
			int d =(int) (Math.random()*8)+ 1;
			int e = a*x + b*y;
			int f = c*x + d*y;
			String eq1= a+"x + "+b+"y = "+e;
			String eq2= c+"x + "+d+"y = "+f;
			ans = "(x,y) is ("+ x+ ","+ y+ ")";
			if(Math.random()<.5)
				ques = eq1+ "\n"+ eq2;
			else
				ques = eq2+ "\n"+ eq1;
		}
		return new Problem(ques,ans);
	}

}
