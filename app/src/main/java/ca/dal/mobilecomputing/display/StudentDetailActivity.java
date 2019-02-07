package ca.dal.mobilecomputing.display;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

import ca.dal.mobilecomputing.R;

public class StudentDetailActivity extends AppCompatActivity {
    private Activity mActivity;

    ListView courseList;
    TextView studentName, studentID, studentAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_details);

        mActivity = this;
        studentName = findViewById(R.id.lblStudentName);
        studentID = findViewById(R.id.lblStudentB00);
        studentAge = findViewById(R.id.lblStudentAge);
        courseList = findViewById(R.id.listview_courses);
        Toolbar toolbar = findViewById(R.id.toolbar);
    }
}
