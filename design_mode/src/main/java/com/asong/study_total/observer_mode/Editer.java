package com.asong.study_total.observer_mode;

import java.io.File;

public class Editer {


    public   final ListernManager listernMaranage;

    private File file;

    public Editer() {
        this.listernMaranage = new ListernManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        listernMaranage.notify("open", file);

    }

    public void saveFile() {
        listernMaranage.notify("save", file);
    }


}
