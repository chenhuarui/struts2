package action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {

    private InputStream inputStream;

    private String contentType;

    private long contentLength;

    //设定Content-Disposition 响应头,该响应指定接应的是一个文件的下载类型
    private String contentDisposition;


    public InputStream getInputStream() {
        return inputStream;
    }


    @Override
    public String execute() throws Exception {


        //确定各个成员变量的值
//        contentType = "image/jpg";
//        contentDisposition = "attachment;filename=we.jpg";

//        contentType = "text/plain";
//        contentDisposition = "attachment;filename='a.txt'";

        System.out.println(inputStream);


        String path = "C:\\Users\\Dell\\Pictures\\Saved Pictures\\a.txt";
        inputStream = new FileInputStream(path);

        System.out.println(inputStream);

//        contentLength = inputStream.available();

        return "success";
    }
}
