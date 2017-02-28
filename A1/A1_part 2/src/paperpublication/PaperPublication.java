/*Assignment 1
 *Part 2
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 *For this program we modified the equals() method from our part 1 program.
 *This equals method checks that the objects passed is null or not and if the objects
 *are the same types.  */

package paperpublication;

public class PaperPublication {
	
	//Attributes:	
	
	private double price;
	private int numOfPages;

	//Constructors:
	
	//Default Constructor,
	
	public PaperPublication() 
	{
		price = 0.00;
		numOfPages = -1;
	}

	//Parameterized Constructor,
	
	public PaperPublication(double p, int n)
	{
		price = p;
		numOfPages = n;
	}
	
	
	//Get and Set Methods:

	public void setPrice(double p)
	{
		price = p;
	}

	public void setNumOfPages(int np)
	{
		numOfPages = np;
	}

	
	public double getPrice()
	{
		return price;
	}

	public int getNumOfPages()
	{
		return numOfPages;
	}

	//Creating toString Method:
	
	public String toString()
	{
		return "\nPublication Information:\n\tPrice: $ " + price + "\n\tNumber of Pages: " + numOfPages; 
	} 

	public boolean equals(PaperPublication pp)
	{
		if((pp == null) || (getClass() != pp.getClass()))
			return false;
		else
			return true;
		//return (price == pp.price) && (numOfPages == pp.numOfPages);
	}
} //End of PaperPublication Class