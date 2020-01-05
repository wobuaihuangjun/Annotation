package com.example.annotation.demo;

import android.widget.TextView;

import com.example.annotation.BindViewCompiler;
import com.example.annotation.OnClickCompiler;
import com.example.annotation.demo.compilerannotation.Injection;
import com.example.annotation.demo.runtimeannotation.BaseActivity;
import com.example.annotation.demo.runtimeannotation.BindViewRuntime;
import com.example.annotation.demo.runtimeannotation.OnClickRuntime;

public class MainActivity extends BaseActivity {

    @BindViewRuntime(R.id.runtime_add_btn)
    private TextView runtimeAddBtn;
    @BindViewRuntime(R.id.runtime_sum_tv)
    private TextView runtimeSumTv;
    @BindViewCompiler(R.id.compile_add_btn)
    TextView compileAddBtn;
    @BindViewCompiler(R.id.compile_sum_tv)
    TextView compileSumTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Injection.inject(this);
    }

    @OnClickRuntime(R.id.runtime_add_btn)
    void runTimeAdd() {
        String text = runtimeSumTv.getText().toString();
        runtimeSumTv.setText(String.valueOf(Integer.parseInt(text) + 1));
    }

    @OnClickCompiler(R.id.compile_add_btn)
    void compileAdd() {
        String text = compileSumTv.getText().toString();
        compileSumTv.setText(String.valueOf(Integer.parseInt(text) + 1));
    }

}
