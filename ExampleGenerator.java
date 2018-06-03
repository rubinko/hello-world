import java.lang.Math;
public class ExampleGenerator implements ProblemGenerator{

	public Problem generateProblem()
	{
		double x= Math.random();
		String q= "Guess a random number between 0 and 1.";
		String a= "The number was "+ x +".";
		return new Problem(q,a);
	}
}
