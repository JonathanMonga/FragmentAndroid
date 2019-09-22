package com.jonathan.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.jonathan.fragment.fragment.DeuxiemeFragment;
import com.jonathan.fragment.fragment.PremierFragment;

public class MainActivity extends AppCompatActivity implements PremierFragment.OnPremierFragmentInteractionListener, DeuxiemeFragment.OnDeuxiemeFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ceci te permet ajouter un fragment au layout de l'activite et l'afficher apres.
        setTitle("PremierFragment");
        addFragment(PremierFragment.creerInstance(), false, "PremierFragment");
    }

    @Override
    public void onDeuxiemeFragmentInteraction() {
        //Retourner au premier Fragment
        setTitle("PremierFragment");
        addFragment(PremierFragment.creerInstance(), false, "PremierFragment");
    }

    @Override
    public void onPremierFragmentInteraction(String argument) {
        //Ceci te permet ajouter un fragment au layout de l'activite et l'afficher apres.
        setTitle("DeuxiemeFragment");
        addFragment(DeuxiemeFragment.creerInstance(argument), false, "DeuxiemeFragment");
    }

    //Methode qui te permet d'ajouter un fragment au layout de l'activite
    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }

        ft.replace(R.id.root, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}
