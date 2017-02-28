/*Assignment 1
 *Part 1
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 *This program aims to create a Superclass that has subclasses,
 *and these subclasses have different methods and attributes that are inherited 
 *from the Superclass. Then finally a driver is made to test the program.*/

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

	//Creating equals Method:
	
	public boolean equals(PaperPublication pp)
	{
		return (price == pp.price) && (numOfPages == pp.numOfPages);
	}
	
} //End of PaperPublication Class