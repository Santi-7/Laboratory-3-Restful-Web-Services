package rest.addressbook;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 * A service that manipulates contacts in an address book.
 */
@Path("/contacts")
@Api(value = "/contacts", description = "Operations to manage an adressBook")
@Produces({"application/json", "application/xml"})
public class AddressBookService {

	/**
	 * The (shared) address book object. 
	 */
	@Inject
	AddressBook addressBook;

	/**
	 * A GET /contacts request should return the address book in JSON.
	 * @return a JSON representation of the address book.
	 */
	@GET
	@ApiOperation(
		value = "Get AdressBook",
		notes = "Returns the adress book.",
		response = AddressBook.class
	)
	@Produces(MediaType.APPLICATION_JSON)
	public AddressBook getAddressBook() {
		return addressBook;
	}

	/**
	 * A POST /contacts request should add a new entry to the address book.
	 * @param info the URI information of the request
	 * @param person the posted entity
	 * @return a JSON representation of the new entry that should be available at /contacts/person/{id}.
	 */
	@POST
	@ApiOperation(
		value = "Add Person",
		notes = "Add a contact to the adressbook.",
		response = Person.class
	)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(@Context UriInfo info,
		@ApiParam(value = "Person that wants to be added", required = true) Person person)
	{
		addressBook.getPersonList().add(person);
		person.setId(addressBook.nextId());
		person.setHref(info.getAbsolutePathBuilder().path("person/{id}").build(person.getId()));
		return Response.created(person.getHref()).entity(person).build();
	}

	/**
	 * A GET /contacts/person/{id} request should return a entry from the address book
	 * @param id the unique identifier of a person
	 * @return a JSON representation of the new entry or 404
	 */
	@GET
	@Path("/person/{id}")
	@ApiOperation(
		value = "Get Person",
		notes = "Returns the contact with specified id.",
		response = Person.class
	)
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Successful retrieval of user detail", response = Person.class),
    		@ApiResponse(code = 404, message = "User with given id does not exist")}
    	)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(
		@ApiParam(value = "ID of the contact that needs to be fetched", required = true)
		@PathParam("id") int id)
	{
		for (Person p : addressBook.getPersonList()) {
			if (p.getId() == id) {
				return Response.ok(p).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	/**
	 * A PUT /contacts/person/{id} should update a entry if exists
	 * @param info the URI information of the request
	 * @param person the posted entity
	 * @param id the unique identifier of a person
	 * @return a JSON representation of the new updated entry or 400 if the id is not a key
	 */
	@PUT
	@Path("/person/{id}")
	@ApiOperation(
		value = "Update Person",
		notes = "Modifies a person managed in the adressbook.",
		response = Person.class
	)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(@Context UriInfo info,
		@ApiParam(value = "ID of the contact that wants to be modified", required = true)
		@PathParam("id") int id,
		@ApiParam(value = "Updated contact", required = true) Person person)
	{
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			if (addressBook.getPersonList().get(i).getId() == id) {
				person.setId(id);
				person.setHref(info.getAbsolutePath());
				addressBook.getPersonList().set(i, person);
				return Response.ok(person).build();
			}
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * A DELETE /contacts/person/{id} should delete a entry if exists
	 * @param id the unique identifier of a person
	 * @return 204 if the request is successful, 404 if the id is not a key
	 */
	@DELETE
	@Path("/person/{id}")
	@ApiOperation(
		value = "Delete Person",
		notes = "Delete a contact of the adressbook."
	)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(
		@ApiParam(value = "ID of the contact that is going to be deleted", required = true)
		@PathParam("id") int id)
	{
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			if (addressBook.getPersonList().get(i).getId() == id) {
				addressBook.getPersonList().remove(i);
				return Response.noContent().build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
