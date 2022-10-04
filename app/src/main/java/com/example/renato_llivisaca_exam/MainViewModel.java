package com.example.renato_llivisaca_exam;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.renato_llivisaca_exam.Api.ResObject;
import com.example.renato_llivisaca_exam.Api.UsuarioService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Usuarios>> eqList = new MutableLiveData<>();
    public LiveData<List<Usuarios>> getEqList() {
        return eqList;
    }
    public void listarproductos(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://fipo.equisd.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsuarioService service=retrofit.create(UsuarioService.class);
        Call<ResObject> call= service.getEarthQuakes();
        call.enqueue(new Callback<ResObject>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<ResObject> call, Response<ResObject> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }

                ResObject rp= response.body();
                eqList.setValue(rp.getObjects());
                System.out.println("Listo");
            }



            @Override
            public void onFailure(Call<ResObject> call, Throwable t) {
                System.out.println("Fallo");
                System.out.println(t.getMessage());

            }
        });
    }


    /*public void getEarthquakes(){
        /*ArrayList<Earthquake> eqList = new ArrayList<>();
        eqList.add(new Earthquake("001","carchi",5.5, 10082022,654654,6544));
        eqList.add(new Earthquake("002","luna",6.0, 15082022,654690,6544));
        eqList.add(new Earthquake("003","csol",7.0, 19082022,65454,6544));
        eqList.add(new Earthquake("004","velf",8.0, 21082022,654654,6544));
        eqList.add(new Earthquake("005","casd",9.0, 29082022,654654,6544));
        this.eqList.setValue(eqList)

        ApiUsuarios.UsService service= ApiUsuarios.getInstance().getService();
        //enqueue  es el resultado de consultar a la api

        //respuesta con scalares string
        service.getEarthQuakes().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //aqui indica si respondio
                //Log.d("VAloresC", response.body());
                List<Usuarios> usuarioslist = parseUsuariosScalar(response.body());
                eqList.setValue(usuarioslist);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //aqui indica si fallo
                Log.d("ErrorDatos", t.getMessage());
            }
        });


        private List<Usuarios> parseUsuariosScalar(String  responseString){
            ArrayList<Usuarios> eqList=new ArrayList<>();
            System.out.println("Texto de entrada"+responseString);
            try {
                JSONObject jsonResponse = new JSONObject(responseString);
                JSONArray featuresJSONArray= jsonResponse.getJSONArray("features");
                for (int i = 0; i < featuresJSONArray.length(); i++) {
                    JSONObject jsonObjects = featuresJSONArray.getJSONObject(i);

                    Usuarios e=new Usuarios(

                            jsonObjects.getInt("id"),
                            jsonObjects.getString("first_name"),
                            jsonObjects.getString("last_name"),
                            jsonObjects.getString("avatar"),
                            jsonObjects.getString("created_at"),
                            jsonObjects.getString("updated_at")
                    );
                    eqList.add(e);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return eqList;
        }



    }*/

}
