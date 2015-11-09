package rest.addressbook;

/**
 * A managed error
 */
public class Error {

	private int id;
	private String description;

	public Error (int id, String description) {
		this.id = id;
    		this.description = description;
  	}
  
}
