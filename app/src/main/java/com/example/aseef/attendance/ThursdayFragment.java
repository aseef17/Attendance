package com.example.aseef.attendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ThursdayFragment extends Fragment {

    public ThursdayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time_table_list, container, false);

        ArrayList<TimeTableItem> items=new ArrayList<TimeTableItem>();
        items.add(new TimeTableItem("OS", "Mahalakshmi", "8:30 - 9:20"));
        items.add(new TimeTableItem("ST", "Manjunath", "9:20 - 10:10"));
        items.add(new TimeTableItem("Tea Break", "","10:10 - 10:30"));
        items.add(new TimeTableItem("Python", "Vinutha","10:30 - 11:20"));
        items.add(new TimeTableItem("FS", "Veena", "11:20 - 12:10"));
        items.add(new TimeTableItem("ST(Tutorial)", "Manjunath", "12:10 - 1:00"));
        items.add(new TimeTableItem("Lunch Break", "", "1:00 - 2:00"));
        items.add(new TimeTableItem("Tutorials", "", "2:00 - 3:40"));

        TimeTableAdapter adapter = new TimeTableAdapter(getActivity(), items);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}