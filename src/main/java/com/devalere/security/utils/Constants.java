package com.devalere.security.utils;

public interface Constants {

    public static String APP_ROOT = "anywr";
    public static String STUDENT_ENDPOINT = APP_ROOT + "/student";
    public static String GET_ALL_STUDENT_ENDPOINT = APP_ROOT + "/students";
    public static String FIND_STUDENT_BY_ID_ENDPOINT = APP_ROOT + "/student/{idStudent}";
    public static String FIND_ALL_STUDENT_BY_CLASS_NAME_ENDPOINT = APP_ROOT + "/student/all/{className}";
    public static String FIND_ALL_STUDENT_BY_TEACHER_FULL_NAME_ENDPOINT = APP_ROOT + "/student/all/teacher/{teacherFullName}";
    public static String FIND_ALL_STUDENT_ENDPOINT = APP_ROOT + "/student/all";
    public static String DELETE_STUDENT_ENDPOINT = APP_ROOT + "/student/delete/{idStudent}";

    public static String TEACHER_ENDPOINT = APP_ROOT + "/teacher";

    public static String FIND_TEACHER_BY_ID_ENDPOINT = APP_ROOT + "/teacher/{idTeacher}";

    public static String FIND_ALL_TEACHER_ENDPOINT = APP_ROOT + "/teacher/all";

    public static String DELETE_TEACHER_ENDPOINT = APP_ROOT + "/teacher/delete/{idTeacher}";

    public static String CLASS_ENDPOINT = APP_ROOT + "/class";

    public static String FIND_CLASS_BY_ID_ENDPOINT = APP_ROOT + "/class/{idClass}";

    public static String FIND_ALL_CLASSES_ENDPOINT = APP_ROOT + "/class/all";

    public static String DELETE_CLASS_ENDPOINT = APP_ROOT + "/class/delete/{idClass}";

    public static String USER_ENDPOINT = APP_ROOT + "/user";
    public static String USER_DEMO_ENDPOINT = APP_ROOT + "/user/demo-controller";



}
