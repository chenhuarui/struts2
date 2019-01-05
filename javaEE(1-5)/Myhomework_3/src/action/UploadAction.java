package action;
import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{

    //上传文件
    private File file;

    private String fileContentType;

    //上传的文件名
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(file);
        System.out.println(fileContentType);
        System.out.println(fileFileName);


        return super.execute();
    }
}