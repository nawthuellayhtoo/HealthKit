package com.example.android.healthkit.data;

import com.example.android.healthkit.data.vos.DoctorCategoryVO;
import com.example.android.healthkit.data.vos.DoctorScheduleVO;
import com.example.android.healthkit.data.vos.HealthTipsVO;
import com.example.android.healthkit.data.vos.HomeVO;
import com.example.android.healthkit.data.vos.ServiceVO;
import com.example.android.healthkit.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by nawthuellay on 3/9/2016.
 */
public class DataManager {
    private static DataManager objInstance;

    private List<HomeVO> homeList;
    private List<ServiceVO> serviceList;
    private List<HealthTipsVO> healthTipsList;
    private List<DoctorCategoryVO> doctorCategoryList;

    private List<DoctorScheduleVO> cardiologistList;
    private List<DoctorScheduleVO> dentistList;
    private List<DoctorScheduleVO> generalPhysicianList;
    private List<DoctorScheduleVO> generalSurgeonList;

    private List<DoctorScheduleVO> neurologistList;
    private List<DoctorScheduleVO> ophthalmologistList;
    private List<DoctorScheduleVO> pediatricianList;
    private List<DoctorScheduleVO> urologistList;

    private DataManager() {

    }

    public static DataManager getInstance() {
        if (objInstance == null) {
            objInstance = new DataManager();
        }
        return objInstance;
    }

    public void loadHomeList() {
        String dummyHomeList = null;
        Gson gson = new Gson();
        try {
            dummyHomeList = JsonUtils.getInstance().loadDummyData("home_list.json");
            Type listType = new TypeToken<List<HomeVO>>() {
            }.getType();
            homeList = gson.fromJson(dummyHomeList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadServiceList() {
        String dummyServiceList = null;
        Gson gson = new Gson();
        try {
            dummyServiceList = JsonUtils.getInstance().loadDummyData("service_list.json");
            Type listType = new TypeToken<List<ServiceVO>>() {
            }.getType();
            serviceList = gson.fromJson(dummyServiceList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadHealthTipsList() {
        String dummyHealthTipsList = null;
        Gson gson = new Gson();
        try {
            dummyHealthTipsList = JsonUtils.getInstance().loadDummyData("health_tips_list.json");
            Type listType = new TypeToken<List<HealthTipsVO>>() {
            }.getType();
            healthTipsList = gson.fromJson(dummyHealthTipsList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadDoctorCategoryList() {
        String dummyDoctorCategoryList = null;
        Gson gson = new Gson();
        try {
            dummyDoctorCategoryList = JsonUtils.getInstance().loadDummyData("doctor_category_list.json");
            Type listType = new TypeToken<List<DoctorCategoryVO>>() {
            }.getType();
            doctorCategoryList = gson.fromJson(dummyDoctorCategoryList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadCardiologistList() {
        String dummyCardiologistList= null;
        Gson gson = new Gson();
        try {
            dummyCardiologistList = JsonUtils.getInstance().loadDummyData("Cardiologists_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            cardiologistList = gson.fromJson(dummyCardiologistList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void loadDentistList() {
        String dummyDentistList= null;
        Gson gson = new Gson();
        try {
            dummyDentistList = JsonUtils.getInstance().loadDummyData("Dentist_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            dentistList = gson.fromJson(dummyDentistList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadGeneralPhysicianList() {
        String dummyGeneralPhysicianList= null;
        Gson gson = new Gson();
        try {
            dummyGeneralPhysicianList = JsonUtils.getInstance().loadDummyData("general_physicians_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            generalPhysicianList = gson.fromJson(dummyGeneralPhysicianList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadGeneralSurgeonList() {
        String dummyGeneralSurgeonList= null;
        Gson gson = new Gson();
        try {
            dummyGeneralSurgeonList = JsonUtils.getInstance().loadDummyData("general_surgeons_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            generalSurgeonList = gson.fromJson(dummyGeneralSurgeonList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadNeurolgistList() {
        String dummyNeurolgistList= null;
        Gson gson = new Gson();
        try {
            dummyNeurolgistList = JsonUtils.getInstance().loadDummyData("neurologist_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            neurologistList = gson.fromJson(dummyNeurolgistList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void loadOphthalmologistList() {
        String dummyOphthalmologistList= null;
        Gson gson = new Gson();
        try {
            dummyOphthalmologistList = JsonUtils.getInstance().loadDummyData("Ophthalmologist_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            ophthalmologistList = gson.fromJson(dummyOphthalmologistList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void loadPediatricianList() {
        String dummyPediatricianList= null;
        Gson gson = new Gson();
        try {
            dummyPediatricianList = JsonUtils.getInstance().loadDummyData("Pediatrician_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            pediatricianList = gson.fromJson(dummyPediatricianList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void loadUrologistList() {
        String dummyUrologistList= null;
        Gson gson = new Gson();
        try {
            dummyUrologistList = JsonUtils.getInstance().loadDummyData("Urologist_list.json");
            Type listType = new TypeToken<List<DoctorScheduleVO>>() {
            }.getType();
            urologistList = gson.fromJson(dummyUrologistList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public List<HomeVO> getHomeVOList() {
        return homeList;
    }

    public List<ServiceVO> getServiceVOList() {
        return serviceList;
    }

    public List<HealthTipsVO> getHealthTipsList() {
        return healthTipsList;
    }
    public List<DoctorCategoryVO> getDoctorCategoryList() {
        return doctorCategoryList;
    }

    public List<DoctorScheduleVO> getCardiologistList() {
        return cardiologistList;
    }
    public List<HomeVO> getHomeList() {
        return homeList;
    }

    public List<ServiceVO> getServiceList() {
        return serviceList;
    }

    public List<DoctorScheduleVO> getDentistList() {
        return dentistList;
    }

    public List<DoctorScheduleVO> getGeneralPhysicianList() {
        return generalPhysicianList;
    }

    public List<DoctorScheduleVO> getGeneralSurgeonList() {
        return generalSurgeonList;
    }

    public List<DoctorScheduleVO> getNeurologistList() {
        return neurologistList;
    }

    public List<DoctorScheduleVO> getOphthalmologistList() {
        return ophthalmologistList;
    }

    public List<DoctorScheduleVO> getPediatricianList() {
        return pediatricianList;
    }

    public List<DoctorScheduleVO> getUrologistList() {
        return urologistList;
    }
}
