package com.back;

public class WiseSaying {

    private final int id;
    private String sentence;
    private String author;

    public WiseSaying(int id, String sentence, String author) {
        this.id=id;
        this.sentence=sentence;
        this.author=author;
    }

    public int getId() {
        return id;
    }

    public String getSentence() {
        return sentence;
    }

    public String getAuthor() {
        return author;
    }

    public void setSentence(String sentence) {
        this.sentence=sentence;
    }

    public void setAuthor(String author) {
        this.author=author;
    }
}
