package homework.service;

import homework.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {


    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("11603080230", "胡兰", 20));
        students.add(new Student("11603080233", "大大", 29));
        students.add(new Student("11603070403", "陈华", 3));
        students.add(new Student("11603090111", "孟丹丹", 64));
        students.add(new Student("22223377575", "张冬冬", 45));
        students.add(new Student("99238833212", "石头", 16));
        students.add(new Student("31722354994", "花陈陈", 7));
        students.add(new Student("47823332323", "东丹冬", 8));

        writeObject("E:\\Temp\\obj.txt", students);
//        writeObject("E:\\Test\\obj.txt", students);
    }

    /**
     * 将list中的对象写入文件
     *
     */
    public static void writeObject(String path,List<Student> students) {

        //将对象序列化写入文件
        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));

            for (Student student : students) {
                objectOutputStream.writeObject(student);
            }
            objectOutputStream.writeObject(null);//解决EOF的关键，加入一个空的对象
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将文件中数据对象读取出来
     *
     */
    public static List<Student> readObject(String path) {

        List<Student> students = new ArrayList<>();

        try {

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));

            Object obj = null;
            while ((obj = objectInputStream.readObject()) != null) {
                students.add((Student)obj);
            }

            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }
}
