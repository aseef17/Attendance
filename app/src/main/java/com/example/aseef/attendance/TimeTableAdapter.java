package com.example.aseef.attendance;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeTableAdapter extends ArrayAdapter<TimeTableItem> {

    public TimeTableAdapter(Context context, ArrayList<TimeTableItem> items){

        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_time_table, parent, false);

        }

        TimeTableItem currentItem = getItem(position);

        TextView subjectName = listItemView.findViewById(R.id.subject_name);
        subjectName.setText(currentItem.getSubject_name());

        TextView subjectFaculty = listItemView.findViewById(R.id.subject_faculty);
        subjectFaculty.setText(currentItem.getSubject_faculty());

        TextView SubjectTimings = listItemView.findViewById(R.id.subject_time);
        SubjectTimings.setText(currentItem.getSubject_timings());


        return listItemView;
    }


}
