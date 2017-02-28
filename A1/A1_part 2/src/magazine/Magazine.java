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

package magazine;

public class Magazine extends paperpublication.PaperPublication {
	
	protected enum paperQuality { HIGH, NORMAL, LOW };
	protected enum issuingFrequency { WEEKLY, MONTHLY, YEARLY };

	private paperQuality paperQ;
	private issuingFrequency issuingF;


	// default Constructor
	public Magazine()
	{
		super();
		paperQ = paperQuality.HIGH;
		issuingF = issuingFrequency.MONTHLY;
	}

	// Parameterized Constructor 

	public Magazine(paperQuality pQ, issuingFrequency iF, double p, int n)
	{
		super(p, n);
		paperQ = pQ;
		issuingF = iF;
	}

	// methods get and set 

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


	public String toString()
	{
		return"\nMAGAZINE:\n\tPaper Quality: " +paperQ +"\n\tIssue Frequency: " +issuingF+ "\n\tPrice: $ " +getPrice() + "\n\tNumber of Pages: " + getNumOfPages();
	}
	
	/*
   public boolean equals(Magazine mz)
   {
	   if( paperQ == mz.getPaperQuality && issuingF == mz.getIssuingFrequency)
         return true;
	   else 
         return false;
   }*/

	public boolean equals(Object x)
		{
			if (x == null || this.getClass() != x.getClass())
				return false;
			else
			{
				// cast the passed object to a body object
				Magazine b = (Magazine)x;
				return (paperQ == b.getPaperQuality() && issuingF == b.getIssuingFrequency() && getNumOfPages() == b.getNumOfPages() && getPrice() == b.getPrice());
			}
		}

}
