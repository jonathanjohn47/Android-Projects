package com.example.fragment3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ProductPage extends AppCompatActivity {

    LoginFragment loginFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_page);

        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.productsPageLoginFragment);
        loginFragment.setOnLoginListener(new LoginFragment.onLoginListener() {
            @Override
            public void loginClick() {
                FragmentB fragmentB = new FragmentB();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.productsPageFrameLayout, fragmentB);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
