package com.example.android.healthkit.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.healthkit.R;
import com.example.android.healthkit.activities.HealthTipsDetailActivity;
import com.example.android.healthkit.adapter.HealthTipsListAdapter;
import com.example.android.healthkit.data.DataManager;
import com.example.android.healthkit.data.dto.HealthTipsDto;
import com.example.android.healthkit.data.vos.HealthTipsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HealthTipsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HealthTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthTipsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HealthTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthTipsFragment newInstance(String param1, String param2) {
        HealthTipsFragment fragment = new HealthTipsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_health_tips, container, false);
        List<HealthTipsVO> healthTipsVOList = DataManager.getInstance().getHealthTipsList();
        List<HealthTipsDto> healthTipsDtoList = changeHealthTipsVOToDto(healthTipsVOList);

        ListView listView = (ListView) view.findViewById(R.id.lv_healthTips_list);
        HealthTipsListAdapter adapter = new HealthTipsListAdapter(this.getActivity());

        adapter.setHealthTipsList(healthTipsDtoList);
        listView.setAdapter(adapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position){
                    case 0:
                        callIntentToHealthTipsDetailActivity(0);
                        break;
                    case 1:
                        callIntentToHealthTipsDetailActivity(1);
                        break;
                    case 2:
                        callIntentToHealthTipsDetailActivity(2);
                        break;
                    case 3:
                        callIntentToHealthTipsDetailActivity(3);
                        break;
                    case 4:
                        callIntentToHealthTipsDetailActivity(4);
                        break;
                    default:
                        Toast.makeText(getActivity(),
                                "Click ListItem Number is invalid ", Toast.LENGTH_LONG)
                                .show();
                        break;
                }
            }
        });
        adapter.notifyDataSetChanged();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public static List<HealthTipsDto> changeHealthTipsVOToDto( List<HealthTipsVO> healthTipsVOList)
    {
        List<HealthTipsDto> healthTipsDtoList =new ArrayList<HealthTipsDto>();

        for (HealthTipsVO healthTipsVO : healthTipsVOList) {
            HealthTipsDto healthTipsDto = new HealthTipsDto();
            String mainTitle = healthTipsVO.getMainTitle();
            String tipsPhoto = healthTipsVO.getTipsPhoto();
            String tipsAuthor= healthTipsVO.getTipsAuthor();
            String tipsDesc= healthTipsVO.getTipsDesc();

            healthTipsDto.setMainTitle(mainTitle);
            healthTipsDto.setTipsPhoto(tipsPhoto);
            healthTipsDto.setTipsAuthor(tipsAuthor);
            healthTipsDto.setTipsDesc(tipsDesc);

            healthTipsDtoList.add(healthTipsDto);
        }
        return healthTipsDtoList;
    }
    public void callIntentToHealthTipsDetailActivity(int position){
        Intent intentToHealthTipsDetailActivity= HealthTipsDetailActivity.newIntent(position);
        startActivity(intentToHealthTipsDetailActivity);
    }

}
