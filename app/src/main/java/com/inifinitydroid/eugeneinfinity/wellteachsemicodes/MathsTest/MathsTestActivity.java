package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.MathsTest;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MathsTestActivity extends AppCompatActivity {


    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_question1)
    TextView tvQuestion1;
    @BindView(R.id.tv_question_no1)
    TextView tvQuestionNo1;
    @BindView(R.id.rb_answer_1)
    RadioButton rbAnswer1;
    @BindView(R.id.rb_answer_2)
    RadioButton rbAnswer2;
    @BindView(R.id.rb_answer_3)
    RadioButton rbAnswer3;
    @BindView(R.id.rb_answer_4)
    RadioButton rbAnswer4;

    @Checked
    @BindView(R.id.rbg_answers_q1)
    RadioGroup rbgAnswersQ1;

    @BindView(R.id.ll_question1)
    LinearLayout llQuestion1;
    @BindView(R.id.tv_question2)
    TextView tvQuestion2;
    @BindView(R.id.tv_question_no2)
    TextView tvQuestionNo2;
    @BindView(R.id.rb_answer_1a)
    RadioButton rbAnswer1a;
    @BindView(R.id.rb_answer_2b)
    RadioButton rbAnswer2b;
    @BindView(R.id.rb_answer_3c)
    RadioButton rbAnswer3c;
    @BindView(R.id.rb_answer_4d)
    RadioButton rbAnswer4d;

    @Checked
    @BindView(R.id.rbg_answers_q2)
    RadioGroup rbgAnswersQ2;
    @BindView(R.id.ll_question2)
    LinearLayout llQuestion2;

    private Unbinder unbinder;
    private Validator validator;
    private boolean q1Correct =false;
    private boolean q2Correct =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_test);
        unbinder = ButterKnife.bind(this);
        validator = new Validator(this);
        validator.setValidationListener(validationListener);

        rbgAnswersQ1.setOnCheckedChangeListener(checkedListenerQ1);
        rbgAnswersQ2.setOnCheckedChangeListener(checkedListenerQ2);
    }

    private Validator.ValidationListener validationListener = new Validator.ValidationListener() {
        @Override
        public void onValidationSucceeded() {
            if(q1Correct && q2Correct){
                Toast.makeText(MathsTestActivity.this, "You have answered the question correctly!", Toast.LENGTH_SHORT).show();
            }else if(q1Correct){
                Toast.makeText(MathsTestActivity.this, "Question 2 is incorrect.", Toast.LENGTH_SHORT).show();
            }else if(q2Correct){
                Toast.makeText(MathsTestActivity.this, "Question 1 is incorrect.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MathsTestActivity.this, "Please try solving both questions again!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onValidationFailed(List<ValidationError> errors) {
            for (ValidationError error : errors) {
                View view = error.getView();
                String message = error.getCollatedErrorMessage(MathsTestActivity.this);
                // Display error messages ;)
                if (view instanceof EditText) {
                    ((EditText) view).setError(message);
                } else {
                    Toast.makeText(MathsTestActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener checkedListenerQ1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i==R.id.rb_answer_2){
                q1Correct = true;
            }else{
                q1Correct = false;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener checkedListenerQ2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i==R.id.rb_answer_4d){
                q2Correct = true;
            }else{
                q2Correct = false;
            }
        }
    };

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        validator.validate();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}
