package products.entity;

import java.util.List;

public class CustomerLocationList implements Entity{
    private List<CustomerLocation> customerLocation;

    public CustomerLocationList() {
    }

    public List<CustomerLocation> getCustomerLocations() {
        return customerLocation;
    }

    public void setCustomerLocations(List<CustomerLocation> customerLocation) {
        this.customerLocation = customerLocation;
    }
}
