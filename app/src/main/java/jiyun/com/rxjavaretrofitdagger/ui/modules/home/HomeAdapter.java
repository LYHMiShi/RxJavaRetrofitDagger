package jiyun.com.rxjavaretrofitdagger.ui.modules.home;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jiyun.com.rxjavaretrofitdagger.R;
import jiyun.com.rxjavaretrofitdagger.model.entity.LiveChina;

public class HomeAdapter extends BaseAdapter{
    Context con;
    ArrayList<LiveChina.LiveBean> liveChinas;
    public HomeAdapter(FragmentActivity activity, ArrayList<LiveChina.LiveBean> liveChinas) {
        this.con  = activity;
        this.liveChinas = liveChinas;
    }

    @Override
    public int getCount() {
        return liveChinas.size();
    }

    @Override
    public Object getItem(int position) {
        return liveChinas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(con).inflate(R.layout.item,null);
        ImageView image = (ImageView) convertView.findViewById(R.id.item_img);
        Glide.with(con).load(liveChinas.get(position).getImage()).into(image);

        return convertView;
    }
}
