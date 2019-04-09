package com.marlon.simplemvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.marlon.simplemvpdemo.contract.LoginContract;
import com.marlon.simplemvpdemo.presenter.LoginPresenter;

/**
 * @author Marlon
 * @desc LoginActivity
 * @date 2018/10/8
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化LoginPresenter
        new LoginPresenter(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override //关联LoginPresenter
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void onClickLogin(View view) {
        mPresenter.login();
    }
}
