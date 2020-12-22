package com.example.newspaperapplication;

public class ProfileModal {
    private int icon;
    private String title;
    private String description;

    //constructor
    public ProfileModal(int icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    //Getter


    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //setter

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
