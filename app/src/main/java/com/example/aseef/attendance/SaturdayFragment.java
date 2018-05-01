package com.example.aseef.attendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class SaturdayFragment extends Fragment {

    public SaturdayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time_table_list, container, false);

        ArrayList<TimeTableItem> items=new ArrayList<TimeTableItem>();
        items.add(new TimeTableItem("FS", "Veena", "8:30 - 9:20"));
        items.add(new TimeTableItem("OS", "Mahalakshmi", "9:20 - 10:10"));
        items.add(new TimeTableItem("Tea Break", "","10:10 - 10:30"));
        items.add(new TimeTableItem("Sports/Cultural Activity", "","10:30 - 12:10"));

        TimeTableAdapter adapter = new TimeTableAdapter(getActivity(), items);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
