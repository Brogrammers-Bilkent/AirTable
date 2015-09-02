
public class Vector
{
	
	// Properties
	private double x, y;
	
	// Constructor
	public Vector (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector (Vector v)
	{
		this.x = v.x;
		this.y = v.y;
	}
	
	// Methods
	public void setXY (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setXY (Vector v)
	{
		this.x = v.x;
		this.y = v.y;
	}
	public void setY (Double y)
	{
		this.y = y;
	}
	public void setX (Double x)
	{
		this.x = x;
	}
	
	public double getX()
	{
		return x;
	}
		
	public double getY()
	{
		return y;
	}
	
	public Vector add (Vector v2)
	{
		this.x += v2.x;
		this.y += v2.y;
		return this;
	}
	
	public static Vector add (Vector v1, Vector v2)
	{
		return new Vector (v1.x + v2.x, v1.y + v2.y);
	}
	
	public Vector subtract (Vector v2)
	{
		this.x -= v2.x;
		this.y -= v2.y;
		return this;
	}
	
	public static Vector subtract (Vector v1, Vector v2)
	{
		return new Vector (v1.x - v2.x, v1.y - v2.y);
	}
	
	public double length()
	{
		return Math.sqrt (x * x + y * y);
	}
	
	public Vector getUnit()
	{
		if (length() != 0)
			return new Vector (x / length(), y / length());
		else
			return new Vector (0, 0);
	}
	
	public void makeUnit()
	{
		if (length() != 0)
		{
			this.x /= length();
			this.y /= length();
		}
	}
		
	public double dotProduct (Vector v2)
	{
		return (x * v2.x + y * v2.y);
	}
	
	public Vector scalarProduct (double scale)
	{
		return new Vector (x * scale, y * scale);
	}
	
	public Vector scale (double scale)
	{
		this.x *= scale;
		this.y *= scale;
		return this;
	}
	
	@Override
	public String toString()
	{
		return  x + " " + y + " " +length();
	}

}