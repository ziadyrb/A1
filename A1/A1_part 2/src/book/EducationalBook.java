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

public class EducationalBook extends Book {
	
	//Attributes:
	
	private int editionNum;
	private String specialityField;
	
	//Constructors:

	//Default constructor,
	
	public EducationalBook()
	{
		super();
		editionNum = 1;
		specialityField = "Math";
	}
	
	//Parameterized Constructor,
	
	public EducationalBook(int en, String sf, long iSBN, String t, String a, int y, double p, int n)
	{
		super(iSBN, t, a, y, p, n);
		editionNum = en;
		specialityField = sf;
	}

	//Get and Set Methods:
	
	public void seteditionNum(int en)
	{
		editionNum = en;
	}
	
	public int geteditionNum()
	{
		return editionNum;
	}
	
	public void setspecialityField(String sf)
	{
		specialityField = sf;
	}
	
	public String getspecialityField()
	{
		return specialityField;
	}
	
	//Creating toString Method:
	
	public String toString(){
		return "\nEDUCATIONAL BOOK:\n\tTile: " + getTitle() + "\n\tAuthor: " + getAuthor() + "\n\tEdition number: "+editionNum+ "\n\tSpeciality field: "+specialityField+ "\n\tISBN: " + getISBN() + "\n\tPrice: $ " + getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
	}
	
	//Creating equals Method:
	
	public boolean equals(EducationalBook eb)
	{
		if((eb == null) || (getClass() != eb.getClass()))
			return false;
		return (editionNum==eb.editionNum)&& (specialityField==eb.specialityField && getISBN() == eb.getISBN() && getYear() == eb.getYear() && (getTitle().equalsIgnoreCase(eb.getTitle())) && (getAuthor().equalsIgnoreCase(eb.getAuthor())) && getNumOfPages() == eb.getNumOfPages() && getPrice() == eb.getPrice());
	}

}
//End of EducationalBook class