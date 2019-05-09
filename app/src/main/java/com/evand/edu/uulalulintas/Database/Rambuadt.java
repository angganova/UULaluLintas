package com.evand.edu.uulalulintas.Database;

/**
 * Created by ACER on 16/01/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.evand.edu.uulalulintas.R;
import com.evand.edu.uulalulintas.rambu;

public class Rambuadt extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public Rambuadt(rambu rambu, String[] ket, int[] img) {
        // TODO Auto-generated constructor stub
        result=ket;
        context=rambu;
        imageId=img;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.imgview_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.ket);
        holder.img=(ImageView) rowView.findViewById(R.id.img);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        return rowView;
    }

}