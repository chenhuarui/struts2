package homework.Action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.Student;
import homework.service.WriteAndReadFile;
import org.apache.struts2.interceptor.RequestAware;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UploadAction extends ActionSupport implements RequestAware {

    //上传文件
    private File file;

    //上传的文件名
    private String fileFileName;

    //上传的文件类型
    private String fileContentType;

    public static List<Student> list = new ArrayList<>();


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Map<String, Object> application;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.application = map;
    }

    @Override
    public String execute() throws Exception {

        //根据上传的文件得到输入流
        InputStream is = new FileInputStream(file);

        //设置文件保存的目录
        String dir = "E:\\Test";

        //设置目标文件
        File toFile = new File(dir, this.getFileFileName());

        //文件输出流
        OutputStream os = new FileOutputStream(toFile);
        byte[] buffer = new byte[1024];


        //读取file文件输出到toFile文件中
        while(is.read(buffer, 0, buffer.length) != -1) {
            os.write(buffer);
        }

        //关闭输入和输出流
        os.close();
        is.close();

        list = WriteAndReadFile.readObject(dir+"\\"+this.getFileFileName());

        //传值给前端页面
        application.put("studentList", list);

        return SUCCESS;
    }
}