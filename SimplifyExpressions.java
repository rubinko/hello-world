
public class SimplifyExpressions implements ProblemGenerator{
	public Problem generateProblem()
	{
		double r=Math.random();
		if(r<.1)
			return SimplifyExpressions.generateLevel1();//(ax+b)^2 = Ax^2 + Bx +C
		else if(r<.5) 
			return SimplifyExpressions.generateLevel2();
		else
			return SimplifyExpressions.generateLevel3();
	}
	public static String plusminus()
	{	
		return (Math.random()<.5) ? "+" : "-";
	}
	
	public static char rchar()
	{
		char c= (char) ((int)(Math.random()*26)+'A');
		if(Math.random()<.8)
			c = (char) (c+32);
		if(c!='o'&&c!='O')  return c;
		else return rchar();
	}
	
	public static Problem generateLevel1()
	{
		
		//(ax+b)^2 = Ax^2 + Bx +C
		int a = ((int) (Math.random()*10))+1;
		int b = ((int) (Math.random()*10))+1;
		int A = a*a;
		int B = 2*a*b;
		int C = b*b;
		char c= rchar();// a random standard letter from the ascii table
		String q = "Simplify: ("+ a + c+ " + " + b + ")^2";
		String ans = ""+A + ""+c+"^2 + "+ B +""+c+ " + "+ C;
		return new Problem(q, ans);
	}
	public static Problem generateLevel2()
	{
		//(ax+b)^2 + (cx+d)^2
		int a = ((int)(Math.random()*9)-4);
		int b = ((int)(Math.random()*9)-4);
		int c = ((int)(Math.random()*9)-4);
		int d = ((int)(Math.random()*9)-4);
		String pm1= plusminus();
		String c2= ""+ rchar();
		
		String quest="Simplify: ";
		String ans="";
		if(pm1.equals("+"))
		{
			int A = a*a +c*c;
			int B = 2*a*b +2*c*d;
			int C = b*b + d*d;
			//quest = (ax+b)^2+(cx+d)^2
			quest+= "("+a+c2+ "+ ";
			quest+= b+")^2 + (";
			quest+= c + c2 + "+ "+ d+")^2";
			//ans = Ax^2 + Bx +C
			ans+= "" + A + c2 +"^2 + ";
			ans+= B + "" + c2 + " + ";
			ans+= C;	
		}
		else //if pm1 is -
		{
			int A = a*a - c*c;
			int B = 2*a*b - 2*c*d;
			int C = b*b - d*d;
			//quest = (ax+b)^2+(cx+d)^2
			quest+= "("+a+c2+ "+ ";
			quest+= b+")^2 - (";
			quest+= c + c2 + "+ "+ d+")^2";
			//ans = Ax^2 + Bx +C
			ans+= "" + A + c2 +"^2 + ";
			ans+= B + "" + c2 + " + ";
			ans+= C;	
		}
		return new Problem(quest,ans);
	}
	public static Problem generateLevel3()
	{
		//(ax+-b)*(cx+-d)
		int a=0; 
		while(a==0)
			a=((int)(Math.random()*9)-4);
		int b=0;
		while(b==0)
			b= ((int)(Math.random()*9)-4);
		int c=0;
		while(c==0)
			c= ((int)(Math.random()*9)-4);
		int d=0;
		while(d==0)
			d= ((int)(Math.random()*9)-4);
		String c2= ""+ rchar();
		
		String quest="";
		String ans="";
		int A= a*c;
		int B= a*d + b*c;
		int C= b*d;
		quest+="Simplify: ("+ a + c2+ " + "+ b +") * ("+c +c2 +" + "+ d +")";
		ans+= "" + A + c2 +"^2 + ";
		ans+= B + "" + c2 + " + ";
		ans+= C;
		return new Problem(quest, ans);
	}
}
