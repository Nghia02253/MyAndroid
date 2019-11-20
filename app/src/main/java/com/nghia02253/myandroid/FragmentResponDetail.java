package com.nghia02253.myandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentResponDetail extends Fragment {
    TextView tvTime, tvStatus, tvTitle, tvDesc;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_respon_detail, container, false);

        AnhXa();
        return view;
    }
    public void setDataKyhop(KyHop kyhop) {
        tvTitle.setText(kyhop.getTvTitle());
        tvTime.setText(kyhop.getTvTime());
        tvStatus.setText(kyhop.getTvStatus());
        tvDesc.setText(kyhop.getTvDesc());
    }
    private void AnhXa() {
        tvTitle = view.findViewById(R.id.tvTitle);
        tvTime = view.findViewById(R.id.tvTime);
        tvStatus = view.findViewById(R.id.tvStatus);
        tvDesc = view.findViewById(R.id.tvDesc);
    }
}
