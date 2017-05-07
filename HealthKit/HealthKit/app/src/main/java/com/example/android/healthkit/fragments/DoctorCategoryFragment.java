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
import com.example.android.healthkit.activities.DoctorScheduleActivity;
import com.example.android.healthkit.adapter.DoctorCategoryListAdapter;
import com.example.android.healthkit.data.DataManager;
import com.example.android.healthkit.data.dto.DoctorCategoryDto;
import com.example.android.healthkit.data.vos.DoctorCategoryVO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DoctorCategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DoctorCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorCategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DoctorCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoctorCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorCategoryFragment newInstance(String param1, String param2) {
        DoctorCategoryFragment fragment = new DoctorCategoryFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_doctor_category, container, false);

        List<DoctorCategoryVO> doctorCategoryList = DataManager.getInstance().getDoctorCategoryList();
        List<DoctorCategoryDto> doctorCategoryDtoList = changeDoctorCategoryVOToDto(doctorCategoryList);

        ListView listView = (ListView) rootView.findViewById(R.id.lv_doctor_category_list);
        DoctorCategoryListAdapter adapter = new DoctorCategoryListAdapter(this.getActivity());
        adapter.setHomeList(doctorCategoryDtoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        callIntentToDoctorScheduleActivity(0);
                        break;
                    case 1:
                        callIntentToDoctorScheduleActivity(1);
                        break;
                    case 2:
                        callIntentToDoctorScheduleActivity(2);
                        break;
                    case 3:
                        callIntentToDoctorScheduleActivity(3);
                        break;
                    case 4:
                        callIntentToDoctorScheduleActivity(4);
                        break;
                    case 5:
                        callIntentToDoctorScheduleActivity(5);
                    case 6:
                        callIntentToDoctorScheduleActivity(6);
                        break;
                    case 7:
                        callIntentToDoctorScheduleActivity(7);
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
        return rootView;
    }

    public static List<DoctorCategoryDto> changeDoctorCategoryVOToDto(List<DoctorCategoryVO> doctorCategoryList) {
        List<DoctorCategoryDto> doctorCategoryDtoList = new ArrayList<DoctorCategoryDto>();

        for (DoctorCategoryVO doctorCategoryVO : doctorCategoryList) {
            DoctorCategoryDto doctorCategoryDto = new DoctorCategoryDto();
            String category = doctorCategoryVO.getDoctorCategory();
            String photo = doctorCategoryVO.getCategoryPhoto();
            doctorCategoryDto.setDoctorCategory(category);
            doctorCategoryDto.setCategoryPhoto(photo);
            doctorCategoryDtoList.add(doctorCategoryDto);
        }
        return doctorCategoryDtoList;
    }

    public void callIntentToDoctorScheduleActivity(int position) {
        Intent intentToDoctorScheduleActivity = DoctorScheduleActivity.newIntent(position);
        startActivity(intentToDoctorScheduleActivity);
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
}
