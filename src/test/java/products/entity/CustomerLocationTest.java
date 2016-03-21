package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerLocationTest {
    private CustomerLocation customerLocation;

    @Before
    public void setUp() throws Exception {
        customerLocation = TestUtils.buildCustomerLocation(TestUtils.LONDON);
    }

    @Test
    public void getId() throws Exception {
        Assert.assertEquals(TestUtils.CUSTOMER_ONE, customerLocation.getId());
    }

    @Test
    public void getLocation() throws Exception {
        Assert.assertEquals(TestUtils.LONDON, customerLocation.getLocation());
    }
}