package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sgt.primoz.macgyversolutions.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Primoz on 5.10.2014.
 */
public class MacAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> objects;
    private static class ViewHolder{
        TextView lab;
    }

    public MacAdapter(Context context, ArrayList<String> objects) {
        super(context, R.layout.simplelistlayout, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.simplelistlayout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.lab = (TextView)convertView.findViewById(R.id.lab);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        String item = getItem(position);
        viewHolder.lab.setText(item);

        return convertView;
    }
}
