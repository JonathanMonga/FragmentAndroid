package com.jonathan.fragment.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jonathan.fragment.R;

import static com.jonathan.fragment.R.id.button;
import static com.jonathan.fragment.R.id.edittext;

/**
 * Ceci c'est ton premier fragment
 */
public class PremierFragment extends Fragment {

    // Ceci te permettra d'initialiser les parametres que tu peut passer a tes fragment,
    private String titre_du_fragment;

    private OnPremierFragmentInteractionListener mListener;

    public PremierFragment() {
        // Doit avoir un constructeur vide et public
    }

    /**
     * Utilise cette methode factorie pour creer tes intances du fragment en question.
     * @return Une nouvelle instance du fragment PremierFragment.
     */
    public static PremierFragment creerInstance() {
        PremierFragment fragment = new PremierFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.premier_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = view.findViewById(edittext);
        view.findViewById(button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPremierFragmentInteraction(editText.getText().toString());
            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPremierFragmentInteractionListener) {
            mListener = (OnPremierFragmentInteractionListener) context;
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
     * Pas trop d'explication de ma part, je crois tu comprends l'anglais :)
     *
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPremierFragmentInteractionListener {
        // TODO: Update argument type and name
        void onPremierFragmentInteraction(String argument);
    }
}
