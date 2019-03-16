package com.pikchillytechnologies.livestreamingchannels;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChannelAdadpter extends RecyclerView.Adapter<ChannelAdadpter.MyViewHolder> {

    private List<ChannelModel> mChannel_List;
    private Context mContext;

    public ChannelAdadpter(Context context, List<ChannelModel> channel){
        this.mContext = context;
        this.mChannel_List = channel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_listview, parent, false);
        mContext = parent.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ChannelModel channel = mChannel_List.get(position);
        holder.mTextView_ChannelName.setText(channel.getmChannelName());

        holder.mImageView_Channel.setImageResource(channel.getmChannelImageURL());


    }

    @Override
    public int getItemCount() {
        return mChannel_List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView_ChannelName;
        private ImageView mImageView_Channel;

        public MyViewHolder(View view){
            super(view);

            mTextView_ChannelName = view.findViewById(R.id.textview_Channel);
            mImageView_Channel = view.findViewById(R.id.imageview_Channel);
        }
    }
}
