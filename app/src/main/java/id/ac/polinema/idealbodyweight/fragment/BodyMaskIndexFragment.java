package id.ac.polinema.idealbodyweight.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BodyMaskIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BodyMaskIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BodyMaskIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BodyMaskIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_mask_index, container, false);
        final EditText heighText = view.findViewById(R.id.editText_height_bmi);
        final EditText weightText = view.findViewById(R.id.editText_weight_bmi);

        Button calculateButton = view.findViewById(R.id.button_submit_bmi);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String heightString = heighText.getText().toString();
                    String weightString = weightText.getText().toString();

                    float height = Integer.parseInt(heightString);
                    float weight = Integer.parseInt(weightString);


                    BodyMaskIndex bodymaskIndex = new BodyMaskIndex(weight, height);
                    mListener.onCalculateBodyMaskClicked(bodymaskIndex.getIndex());
                } else {
                    Toast.makeText(getActivity(), "Please input correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


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
        void onCalculateBodyMaskClicked(float index);
    }
}
