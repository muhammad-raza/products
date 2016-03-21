package products.service;

public enum DataProvider {

    CUSTOMER_LOCATION("customer_location.json"),
    LOCATION_PRODUCTS("location_products.json");

    private final String fileName;
    DataProvider(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
