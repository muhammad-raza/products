package products.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.entity.Catalogue;
import products.entity.LocationBasedCatalogues;
import products.entity.TestUtils;

public class ProductsClientTest {
    private ProductsClient client;

    @Before
    public void setUp() throws Exception {
        client = new ProductsClient();
    }

    @Test
    public void getCataloguesForCustomerOne() throws Exception {
        LocationBasedCatalogues locationBasedCatalogues = client.getCataloguesFor(TestUtils.CUSTOMER_ONE);
        Assert.assertEquals(TestUtils.LONDON, locationBasedCatalogues.getLocation());
        Catalogue catalogue = locationBasedCatalogues.getCatalogue();

        Assert.assertEquals(2, catalogue.getSports().size());
        Assert.assertTrue(catalogue.getSports().stream().filter(cat -> cat.getName().equals(TestUtils.ARSENAL_TV)).findAny().isPresent());
        Assert.assertTrue(catalogue.getSports().stream().filter(cat -> cat.getName().equals(TestUtils.CHELSEA_TV)).findAny().isPresent());

        Assert.assertEquals(2, catalogue.getNews().size());
        Assert.assertTrue(catalogue.getNews().stream().filter(cat -> cat.getName().equals(TestUtils.SKY_NEWS)).findAny().isPresent());
        Assert.assertTrue(catalogue.getNews().stream().filter(cat -> cat.getName().equals(TestUtils.SKY_SPORTS_NEWS)).findAny().isPresent());
    }

    @Test
    public void getCataloguesForCustomerTwo() throws Exception {
        LocationBasedCatalogues locationBasedCatalogues = client.getCataloguesFor(TestUtils.CUSTOMER_TWO);
        Assert.assertEquals(TestUtils.LIVERPOOL, locationBasedCatalogues.getLocation());
        Catalogue catalogue = locationBasedCatalogues.getCatalogue();

        Assert.assertEquals(1, catalogue.getSports().size());
        Assert.assertTrue(catalogue.getSports().stream().filter(cat -> cat.getName().equals(TestUtils.LIVERPOOL_TV)).findAny().isPresent());

        Assert.assertEquals(2, catalogue.getNews().size());
        Assert.assertTrue(catalogue.getNews().stream().filter(cat -> cat.getName().equals(TestUtils.SKY_NEWS)).findAny().isPresent());
        Assert.assertTrue(catalogue.getNews().stream().filter(cat -> cat.getName().equals(TestUtils.SKY_SPORTS_NEWS)).findAny().isPresent());
    }
}