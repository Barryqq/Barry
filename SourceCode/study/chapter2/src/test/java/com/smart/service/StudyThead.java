package com.smart.service;

/**
 * Created by Dove on 2018/4/26.
 */
public class StudyThead implements Runnable{
    private int countDown;
    private int taskCount;

    private StudyThead(){}

    public StudyThead(int countDown,int taskCount){
        this.countDown = countDown;
        this.taskCount = taskCount;
    }

    public void show(StudyThead studyThead){
        /*studyThead.countDown--;
        do{
            for (int i = 0;i < 6;i++){
                System.out.print(studyThead.countDown+"("+i+")");
            }
        }while (studyThead.countDown>0);*/
        while (studyThead.countDown-- > 0){
            for (int i = 0;i < 6;i++){
                System.out.print(studyThead.countDown+"("+i+")");
            }
        }
    }

    public String chat(StudyThead studyThead){
        return "#"+studyThead.taskCount+"("+(countDown >0 ? countDown:"end")+")";
    }

    public String chat(){
        return "#"+taskCount+"("+(countDown >0 ? countDown:"end")+")";
    }

    public void run() {
        while (countDown-- > 0){
            System.out.print(chat());
            Thread.yield();
        }
    }


    public static void main(String args[]){
        StudyThead studyThead0 = new StudyThead(5,0);
        StudyThead studyThead1 = new StudyThead(5,1);
        StudyThead studyThead2 = new StudyThead(5,2);
        studyThead0.run();
        studyThead1.run();
        studyThead2.run();

        for (int i=0;i<100;i++){
            StudyThead studyThead = new StudyThead(5,i);
        }
    }
}
