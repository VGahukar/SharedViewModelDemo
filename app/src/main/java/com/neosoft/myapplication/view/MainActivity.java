package com.neosoft.myapplication.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.neosoft.myapplication.R;
import com.neosoft.myapplication.viewmodel.MainViewModel;
import com.neosoft.myapplication.viewmodel.SharedViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    SharedViewModel sharedViewModel;

    TabLayout tabLayout;

    ViewPager viewPager;

    EditText etTextOne, etTextTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seperate viewmodel specific to this activity, to perform operation that is only
        // required in this activity
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //viewmodel that is shared among activity and fragment that observes this changes.
        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);

        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewPager);

        etTextOne = findViewById(R.id.etTextOne);

        etTextTwo = findViewById(R.id.etTextTwo);

        initializeViewPager();

        updateDataOnTextChange();
    }

    //update the viewmodel when there's any change in edittext.
    private void updateDataOnTextChange() {

        etTextOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setTextWatcher(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etTextTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setTextWatcherTwo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    //initialize viewpager and its corresponding adapter
    private void initializeViewPager() {
        tabLayout.addTab(tabLayout.newTab().setText("One"));
        tabLayout.addTab(tabLayout.newTab().setText("Two"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
