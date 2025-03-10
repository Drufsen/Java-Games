public class Division extends Enemy
{
	protected String problem;
	protected int solution;

	public Division(java.awt.Color color)
	{
		super(.3, color);
		int n1 = (int)(Math.random()*9)+1;
		int n2 = (int)(Math.random()*9)+1;
		solution = n1;
		problem = ""+(n1*n2)+"/"+n2;
		radius = 8;
	}

	@Override
	public String getProblem()
	{
		return problem;
	}

	@Override
	public int getSolution()
	{
		return solution;
	}
}