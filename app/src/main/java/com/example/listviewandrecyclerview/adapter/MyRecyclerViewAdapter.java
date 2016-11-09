package com.example.listviewandrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewandrecyclerview.R;

/**
 * Created by Promlert on 11/8/2016.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.GenericHolder> {

    private Context mContext;
    private String[] mDataset;

    public MyRecyclerViewAdapter(Context context, String[] dataset) {
        mContext = context;
        mDataset = dataset;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 + 1;
/*
        int n = 2;

        if (position % n < n - 1) {
            return 1;
        } else return 2;
*/
    }

    @Override
    public GenericHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
            ViewHolder1 holder = new ViewHolder1(v);
            return holder;
        } else if (viewType == 2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
            ViewHolder2 holder = new ViewHolder2(v);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(GenericHolder holder, int position) {

        position %= mDataset.length;
        holder.setViewData(mDataset[position]);
/*
        try {
            ViewHolder1 vh = (ViewHolder1) holder;
            vh.mProductNameTextView.setText(mDataset[position]);
        } catch (Exception e){
            e.printStackTrace();

            ViewHolder2 vh = (ViewHolder2) holder;
            vh.mProductNameTextView.setText(mDataset[position]);
        }
*/

/*
        if (holder instanceof ViewHolder1) {
            ViewHolder1 vh = (ViewHolder1) holder;
            vh.mProductNameTextView.setText(mDataset[position]);
        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 vh = (ViewHolder2) holder;
            vh.mProductNameTextView.setText(mDataset[position]);
        }
*/
    }

    @Override
    public int getItemCount() {
        return 500;
    }

    public abstract static class GenericHolder extends RecyclerView.ViewHolder {

        public GenericHolder(View itemView) {
            super(itemView);
        }

        abstract public void setViewData(String data);
    }

    public static class ViewHolder1 extends GenericHolder {

        private final TextView mProductNameTextView;
        private final ImageView mProductImageImageView;

        public ViewHolder1(View itemView) {
            super(itemView);
            mProductNameTextView = (TextView) itemView.findViewById(R.id.product_name_text_view);
            mProductImageImageView = (ImageView) itemView.findViewById(R.id.product_image_image_view);
        }

        @Override
        public void setViewData(String data) {
            mProductNameTextView.setText(data);
        }
    }

    public static class ViewHolder2 extends GenericHolder {

        private final TextView mProductNameTextView;
        private final ImageView mProductImageImageView;

        public ViewHolder2(View itemView) {
            super(itemView);
            mProductNameTextView = (TextView) itemView.findViewById(R.id.product_name_text_view);
            mProductImageImageView = (ImageView) itemView.findViewById(R.id.product_image_image_view);
        }

        @Override
        public void setViewData(String data) {
            mProductNameTextView.setText(data);
        }
    }
}
