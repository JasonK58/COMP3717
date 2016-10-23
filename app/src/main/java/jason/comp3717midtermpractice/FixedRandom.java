package jason.comp3717midtermpractice;

import java.util.Random;

/**
 * Created by Jason on 2016-10-22.
 */

public class FixedRandom extends Random {
    private final static boolean[] resultArray = {
            true,
            false,
            true,
            false
    };
    private int counter = 0;

    @Override
    public boolean nextBoolean(){
        final boolean resultValue;

        resultValue = resultArray[counter];

        if (counter == resultArray.length - 1){
            counter = 0;
        }
        else {
            counter++;
        }

        return resultValue;
    }
}
