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
    	resources.add(AddressBookService.class);
    	resources.add(MOXyJsonProvider.class);
    	resources.add(new AbstractBinder() {
		@Override
		protected void configure() {
			bind(myAddress).to(AddressBook.class);
		}
    	});
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
    	BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8282");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("rest.addressbook");
        beanConfig.setScan(true);
    }
}
