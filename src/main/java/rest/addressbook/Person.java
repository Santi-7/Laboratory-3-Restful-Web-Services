package rest.addressbook;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A person entry in an address book
 *
 */
@ApiModel(value="Person", description="Description of a person that is managed in the adressbook")
public class Person {

	private String name;
	private int id;
	private String email;
	private URI href;
	private List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();
	
	@ApiModelProperty(position = 1, required = true, value = "Contact's name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ApiModelProperty(position = 2, required = true, value = "Contact's id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ApiModelProperty(position = 3, required = true, value = "Contact's email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ApiModelProperty(position = 4, value = "Contact's phone list")
	public List<PhoneNumber> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneNumber> phones) {
		this.phoneList = phones;
	}

	public void addPhone(PhoneNumber phone) {
		getPhoneList().add(phone);
	}

	public boolean hasEmail() {
		return getEmail() != null;
	}

	public void setHref(URI href) {
		this.href = href;
	}
	@ApiModelProperty(position = 5, required = true, value = "Contact's uri")
	public URI getHref() {
		return href;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneList == null) {
			if (other.phoneList != null)
				return false;
		} else if (!phoneList.equals(other.phoneList))
			return false;
		return true;
	}
}
