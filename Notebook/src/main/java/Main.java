import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String pathToFile = "./testfile.json";
        List<NotebookRecord> recordList;
        if (new File(pathToFile).exists()) {
            recordList = new ObjectMapper().readValue(new File(pathToFile), new TypeReference<List<NotebookRecord>>(){});
        } else {
            recordList = new ArrayList<>();
        }

        Notebook notebook = new Notebook(recordList);

        int argsNumber = args.length;
        if (argsNumber == 0) throw new IllegalArgumentException("No arguments provided");

        switch (args[0]) {

            case "-add":
                if(argsNumber != 3) {
                    throw new IllegalArgumentException("Not enough arguments");
                }
                notebook.add(new NotebookRecord(args[1], args[2], new Date()));
                break;

            case "-rm":
                if(argsNumber != 2) {
                    throw new IllegalArgumentException("Not enough arguments");
                }
                notebook.deleteByName(args[1]);
                break;

            case "-show":
                if(argsNumber == 1) {
                    for (var record : notebook.getByTime()) {
                        record.printRecord();
                    }
                }
                else if (argsNumber >= 3) {
                    Date from = getParser().parse(args[1]);
                    Date to = getParser().parse(args[2]);
                    List<String> substrings = new ArrayList<>();
                    for (int i = 3; i < argsNumber; i++) {
                        substrings.add(args[i]);
                    }
                    for (var record : notebook.getByTimeAndKey(from, to, substrings)) {
                        record.printRecord();
                    }
                }
                else throw new IllegalArgumentException("Wrong number of arguments");
            default:
                throw new IllegalArgumentException("No such argument");
        }

        recordList = notebook.getRecordList();
        File l = new File(pathToFile);
        if (l.exists()) {
            l.delete();
        }
        new ObjectMapper().writeValue(new File(pathToFile), recordList);

    }

    private static SimpleDateFormat getParser() {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        parser.setTimeZone(TimeZone.getTimeZone("Asia/Novosibirsk"));
        return parser;
    }
}
