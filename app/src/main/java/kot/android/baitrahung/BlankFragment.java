package kot.android.baitrahung;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class BlankFragment extends Fragment {

    private static final String TEXT = "text";


    private String mText;
    private OnFragmentInteractionListener mListener;

    private EditText editTextFragment;
    private Button buttonFragment;

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(String mText) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, mText);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank,container,false);
        buttonFragment = view.findViewById(R.id.button_fragment);
        editTextFragment = view.findViewById(R.id.edittext_fragment);
        editTextFragment.setText(mText);
        editTextFragment.requestFocus();

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendBack = editTextFragment.getText().toString();
                sendBack(sendBack);
            }
        });
        return view;
    }

    private void sendBack(String mText) {
        if(mListener != null){
            mListener.onFragmentInteraction(mText);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener= (OnFragmentInteractionListener) context;
        }else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener=null;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(String text);
    }

}
