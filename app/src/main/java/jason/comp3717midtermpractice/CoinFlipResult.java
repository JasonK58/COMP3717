package jason.comp3717midtermpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CoinFlipResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip_result);

        Intent intent = getIntent();
        int imageId = intent.getExtras().getInt("imageId");

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(imageId);

        Button homeButton = (Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.homeButton:
                    Intent intent = new Intent(CoinFlipResult.this, CoinFlipMainActivity.class);
                    startActivity(intent);
            }
        }
    };
}
