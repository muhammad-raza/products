package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.spi.LocaleNameProvider;

import static org.junit.Assert.*;

public class CatalogueTest {
    private Catalogue catalogue;

    @Before
    public void setup(){
        catalogue = TestUtils.buildCatalogue(TestUtils.LONDON);
    }

    @Test
    public void getNews() throws Exception {
        Assert.assertTrue(catalogue.getNews().stream().filter(news -> news.getName().equals(TestUtils.SKY_NEWS)).findAny().isPresent());
        Assert.assertTrue(catalogue.getNews().stream().filter(news -> news.getName().equals(TestUtils.SKY_SPORTS_NEWS)).findAny().isPresent());
    }

    @Test
    public void getSports() throws Exception {
        Assert.assertTrue(catalogue.getSports().stream().filter(news -> news.getName().equals(TestUtils.CHELSEA_TV)).findAny().isPresent());
        Assert.assertTrue(catalogue.getSports().stream().filter(news -> news.getName().equals(TestUtils.ARSENAL_TV)).findAny().isPresent());
    }
}