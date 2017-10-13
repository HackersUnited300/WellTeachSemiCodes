package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.Bluetooth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inifinitydroid.eugeneinfinity.wellteachsemicodes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BluetoothActivity extends AppCompatActivity {

    /*
    I dont know how to separate between the teacher and the student activity using this bluetooth crap.
    SO IM PUTTING THEM TOGETHER!
    When you compile them, take note of my comments as it will indicate parts which is for the student and parts which is for teacher.
    CALL ME IF U DONT UNDERSTAND!!!!!!
     */

    @BindView(R.id.peersTextView)
    TextView peersTextView;
    @BindView(R.id.framesTextView)
    TextView framesTextView;
    @BindView(R.id.sendFramesButton)
    Button sendFramesButton;
    @BindView(R.id.btn_start_class)
    Button btnStartClass;
    @BindView(R.id.btn_previous_module)
    Button btnPreviousModule;
    @BindView(R.id.btn_next_module)
    Button btnNextModule;
    @BindView(R.id.btn_back_lesson_slide)
    Button btnBackLessonSlide;
    @BindView(R.id.btn_next_lesson_slide)
    Button btnNextLessonSlide;

    Node node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        node = new Node(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        node.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (node != null)
            node.stop();
    }

    public void sendFrames() {
        node.broadcastFrame(new byte[1]);
    }

    public void refreshPeers() {
        peersTextView.setText(node.getLinks().size() + " connected");
    }

    public void refreshFrames() {
        framesTextView.setText(node.getFramesCount() + " frames");
    }

    //NOTE TO SAM: CODE AFTER THIS PART IS FOR THE TEACHER BLUETOOTH! TAKE NOTE!!
    @OnClick({R.id.sendFramesButton, R.id.btn_start_class, R.id.btn_previous_module, R.id.btn_next_module, R.id.btn_back_lesson_slide, R.id.btn_next_lesson_slide})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sendFramesButton:
                break;
            case R.id.btn_start_class:
                startClass();
                break;
            case R.id.btn_previous_module:
                previousModule();
                break;
            case R.id.btn_next_module:
                nextModule();
                break;
            case R.id.btn_back_lesson_slide:
                previouLessonSlide();
                break;
            case R.id.btn_next_lesson_slide:
                nextLessonSlides();
                break;
        }
        //reset the number of frame
        node.setFramesCount(0);
    }

    private void checkFrames() {
        Log.d("frames count: ", "" + node.getFramesCount());
        node.setFramesCount(0);
        Log.d("frames count: ", "" + node.getFramesCount());
    }

    public void startClass() {
        for (int i = 0; i < 3; i++) {
            sendFrames();
        }
        Toast.makeText(this, ""+node.getFramesCount(), Toast.LENGTH_SHORT).show();
    }

    public void previousModule() {
        for (int i = 0; i < 4; i++) {
            sendFrames();
        }
        Toast.makeText(this, ""+node.getFramesCount(), Toast.LENGTH_SHORT).show();
    }

    public void nextModule() {
        for (int i = 0; i < 5; i++) {
            sendFrames();
        }
        Toast.makeText(this, ""+node.getFramesCount(), Toast.LENGTH_SHORT).show();
    }

    public void previouLessonSlide() {
        for (int i = 0; i < 6; i++) {
            sendFrames();
        }
        Toast.makeText(this, ""+node.getFramesCount(), Toast.LENGTH_SHORT).show();
    }

    public void nextLessonSlides() {
        for (int i = 0; i < 7; i++) {
            sendFrames();
        }
        Toast.makeText(this, ""+node.getFramesCount(), Toast.LENGTH_SHORT).show();
    }
    //END OF TEACHER BLUETOOTH FUNCTIONS AND METHOD!!

    //CODES BELOW THIS LINE CONTAINS FUNCTION FOR STUDENTS!!!!
    private void studentActivityActions(){
        //this part nids ur coding @sam
        int frames = node.getFramesCount();
        if(frames == 3){
            //this is start class.
        }else if(frames == 4){
            //this is to go previous module.
        }else if(frames == 5){
            //this is for next module.
        }else if(frames == 6){
            //this is back one lesson slide.
        }else if(frames == 7){
            //this is to go next lesson slide.
        }
    }
    //end of student functions

    /*
    @SAM:

    SIDE NOTE: because student and teacher uses the same activity class, i suggest we create a
    static/global variable where we can check for condition whether the user is teacher or student.
    Something like during first page when choose student, then it will save into a static variable then we can do checking here to mute some VIEWs out e.g START button etc.
    if u dont understand give me a call. If im not asleep, maybe ill answer!

    Sorry for long post.
     */

}
