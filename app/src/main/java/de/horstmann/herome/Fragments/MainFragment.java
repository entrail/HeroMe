package de.horstmann.herome.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.horstmann.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int DRAWABLE_LEFT = 0;
    private static final int DRAWABLE_TOP = 1;
    private static final int DRAWABLE_RIGHT = 2;
    private static final int DRAWABLE_BOTTOM = 3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button button_accident;
    private Button button_born;
    private Button button_genetic;
    private Button button_choose;

    private View.OnClickListener onClickListener;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;

                //clear all checked buttons
                button_accident.setCompoundDrawablesWithIntrinsicBounds(button_accident.getCompoundDrawables()[DRAWABLE_LEFT], null, null, null);
                button_born.setCompoundDrawablesWithIntrinsicBounds(button_born.getCompoundDrawables()[DRAWABLE_LEFT], null, null, null);
                button_genetic.setCompoundDrawablesWithIntrinsicBounds(button_genetic.getCompoundDrawables()[DRAWABLE_LEFT], null, null, null);

                //enable choose button when the a button was selected
                button_choose.setEnabled(true);
                button_choose.getBackground().setAlpha(255);


                Drawable drawableLeft = btn.getCompoundDrawables()[DRAWABLE_LEFT];
                Drawable drawableRight = ResourcesCompat.getDrawable(getResources(), R.drawable.itemselected, null);
                btn.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, drawableRight, null);
            }
        };
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        button_accident = (Button) view.findViewById(R.id.button_gotItByAccident);
        button_born = (Button) view.findViewById(R.id.button_bornWithIt);
        button_genetic = (Button) view.findViewById(R.id.button_mutation);
        button_choose = (Button) view.findViewById(R.id.button_choose);
        button_accident.setOnClickListener(onClickListener);
        button_genetic.setOnClickListener(onClickListener);
        button_born.setOnClickListener(onClickListener);


        button_choose.setEnabled(false);
        button_choose.getBackground().setAlpha(128);

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
