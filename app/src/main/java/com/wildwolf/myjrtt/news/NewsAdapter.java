package com.wildwolf.myjrtt.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.beans.NewsBean;
import com.wildwolf.myjrtt.view.GlideImageView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<NewsBean> mData;
    private boolean mShowFooter = true;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public NewsAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDate(List<NewsBean> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
            ItemViewHolder vh = new ItemViewHolder(v);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer, null);
            view.setLayoutParams(
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {

            NewsBean news = mData.get(position);
            if (news == null) {
                return;
            }
            ((ItemViewHolder) holder).mTitle.setText(news.title);
            ((ItemViewHolder) holder).mDesc.setText(news.digest);
            ((ItemViewHolder) holder).mNewsImg.setImageURL(news.imgsrc);
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter ? 1 : 0;
        if (mData == null) {
            return begin;
        }
        return mData.size() + begin;
    }

    public NewsBean getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void isShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public TextView mDesc;
        public GlideImageView mNewsImg;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mDesc = (TextView) v.findViewById(R.id.tvDesc);
            mNewsImg = (GlideImageView) v.findViewById(R.id.ivNews);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}