package com.neosoft.myapplication.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neosoft.myapplication.R;
import com.neosoft.myapplication.viewmodel.SecondChildViewModel;
import com.neosoft.myapplication.viewmodel.SharedViewModel;

/**
 * Created by Vishakha Gahukar on 10/10/19.
 * Email : vishakha.gahukar@neosofttech.com
 */
public class SecondChildFragment extends Fragment {

    SharedViewModel sharedViewModel;

    SecondChildViewModel secondChildViewModel;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        //seperate viewmodel specific to this fragment, to perform operation that is only
        // required in this fragment
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        //viewmodel to perform this fragment specific operations
        secondChildViewModel = ViewModelProviders.of(this).get(SecondChildViewModel.class);

        textView = v.findViewById(R.id.textTwo);

        sharedViewModel.getTextTwo().observe(this, textTwoObserver);

        return v;
    }

    Observer<String> textTwoObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            textView.setText(sharedViewModel.getTextTwo().getValue());
        }
    };
}
