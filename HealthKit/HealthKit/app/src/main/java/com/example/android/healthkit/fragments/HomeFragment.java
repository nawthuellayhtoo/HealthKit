package com.example.android.healthkit.fragments;

import android.app.Fragment;
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
import com.example.android.healthkit.activities.CallEmergencyActivity;
import com.example.android.healthkit.activities.DoctorCategoryActivity;
import com.example.android.healthkit.adapter.HomeListAdapter;
import com.example.android.healthkit.data.DataManager;
import com.example.android.healthkit.data.dto.HomeDto;
import com.example.android.healthkit.data.vos.HomeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        List<HomeVO> homeVOList = DataManager.getInstance().getHomeVOList();
        List<HomeDto> homeDtoList = changeHomeVOToDto(homeVOList);

        ListView listView = (ListView) view.findViewById(R.id.home_list);
        HomeListAdapter adapter = new HomeListAdapter(this.getActivity());
        adapter.setHomeList(homeDtoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position){
                    case 0:
                        Intent intentToCallEmergency= CallEmergencyActivity.newIntent();
                        startActivity(intentToCallEmergency);
                        break;
                    case 1:
                        Intent intentToDoctorCategory= DoctorCategoryActivity.newIntent();
                        startActivity(intentToDoctorCategory);
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
    public static List<HomeDto> changeHomeVOToDto( List<HomeVO> homeVOList)
    {
        List<HomeDto> homeDtoList = new ArrayList<HomeDto>();

        for (HomeVO homeVO : homeVOList) {
            HomeDto homeDto = new HomeDto();
            String url = homeVO.getUrl();
            String name = homeVO.getName();
            homeDto.setUrl(url);
            homeDto.setName(name);
            homeDtoList.add(homeDto);
        }
        return homeDtoList;
    }

 }

