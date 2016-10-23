package jason.comp3717midtermpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import jason.comp3717midtermpractice.Coin.Result;

import java.util.Random;

public class CoinFlipMainActivity extends AppCompatActivity {
    private Random random = new Random();
    private Coin coin = new Coin(random);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip_main);

        Button flipButton = (Button)findViewById(R.id.flipButton);
        Button flipButton2 = (Button)findViewById(R.id.flipButton2);
        Button flipButton3 = (Button)findViewById(R.id.flipButton3);
        Button home = (Button)findViewById(R.id.homeButton);
        flipButton.setOnClickListener(listener);
        flipButton2.setOnClickListener(listener);
        flipButton3.setOnClickListener(listener);
        home.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = (TextView)findViewById(R.id.textView);
            ImageView imageView = (ImageView)findViewById(R.id.imageView);

            switch(v.getId()){
                case R.id.flipButton:
                    Result result = coin.Flip();
                    String returnResult = result.getWord();

                    textView.setText(returnResult);
                    break;
                case R.id.flipButton2:
                    Result result2 = coin.Flip();
                    int resultId = result2.getImageId();

                    imageView.setBackgroundResource(resultId);
                    break;
                case R.id.flipButton3:
                    Intent intent = new Intent(CoinFlipMainActivity.this, CoinFlipResult.class);
                    Result result3 = coin.Flip();
                    int resultId2 = result3.getImageId();

                    intent.putExtra("imageId", resultId2);
                    startActivity(intent);
                    break;
                case R.id.homeButton:
                    Intent intent2 = new Intent(CoinFlipMainActivity.this, MainActivity.class);
                    startActivity(intent2);
                    break;
            }

        }
    };
}
