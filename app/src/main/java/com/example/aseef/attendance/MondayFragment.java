package com.example.aseef.attendance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MondayFragment extends Fragment {

    public MondayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time_table_list, container, false);

        ArrayList<TimeTableItem> items=new ArrayList<TimeTableItem>();
        items.add(new TimeTableItem("Python", "Vinutha", "8:30 - 9:20"));
        items.add(new TimeTableItem("OR", "Ashwini", "9:20 - 10:10"));
        items.add(new TimeTableItem("Tea Break", "","10:10 - 10:30"));
        items.add(new TimeTableItem("Software Testing", "Manjunath","10:30 - 11:20"));
        items.add(new TimeTableItem("CNC", "Shwetha", "11:20 - 12:10"));
        items.add(new TimeTableItem("OS(Tutorial)", "Mahalakshmi", "12:10 - 1:00"));
        items.add(new TimeTableItem("Lunch Break", "", "1:00 - 2:00"));
        items.add(new TimeTableItem("ST/FS(Lab)", "Veena/Manjunath", "2:00 - 4:30"));

        TimeTableAdapter adapter = new TimeTableAdapter(getActivity(), items);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}