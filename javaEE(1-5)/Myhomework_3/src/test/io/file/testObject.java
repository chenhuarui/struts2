//package test.io.file;
//
//import homework.entity.Student;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 测试：文件对于对象Object的写入和写出
// * 单个对象以及list
// *
// */
//public class testObject {
//
//    public static void main(String[] args) throws Exception {
//        File f = new File("e:\\Test\\obj.txt");
////        File f = new File("D:\\upload\\obj.txt");
//
////        writeObject(f);
//        readObject(f);
//
//        System.out.println("OK");
//    }
//
//
//
//    public static void writeObject(File f) {
//
//        StuArray stuArray = new StuArray();
//
//        //将对象序列化写入文件
//        FileOutputStream outputStream = null;
//        ObjectOutputStream objectOutputStream = null;
//        try {
//            outputStream = new FileOutputStream(f);
//            objectOutputStream = new ObjectOutputStream(outputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        for (Student student : stuArray.getList()) {
//            try {
//                objectOutputStream.writeObject(student);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            objectOutputStream.writeObject(null);//解决EOF的关键，加入一个空的对象
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            objectOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public static void readObject(File f) throws Exception {
//
//        StuArray stuArray = new StuArray();
//
//        FileInputStream inputStream = new FileInputStream(f);
//        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//
//        List<Student> students = new ArrayList<>();
//
//        Object student = null;
//        for(int i=0; i<stuArray.getList().size(); i++) {
//            if((student = objectInputStream.readObject()) != null) {
//                students.add((Student) student);
//            }
//        }
//        objectInputStream.close();
//
//        //打印出来里面list中的数据
//        System.out.println(students.toString());
//    }
//
//}
