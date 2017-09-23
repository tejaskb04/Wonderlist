package com.falak_tejas.wonderlist;

/**
 * Created by Falak on 9/23/17.
 */

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Falak on 9/1/17.
 */

public class EditCatDialog extends DialogFragment implements View.OnClickListener {
    Button ok;
    EditText edit;
    String currentName;
    int pos;
    String newName;
    itemEditor editor;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        editor = (EditCatDialog.itemEditor) activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_edit_cat, null);

        ok = (Button) view.findViewById(R.id.ok_btn);
        edit = (EditText) view.findViewById(R.id.editCat);
        ok.setOnClickListener(this);

        edit.setText(currentName);

        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        newName = edit.getText().toString();
        editor.changeItem(pos, newName);
        dismiss();
    }

    public interface itemEditor {
        public void changeItem(int pos, String newName);
    }
}
