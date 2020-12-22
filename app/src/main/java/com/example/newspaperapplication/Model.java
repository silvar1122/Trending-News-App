package com.example.newspaperapplication;

public class Model {
  private int the_image;
  private String description;
  private String date;

  //constructor
    public Model(int the_image, String description, String date) {
        this.the_image = the_image;
        this.description = description;
        this.date = date;
    }

    //getter
    public int getThe_image() {
        return the_image;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
    //setter

    public void setThe_image(int the_image) {
        this.the_image = the_image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
