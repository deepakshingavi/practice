import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HdfsJava {
    public static void main(String[] args) throws IOException {
        FileSystem fs = FileSystem.get(new Configuration());
        List<List<Object>> list = new ArrayList<>();
    }
}
