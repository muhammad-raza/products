package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerLocationListTest {
    private CustomerLocationList customerLocationList;

    @Before
    public void setup(){
        customerLocationList = TestUtils.buildCustomerLocationList();
    }
    @Test
    public void getCustomerLocations() throws Exception {
        Assert.assertTrue(customerLocationList.getCustomerLocations().stream().filter(loc -> loc.getLocation().equals(TestUtils.LONDON)).findAny().isPresent());
        Assert.assertTrue(customerLocationList.getCustomerLocations().stream().filter(loc -> loc.getLocation().equals(TestUtils.LIVERPOOL)).findAny().isPresent());
    }
}