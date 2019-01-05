package homework.Action;

import com.opensymphony.xwork2.ActionSupport;
import homework.entity.Screen;
import homework.entity.Student;
import homework.service.QueryStuInfo;

import java.io.*;
import java.util.List;

public class DownloadAction extends ActionSupport {

    private Screen screen;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private InputStream downloadFile;


    public InputStream getDownloadFile() throws UnsupportedEncodingException {

        List<Student> students = new QueryStuInfo().queryInfo(screen.getAttribute(),screen.getOperation(),screen.getKey());

        return new ByteArrayInputStream(students.toString().getBytes("UTF-8"));
    }

    public void setDownloadFile(InputStream downloadFile) {
        this.downloadFile = downloadFile;
    }
}
