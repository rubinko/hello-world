import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class HomeWorkList {

	
	public static void main(String[] args)
	{
		try{
			long time = System.currentTimeMillis();
			PrintWriter quizWriter =  new PrintWriter("Quiz "+time+".txt");
			PrintWriter keyWriter =  new PrintWriter("Key "+time+".txt");
			
			addProblems(new SystemOf2Eq(),10);
			addProblems(new SimplifyExpressions(), 14);
			addProblems(new SimplifyRootExpression(),6);
			addProblems(new Factor(), 14);
			
			for(int i=0;i<myProblems.size();i++)
			{
				String quest= myProblems.get(i).question;
				quizWriter.println((i+1)+".");
				while(quest.indexOf("\n")!= -1               &&
					  quest.indexOf("\n")!= quest.length()-1)
				{
					quizWriter.println(quest.substring(0, quest.indexOf("\n")));
					quest=quest.substring(quest.indexOf("\n")+1);
				}
				quizWriter.println(quest);
				quizWriter.println();
				quizWriter.println();
				
			}
			for(int i=0;i<myProblems.size();i++)
			{
				String quest= myProblems.get(i).question;
				String ans = myProblems.get(i).answer;
				keyWriter.println((i+1)+".");
				while(quest.indexOf("\n")!=-1				&&
					  quest.indexOf("\n")!= quest.length()-1)
				{
					keyWriter.println(quest.substring(0, quest.indexOf("\n")));
					quest=quest.substring(quest.indexOf("\n")+1);
				}
				keyWriter.println(quest);
				keyWriter.println();
				keyWriter.println(ans);
				keyWriter.println();
			}
			
			//quizWriter.print(generateQuiz());
			//keyWriter.println(generateKey());
			quizWriter.close();
			keyWriter.close();
		}
		catch(IOException e)
		{
			System.err.println("IOException occured: "+ e.getMessage());
		}
			System.out.println(generateKey());
	}
	
	private static List<Problem> myProblems=new ArrayList<Problem>();
	/*
	public HomeWorkList()
	{
		myProblems =  new ArrayList<String>();
	}
	
	public HomeWorkList(List<String> problems)
	{
		myProblems= problems;
	}
	
	public HomeWorkList(HomeWorkList other)
	{
		myProblems = new ArrayList<String>();
		for(String s:other.myProblems)
			myProblems.add(s);
	}
	*/
	public static void reset()
	{
		myProblems=new ArrayList<Problem>();
	}
	
	public static void addProblems(ProblemGenerator p, int n)
	{
		for(int i=0; i<n; i++)
			myProblems.add(p.generateProblem());
	}
	
	public static String generateQuiz()
	{
		String Quiz="";
		for(int i=0;i<myProblems.size();i++)
		{
			String quest= myProblems.get(i).question;
			Quiz+=i+". \n"+quest+"\n\n";
			
		}
		return Quiz;
	}
		
	public static String generateKey()
	{
		String Key="";
		for(int i=0;i<myProblems.size();i++)
		{
			String quest= myProblems.get(i).question;
			String ans= myProblems.get(i).answer;
			Key+=(i+1)+". \n"+quest+"\n\n"+ans+"\n\n";
			
		}
		return Key;
	}
}
