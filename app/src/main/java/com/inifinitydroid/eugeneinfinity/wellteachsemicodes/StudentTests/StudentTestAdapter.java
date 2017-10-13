package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.StudentTests;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;


import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.R;
import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.TestMaker.TestMakerModel;

import java.util.ArrayList;

/**
 * Created by Eugene Infinity on 13/10/2017.
 */

public class StudentTestAdapter extends ArrayAdapter<TestMakerModel> {


    public StudentTestAdapter(Context context, ArrayList<TestMakerModel> tests) {
        super(context, 0, tests);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TestMakerModel model = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_items, parent, false);
        }

        TextView tvTestQuestion = convertView.findViewById(R.id.tv_test_question);
        RadioButton rbTestSelection1 = convertView.findViewById(R.id.rb_test_selection1);
        RadioButton rbTestSelection2 = convertView.findViewById(R.id.rb_test_selection2);
        RadioButton rbTestSelection3 = convertView.findViewById(R.id.rb_test_selection3);
        RadioButton rbTestSelection4 = convertView.findViewById(R.id.rb_test_selection4);

        tvTestQuestion.setText(model.getQuestion());
        rbTestSelection1.setText(model.getAnswer());
        rbTestSelection2.setText(model.getSelection1());
        rbTestSelection3.setText(model.getSelection2());
        rbTestSelection4.setText(model.getSelection3());
        return convertView;
    }
}
