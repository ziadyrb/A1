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

package book;

public class ChildrenBook extends Book 
{
	//Attributes:
	
	private int minAge;

	//Constructors:
	
	//Default Constructor,
	
	public ChildrenBook() 
	{
		super();		
		minAge=4;
	}
	
	//Parameterized Constructor,
	
	public ChildrenBook(int ma, long iSBN, String t, String a, int y, double p, int n)
	{
		super(iSBN, t, a, y, p, n);
		minAge = ma;
	}
	

	//Get and Set Methods:
	
	public void setminAge(int ma)
	{
		minAge = ma;
	}
	
	public int getminAge()
	{
		return minAge;
	}
	
	//Creating toString Method:
	
	public String toString()
	{
		return "\nCHILDREN BOOK:\n\tTile: " + getTitle() + "\n\tAuthor: " + getAuthor() + "\n\tMinimum age: "+ minAge + "\n\tISBN: " + getISBN() + "\n\tPrice: $ " + getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
	}
	
	//Creating equals Method:
	
	public boolean equals(ChildrenBook cb)
	{
		if((cb == null) || (getClass() != cb.getClass()))
			return false;
		return (minAge==cb.minAge && getISBN() == cb.getISBN() && getYear() == cb.getYear() && (getTitle().equalsIgnoreCase(cb.getTitle())) && (getAuthor().equalsIgnoreCase(cb.getAuthor())) && getNumOfPages() == cb.getNumOfPages() && getPrice() == cb.getPrice());
	}

}
//End of ChildrenBook class
