package com.example.lenovo.mvp_tao.data;


import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.User;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.Map;

import io.reactivex.Observer;

public interface UserDataSource {

    void sendVerificationCode(RxFragment fragment, Map<String, String> map, Observer<Object> observer);

    void login(RxFragment fragment, Map<String, String> map, Observer<User> observer);




}
