package com.falak_tejas.wonderlist;

/**
 * Created by Falak on 9/23/17.
 */

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Falak on 8/30/17.
 */

public class DeleteWarningDialog extends DialogFragment implements OnClickListener {
    Button cancel, ok;
    ItemCommunicator communicator;
    int position;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        communicator = (ItemCommunicator) activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_delete_warning, null);

        cancel = (Button) view.findViewById(R.id.cancel_btn);
        ok = (Button) view.findViewById(R.id.ok_btn);
        cancel.setOnClickListener(this);
        ok.setOnClickListener(this);

        setCancelable(false);
        return view;
    }



    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.ok_btn){
            communicator.removeCategory(true, position);
            dismiss();
        }
        else {
            dismiss();
        }

    }

    interface ItemCommunicator {
        public void removeCategory(boolean b, int position);
    }
}
