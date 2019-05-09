package com.evand.edu.uulalulintas.Database;


/**
 * Created by ACER on 15/01/2015.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.evand.edu.uulalulintas.R;

public class R4adt extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<R4pasal> pasalList = null;
    private ArrayList<R4pasal> arraylist;

    public R4adt(Context context, List<R4pasal> pasalList) {
        mContext = context;
        this.pasalList = pasalList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<R4pasal>();
        this.arraylist.addAll(pasalList);
    }

    public class ViewHolder {
        TextView pasal;
        TextView pelanggaran;
        TextView sanksi;
    }

    @Override
    public int getCount() {
        return pasalList.size();
    }

    @Override
    public R4pasal getItem(int position) {
        return pasalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            holder.pasal = (TextView) view.findViewById(R.id.pasal);
            holder.pelanggaran = (TextView) view.findViewById(R.id.pelanggaran);
            holder.sanksi = (TextView) view.findViewById(R.id.sanksi);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.pasal.setText(pasalList.get(position).getPasal());
        holder.pelanggaran.setText(pasalList.get(position).getPelanggaran());
        holder.sanksi.setText(pasalList.get(position).getSanksi());

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        pasalList.clear();
        if (charText.length() == 0) {
            pasalList.addAll(arraylist);
        }
        else
        {
            for (R4pasal wp : arraylist)
            {
                if (wp.getPelanggaran().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    pasalList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}