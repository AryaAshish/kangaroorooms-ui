package com.aryan.android.oyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin1 on 1/3/18.
 */

class CustomAdapter extends BaseAdapter {

    Context context;
    List<String> countryCode;
    List<String> countryNames;
    LayoutInflater inflater;
   // RecyclerView spin_recycler_view;

    public CustomAdapter(Context applicationContext, List<String> countryNames, List<String> code) {
        this.context = applicationContext;
        this.countryNames = countryNames;
        this.countryCode = code;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryCode.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /*@Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }*/

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

       // return spin_recycler_view;
        /*TextView txt = new TextView(context);
        txt.setText(countryCode.get(position));
        return  txt;*/
        convertView = inflater.inflate(R.layout.spinner_recycler_view, null);
        //RecyclerView spin_recycler_view = (RecyclerView)convertView.findViewById(R.id.recycler_view_spinner) ;
        //SpinnerRecyclerViewAdapter mAdapter = new SpinnerRecyclerViewAdapter(context,countryNames,countryCode);
        //spin_recycler_view.setAdapter(mAdapter);
        //spin_recycler_view.setLayoutManager(new LinearLayoutManager(context));
        TextView code = (TextView) convertView.findViewById(R.id.country_code_recycler_view);
        TextView cName = (TextView) convertView.findViewById(R.id.country_name_recycler_view) ;
        //TextView name = (TextView) view.findViewById(R.id.text_view_country_name);
        //name.setText(countryNames.get(i));
        cName.setText(countryNames.get(position));
        code.setText(countryCode.get(position));
        return convertView;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.spinner_list_item, null);
        TextView code = (TextView) view.findViewById(R.id.text_view_country_code);
        //TextView name = (TextView) view.findViewById(R.id.text_view_country_name);
        //name.setText(countryNames.get(i));
        code.setText(countryCode.get(i));
        return view;
    }
}
