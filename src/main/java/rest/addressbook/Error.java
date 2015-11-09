package rest.addressbook;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A managed error
 */
@ApiModel(value="Error", description="Description of an error ")
public class Error {

	private int id;
	private String description;

  public Error (int id, String description) {
    this.id = id;
    this.description = description;
  }
}
