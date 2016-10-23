package jason.comp3717midtermpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCoinFlip(View view){
        Log.d(TAG, "Going into Coin Flip");
        Intent intent = new Intent(this, CoinFlipMainActivity.class);
        startActivity(intent);
    }

    public void goToSpinner(View view){
        Log.d(TAG, "Going into Spinner");
        Intent intent = new Intent(this, SpinnerMainActivity.class);
        startActivity(intent);
    }

    public void goToSQL(View view){
        Log.d(TAG, "Going into SQL Demo");
        Intent intent = new Intent(this, SQLMainActivity.class);
        startActivity(intent);
    }
}
