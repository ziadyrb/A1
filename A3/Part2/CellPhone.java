package Part2;

/**
 *Assignment 3
 *Part 2
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 * 
 *In this program we are making a CellPhone, CellList, CellHash, and CellHashUtilization classes.
 *
 *The CellPhone class contain the basic constructors, mutators and assessors, 
 *toString, equals, and clone methods.
 *
 */


public class CellPhone {

	private long serialNumber;
	private String brand;
	private int year;
	private double price;


	// default constructor
	
	public CellPhone() 
	{
		serialNumber= 0;
		brand = "No Brand";
		year = 0;
		price= 0;
	}

	//Parameterized Constructor
	
	public CellPhone ( long sNum, String brn, double pr, int y ) 
	{

		serialNumber= sNum;
		brand = brn;
		year = y;
		price= pr;
	}
	
	// copy constructor
	
	public CellPhone(CellPhone celPhn) 
	{
		serialNumber = celPhn.serialNumber;
		brand = celPhn.brand;
		year = celPhn.year;
		price = celPhn.price;
	}

	//creation of the method get and set 
	
	public void setBrand(String br)
	{
		brand = br;
	}

	public String getBrand()
	{
		return brand;
	}
	public void setSerialNumber(long sNum)
	{
		serialNumber = sNum;
	}

	public long getSerialNumber()
	{
		return serialNumber;
	}
	public void setYear(int y)
	{
		year = y;
	}

	public long getYear()
	{
		return year;
	}

	public void setPrice(double pr)
	{
		price = pr;
	}

	public double getPrice()
	{
		return price;
	}

	//Clone() method
	
	public CellPhone clone()
	{
		return new CellPhone(this);
	}


	// toString() method 
	
	public String toString ()
	{
		return("Serial Number: " +getSerialNumber() +" Brand: " +getBrand() +" Price: " +getPrice() +" Year: " +getYear());
	}


	// equals() method 
	
	public boolean equals(CellPhone phn) // two cell phone consider equal if they have the same brand and price.
	{
		if (brand.equalsIgnoreCase(phn .getBrand()) && year == phn.getYear()&& price == phn.getPrice())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

} //End of CellPhone Class
