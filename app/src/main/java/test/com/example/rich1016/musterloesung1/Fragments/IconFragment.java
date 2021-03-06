package test.com.example.rich1016.musterloesung1.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import test.com.example.rich1016.musterloesung1.R;

/**
 * Created by rich1016 on 20.12.2017.
 */

public class IconFragment extends DialogFragment implements View.OnClickListener {

    View view;

    private OnFragmentInteractionListener mListener;

    public IconFragment (){

    }

    @Override
    public void onStart() {
        super.onStart();

        if (getDialog() == null)
            return;

        int dialogWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        int dialogHeight = ViewGroup.LayoutParams.WRAP_CONTENT;

        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.icon_fragment, container, false);
        ImageButton buttonBus = (ImageButton) view.findViewById(R.id.button_bus);
        buttonBus.setOnClickListener(this);


        view.setBottom(5);


        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IconFragment.OnFragmentInteractionListener) {
            mListener = (IconFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Drawable background);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_bus:
                mListener.onFragmentInteraction(v.getBackground());
                dismiss();
                break;


        }

    }
}
