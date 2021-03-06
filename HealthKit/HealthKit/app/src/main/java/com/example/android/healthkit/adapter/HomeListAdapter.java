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
import com.example.android.healthkit.data.dto.HomeDto;

import java.util.List;

/**
 * Created by nawthuellay on 3/9/2016.
 */
public class HomeListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    List<HomeDto> homeListDto;

    public HomeListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setHomeList(List<HomeDto> homeListDto) {
        this.homeListDto = homeListDto;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return homeListDto.size();
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

        return homeListDto.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {

        return homeListDto.get(position).getId();
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
        convertView = layoutInflater.inflate(R.layout.home_list, parent, false);

        ImageView listImg = (ImageView) convertView.findViewById(R.id.home_list_img);
        Glide.with(getContext())
                .load(homeListDto.get(position)
                        .getUrl()).placeholder(R.drawable.ic_splash2).into(listImg);
        ((TextView) convertView.findViewById(R.id.home_list_text))
                .setText(homeListDto.get(position).getName());

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
