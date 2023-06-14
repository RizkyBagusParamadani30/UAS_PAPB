package com.example.uas_papb;

public class ToDoItem {
    private String time;
    private String what;
    private boolean checkbox;

    public ToDoItem (String time, String what){
        this.time = time;
        this.what = what;
        this.checkbox = false;
    }

    public String getTime(){
        return time;
    }

    public  String getWhat(){
        return what;
    }

    public boolean checkbox(){
        return checkbox;
    }

    public void setCheckbox(boolean complete) {
        this.checkbox = complete;
    }
}
