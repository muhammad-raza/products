package products.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import products.entity.CustomerLocation;
import products.entity.CustomerLocationList;
import java.io.File;
import java.util.Optional;


public class CustomerLocationService implements Service<CustomerLocation> {

    @Override
    public CustomerLocation get(String id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(this.getClass().getClassLoader().getResource(DataProvider.CUSTOMER_LOCATION.getFileName()).toURI());
        CustomerLocationList list = mapper.readValue(file, CustomerLocationList.class);
        Optional<CustomerLocation> customerLocation = list.getCustomerLocations().stream().filter(cat -> cat.getId().equalsIgnoreCase(id)).limit(1).findFirst();
        if (!customerLocation.isPresent()){
            throw new NotFoundException();
        }
        return customerLocation.get();
    }
}
