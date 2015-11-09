package rest.addressbook;

/**
 * A managed error
 */
@ApiModel(value="Error", description="Description of an error occured in our service")
public class Error {

	private int id;
	private String description;

	public Error (int id, String description) {
		this.id = id;
    		this.description = description;
  	}
  
}
