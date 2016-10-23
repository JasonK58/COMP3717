package jason.comp3717midtermpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SQLMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlmain);

        Button homeButton = (Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.homeButton:
                    Intent intent = new Intent(SQLMainActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        }
    };
}
