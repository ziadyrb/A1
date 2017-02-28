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


package magazine;

public class Magazine extends paperpublication.PaperPublication {
	
	//Attributes:
	
	public enum paperQuality { HIGH, NORMAL, LOW };
	public enum issuingFrequency { WEEKLY, MONTHLY, YEARLY };

	private paperQuality paperQ;
	private issuingFrequency issuingF;

	//Constructors:

	//Default Constructor,
	
	public Magazine()
	{
		super();
		paperQ = paperQuality.HIGH;
		issuingF = issuingFrequency.MONTHLY;
	}

	//Parameterized Constructor, 

	public Magazine(paperQuality pQ, issuingFrequency iF, double p, int n)
	{
		super(p, n);
		paperQ = pQ;
		issuingF = iF;
	}

	//Get and Set Methods:
	
	public void setPaperQuality(paperQuality pqt)
	{
		paperQ = pqt;
	}
	
	public paperQuality getPaperQuality()
	{
		return paperQ;
	}

	public void setIssuingFrequency(issuingFrequency isF)
	{
		issuingF = isF;
	}
	
	public issuingFrequency getIssuingFrequency()
	{
		return issuingF;
	}

	//Creating toString Method:
	
	public String toString()
	{
		return"\nMAGAZINE:\n\tPaper Quality: " +paperQ +"\n\tIssue Frequency: " +issuingF+ "\n\tPrice: $ " +getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
	}
	
	//Creating equals Method:
	
	public boolean equals(Magazine x)
		{
			if (x == null || this.getClass() != x.getClass())
				return false;
			else
			{
				//Casting the Magazines object
				Magazine b = (Magazine)x;
				return (paperQ == b.getPaperQuality() && issuingF == b.getIssuingFrequency() && getNumOfPages() == b.getNumOfPages() && getPrice() == b.getPrice());
			}
		}

} //End of Magazine Class
