package com.nghia02253.myandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListUserAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ListUser> listUser;

    public ListUserAdapter(Context context, int layout, List<ListUser> listUser) {
        this.context = context;
        this.layout = layout;
        this.listUser = listUser;
    }

    @Override
    public int getCount() {
        return listUser.size();
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
        ImageView imgImage;
        TextView tvTime, tvStatus, tvTitle, tvDesc;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder.imgImage = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.tvTime = (TextView) view.findViewById(R.id.textViewTime);
            viewHolder.tvStatus = (TextView) view.findViewById(R.id.textViewStatus);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
            viewHolder.tvDesc = (TextView) view.findViewById(R.id.textViewDesc);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        ListUser listUserItem = listUser.get(i);
        viewHolder.imgImage.setImageResource(listUserItem.getIvImage());
        viewHolder.tvTime.setText(listUserItem.getTvTime());
        viewHolder.tvStatus.setText(listUserItem.getTvStatus());

        viewHolder.tvTitle.setText(listUserItem.getTvTitle());
        viewHolder.tvDesc.setText(listUserItem.getTvDesc());

        // add animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_scale);
        view.startAnimation(animation);
        return view;
    }
}
