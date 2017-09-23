package com.falak_tejas.wonderlist;

/**
 * Created by Falak on 9/23/17.
 */

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class createCatDialog extends DialogFragment implements View.OnClickListener{
    Button cancel, setNew;
    EditText edit;
    Communicator communicator;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_create_cat_dialog, null);

        cancel = (Button) view.findViewById(R.id.cancelButton);
        setNew = (Button) view.findViewById(R.id.setCatButton);
        cancel.setOnClickListener(this);
        setNew.setOnClickListener(this);
        edit = (EditText) view.findViewById(R.id.editNewCat);

        setCancelable(false);
        return view;
    }

    public void onClick(View view){
        if(view.getId()==R.id.cancelButton){
            dismiss();

        }
        else {
            String title = edit.getText().toString();
            try {
                communicator.addCategory(title);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dismiss();

        }
    }

    interface Communicator{
        void addCategory(String newTitle) throws IOException;
    }
}
