package com.nghia02253.myandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class FragmentKyhopList extends ListFragment {
    ArrayList<KyHop> arrayList;
    KyhopAdapter adapter;
    Database database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        arrayList = new ArrayList<>();
        adapter = new KyhopAdapter(getActivity(), R.layout.kyhop_row, arrayList);
        database = new Database(getActivity(), "ghichu.sqlite", null, 1);
        GetDataKyhop();


        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_kyhop_list, container, false);
    }

    private void GetDataKyhop(){
        Cursor dataKyhop = database.GetData("SELECT * FROM ListUser ORDER BY CreatedDate DESC");
        arrayList.clear();
        while (dataKyhop.moveToNext()){
            int idUser = dataKyhop.getInt(0);
            String Time = dataKyhop.getString(1);
            String Status = dataKyhop.getString(2);
            String Title = dataKyhop.getString(3);
            String Desc = dataKyhop.getString(4);

            arrayList.add(new KyHop(Time, Status, Title, Desc, R.drawable.logo, idUser));
        }
        adapter.notifyDataSetChanged();
    }

}
