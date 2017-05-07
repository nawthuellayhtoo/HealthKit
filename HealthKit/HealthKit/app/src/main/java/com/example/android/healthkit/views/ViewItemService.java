package com.example.android.healthkit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.CardView;
import com.bumptech.glide.Glide;
import com.example.android.healthkit.R;
import com.example.android.healthkit.data.vos.ServiceVO;

/**
 * Created by nawthuellay on 3/9/2016.
 */
public class ViewItemService extends CardView {

    private TextView tvServiceTitle;
    private ImageView ivServicePhoto;
    private TextView tvServiceDesc;

    public ViewItemService(Context context) {
        super(context);
    }

    public ViewItemService(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemService(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvServiceTitle = (TextView) findViewById(R.id.tv_service_title);
        ivServicePhoto = (ImageView) findViewById(R.id.iv_service_photo);
        tvServiceDesc = (TextView) findViewById(R.id.tv_service_desc);

    }

    public void setData(ServiceVO service) {
        tvServiceTitle.setText(service.getServiceTitle());
        tvServiceDesc.setText(service.getServiceDesc());

               Glide.with(getContext())
                .load(service.getServicePhoto()) //url.
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(ivServicePhoto);
    }
}
