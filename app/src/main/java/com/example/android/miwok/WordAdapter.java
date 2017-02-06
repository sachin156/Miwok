package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by sachin vadlakonda on 1/21/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    int color_id;
    public WordAdapter(Context context, ArrayList<Word> androidFlavors, int  color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, androidFlavors);
        color_id=color;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
//        TextView numberTextView = (TextView) listItemView.findViewById(R.id.textView1);
//        // Get the version number from the current AndroidFlavor object and
//        // set this text on the number TextView
//        numberTextView.setText(currentWord.translationMiwok());

        TextView numberTextView =(TextView) listItemView.findViewById(R.id.textView1);
        numberTextView.setText(currentWord.translationEnglish());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.textView2);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.translationMiwok());
        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        /* if the word has image then following statements will execute*?

         */
        if(currentWord.hasImage())
        {
            imageView.setImageResource(currentWord.Imageid());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }
        View text_color=listItemView.findViewById(R.id.text_color);
        int color= ContextCompat.getColor(getContext(),color_id);
        text_color.setBackgroundColor(color);
        /*code to play particular audio*/

        return listItemView;
    }
}
