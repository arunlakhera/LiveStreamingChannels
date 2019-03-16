package com.pikchillytechnologies.livestreamingchannels;

public class ChannelModel {

    private String mChannelName;
    private String mChannelId;
    private int mChannelImageURL;

    public ChannelModel(String channelname, String channelid, int channelimageurl){
        this.mChannelName = channelname;
        this.mChannelId = channelid;
        this.mChannelImageURL = channelimageurl;
    }

    public String getmChannelName() {
        return mChannelName;
    }

    public void setmChannelName(String mChannelName) {
        this.mChannelName = mChannelName;
    }

    public String getmChannelId() {
        return mChannelId;
    }

    public void setmChannelId(String mChannelId) {
        this.mChannelId = mChannelId;
    }

    public int getmChannelImageURL() {
        return mChannelImageURL;
    }

    public void setmChannelImageURL(int mChannelImageURL) {
        this.mChannelImageURL = mChannelImageURL;
    }
}
