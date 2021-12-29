import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Notebook {

    private List<NotebookRecord> recordList;

    public Notebook(List<NotebookRecord> recordList) {
        this.recordList = recordList;
    }

    public List<NotebookRecord> getRecordList() {
        return recordList;
    }

    public void add(NotebookRecord record) {
        recordList.add(record);
    }

    public void deleteByName(String name) {
        recordList = recordList.stream()
                .filter(record -> !Objects.equals(record.getRecordName(), name))
                .collect(Collectors.toList());
    }

    private void sortByDate() {
        recordList.sort(
                (a, b) ->
                        a.getRecordDate().before(b.getRecordDate()) ? 1 : 0
        );
    }

    public List<NotebookRecord> getByTime() {
        sortByDate();
        return recordList;
    }

    public List<NotebookRecord> getByTimeAndKey(
            Date from,
            Date to,
            List<String> keys
    ) {
        sortByDate();
        List<NotebookRecord> recordBuff = recordList.stream()
                .filter(record -> record.getRecordDate().after(from))
                .filter(record -> record.getRecordDate().before(to))
                .collect(Collectors.toList());

        if(keys.isEmpty()){
            return recordBuff;
        }

        List<NotebookRecord> filteredList = new ArrayList<>();
        for (NotebookRecord record : recordBuff) {
            boolean flag = false;
            for(String t : keys){
                if(record.getRecordName().contains(t)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                filteredList.add(record);
            }
        }
        return filteredList;
    }

}
