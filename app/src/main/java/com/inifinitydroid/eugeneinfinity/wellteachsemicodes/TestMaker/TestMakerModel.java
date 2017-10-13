package com.inifinitydroid.eugeneinfinity.wellteachsemicodes.TestMaker;

import com.google.gson.Gson;

/**
 * Created by Eugene Infinity on 13/10/2017.
 */

public class TestMakerModel {
   private String question;
    private String answer;
    private String selection1;
    private String selection2;
    private String selection3;

    public TestMakerModel(String question, String answer, String selection1, String selection2, String selection3) {
        this.question = question;
        this.answer = answer;
        this.selection1 = selection1;
        this.selection2 = selection2;
        this.selection3 = selection3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSelection1() {
        return selection1;
    }

    public void setSelection1(String selection1) {
        this.selection1 = selection1;
    }

    public String getSelection2() {
        return selection2;
    }

    public void setSelection2(String selection2) {
        this.selection2 = selection2;
    }

    public String getSelection3() {
        return selection3;
    }

    public void setSelection3(String selection3) {
        this.selection3 = selection3;
    }

    // Serialize a single object.
    public String serializeToJson(TestMakerModel myClass) {
        Gson gson = new Gson();
        return gson.toJson(myClass);
    }

    // Deserialize to single object.
    public TestMakerModel deserializeFromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, TestMakerModel.class);
    }

}
