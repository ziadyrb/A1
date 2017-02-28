package parts1and2;

public class DuplicateISBNException extends Exception{

	//Default constructor
		public DuplicateISBNException ()
		{
			super ("Error: There exists a book with the same ISBN ...");
		}
		
		//Exception with parameters
		public DuplicateISBNException(String s)
		{
			super(s);
		}

		//getMessage constructor
		public String getMessage()
		{
			return super.getMessage();
		}
}
