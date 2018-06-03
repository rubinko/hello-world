
public class Factor implements ProblemGenerator{
	public Problem generateProblem()
	{
		double r= Math.random();
		
		Problem simplifyProblem;
		if(r<.13)
			simplifyProblem= SimplifyExpressions.generateLevel1();
		else
			simplifyProblem= SimplifyExpressions.generateLevel3();
		//flip a simplification question backwards
		String quest= simplifyProblem.answer;
		String ans= simplifyProblem.question;
		quest="Factor: "+quest;
		ans= ans.substring(ans.indexOf(" ")+ 1);
		return new Problem(quest, ans);
	}

}
