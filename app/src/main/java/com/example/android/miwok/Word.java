package com.example.android.miwok;

/**
 * Created by sachin vadlakonda on 1/20/2017.
 */

public class Word {
   private String english;
    private String miwok;
    private int image=Imageid;
    /* specially defined class variable checks if image is present*/
    private static int Imageid=-1;
    private int song;
 public Word(String English,String Miwok,int Song)
 {
     english=English;
     miwok=Miwok;
     song=Song;

 }
    public Word(String English,String Miwok,int Image,int Song)
    {
        english=English;
        miwok=Miwok;
        image=Image;
        song=Song;
    }
    public int Imageid()
    {

        return image;
    }
    public boolean hasImage()
    {
        return image!=Imageid;
    }
    public String translationEnglish()
    {
        return english;
    }
    public  String translationMiwok()
    {
        return miwok;
    }
    public int getSong()
    {
        return song;
    }
}
