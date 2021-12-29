import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class NotebookRecord {
    String recordName;
    String recordBody;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    Date recordDate;

    public NotebookRecord(String recordName, String recordBody, Date recordDate) {
        this.recordName = recordName;
        this.recordBody = recordBody;
        this.recordDate = recordDate;
    }

    public NotebookRecord(){}

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordBody() {
        return recordBody;
    }

    public void setRecordBody(String recordBody) {
        this.recordBody = recordBody;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public void printRecord() {
        System.out.println(recordName);
        System.out.println(recordBody);
    }

}
