package jason.comp3717midtermpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class SpinnerMainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinnerChoices,
                R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_spinner_main);
        String selected = parent.getItemAtPosition(pos).toString();

        switch(selected){
            case "Red":
                layout.setBackgroundColor(Color.RED);
                break;
            case "Blue":
                layout.setBackgroundColor(Color.BLUE);
                break;
            case "Yellow":
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case "White":
                layout.setBackgroundColor(Color.WHITE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
}
