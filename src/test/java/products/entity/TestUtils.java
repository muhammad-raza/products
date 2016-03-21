package products.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public static final String LONDON = "London";
    public static final String LIVERPOOL = "Liverpool";
    public static final String UNKNOWN = "unknown";
    public static final String SKY_SPORTS_NEWS = "Sky Sports News";
    public static final String SKY_NEWS = "Sky News";
    public static final String CHELSEA_TV = "ChelseaTV";
    public static final String ARSENAL_TV = "ArsenalTV";
    public static final String LIVERPOOL_TV = "LiverpoolTV";
    public static final String PRODUCT_ONE = "product1";
    public static final String PRODUCT_TWO = "product2";
    public static final String PRODUCT_THREE = "product3";
    public static final String PRODUCT_FOUR = "product4";
    public static final String PRODUCT_FIVE = "product5";
    public static final String CUSTOMER_ONE = "customer1";
    public static final String CUSTOMER_TWO = "customer2";

    public static Sports buildSports(String id, String name){
        Sports sports = new Sports();
        sports.setId(id);
        sports.setName(name);
        return sports;
    }

    public static News buildNews(String id, String name){
        News news = new News();
        news.setId(id);
        news.setName(name);
        return news;
    }

    public static Catalogue buildCatalogue(String city){
        Catalogue catalogue = new Catalogue();
        List<Sports> sports = new ArrayList<Sports>();
        List<News> news = new ArrayList<News>();
        if (city.equals(LONDON)){
            sports.add(buildSports(PRODUCT_ONE, CHELSEA_TV));
            sports.add(buildSports(PRODUCT_TWO, ARSENAL_TV));
        } else if (city.equals(LIVERPOOL)){
            sports.add(buildSports(PRODUCT_FIVE, LIVERPOOL));
        }
        news.add(buildNews(PRODUCT_THREE, SKY_NEWS));
        news.add(buildNews(PRODUCT_FOUR, SKY_SPORTS_NEWS));
        catalogue.setSports(sports);
        catalogue.setNews(news);
        return catalogue;
    }

    public static LocationBasedCatalogues buildLocationBasedCatalogue(String city){
        LocationBasedCatalogues locationBasedCatalogues = new LocationBasedCatalogues();
        if (city.equals(LONDON)) {
            locationBasedCatalogues.setLocation(LONDON);
            locationBasedCatalogues.setCatalogue(buildCatalogue(LONDON));
        }else {
            locationBasedCatalogues.setLocation(LIVERPOOL);
            locationBasedCatalogues.setCatalogue(buildCatalogue(LIVERPOOL));
        }
        return locationBasedCatalogues;
    }

    public static CatalogueList buildCatalogueList(){
        CatalogueList catalogueList = new CatalogueList();
        List<LocationBasedCatalogues> list = new ArrayList<LocationBasedCatalogues>();
        list.add(buildLocationBasedCatalogue(LONDON));
        list.add(buildLocationBasedCatalogue(LIVERPOOL));
        catalogueList.setCatalogues(list);
        return catalogueList;
    }

    public static CustomerLocation buildCustomerLocation(String city) {
        CustomerLocation customerLocation = new CustomerLocation();
        if (city.equals(LONDON)) {
            customerLocation.setId(CUSTOMER_ONE);
            customerLocation.setLocation(LONDON);
        } else {
            customerLocation.setId(CUSTOMER_TWO);
            customerLocation.setLocation(LIVERPOOL);
        }
        return customerLocation;
    }

    public static CustomerLocationList buildCustomerLocationList(){
        CustomerLocationList customerLocationList = new CustomerLocationList();
        List<CustomerLocation> list = new ArrayList<CustomerLocation>();
        list.add(buildCustomerLocation(LONDON));
        list.add(buildCustomerLocation(LIVERPOOL));
        customerLocationList.setCustomerLocations(list);
        return customerLocationList;
    }
}
