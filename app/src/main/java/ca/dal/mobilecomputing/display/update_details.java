package ca.dal.mobilecomputing.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import ca.dal.mobilecomputing.R;

public class update_details extends AppCompatActivity {

    private TextView showID = findViewById(R.id.labelID);
    private TextView showName = findViewById(R.id.labelName);
    private TextView showAge = findViewById(R.id.labelAge);
    private TextView showStudentID = findViewById(R.id.showStudentID);
    private EditText updateName = findViewById(R.id.changeName);
    private EditText updateAge = findViewById(R.id.changeAge);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_details);
    }
}
