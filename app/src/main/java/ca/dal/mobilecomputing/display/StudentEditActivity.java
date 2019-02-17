package ca.dal.mobilecomputing.display;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import ca.dal.mobilecomputing.R;
import ca.dal.mobilecomputing.db.Database;
import ca.dal.mobilecomputing.model.StudentModel;

public class StudentEditActivity extends AppCompatActivity {
    private Activity mActivity;
    EditText studentName, studentAge;
    TextView studentID;
    Button saveButton;
    Database database;
    StudentModel student;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_details);

        mActivity = this;
        studentName = findViewById(R.id.changeName);
        studentAge = findViewById(R.id.changeAge);
        studentID = findViewById(R.id.labelID);
        saveButton = findViewById(R.id.updateDetails);
        Toolbar toolbar = findViewById(R.id.toolbar);
        database = new Database(mActivity);

        setSupportActionBar(toolbar);

        String studentB00 = getIntent().getStringExtra("B00");
        student = database.getStuModelByID(studentB00);

        studentID.setText(student.getStudent_Id());
        studentName.setText(student.getName());
        studentAge.setText(String.valueOf(student.getAge()));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newAge = Integer.parseInt(studentAge.getText().toString());

                student.setAge(newAge);
                student.setName(studentName.getText().toString());

                if (database.updateStudent(student)){
                    Intent detailsIntent = new Intent(StudentEditActivity.this, StudentDetailActivity.class);

                    Bundle detailsBundle = new Bundle();

                    detailsIntent.putExtra("studentID", student.getStudent_Id());

                    detailsBundle.putString("name", student.getName());
                    detailsBundle.putInt("age", student.getAge());

                    detailsIntent.putExtra("bundle", detailsBundle);

                    startActivity(detailsIntent);
                } else {
                    Toast.makeText(mActivity, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
