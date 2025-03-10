import java.awt.*;
import java.util.*;

public class World
{
	public Player player;
	public Level[] levels;
	public int level = 0;
	public boolean win = false;
	public boolean lose = false;
	private ColorProvider colorProvider;
	private EnemyFactory enemyFactory;


	public World(Player player, ColorProvider colorProvider, EnemyFactory enemyFactory, Level... levels)
	{
		this.player = player;
		this.levels = levels;
		this.enemyFactory = enemyFactory;
		this.colorProvider = colorProvider;
	}

	public void tryKey(int key)
	{
		for(int i = 0; i < levels.length; i++)
		{
			if(levels[i].key==key)
			{
				level = i;
				i = levels.length;
			}
		}
	}

	public Level getLevel()
	{
		return levels[level];
	}

	public void update()
	{
		if(!win && !lose)
		{
			getLevel().update();
			player.hit(getLevel().getHitting());
			if(player.dead())
				lose = true;
			if(getLevel().finished()&& !lose)
			{
				player.heal();
				level++;
				if(level==levels.length)
				{
					win = true;
					level--;
				}
			}
		}
	}

	public void draw(Graphics g)
	{
		getLevel().drawEnemies(g);
		player.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("Level: "+(level+1),5,15);
		g.drawString("Key: "+getLevel().key,Util.MAX_R*2-90,15);
		if(win)
		{
			g.setColor(Color.GREEN);
			g.setFont(new Font("Verdana",Font.BOLD,14));
			g.drawString("You WIN!",140,150);
		}
		if(lose)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("Verdana",Font.BOLD,14));
			g.drawString("You lose.",140,150);
		}
	}

	public static World getWorld()
	{
		Player player = new Player();
		ColorProvider colorProvider = new ColorProvider();
		EnemyFactory enemyFactory = new EnemyFactory(colorProvider);

		//Level 1
		Vector<Enemy> l1e = new Vector();
		for(int i = 0; i < 10; i ++) l1e.add(enemyFactory.createAddition());
		Level l1 = new Level(2,1234567,l1e);

		//Level 2
		Vector<Enemy> l2e = new Vector();
		for(int i = 0; i < 8; i ++) l2e.add(enemyFactory.createAddition());
		for(int i = 0; i < 5; i ++) l2e.add(enemyFactory.createMultiplication());
		Level l2 = new Level(2,6394658,l2e);

		//Level 3
		Vector<Enemy> l3e = new Vector();
		for(int i = 0; i < 5; i ++) l3e.add(enemyFactory.createAddition());
		for(int i = 0; i < 8; i ++) l3e.add(enemyFactory.createMultiplication());
		Level l3 = new Level(3,1563826,l3e);

		//Level 4
		Vector<Enemy> l4e = new Vector();
		for(int i = 0; i < 7; i ++) l4e.add(enemyFactory.createAddition());
		for(int i = 0; i < 7; i ++) l4e.add(enemyFactory.createMultiplication());
		for(int i = 0; i < 3; i ++) l4e.add(enemyFactory.createSubtraction());
		Level l4 = new Level(3,1927462,l4e);

		//Level 5
		Vector<Enemy> l5e = new Vector();
		for(int i = 0; i < 7; i ++) l5e.add(enemyFactory.createAddition());
		for(int i = 0; i < 7; i ++) l5e.add(enemyFactory.createMultiplication());
		for(int i = 0; i < 5; i ++) l5e.add(enemyFactory.createSubtraction());
		for(int i = 0; i < 3; i ++) l5e.add(enemyFactory.createDivision());
		Level l5 = new Level(3,3728465,l5e);

		//Level 6
		Vector<Enemy> l6e = new Vector();
		for(int i = 0; i < 7; i ++) l6e.add(enemyFactory.createAddition());
		for(int i = 0; i < 7; i ++) l6e.add(enemyFactory.createMultiplication());
		for(int i = 0; i < 7; i ++) l6e.add(enemyFactory.createSubtraction());
		for(int i = 0; i < 5; i ++) l6e.add(enemyFactory.createDivision());
		Level l6 = new Level(3,7384920,l6e);

		//Level 7
		Vector<Enemy> l7e = new Vector();
		for(int i = 0; i < 5; i ++) l7e.add(enemyFactory.createBigAddition());
		for(int i = 0; i < 7; i ++) l7e.add(enemyFactory.createMultiplication());
		for(int i = 0; i < 7; i ++) l7e.add(enemyFactory.createSubtraction());
		for(int i = 0; i < 7; i ++) l7e.add(enemyFactory.createDivision());
		Level l7 = new Level(3,6374198,l7e);

		//Level 8
		Vector<Enemy> l8e = new Vector();
		for(int i = 0; i < 5; i ++) l8e.add(enemyFactory.createBigAddition());
		for(int i = 0; i < 1; i ++) l8e.add(enemyFactory.createBigMultiplication());
		for(int i = 0; i < 7; i ++) l8e.add(enemyFactory.createSubtraction());
		for(int i = 0; i < 7; i ++) l8e.add(enemyFactory.createDivision());
		Level l8 = new Level(3,1738295,l8e);

		return new World(player,colorProvider,enemyFactory,l2,l3,l4,l5,l6,l7,l8);
	}
}