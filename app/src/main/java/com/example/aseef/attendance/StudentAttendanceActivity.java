package com.example.aseef.attendance;


import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class StudentAttendanceActivity extends AppCompatActivity implements LoaderCallbacks<List<StudentItem>> {

    private static final int STUDENTS_LOADER_ID = 1;
    private static final String URL = "https://bims.bmsit.ac.in/hod/tj.php?adno=";
    private static String id = null;
    public String BIMS_REQUEST_URL;

    private StudentAdapter mAdapter;

    private TextView mEmptyStateTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);

        id = getIntent().getStringExtra("user_id");

        this.BIMS_REQUEST_URL = URL + id;

        ListView studentsListView = findViewById(R.id.list);

        this.mEmptyStateTextView = findViewById(R.id.empty_view);
        studentsListView.setEmptyView(this.mEmptyStateTextView);

        this.mAdapter = new StudentAdapter(this, new ArrayList());
        studentsListView.setAdapter(this.mAdapter);

        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected()) {

            findViewById(R.id.progress_bar).setVisibility(View.GONE);

            this.mEmptyStateTextView.setText(R.string.no_internet_connection);

            Toasty.info(StudentAttendanceActivity.this,"Check Your Internet Connection", Toast.LENGTH_SHORT,true).show();

            return;
        }

        getLoaderManager().initLoader(STUDENTS_LOADER_ID, null, this);
    }

    public Loader<List<StudentItem>> onCreateLoader(int i, Bundle bundle) {

        return new StudentLoader(this, this.BIMS_REQUEST_URL);

    }

    public void onLoadFinished(Loader<List<StudentItem>> loader, List<StudentItem> students) {

        findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);

        this.mEmptyStateTextView.setText(R.string.wrong_id);

        this.mAdapter.clear();

        if (students != null && !students.isEmpty()) {

            this.mAdapter.addAll(students);

        } else {

            Toasty.info(StudentAttendanceActivity.this,"Details for entered ID Not Found", Toast.LENGTH_LONG,true).show();


        }
    }

    public void onLoaderReset(Loader<List<StudentItem>> loader) {

        this.mAdapter.clear();

    }

}

