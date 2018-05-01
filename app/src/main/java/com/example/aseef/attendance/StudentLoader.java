package com.example.aseef.attendance;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Loads a list of subjects by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class StudentLoader extends AsyncTaskLoader<List<StudentItem>> {

    /** Tag for log messages */
    private static final String LOG_TAG = StudentLoader.class.getName();

    /** Query URL */
    private String mUrl;


    /**
     * Constructs a new {@link StudentLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public StudentLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        Log.i(LOG_TAG,"TEST: onStartLoading() called");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<StudentItem> loadInBackground() {

        Log.i(LOG_TAG,"TEST: loadInBackground() called");
        if (mUrl == null) {
            Log.i(LOG_TAG,"NULL");
            return null;
        }
        // Perform the network request, parse the response, and extract a list of subjects.
        List<StudentItem> students = QueryUtilStudentAttendance.fetchStudentData(mUrl);

        return students;
    }
}