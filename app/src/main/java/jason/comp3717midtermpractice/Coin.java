package jason.comp3717midtermpractice;

import java.util.Random;

/**
 * Created by Jason on 2016-10-22.
 */

public class Coin {
    private final Random random;

    public enum Result {
        HEADS(true, "HEADS", R.drawable.heads),
        TAILS(false, "TAILS", R.drawable.tails);

        private final boolean _value;
        private final String _word;
        private final int _imageId;

        private Result(final boolean value, final String word, final int imageId){
            _value = value;
            _word = word;
            _imageId = imageId;
        }

        public boolean getValue(){
            return _value;
        }

        public String getWord() {
            return _word;
        }

        public int getImageId(){
            return _imageId;
        }
    }

    public Coin(Random r){
        random = r;
    }

    public Result Flip(){
        Result resultValue;
        Boolean result = random.nextBoolean();

        resultValue = result == true ? Result.HEADS : Result.TAILS;

        return resultValue;
    }
}
