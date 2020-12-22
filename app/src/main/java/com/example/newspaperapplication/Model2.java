package com.example.newspaperapplication;

public class Model2 {
    private int the_image;
    private String title;
    private String background;

    //Constructor
    public Model2(int the_image, String title,String background) {
        this.the_image = the_image;
        this.title = title;
        this.background=background;
    }
    //Getter

    public int getThe_image() {
        return the_image;
    }
    public String getBackground(){
        return background;
    }

    public String getTitle() {
        return title;
    }
    //Setter

    public void setThe_image(int the_image) {
        this.the_image = the_image;
    }
    public void setBackground(String background){
        this.background=background;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
