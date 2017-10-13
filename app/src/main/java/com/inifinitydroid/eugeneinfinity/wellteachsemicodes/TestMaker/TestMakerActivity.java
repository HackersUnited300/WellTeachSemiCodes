package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.TestMaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TestMakerActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @NotEmpty
    @BindView(R.id.et_add_question)
    EditText etAddQuestion;
    @NotEmpty
    @BindView(R.id.et_add_answer)
    EditText etAddAnswer;
    @NotEmpty
    @BindView(R.id.et_add_answer_selection1)
    EditText etAddAnswerSelection1;
    @NotEmpty
    @BindView(R.id.et_add_answer_selection2)
    EditText etAddAnswerSelection2;
    @NotEmpty
    @BindView(R.id.et_add_answer_selection3)
    EditText etAddAnswerSelection3;
    @NotEmpty
    @BindView(R.id.tv_add_selection)
    TextView tvAddSelection;
    @BindView(R.id.tv_preview_question)
    TextView tvPreviewQuestion;
    @BindView(R.id.rg_answer_selections)
    RadioGroup rgAnswerSelections;
    @BindView(R.id.preview_container)
    LinearLayout previewContainer;
    @BindView(R.id.ll_question_maker)
    LinearLayout llQuestionMaker;
    @BindView(R.id.btn_discard)
    Button btnDiscard;
    @BindView(R.id.btn_create_question)
    Button btnCreateQuestion;
    @BindView(R.id.rb_selection1)
    RadioButton rbSelection1;
    @BindView(R.id.rb_selection2)
    RadioButton rbSelection2;
    @BindView(R.id.rb_selection3)
    RadioButton rbSelection3;
    @BindView(R.id.rb_selection4)
    RadioButton rbSelection4;

    private TestMakerModel testmakerModel;
    private Unbinder unbinder;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_maker);
        unbinder = ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(validationListener);
        initViews();
    }

    @OnClick({R.id.btn_discard, R.id.btn_create_question})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_discard:
                clearViews();
                break;
            case R.id.btn_create_question:
                validator.validate();
                break;
        }
    }

    private void clearViews(){
        etAddQuestion.setText("");
        etAddAnswer.setText("");
        etAddAnswerSelection1.setText("");
        etAddAnswerSelection2.setText("");
        etAddAnswerSelection3.setText("");
    }
        private void initViews() {
            etAddQuestion.addTextChangedListener(textWatcher1);
            etAddAnswer.addTextChangedListener(textWatcher2);
            etAddAnswerSelection1.addTextChangedListener(textWatcher3);
            etAddAnswerSelection2.addTextChangedListener(textWatcher4);
            etAddAnswerSelection3.addTextChangedListener(textWatcher5);
        }

        private TextWatcher textWatcher1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvPreviewQuestion.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        private TextWatcher textWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                rbSelection1.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        private TextWatcher textWatcher3 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                rbSelection2.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        private TextWatcher textWatcher4 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                rbSelection3.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        private TextWatcher textWatcher5 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                rbSelection4.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        private Validator.ValidationListener validationListener = new Validator.ValidationListener() {
            @Override
            public void onValidationSucceeded() {
                testmakerModel = new TestMakerModel(etAddQuestion.getText().toString(), etAddAnswer.getText().toString(), etAddAnswerSelection1.getText().toString(), etAddAnswerSelection2.getText().toString(), etAddAnswerSelection3.getText().toString());
                String json = testmakerModel.serializeToJson(testmakerModel);
                Log.d("json question", ""+json);
            }

            @Override
            public void onValidationFailed(List<ValidationError> errors) {
                for (ValidationError error : errors) {
                    View view = error.getView();
                    String message = error.getCollatedErrorMessage(TestMakerActivity.this);
                    // Display error messages ;)
                    if (view instanceof EditText) {
                        ((EditText) view).setError(message);
                    } else {
                        Toast.makeText(TestMakerActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        @Override
        protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
