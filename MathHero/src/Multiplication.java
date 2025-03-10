public class Multiplication extends Enemy
{
	protected String problem;
	protected int solution;

	public Multiplication(java.awt.Color color)
	{
		super(.4, color);
		int n1 = (int)(Math.random()*9)+1;
		int n2 = (int)(Math.random()*9)+1;
		solution = n1*n2;
		problem = ""+n1+"*"+n2;
		radius = 8;
	}

	public String getProblem()
	{
		return problem;
	}

	public int getSolution()
	{
		return solution;
	}
}