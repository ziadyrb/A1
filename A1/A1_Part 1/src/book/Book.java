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

	//Creating toString Method:
	
	public String toString()
	{
		return "BOOK:\n\tTile: " + title + "\n\tAuthor: " + authorName + "\n\tISBN: " + isbn + "\n\tYear Issued: " + year + "\n\tPrice: $ " + getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
	}

	//Creating equals Method:
	
	public boolean equals(Book b)
	{
		return ((isbn == b.isbn) && (year == b.year) && (title.equalsIgnoreCase(b.title)) && (authorName.equalsIgnoreCase(b.authorName)) && getNumOfPages() == b.getNumOfPages() && getPrice() == b.getPrice());
	}

} //End of book class
