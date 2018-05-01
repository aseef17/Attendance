package com.example.aseef.attendance;



public class StudentItem {
    private static String mStudentName;
    private String mAttendance;
    private String mSubjectName;

    public StudentItem(String Name, String Subject, String Attendance) {
        mStudentName = Name;
        this.mSubjectName = Subject;
        this.mAttendance = Attendance;
    }

    public static String getmName() {
        return mStudentName;
    }

    public String getmAttendance() {
        return this.mAttendance;
    }

    public String getmSubject() {
        return this.mSubjectName;
    }
}

