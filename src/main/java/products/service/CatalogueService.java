package products.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import products.entity.CatalogueList;
import products.entity.LocationBasedCatalogues;

import java.io.File;
import java.util.Optional;

public class CatalogueService implements Service<LocationBasedCatalogues> {

    @Override
    public LocationBasedCatalogues get(String location) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(this.getClass().getClassLoader().getResource(DataProvider.LOCATION_PRODUCTS.getFileName()).toURI());
        CatalogueList list = mapper.readValue(file, CatalogueList.class);
        Optional<LocationBasedCatalogues> locationBasedCatalogues = list.getCatalogues().stream().filter(cat -> cat.getLocation().equals(location)).limit(1).findFirst();
        if(!locationBasedCatalogues.isPresent()) {
            throw new NotFoundException();
        }
        return locationBasedCatalogues.get();
    }

}
