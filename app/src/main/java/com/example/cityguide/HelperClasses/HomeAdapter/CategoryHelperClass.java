package com.example.cityguide.HelperClasses.HomeAdapter;

public class CategoryHelperClass {
    int image;
    String title;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }
}
