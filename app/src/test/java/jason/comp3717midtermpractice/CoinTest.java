package jason.comp3717midtermpractice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import jason.comp3717midtermpractice.Coin.Result;

/**
 * Created by Jason on 2016-10-22.
 */

public class CoinTest {
    private Random random = new FixedRandom();
    private Coin sut = new Coin(random);

    @Test
    public void FlipShouldReturnABooleanValue(){
        Assert.assertTrue(sut.Flip() instanceof Result);
    }

    @Test
    public void FlipShouldReturnTrueOrFalseWhenCalled(){
        Result[] expected = {
                Result.HEADS,
                Result.TAILS,
                Result.HEADS,
                Result.TAILS,
                Result.HEADS,
                Result.TAILS,
                Result.HEADS,
                Result.TAILS};

        Assert.assertTrue(sut.Flip() == expected[0]);
        Assert.assertTrue(sut.Flip() == expected[1]);
        Assert.assertTrue(sut.Flip() == expected[2]);
        Assert.assertTrue(sut.Flip() == expected[3]);
        Assert.assertTrue(sut.Flip() == expected[4]);
        Assert.assertTrue(sut.Flip() == expected[5]);
        Assert.assertTrue(sut.Flip() == expected[6]);
        Assert.assertTrue(sut.Flip() == expected[7]);
    }
}
