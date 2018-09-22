package com.example.lenovo.mvp_tao.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.ui.home.Me.MeFragment;
import com.example.lenovo.mvp_tao.ui.home.News.NewsFragment;
import com.example.lenovo.mvp_tao.ui.home.News.NewsPresenter;
import com.example.lenovo.mvp_tao.ui.home.Topic.TopicFragment;
import com.example.lenovo.mvp_tao.userdata.UserDataRepositor;
import com.example.lenovo.mvp_tao.utils.StatusBarManager;


public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radiogroup;
    private RadioButton news;
    private RadioButton topic;
    private RadioButton me;
    private NewsFragment newsFragment;
    private TopicFragment topicFragment;
    private MeFragment meFragment;
    private NewsPresenter newsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StatusBarManager.setStatusBarColor(this,StatusBarManager.ASC);
        initView();
    }

    private void initView() {
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

        radiogroup.setOnCheckedChangeListener(this);
        news = (RadioButton) findViewById(R.id.news);
        topic = (RadioButton) findViewById(R.id.topic);
        me = (RadioButton) findViewById(R.id.me);

        newsPresenter = new NewsPresenter(UserDataRepositor.getInstance());

        news.setChecked(true);
        addFragment(NewsFragment.class, newsPresenter, R.id.form, null, null);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.news:
                addFragment(NewsFragment.class, newsPresenter, R.id.form, null, null);
                break;
            case R.id.topic:

                addFragment(TopicFragment.class, newsPresenter, R.id.form, null, null);

                break;
            case R.id.me:

                addFragment(MeFragment.class, newsPresenter, R.id.form, null, null);

                break;
        }
    }
}
