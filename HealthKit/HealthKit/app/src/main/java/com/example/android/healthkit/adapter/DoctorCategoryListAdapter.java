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
import com.example.android.healthkit.data.dto.DoctorCategoryDto;

import java.util.List;

/**
 * Created by nawthuellay on 3/12/2016.
 */
public class DoctorCategoryListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    List<DoctorCategoryDto> doctorCategoryDto;

    public DoctorCategoryListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setHomeList(List<DoctorCategoryDto> doctorCategoryDto) {
        this.doctorCategoryDto = doctorCategoryDto;
    }
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return doctorCategoryDto.size();
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

        return doctorCategoryDto.get(position);
    }
    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {

        return doctorCategoryDto.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.doctor_category_list, parent, false);

        ImageView listImg = (ImageView) convertView.findViewById(R.id.iv_doctor_category);
        Glide.with(getContext())
                .load(doctorCategoryDto.get(position)
                        .getCategoryPhoto()).placeholder(R.drawable.ic_splash2).into(listImg);
        ((TextView) convertView.findViewById(R.id.tv_doctor_category))
                .setText(doctorCategoryDto.get(position).getDoctorCategory());

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
