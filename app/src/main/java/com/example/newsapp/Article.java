package com.example.newsapp;

public class Article {

    private String mArticleTitle;
    private String mArticleImage;
    private String mArticleUrl;
    private String mArticleSection;
    private String mArticlePublicationDate;

    public Article(String mArticleTitle, String mArticleImage, String mArticleUrl, String mArticleSection, String mArticlePublicationDate) {
        this.mArticleTitle = mArticleTitle;
        this.mArticleImage = mArticleImage;
        this.mArticleUrl = mArticleUrl;
        this.mArticleSection = mArticleSection;
        this.mArticlePublicationDate = mArticlePublicationDate;
    }

    public String getmArticleTitle() {
        return mArticleTitle;
    }

    public String getmArticleImage() {
        return mArticleImage;
    }

    public String getmArticleUrl() {
        return mArticleUrl;
    }

    public String getmArticleSection() {
        return mArticleSection;
    }

    public String getmArticlePublicationDate() {
        return mArticlePublicationDate;
    }
}
