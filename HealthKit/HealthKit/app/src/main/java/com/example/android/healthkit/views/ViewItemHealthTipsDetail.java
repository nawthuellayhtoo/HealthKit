package com.example.android.healthkit.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.healthkit.R;
import com.example.android.healthkit.data.vos.HealthTipsVO;

/**
 * Created by nawthuellay on 3/11/2016.
 */
public class ViewItemHealthTipsDetail extends CardView{
    private TextView tvHealthTipsDetailTitle;
    private ImageView ivHealthTipsDetailPhoto;
    private TextView tvHealthTipsDetailDesc;

    public ViewItemHealthTipsDetail(Context context) {
        super(context);
    }

    public ViewItemHealthTipsDetail(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemHealthTipsDetail(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvHealthTipsDetailTitle = (TextView) findViewById(R.id.tv_healthTips_detail_title);
        ivHealthTipsDetailPhoto = (ImageView) findViewById(R.id.iv_healthTips_detail_photo);
        tvHealthTipsDetailDesc = (TextView) findViewById(R.id.tv_healthTips_detail_desc);

    }

    public void setData(HealthTipsVO healhTipVO) {
        tvHealthTipsDetailTitle.setText(healhTipVO.getMainTitle());
        tvHealthTipsDetailDesc.setText(healhTipVO.getTipsDesc());

        Glide.with(getContext())
                .load(healhTipVO.getTipsPhoto()) //url.
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(ivHealthTipsDetailPhoto);
    }
}
