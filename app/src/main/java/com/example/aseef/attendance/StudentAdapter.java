package com.example.aseef.attendance;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Pattern;

public class StudentAdapter extends ArrayAdapter {
    private static final String ATTENDANCE_SEPARATOR_FINISH = ")";
    private static final String ATTENDANCE_SEPARATOR_START = "(";

    public StudentAdapter(Context context, List<StudentItem> earthquakes) {
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.student_attendance_list_item, parent, false);
        }
        ((TextView) ((Activity) getContext()).findViewById(R.id.studentname)).setText(StudentItem.getmName());
        StudentItem currentStudent = (StudentItem) getItem(position);
        ((TextView) listItemView.findViewById(R.id.subjectname)).setText(currentStudent.getmSubject());
        String OriginalAttendance = currentStudent.getmAttendance();
        String no_of_days = null;
        if (OriginalAttendance.contains(ATTENDANCE_SEPARATOR_FINISH)) {
            String[] parts = OriginalAttendance.split(Pattern.quote(ATTENDANCE_SEPARATOR_FINISH));
            no_of_days = parts[0] + ATTENDANCE_SEPARATOR_FINISH;
            OriginalAttendance = parts[1];
        }
        TextView NoOfClassesTextView = listItemView.findViewById(R.id.no_of_classes);
        NoOfClassesTextView.setText(no_of_days);
        NoOfClassesTextView.setTextColor(Color.parseColor("#5c6262"));
        ((TextView) listItemView.findViewById(R.id.subjectattendance)).setText(OriginalAttendance);
        return listItemView;
    }
}

