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

public class Book extends paperpublication.PaperPublication {

	//Attributes:
	
	protected long isbn; 
	protected int year;	 
	private String title;
	private String authorName;

	//Constructors:

	//Default Constructor,
	
	public Book() 
	{	
		super.getPrice();
		isbn = 123456789;
		year = -1;
		title = "DNE";
		authorName = "DNE";
	}
	
	//Parameterized Constructor,
	
	public Book(long iSBN, String t, String a, int y, double p, int n)
	{
		super(p, n);		
		isbn = iSBN;
		year = y;
		title = t;
		authorName = a;
	}


	//Get and Set Methods:
		
	public void  setISBN(long iSBN)
	{
		isbn = iSBN;
	}
	
	public void setYear(int y)
	{
		year = y;
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public void setAuthor(String a)
	{
		authorName = a;
	}

	public long getISBN()
	{
		return isbn;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return authorName;
	}

	public boolean equals(Book b)
	{
		if((b == null) || (getClass() != b.getClass()))
			return false;
		return ((isbn == b.isbn) && (year == b.year) && (title.equalsIgnoreCase(b.title)) && (authorName.equalsIgnoreCase(b.authorName)) && getNumOfPages() == b.getNumOfPages() && getPrice() == b.getPrice());
	}

}//End of book class
