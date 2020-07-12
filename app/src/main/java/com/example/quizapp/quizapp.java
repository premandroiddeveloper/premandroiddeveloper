package com.example.quizapp;

public class quizapp {
    private int questionno;
    private boolean t3;
    public quizapp(int qu,boolean match)
    {
        questionno=qu;
        t3=match;
    }
    public int getQuestionno()
    {
        return questionno;
    }

    public boolean getmatch()
    {
        return t3;
    }
    public void setmatch(boolean data)
    {
        t3=data;
    }
    public void setquestionno(int data1)
    {
        questionno=data1;
    }


}
