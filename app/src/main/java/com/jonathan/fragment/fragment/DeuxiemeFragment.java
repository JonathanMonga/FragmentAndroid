package com.jonathan.fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jonathan.fragment.R;

import static com.jonathan.fragment.R.id.button;
import static com.jonathan.fragment.R.id.text;

/**
 * Ceci c'est ton deuxieme fragment
 */
public class DeuxiemeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // Ce proprietes statique sont des clefs de tes parametres d'initialisation de ton fragment
    // C'est pas toujours neccessaire
    private static final String ARG_VALEUR = "valeur";

    private OnDeuxiemeFragmentInteractionListener mListener;
    private String valeur;

    public DeuxiemeFragment() {
        // Doit avoir un constructeur vide et public
    }

    /**
     * Utilise cette methode factorie pour creer tes intances du fragment en question.
     * @param paramettre Parametre d'initialisation
     * @return Une nouvelle instance du fragment PremierFragment.
     */
    public static DeuxiemeFragment creerInstance(String paramettre) {
        DeuxiemeFragment fragment = new DeuxiemeFragment();
        Bundle args = new Bundle(); //Bundle est une classe qui te permet d'encapsuler les donnees passer soit entre Activite ou Fragment
        args.putString(ARG_VALEUR, paramettre);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            valeur = getArguments().getString(ARG_VALEUR); //On recupere la donnee encapsulee dans le Bundle
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.deuxieme_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(text);
        textView.setText(valeur);

        view.findViewById(button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onDeuxiemeFragmentInteraction();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDeuxiemeFragmentInteractionListener) {
            mListener = (OnDeuxiemeFragmentInteractionListener) context;
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
    public interface OnDeuxiemeFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDeuxiemeFragmentInteraction();
    }
}
