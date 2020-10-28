package com.mobcom.counter1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mobcom.counter1.R;

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;
  private TextView countNumber;
  private Button add, min;
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    countNumber = root.findViewById(R.id.countNumber);
    add = root.findViewById(R.id.button_add);
    min = root.findViewById(R.id.button_decrease);

    homeViewModel.getCount().observe(getViewLifecycleOwner(), new Observer<Integer>() {
      @Override
      public void onChanged(Integer integer) {
        countNumber.setText(String.valueOf(integer));
      }
    });

    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        homeViewModel.add();
      }
    });

    min.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        homeViewModel.min();
      }
    });




//    homeViewModel.getCount().observe(getViewLifecycleOwner(), new Observer<String>() {
//      @Override
//      public void onChanged(@Nullable String s) {
//        //textView.setText(s);
//      }
//    });
    return root;
  }
}