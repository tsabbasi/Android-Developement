package com.example.tubaabbasi.notebook;

/**
 * Created by tubaabbasi on 10/26/16.
 */
public class Note {
    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;

    public enum Category{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN}

    public Note(String title, String message, Category category) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getId() {
        return noteId;
    }

    public long getDate() {
        return dateCreatedMilli;
    }

    public String toString() {
        return "ID: " + noteId + " Title: " + title + " Message: " + message + " IconID: " + category.name() +  " Date: ";
    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory) {

        switch (noteCategory) {
            case ONE:
                return R.drawable.one;
            case TWO:
                return R.drawable.two;
            case THREE:
                return R.drawable.three;
            case FOUR:
                return R.drawable.four;
            case FIVE:
                return R.drawable.five;
            case SIX:
                return R.drawable.six;
            case SEVEN:
                return R.drawable.seven;
            case EIGHT:
                return R.drawable.eight;
            case NINE:
                return R.drawable.nine;
            case TEN:
                return R.drawable.ten;
        }

        return R.drawable.one;

    }


}
