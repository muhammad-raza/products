package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogueListTest {
    private CatalogueList catalogueList;

    @Before
    public void setUp() throws Exception {
        catalogueList = TestUtils.buildCatalogueList();
    }

    @Test
    public void getCatalogues() throws Exception {
        Assert.assertEquals(2, catalogueList.getCatalogues().size());
        Assert.assertTrue(catalogueList.getCatalogues().stream().filter(cat -> cat.getLocation().equals(TestUtils.LONDON)).findAny().isPresent());
        Assert.assertTrue(catalogueList.getCatalogues().stream().filter(cat -> cat.getLocation().equals(TestUtils.LIVERPOOL)).findAny().isPresent());

    }

    @Test
    public void setCatalogues() throws Exception {

    }
}