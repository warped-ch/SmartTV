package org.dev.warped.smarttv;

interface OnChannelClickedListener {
    void onClick(Channel channel);

    void onClickIMDb(Channel channel);

    void onClickTrailer(Channel channel);

    void onClickZap(Channel channel);
}
