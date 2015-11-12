package rest.addressbook;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import io.swagger.jaxrs.config.BeanConfig;

public class ApplicationConfig extends ResourceConfig  {
	
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
        register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
    	BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8282");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }
}
