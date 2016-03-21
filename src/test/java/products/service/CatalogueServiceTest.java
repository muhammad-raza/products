package products.service;

import org.junit.Assert;
import org.junit.Test;
import products.entity.*;

import java.util.List;

public class CatalogueServiceTest {

    private CatalogueService service = new CatalogueService();

    @Test
    public void testCatalogueServiceReturnsCorrectChannels_whenLondonIsPassed() throws Exception {

        LocationBasedCatalogues catalogue = service.get(TestUtils.LONDON);
        Assert.assertEquals(TestUtils.LONDON, catalogue.getLocation());

        List<Sports> sports = catalogue.getCatalogue().getSports();
        Assert.assertEquals(2, sports.size());
        Assert.assertTrue(sports.stream().filter(channel -> channel.getName().equals(TestUtils.ARSENAL_TV)).findAny().isPresent());
        Assert.assertTrue(sports.stream().filter(channel -> channel.getName().equals(TestUtils.CHELSEA_TV)).findAny().isPresent());

        checkNewsChannelsPresent(catalogue);
    }

    @Test
    public void testCatalogueServiceReturnsCorrectChannels_whenLiverpoolIsPassed() throws Exception {

        LocationBasedCatalogues catalogue = service.get(TestUtils.LIVERPOOL);
        Assert.assertEquals(TestUtils.LIVERPOOL, catalogue.getLocation());

        List<Sports> sports = catalogue.getCatalogue().getSports();
        Assert.assertEquals(1, sports.size());
        Assert.assertTrue(sports.stream().filter(channel -> channel.getName().equals(TestUtils.LIVERPOOL_TV)).findAny().isPresent());

        checkNewsChannelsPresent(catalogue);
    }

    @Test(expected = NotFoundException.class)
    public void testCatalogueServiceReturnsCorrectChannels_whenLiverpoolIsPassed1() throws Exception {
        service.get(TestUtils.UNKNOWN);
    }

    private void checkNewsChannelsPresent(LocationBasedCatalogues catalogue) {
        List<News> news = catalogue.getCatalogue().getNews();
        Assert.assertEquals(2, news.size());
        Assert.assertTrue(news.stream().filter(channel -> channel.getName().equals(TestUtils.SKY_SPORTS_NEWS)).findAny().isPresent());
        Assert.assertTrue(news.stream().filter(channel -> channel.getName().equals(TestUtils.SKY_NEWS)).findAny().isPresent());
    }

}