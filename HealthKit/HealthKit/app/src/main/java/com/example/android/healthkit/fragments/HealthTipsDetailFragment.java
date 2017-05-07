package com.example.android.healthkit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.healthkit.R;
import com.example.android.healthkit.activities.HealthTipsDetailActivity;
import com.example.android.healthkit.data.DataManager;
import com.example.android.healthkit.data.vos.HealthTipsVO;
import com.example.android.healthkit.views.ViewItemHealthTipsDetail;

import java.util.List;

/**
 * Created by nawthuellay on 3/11/2016.
 */
public class HealthTipsDetailFragment extends Fragment {
    public HealthTipsDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // int position = getArguments().getInt(ARG_POSITION, 0);
        HealthTipsDetailActivity healthTipsDetailActivity= (HealthTipsDetailActivity)getActivity();
        int position=healthTipsDetailActivity.getDetailPosition();

        //get view from fragment
        View rootView = inflater.inflate(R.layout.fragment_health_tips_detail, container, false);
        LinearLayout llHealthTipsDetailRoot = (LinearLayout) rootView.findViewById(R.id.ll_heath_tips_detail_root);
        List<HealthTipsVO> healthTipsVOList = DataManager.getInstance().getHealthTipsList();

        for (int index = 0; index < healthTipsVOList.size(); index++) {
            HealthTipsVO healthTips = healthTipsVOList.get(index);
            ViewItemHealthTipsDetail viHealthTipsDetail = (ViewItemHealthTipsDetail) inflater.inflate(R.layout.view_item_health_tips_detail, container, false);
            if (index == position) {
                viHealthTipsDetail.setData(healthTips);
                llHealthTipsDetailRoot.addView(viHealthTipsDetail);
            }
        }
        return rootView;
    }
}
