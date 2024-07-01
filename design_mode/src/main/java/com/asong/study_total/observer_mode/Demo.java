package com.asong.study_total.observer_mode;

public class Demo {

    public static void main(String[] args) {
        Editer editer = new Editer();

        editer.listernMaranage.addListernService("open", new LogListernTemplate("1.txt"));

        editer.openFile("1.txt");
    }
}
