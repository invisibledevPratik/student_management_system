package com.student.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.student.model.Student;

public class FileUtil {

    public static void save(List<Student> students, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
            System.out.println("✅ Data saved to " + filename);
        } catch (Exception e) {
            System.out.println("❌ Save error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Student> load(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Student> students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("✅ Data loaded from " + filename);
            return students;
        } catch (Exception e) {
            System.out.println("❌ Load error: " + e.getMessage());
            return null;
        }
    }
}

