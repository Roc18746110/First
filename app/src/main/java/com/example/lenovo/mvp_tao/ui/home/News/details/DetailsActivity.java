package com.example.lenovo.mvp_tao.ui.home.News.details;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.bean.ListComment;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.cache.NewsRemoteDataSource;
import com.example.lenovo.mvp_tao.ui.home.News.DetaPreseter;
import com.example.lenovo.mvp_tao.ui.home.News.MyAdapter.DetaAdapter;
import com.example.lenovo.mvp_tao.ui.home.News.MyAdapter.ListCommentAdapter;
import com.example.lenovo.mvp_tao.ui.home.News.NewsContract;
import com.example.lenovo.mvp_tao.ui.home.News.NewsPresenter;
import com.example.lenovo.mvp_tao.userdata.UserDataRepositor;
import com.example.lenovo.mvp_tao.utils.StatusBarManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DetailsActivity extends BaseActivity implements NewsContract.DetaView, View.OnClickListener {
    private DetaPreseter mPreseter;
    private WebView webView;
    private TextView tietel;
    private TextView publishTime;
    private TextView origin;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private DetaAdapter detaAdapter;
    private String newsId;
    private EditText inputComment;
    private TextView btn_submit;
    private PopupWindow popupWindow;
    private ImageView imageView10;
    private Handler handler;
    private View imageView12;
    private ArrayList<ListComment.UserCommentListBean> userCommentList;
    private ArrayList<ListComment.UserCommentListBean> relevantArrayList;
    private View imageView3;
    private ListCommentAdapter adapter;
    private int a = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        StatusBarManager.translucentStatusBar(this);
        StatusBarManager.translucentStatusBarAndImmersive(this);
        Intent intent = getIntent();
        String newid = intent.getStringExtra("newid");
        mPreseter = new DetaPreseter(UserDataRepositor.getInstance());
        mPreseter.detailsList("d56ea66e7ee741f498ca51242c8c6394", newid);
        mPreseter.RelevantList(newid);
        mPreseter.ListComment("d56ea66e7ee741f498ca51242c8c6394");

        setPresenter(mPreseter);
        initview();
    }

    private void initview() {
        webView = findViewById(R.id.webView);
        tietel = findViewById(R.id.textView7);
        publishTime = findViewById(R.id.textView10);
        origin = findViewById(R.id.textView9);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);
        imageView10 = findViewById(R.id.imageView10);
        imageView12 = findViewById(R.id.imageView12);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a >= userCommentList.size()) {
                    Toast.makeText(DetailsActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < 5; i++) {
                        relevantArrayList.add(userCommentList.get(a));
                        a++;
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "http://www.baidu.com");
                startActivity(Intent.createChooser(intent, "分享"));
            }
        });
        imageView10.setOnClickListener(this);
    }

    @Override
    public void details(String message) {
    }

    @Override
    public void detailsList(Newsinfo info) {
        String content = info.getContent();
        tietel.setText(info.getTitle());
        publishTime.setText(info.getPublishTime());
        origin.setText(info.getOrigin());
        webView.loadDataWithBaseURL("", getNewContent(content), "text/html", "UTF-8", "");
    }

    @Override
    public void RelevantList(ArrayList<Relevant> list) {
        Log.e("asdfasf", list.toString());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detaAdapter = new DetaAdapter(list, this);
        recyclerView.setAdapter(detaAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void ListComment(ListComment listComment) {
        userCommentList = listComment.getUserCommentList();
        relevantArrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            relevantArrayList.add(userCommentList.get(i));
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListCommentAdapter(relevantArrayList, this);
        recyclerView2.setAdapter(adapter);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


    }

    @Override
    public void Comment(String message) {

    }

    @Override
    public void Commentnext() {
        Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        mPreseter.ListComment("d56ea66e7ee741f498ca51242c8c6394");
//        adapter.setList(relevantArrayList);
//        adapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(NewsContract.DatePresenter presenter) {
        presenter.attachView(this);


    }

    @Override
    public Activity getActivity() {
        return null;
    }

    private String getNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        Log.d("VACK", doc.toString());
        return doc.toString();
    }

    @SuppressLint("WrongConstant")
    private void showPopupCommnet() {
        final View view = LayoutInflater.from(this).inflate(
                R.layout.comment_popupwindow, null);
        inputComment = (EditText) view.findViewById(R.id.et_discuss);
        btn_submit = (TextView) view.findViewById(R.id.tv_confirm);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, false);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE)
                    popupWindow.dismiss();
                return false;
            }
        });
        popupWindow.setFocusable(true);

        // 设置点击窗口外边窗口消失
//        popupWindow.setOutsideTouchable(true);
//    popupWindow.setBackgroundDrawable(getResources().getDrawable(/
//          R.drawable.popuwindow_white_bg));
        // 设置弹出窗体需要软键盘
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        // 再设置模式，和Activity的一样，覆盖，调整大小。
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        ColorDrawable cd = new ColorDrawable(0x000000);
        popupWindow.setBackgroundDrawable(cd);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.4f;
        getWindow().setAttributes(params);
        // 设置popWindow的显示和消失动画
//    popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.update();
        //popupInputMethodWindow();
        InputMethodManager inputMethodManager = (InputMethodManager) inputComment.getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1f;
                getWindow().setAttributes(params);
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn_submit.setClickable(false);
                String comment1 = inputComment.getText().toString().trim();
                Log.i("comment1--------", comment1);
                if (comment1 == null || "".equals(comment1)) {
                    Toast.makeText(DetailsActivity.this, "请输入评论内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                //调用提交评论接口
//                saveDiscuss(comment1);
                mPreseter.Commrnt("d56ea66e7ee741f498ca51242c8c6394", "d56ea66e7ee741f498ca51242c8c6394", "0", comment1);

                popupWindow.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        showPopupCommnet();
    }

}