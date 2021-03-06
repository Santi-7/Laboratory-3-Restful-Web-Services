package rest.addressbook;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static rest.addressbook.PhoneType.*;

/**
 * A phone number 
 *
 */
@ApiModel(value="PhoneNumber", description="Phone number of a contact")
public class PhoneNumber {
	
	private String number;
	private PhoneType type = HOME;

	@ApiModelProperty(position = 1, required = true, value = "Phone number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@ApiModelProperty(position = 2, required = true, value = "Type of number")
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
