public class BigAddition extends Enemy
{
	protected String problem;
	protected int solution;

	public BigAddition(java.awt.Color color)
	{
		super(.3, color);
		int n1 = (int)(Math.random()*90)+10;
		int n2 = (int)(Math.random()*90)+10;
		solution = n1+n2;
		problem = ""+n1+"+"+n2;
		radius = 15;
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