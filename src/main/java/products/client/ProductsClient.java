package products.client;

import products.entity.CustomerLocation;
import products.entity.LocationBasedCatalogues;
import products.service.CatalogueService;
import products.service.CustomerLocationService;

public class ProductsClient {

    private CustomerLocationService locationService = new CustomerLocationService();
    private CatalogueService catalogueService = new CatalogueService();

    public LocationBasedCatalogues getCataloguesFor(String id) throws Exception {
        CustomerLocation customerLocation = locationService.get(id);
        return catalogueService.get(customerLocation.getLocation());
    }
}
