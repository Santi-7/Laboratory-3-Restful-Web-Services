package rest.addressbook;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.mentabean.BeanConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new AddressBook());
    	BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8002");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }


    /**
     * Main constructor
     * @param addressBook a provided address book
     */
    public ApplicationConfig(final AddressBook addressBook) {
    	register(io.swagger.jaxrs.listing.ApiListingResource.class);
    	register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    	register(AddressBookService.class);
    	register(MOXyJsonProvider.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(addressBook).to(AddressBook.class);
			}
    		
    	});
    }
}
