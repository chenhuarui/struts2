package test.io.file;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

public class FileUploadAction extends ActionSupport {
//    public static final long serialVersionUID = 1;


    //提交过来的文件
            private File file;

            //提交过来的file的名字
            private String fileFileName;

            //提交过来的file的文件类型
            private String fileContentType;


            @Override
            public String execute() throws Exception {

                System.out.println(file.toString());
                System.out.println(fileFileName);
                System.out.println(fileContentType);

                if(file != null) {

                    //上传文件存放的目录
                    String dataDir = "d:\\upload\\";

                    //上传文件在服务器具体的位置
                    File saveFile = new File(dataDir, fileFileName);

            //将上传文件从临时文件复制到指定的文件
            file.renameTo(saveFile);
        }else {
            return INPUT;
        }

        return "success";
    }

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

}
