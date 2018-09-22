package com.example.lenovo.mvp_tao.ui.home.News.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.ListComment;

import java.util.ArrayList;

public class ListCommentAdapter extends RecyclerView.Adapter<ListCommentAdapter.ViewHolder> {
    private ArrayList<ListComment.UserCommentListBean> list;
    private Context context;

    public void setList(ArrayList<ListComment.UserCommentListBean> list) {
        this.list = list;
    }

    public ListCommentAdapter(ArrayList<ListComment.UserCommentListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ListCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_gentei, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCommentAdapter.ViewHolder holder, int position) {
        ListComment.UserCommentListBean userCommentListBean = list.get(position);
//        holder.title.setText(userCommentListBean.getTitle());
        holder.commentTime.setText(userCommentListBean.getCommentTime());
        holder.content.setText(userCommentListBean.getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        private final TextView title;
        private final TextView content;
        private final TextView commentTime;


        public ViewHolder(View itemView) {
            super(itemView);
//            title = itemView.findViewById(R.id.textView4);
            content = itemView.findViewById(R.id.textView13);
            commentTime = itemView.findViewById(R.id.textView16);


        }
    }
}
