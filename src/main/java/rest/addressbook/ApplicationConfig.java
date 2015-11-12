package rest.addressbook;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new AddressBook());
    }


    /**
     * Main constructor
     * @param addressBook a provided address book
     */
    public ApplicationConfig(final AddressBook addressBook) {
    	register(AddressBookService.class);
    	register(MOXyJsonProvider.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(addressBook).to(AddressBook.class);
			}
    		
    	});
    }
    
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> resources = new HashSet();
    	resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
    	resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    	return resources;
    }

}
