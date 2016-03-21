package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationBasedCataloguesTest {
    private LocationBasedCatalogues locationBasedCatalogues;

    @Before
    public void setUp() throws Exception {
        locationBasedCatalogues = TestUtils.buildLocationBasedCatalogue(TestUtils.LONDON);
    }

    @Test
    public void getCatalogue() throws Exception {
        Assert.assertTrue(locationBasedCatalogues.getCatalogue().getNews().stream().filter(news -> news.getName().equals(TestUtils.SKY_NEWS)).findAny().isPresent());
        Assert.assertTrue(locationBasedCatalogues.getCatalogue().getNews().stream().filter(news -> news.getName().equals(TestUtils.SKY_SPORTS_NEWS)).findAny().isPresent());
    }

    @Test
    public void getLocation() throws Exception {
        Assert.assertEquals(TestUtils.LONDON, locationBasedCatalogues.getLocation());
    }
}