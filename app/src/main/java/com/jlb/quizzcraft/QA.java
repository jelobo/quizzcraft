package com.jlb.quizzcraft;

/**
 * Created by bobo_ on 24-10-17.
 */

public class QA {

    private String question;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private int good_answer;
    private String image;

    public QA() {
        this.question = "";
        this.answer_1 = "";
        this.answer_2 = "";
        this.answer_3 = "";
        this.answer_4 = "";
        this.good_answer = 0;
        this.image = "";
    }

    public QA(String pQuestion, String pAnswer_1, String pAnswer_2, String pAnswer_3, String pAnswer_4, int pGoodAnswer, String pImage) {
        this.question = pQuestion;
        this.answer_1 = pAnswer_1;
        this.answer_2 = pAnswer_2;
        this.answer_3 = pAnswer_3;
        this.answer_4 = pAnswer_4;
        this.good_answer = pGoodAnswer;
        this.image = pImage;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer_1() {return answer_1; }

    public String getAnswer_2() {return answer_2; }

    public String getAnswer_3() {return answer_3; }

    public String getAnswer_4() {return answer_4; }

    public int getResult() {return good_answer; }

    public String getImage() {return image; }

}
