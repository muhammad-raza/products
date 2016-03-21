package products.service;

import org.junit.Test;

public class CustomerLocationServiceTest {

    Service service = new CustomerLocationService();
    @Test
    public void testCustomerLocationService() throws Exception{
        service.get("customer1");
    }

}