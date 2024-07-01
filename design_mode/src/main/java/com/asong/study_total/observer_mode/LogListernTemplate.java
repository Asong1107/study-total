package com.asong.study_total.observer_mode;

import java.io.File;

public class LogListernTemplate implements ListernService {

    private File file;

    public LogListernTemplate(String type){
        this.file = new File(type);
    }
    @Override
    public void update(String name, File file) {
        System.out.println(name);
    }



}
