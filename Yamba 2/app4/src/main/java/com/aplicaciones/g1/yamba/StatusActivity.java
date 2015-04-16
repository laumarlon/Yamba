package com.aplicaciones.g1.yamba;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class StatusActivity extends ActionBarActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (savedInstanceState == null) {
                StatusFragment fragment = new StatusFragment();
                getFragmentManager()
                        .beginTransaction()
                        .add(android.R.id.content, fragment,
                                fragment.getClass().getSimpleName())
                        .commit(); //
            }
        }
    }
