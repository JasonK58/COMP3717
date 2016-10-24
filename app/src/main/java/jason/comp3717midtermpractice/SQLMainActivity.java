package jason.comp3717midtermpractice;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SQLMainActivity extends ListActivity {
    private SQLiteDatabase mydatabase;
    private String tableName = "midtermPractice";
    private List<String> listItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private EditText nameField;
    private EditText emailField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlmain);

        //Create the database.
        mydatabase = openOrCreateDatabase("midterm",MODE_PRIVATE,null);

        //Create and set the listview adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

        Button homeButton = (Button)findViewById(R.id.homeButton);
        Button submitButton = (Button)findViewById(R.id.submitButton);
        homeButton.setOnClickListener(listener);
        submitButton.setOnClickListener(listener);

        //Delete the table and create it every time the activity starts, since it's just a demo.
        mydatabase.delete(tableName, null, null);

        /* _id is necessary because without it, the cursor can not be properly used.*/
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Username VARCHAR," +
                "Email VARCHAR);");
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.homeButton:
                    Intent intent = new Intent(SQLMainActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.submitButton:
                    nameField = (EditText)findViewById(R.id.nameEditText);
                    emailField = (EditText)findViewById(R.id.emailEditText);

                    String name = nameField.getText().toString();
                    String email = emailField.getText().toString();

                    Insert(name, email);
                    break;
            }
        }
    };

    private void Insert(String name, String email){
        /*Inserts the data into the specified table in the database. The escaped single quotes are
        * necessary. You need single quotes around the strings that are entered.*/
        mydatabase.execSQL("INSERT INTO " + tableName +
                " VALUES(" + "\'" + name + "\'" + "," + "\'" + email + "\'" + ");");

        populateListView();
    }

    private void populateListView(){
        String firstName;
        String email;
        String entry;

        /*Clear the listview first. If this is not done, duplicates will show up.*/
        adapter.clear();

        Cursor resultSet = mydatabase.rawQuery("Select * from " + tableName,null);

        //While the resultSet has rows of data, add them to the listView item list.
        while (resultSet.moveToNext()){
            firstName = resultSet.getString(0);
            email = resultSet.getString(1);
            entry = firstName + " - " + email;
            listItems.add(entry);
        }

        //Close the resultSet when complete.
        if (!resultSet.isClosed()){
            resultSet.close();
        }

        //The listview adapter will update the listview on the screen with this call.
        adapter.notifyDataSetChanged();
    }
}
