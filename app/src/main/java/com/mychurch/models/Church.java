package com.mychurch.models;

public class Church {

    private String mHolyBook;
    private String mBookChapter;
    private String mBookVerseFrom;
    private String mBookVerseTo;

public Church(String holyBook, String bookChapter, String bookVerseFrom, String bookVerseTo)
    {
        String mHolyBook = holyBook;
        this.mBookChapter = bookChapter;
        this.mBookVerseFrom = bookVerseFrom;
        this.mBookVerseTo = bookVerseTo;

    }
    public String getHolyBook(){
        return mHolyBook;
    }
    public String getBookChapter(){
        return mBookChapter;
    }
    public String getBookVerseFrom(){
        return mBookVerseFrom;
    }
    public String getBookVerseTo(){
        return mBookVerseTo;
    }
}
