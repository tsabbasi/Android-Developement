package com.example.tubaabbasi.notebook;


import android.annotation.TargetApi;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        String[] values = new String[] {"Android", "iPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Mac OS X", "Linux", "OS/2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);
        */

        notes = new ArrayList<Note>();
        notes.add(new Note("Question 1", "A) symbol\nB) binary\nC) byte\nD) system", Note.Category.ONE));
        notes.add(new Note("Question 2", "A) bytes\nB) kilobytes\nC) characters\nD) bits", Note.Category.TWO));
        notes.add(new Note("Question 3", "A) Megabyte\nB) Gigabyte\nC) Petabyte\nD) Terabyte", Note.Category.THREE));
        notes.add(new Note("Question 4", "A) utility\nB) application\nC) operating system\nD) communication", Note.Category.FOUR));
        notes.add(new Note("Question 5", "A) tablet\nB) netbook\nC) desktop\nD) laptop", Note.Category.FIVE));
        notes.add(new Note("Question 6", "A) Desktop computer\nB) Supercomputer\nC) Mainframe computer\nD) Embedded computer", Note.Category.SIX));
        notes.add(new Note("Question 7", "A) Tablet\nB) Desktop\nC) Embedded\nD) Netbook", Note.Category.SEVEN));
        notes.add(new Note("Question 8", "A) output\nB) processing\nC) input\nD) storage", Note.Category.EIGHT));
        notes.add(new Note("Question 9", "A) joystick\nB) e-rod\nC) pointer\nD) stylus", Note.Category.NINE));
        notes.add(new Note("Question 10", "A) resistive\nB) reflective\nC) capacitive\nD) surface acoustic wave", Note.Category.TEN));


        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v, position, id);

    }



}
