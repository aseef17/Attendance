package com.example.aseef.attendance;


public class TimeTableItem {

    private String subject_name;
    private String subject_faculty;
    private String subject_timings;

    public TimeTableItem(String subject_name, String subject_faculty, String subject_timings) {
        this.subject_name = subject_name;
        this.subject_faculty = subject_faculty;
        this.subject_timings = subject_timings;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_faculty() {
        return subject_faculty;
    }

    public void setSubject_faculty(String subject_faculty) {
        this.subject_faculty = subject_faculty;
    }

    public String getSubject_timings() {
        return subject_timings;
    }

    public void setSubject_timings(String subject_timings) {
        this.subject_timings = subject_timings;
    }

}
