package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

public class Phrase extends AppCompatActivity {

MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mcompleteListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
       final ArrayList<Word> words = new ArrayList<Word>();
                words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));
        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.activity_phrase);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                releaseMediaPlayer();

                Word word=words.get(i);
                mediaPlayer=MediaPlayer.create(Phrase.this,word.getSong());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mcompleteListener);

            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

}
