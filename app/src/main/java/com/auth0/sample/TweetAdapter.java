package com.auth0.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.auth0.sample.model.Tweet;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by cubecnelson on 24/3/16.
 */
public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    ArrayList<Tweet> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLinearLayout;
        public Context mContext;
        public TextView id;
        public TextView type;
        public TextView author;
        public TextView body;
        public TextView created;
        public ViewHolder(LinearLayout v) {
            super(v);
            mLinearLayout = v;
            mContext = v.getContext();
            id = (TextView) v.findViewById(R.id.id);
            type = (TextView) v.findViewById(R.id.type);
            author = (TextView) v.findViewById(R.id.author);
            body = (TextView) v.findViewById(R.id.body);
            created = (TextView) v.findViewById(R.id.created);
        }
    }


    public TweetAdapter(ArrayList<Tweet> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public TweetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweet_card, parent, false);

        ViewHolder vh = new ViewHolder((LinearLayout) v);
        vh.mContext = parent.getContext();

        return vh;
    }

    @Override
    public void onBindViewHolder(TweetAdapter.ViewHolder holder, int position) {
        holder.author.setText(mDataset.get(position).getAuthor());
        holder.body.setText(mDataset.get(position).getBody());
        holder.created.setText(mDataset.get(position).getCreated_at().toString());
        holder.type.setText(mDataset.get(position).getType());
        holder.id.setText(mDataset.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
