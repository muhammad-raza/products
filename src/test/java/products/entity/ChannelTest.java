package products.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by muhammadraza on 20/03/2016.
 */
public class ChannelTest {
    private Channel channel;
    @Before
    public void setUp() throws Exception {
        channel = TestUtils.buildSports(TestUtils.PRODUCT_ONE, TestUtils.CHELSEA_TV);
    }

    @Test
    public void getId() throws Exception {
        Assert.assertEquals(TestUtils.PRODUCT_ONE, channel.getId());
    }


    @Test
    public void getName() throws Exception {
        Assert.assertEquals(TestUtils.CHELSEA_TV, channel.getName());
    }
}