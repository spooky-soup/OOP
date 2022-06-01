import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NotebookTests {
    @Test
    public void addTest() {
        Notebook notebook = new Notebook(new ArrayList<>());

        Date d1 = new Date();
        Date d2 = new Date();
        NotebookRecord record1 = new NotebookRecord("Initial record", "this is first record", d1);
        NotebookRecord record2 = new NotebookRecord("second record", "this is a new record", d2);

        notebook.add(record1);
        notebook.add(record2);

        Assertions.assertArrayEquals(
                new NotebookRecord[]{
                        record1,
                        record2
                },
                notebook.getRecordList().toArray()
        );
    }

    @Test
    public void deleteByNameTest() {
        Notebook notebook = new Notebook(new ArrayList<>());
        Date d1 = new Date();
        Date d2 = new Date();
        NotebookRecord record1 = new NotebookRecord("Initial record", "this is first record", d1);
        NotebookRecord record2 = new NotebookRecord("second record", "this is a new record", d2);

        notebook.add(record1);
        notebook.add(record2);

        notebook.deleteByName("123312123312");

        Assertions.assertArrayEquals(
                new NotebookRecord[]{
                        record1,
                        record2
                },
                notebook.getRecordList().toArray()
        );

        notebook.deleteByName("Initial record");

        Assertions.assertArrayEquals(
                new NotebookRecord[]{
                        record2
                },
                notebook.getRecordList().toArray()
        );

    }

    @Test
    public void getByTimeTest() throws ParseException {
        Notebook notebook = new Notebook(new ArrayList<>());
        Date d1 = getParser().parse("2021-11-14 07:06:12+0000");
        Date d2 = getParser().parse("2020-11-10 07:06:12+0000");
        NotebookRecord record1 = new NotebookRecord("Initial record", "this is first record", d1);
        NotebookRecord record2 = new NotebookRecord("second record", "this is a new record", d2);

        notebook.add(record1);
        notebook.add(record2);

        List<NotebookRecord> sortedRecords = notebook.getByTime();

        Date from = getParser().parse("2021-11-10 07:06:12+0000");
        Date to = getParser().parse("2021-11-16 07:06:12+0000");

        List<NotebookRecord> filteredRecords = notebook.getByTimeAndKey(from, to, List.of("Initial"));

        Assertions.assertArrayEquals(
                new NotebookRecord[]{
                        record1, record2
                },
                sortedRecords.toArray()
        );

        Assertions.assertArrayEquals(
                new NotebookRecord[]{
                        record1
                },
                filteredRecords.toArray()
        );
    }

    private static SimpleDateFormat getParser() {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        parser.setTimeZone(TimeZone.getTimeZone("Asia/Novosibirsk"));
        return parser;
    }

}
