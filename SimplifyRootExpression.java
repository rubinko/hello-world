
public class SimplifyRootExpression implements ProblemGenerator {
	
	public Problem generateProblem()
	{
		return generateSimpleNumerical();
	}
	
	public Problem generateSimpleNumerical()
	{
		String question = "";
		String answer = "";
		
		int twos=1+(int)(Math.random()*5);
		int threes=(int)(Math.random()*3);
		int fives=(int)(Math.random()*3);
		int sevens=(int)(Math.random()*2);
		//P(0):5/6 P(1):1/12 P(2):1/12
		int elevens= ((int)(Math.random()*2))*((int)(Math.random()*2))*((int)(Math.random()*3));
		int[] factorization= new int[]{twos, threes, fives, sevens,elevens};
		int[] primes = new int[]{2,3,5,7,11};
		int qInt=1;
		int a=1;
		int b=1;
		
		//qInt= a sqrt(b)
		for(int i=0;i<factorization.length;i++)
		{
			
			qInt*=power(primes[i],factorization[i]);
			a*=power(primes[i],factorization[i]%2);
			b*=power(primes[i],factorization[i]/2);
		}
		
		question = "simplify: (sqrt means square root) \n"
				+ "sqrt("+qInt+")";
		answer = b+"*sqrt("+a+")";
		return new Problem(question, answer);
	}
	
	public int power(int x, int y)
	{
		if(y==0)
			return 1;
		else
			return x*power(x,y-1);
	}	

}
