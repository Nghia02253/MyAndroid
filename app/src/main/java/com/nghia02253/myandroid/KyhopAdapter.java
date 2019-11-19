package com.nghia02253.myandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KyhopAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<KyHop> kyHopList;

    public KyhopAdapter(Context context, int layout, List<KyHop> kyHopList) {
        this.context = context;
        this.layout = layout;
        this.kyHopList = kyHopList;
    }

    @Override
    public int getCount() {
        return kyHopList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView textViewTime, textViewStatus, textViewTitle;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.textViewTime = view.findViewById(R.id.textViewTime);
            viewHolder.textViewStatus = view.findViewById(R.id.textViewStatus);
            viewHolder.textViewTitle = view.findViewById(R.id.textViewTitle);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        KyHop kyHop = kyHopList.get(i);

        viewHolder.textViewTime.setText(kyHop.getTvTime());
        viewHolder.textViewStatus.setText(kyHop.getTvStatus());
        viewHolder.textViewTitle.setText(kyHop.getTvTitle());

        return view;
    }
}
