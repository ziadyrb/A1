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

package journal;

public class Journal extends paperpublication.PaperPublication {
	
	//Attributes:
	
	private int issueNum;
	private String specialityField;

	//Constructors:
	
	//Default Constructor,
	
	public Journal()
	{
		super();
		issueNum = 0 ;
		specialityField = "DNE";    
	}

	//Parameterized Constructor,
	
	public Journal( int in, String sf, double p, int num)
	{
		super(p, num);
		issueNum = in;
		specialityField = sf;		
	}


	//Get and Set Methods:
	
	public void setIssueNum(int in)
	{
		issueNum = in;
	}
	
	public int getIssueNum()
	{
		return issueNum;
	}

	public void setSpecilityField(String sf)
	{
		specialityField = sf;
	}
	
	public String getSpecialityFied()
	{
		return specialityField;
	}

	//Creating toString Method:
	
	public String toString()
	{
		String journalInfo= "\nJOURNAL:\n\tIssue Number: " + issueNum + "\n\tField: "+ specialityField + "\n\tPrice: $ " +getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
		return journalInfo ;
	}
	
	//Creating equals Method:
	
	public boolean equals(Journal jn)
	{
		if((jn == null) || (getClass() != jn.getClass()))
			return false;
		if( issueNum == jn.getIssueNum() && specialityField.equalsIgnoreCase(jn.getSpecialityFied()) && getNumOfPages() == jn.getNumOfPages() && getPrice() == jn.getPrice())
			return true;
		else 
			return false;

	}
}


