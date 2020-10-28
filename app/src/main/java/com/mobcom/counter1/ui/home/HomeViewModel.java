package com.mobcom.counter1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

  private MutableLiveData<Integer> countNumber = new MutableLiveData<>();

  public HomeViewModel() {
    if (countNumber.getValue() == null) {
      initCart();
    }
  }

  public void initCart(){
    countNumber.setValue(0);
  }

  public LiveData<Integer> getCount() {
    return countNumber;
  }

  public void add() {
    int i = countNumber.getValue() + 1;
    countNumber.setValue(i);

  }

  public void min() {
    int i = countNumber.getValue() - 1;
    countNumber.setValue(i);
  }

  public void edit (int num) {
    countNumber.setValue(num);
  }
}