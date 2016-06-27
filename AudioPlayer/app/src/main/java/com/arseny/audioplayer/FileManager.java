package com.arseny.audioplayer;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
<<<<<<< HEAD
import android.support.v7.widget.Toolbar;
=======
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arseny on 08.06.16.
 */
public class FileManager extends ListActivity {

<<<<<<< HEAD
    public static final String LOG_TAG = FileManager.class.getSimpleName();

    final String basePath = Environment.getExternalStorageDirectory().getAbsolutePath();

    private List<String> directoryEntries = new ArrayList<>();
    private File currentDirectory = new File(basePath);

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.file_manager_activity);
=======
    final String LOG_TAG = "My logs";

    final String basePath = Environment.getExternalStorageDirectory().getAbsolutePath();

    public void onCompletion() {Log.e(LOG_TAG, basePath);}

    private List<String> directoryEntries = new ArrayList<>();
    private File currentDirectory = new File(basePath);

    //when application started
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //set main layout
        setContentView(R.layout.file_manager_activity);
        //browse to root directory
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
        try{
            browseTo(currentDirectory);
        } catch(Exception e) {
            e.printStackTrace();
            currentDirectory = new File("/storage");
            browseTo(currentDirectory);
        }
        onCompletion();
<<<<<<< HEAD

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mActionBarToolbar.setTitle("Files on your phone");
    }

=======
    }

    //browse to parent directory
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
    private void upOneLevel(){
        if(this.currentDirectory.getParent() != null) {
            this.browseTo(this.currentDirectory.getParentFile());
        }
    }

<<<<<<< HEAD
    private void browseTo(final File aDirectory){
        if (aDirectory.isDirectory()){
            this.currentDirectory = aDirectory;
            fill(aDirectory.listFiles());

            TextView titleManager = (TextView) findViewById(R.id.titleManager);
            titleManager.setText(currentDirectory.getAbsolutePath());
            //mActionBarToolbar.setTitle(currentDirectory.getAbsolutePath());
        } else {
            if (aDirectory.getAbsolutePath().endsWith(".mp3")){

                Intent intent = new Intent();
                intent.putExtra("path", aDirectory.getAbsolutePath());
                setResult(RESULT_OK, intent);
                finish();

            } else {

                DialogInterface.OnClickListener okButtonListener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("file://" + aDirectory.getAbsolutePath()));
                        startActivity(i);
                    }
                };
                //listener when NO button clicked
                DialogInterface.OnClickListener cancelButtonListener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //do nothing
                        //or add something you want
                    }
                };

                new AlertDialog.Builder(this)
                        .setTitle("Подтверждение")
                        .setMessage("Хотите открыть файл " + aDirectory.getName() + "?")
                        .setPositiveButton("Да", okButtonListener)
                        .setNegativeButton("Нет", cancelButtonListener)
                        .show();
            }
        }
    }

    private void fill(File[] files) {
=======
    //browse to file or directory
    private void browseTo(final File aDirectory){
        //if we want to browse directory
        if (aDirectory.isDirectory()){
            //fill list with files from this directory
            this.currentDirectory = aDirectory;
            fill(aDirectory.listFiles());

            //set titleManager text
            TextView titleManager = (TextView) findViewById(R.id.titleManager);
            titleManager.setText(aDirectory.getAbsolutePath());
        } else {
            //if we want to open file, show this dialog:
            //listener when YES button clicked
            DialogInterface.OnClickListener okButtonListener = new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface arg0, int arg1) {
                    //intent to navigate file
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("file://" + aDirectory.getAbsolutePath()));
                    //start this activity
                    startActivity(i);
                }
            };
            //listener when NO button clicked
            DialogInterface.OnClickListener cancelButtonListener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    //do nothing
                    //or add something you want
                }
            };

            //create dialog
            new AlertDialog.Builder(this)
                    .setTitle("Подтверждение") //title
                    .setMessage("Хотите открыть файл "+ aDirectory.getName() + "?") //message
                    .setPositiveButton("Да", okButtonListener) //positive button
                    .setNegativeButton("Нет", cancelButtonListener) //negative button
                    .show(); //show dialog
        }
    }

    //fill list
    private void fill(File[] files) {
        //clear list
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
        this.directoryEntries.clear();

        if (this.currentDirectory.getParent() != null)
            this.directoryEntries.add("..");

<<<<<<< HEAD
=======
        //add every file into list
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
        for (File file : files) {
            this.directoryEntries.add(file.getAbsolutePath());
        }

<<<<<<< HEAD
        ArrayAdapter<String> directoryList = new ArrayAdapter<>
=======
        //create array adapter to show everything
        ArrayAdapter<String> directoryList = new ArrayAdapter<String>
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
                (this, R.layout.file_manager_activity_helper, this.directoryEntries);
        this.setListAdapter(directoryList);
    }

<<<<<<< HEAD
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedFileString = this.directoryEntries.get(position);

        if(selectedFileString.equals("..")){
            this.upOneLevel();
        } else {
            File clickedFile = new File(selectedFileString);
            this.browseTo(clickedFile);
        }
    }

    public void onCompletion() {Log.e(LOG_TAG, basePath);}
=======
    //when you clicked onto item
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //get selected file name
        String selectedFileString = this.directoryEntries.get(position);

        //if we select ".." then go upper
        if(selectedFileString.equals("..")){
            this.upOneLevel();
        } else {
            //browse to clicked file or directory using browseTo()
            File clickedFile = null;
            clickedFile = new File(selectedFileString);
            this.browseTo(clickedFile);
        }
    }
>>>>>>> cdb7ab69765d415d4970f3b96b182fa59dc4a3d8
}
