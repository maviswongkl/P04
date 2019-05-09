package com.example.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demodatabase.Task;
import com.example.demodatabase.DBHelper;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvid, tvdesc, tvdate;

    public CustomAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvid = rowView.findViewById(R.id.tvID);
        tvdesc = rowView.findViewById(R.id.tvDesc);
        tvdate = rowView.findViewById(R.id.tvDate);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentTask = task.get(position);
        // Set the TextView to show the food

        tvid.setText(Integer.toString(currentTask.getId()));
        tvdate.setText(currentTask.getDate());
        tvdesc.setText(currentTask.getDescription());

        return rowView;
    }
}
