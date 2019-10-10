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
import com.neosoft.myapplication.viewmodel.FirstChildViewModel;
import com.neosoft.myapplication.viewmodel.SharedViewModel;

/**
 * Created by Vishakha Gahukar on 10/10/19.
 * Email : vishakha.gahukar@neosofttech.com
 */
public class FirstChildFragment extends Fragment {

    SharedViewModel sharedViewModel;

    FirstChildViewModel firstChildViewModel;

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        //seperate viewmodel specific to this fragment, to perform operation that is only
        // required in this fragment
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        //viewmodel to perform this fragment specific operations
        firstChildViewModel = ViewModelProviders.of(getActivity()).get(FirstChildViewModel.class);

        textView = v.findViewById(R.id.textone);

        sharedViewModel.getTextOne().observe(this, textOneObserver);

        return v;
    }

    Observer<String> textOneObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            textView.setText(sharedViewModel.getTextOne().getValue());
        }
    };

}
