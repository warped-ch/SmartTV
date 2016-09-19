package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 12.07.2016.
 */
interface OnChannelClickedListener {
    void onClick(Channel channel);

    void onClickIMDb(Channel channel);

    void onClickTrailer(Channel channel);

    void onClickZap(Channel channel);
}
