public class Subtraction extends Enemy
{
	public Subtraction(java.awt.Color color)
	{
		super(.4, color);
	}

	public String getProblem()
	{
		return ""+(getN1()+getN2())+"-"+getN2();
	}
	public int getSolution()
	{
		return getN1();
	}
}