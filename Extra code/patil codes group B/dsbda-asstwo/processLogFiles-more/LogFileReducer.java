package LogFileCountry;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class LogFileReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text t_key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
            Reporter reporter) throws IOException {
        Text key = t_key;
        int frequencyForIp = 0;
        while (values.hasNext()) {
            IntWritable value = (IntWritable) values.next();
            frequencyForIp += value.get();
        }
        output.collect(key, new IntWritable(frequencyForIp));
    }
}
