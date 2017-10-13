package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.StudentTests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.R;
import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.TestMaker.TestMakerModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentTestActivity extends AppCompatActivity {

    @BindView(R.id.lv_student_tests)
    ListView lvStudentTests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_test);
        ButterKnife.bind(this);

        try{
            ArrayList<TestMakerModel> tests = new ArrayList<>();
            tests.add(new TestMakerModel("what is your name?", "ali", "abu", "bobo", "bibi"));
            tests.add(new TestMakerModel("what is your name2?", "alli", "aabu", "bobo", "bibi"));

            StudentTestAdapter adapter = new StudentTestAdapter(this, tests);
            lvStudentTests.setAdapter(adapter);
        }catch (Exception e){
            Log.d("exp", e.toString());
        }

    }
}
