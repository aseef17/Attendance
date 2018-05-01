package com.example.aseef.attendance;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.intuit.sdp.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtilStudentAttendance extends AppCompatActivity {
    public static final String LOG_TAG = QueryUtilStudentAttendance.class.getSimpleName();
    public static String studentName;

    private QueryUtilStudentAttendance() {
    }

    public static List<StudentItem> fetchStudentData(String requestUrl) {
        Log.i(LOG_TAG, "TEST: fetchStudentData() called");
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(createUrl(requestUrl));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }
        return extractFeatureFromJson(jsonResponse);
    }

    private static URL createUrl(String stringUrl) {
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
            return null;
        }
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = BuildConfig.FLAVOR;
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the students JSON results.", e);
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                output.append(line);
            }
        }
        return output.toString();
    }

    public static List<StudentItem> extractFeatureFromJson(String studentJSON) {
        String temp = null;
        if (TextUtils.isEmpty(studentJSON)) {
            return null;
        }
        List<StudentItem> students = new ArrayList();
        try {
            JSONArray data = new JSONObject(studentJSON).getJSONArray("data");
            studentName = data.getJSONObject(0).getString("sname");
            for (int i = 0; i < 8; i++) {
                JSONObject student = data.getJSONObject(0);
                temp = String.valueOf(i);
                JSONObject properties = student.getJSONObject(temp);
                String attendance = properties.getString("attendance");
                students.add(new StudentItem(studentName, properties.getString("subjectname"), attendance));
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the students JSON results", e);
        }
        Log.e(LOG_TAG, temp);
        return students;
    }
}
