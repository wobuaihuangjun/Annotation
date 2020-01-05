package com.example.annotation.demo.runtimeannotation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        new InjectionRuntime().inject(this);
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
