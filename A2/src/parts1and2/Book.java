package parts1and2;

/**
 * Assignment 2
 * Part 2
 * Writen By:
 * Jonny Linton (27388489)
 * Sorina Kong (26652786)
 * Ziad Yarbouh (27762585)
 * Sabrina D'Mello (27739486)
 * Program Details:
 * 1) In the main we need to OPEN the Sorted_Book_Info.txt
 * 2) The USER needs to APPEND a few records to the Sorted_Book_Info.txt -----We assume the user has sorted the .txt. THEREFORE no need to sort.
 * 3) Call displayFileContents() to show all the files in Sorted_Book_Info.txt
 * 4) Use bkArr[] to find how many records are in Sorted_Book_Info.txt --- The array need to be set to the size of the total number of records.
 * 5) Program must read the contents of the file to the array objects.
 * 6) The USER enters an ISBN and it uses binaryBookSearch() and the sequentialBookSearch() to find it
 * 7) Store everything in bkArr[] into a binary file
 * 
 */

public class Book {
	
	//Attributes:
	private long iSBN;
	private int yearIssue;
	private String title;     	//Titles need to be connected by _
	private String author;		// Names need to be connected by _
	private double price;
	private int numOfPages;
	
	public Book ()
	{
		iSBN = 123456789;
		yearIssue = 0;
		price = 0.0;	
		title = "No title ";
		numOfPages = 0; 
	}
	
	public Book(long iSBN, int yearIssue, String title, String author, double price, int numOfPages)
	{
		this.iSBN = iSBN;
		this.yearIssue = yearIssue;
		this.title = title;
		this.author = author;
		this.price = price;
		this.numOfPages = numOfPages;
	}
	
	public long getISBN()
	{
		return iSBN;
	}
	
	public void setISBN(long iSBN)
	{
		this.iSBN = iSBN;
	}
	
	public int getYear()
	{
		return yearIssue;
	}
	
	public void setYear(int yearIssue)
	{
		this.yearIssue = yearIssue;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public int getNumOfPages()
	{
		return this.numOfPages;
	}
	
	public void setNumOfPages(int numOfPages)
	{
		this.numOfPages = numOfPages;
	}
	
	public String toString()
	{
		return getISBN() +" " +getTitle() +" " +getYear() +" " +getAuthor() +" " +getPrice() +" " +getNumOfPages();
	}
	
	public boolean equals(Book b)
	{
		return title.equalsIgnoreCase(b.getTitle()) && author.equalsIgnoreCase(b.getAuthor()) && price == b.getPrice() && iSBN == b.getISBN() && yearIssue == b.getYear() && numOfPages == b.getNumOfPages();
	}
		
} //End of Book class
