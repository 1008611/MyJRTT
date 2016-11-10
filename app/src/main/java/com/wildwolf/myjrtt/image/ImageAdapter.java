package com.wildwolf.myjrtt.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.utils.ToolsUtil;
import com.wildwolf.myjrtt.view.GlideImageView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class ImageAdapter  extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder>{

    private List<ImageBean> mData;
    private Context mContext;
    private int mMaxWidth;
    private int mMaxHeight;
    private OnItemClickListener mOnItemClickListener;

    public ImageAdapter(Context context) {
        this.mContext = context;
        mMaxWidth = ToolsUtil.getWidthInPx(mContext) - 20;
        mMaxHeight = ToolsUtil.getHeightInPx(mContext) - ToolsUtil.getStatusHeight(mContext) -
                ToolsUtil.dip2px(mContext, 96);
    }

    public void setmData(List<ImageBean> mData) {
        this.mData= mData;
        this.notifyDataSetChanged();
    }


    @Override
    public ImageAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        ItemViewHolder vh = new ItemViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ItemViewHolder holder, int position) {
        ImageBean imageBean = mData.get(position);
        if (imageBean == null){
            return;
        }
        holder.mTitle.setText(imageBean.getTitle());
        float scale = (float)imageBean.getWidth() / (float) mMaxWidth;
        int height = (int)(imageBean.getHeight() / scale);
        if(height > mMaxHeight) {
            height = mMaxHeight;
        }
        holder.mImage.setLayoutParams(new LinearLayout.LayoutParams(mMaxWidth, height));
//        ImageLoaderUtils.display(mContext, holder.mImage, imageBean.getThumburl());
        holder.mImage.setImageURL(imageBean.getThumburl());

    }

    @Override
    public int getItemCount() {
        if (mData == null){
            return 0;
        }
        return mData.size();
    }


    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public GlideImageView mImage;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mImage = (GlideImageView) v.findViewById(R.id.ivImage);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null){
                mOnItemClickListener.onItemClick(v,this.getPosition());
            }
        }
    }
}
