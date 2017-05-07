package com.example.android.healthkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.healthkit.R;
import com.example.android.healthkit.data.dto.HealthTipsDto;

import java.util.List;

/**
 * Created by nawthuellay on 3/11/2016.
 */
public class HealthTipsListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    List<HealthTipsDto> healthTipsListDto;

    public HealthTipsListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setHealthTipsList(List<HealthTipsDto> healthTipsListDto) {
        this.healthTipsListDto = healthTipsListDto;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return healthTipsListDto.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {

        return healthTipsListDto.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {

        return healthTipsListDto.get(position).getId();
    }
    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.health_tips_list, parent, false);

        ImageView tipsImg = (ImageView) convertView.findViewById(R.id.healthTips_list_img);
        Glide.with(getContext())
                .load(healthTipsListDto.get(position)
                        .getTipsPhoto())
                .placeholder(R.drawable.ic_placeholder)
                .into(tipsImg);
       ((TextView) convertView.findViewById(R.id.healthtips_list_main_title))
                .setText(healthTipsListDto.get(position).getMainTitle());

        ((TextView) convertView.findViewById(R.id.healthtips_list_main_author))
                .setText(healthTipsListDto.get(position).getTipsAuthor());

        return convertView;
    }

    /**
     * Get context
     * @return context
     */
    public Context getContext() {
        return context;
    }
}
