import parcs.AMInfo;
import parcs.channel;
import parcs.point;
import parcs.task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Master {
    final static String STRING = "Wikis are enabled by wiki software, otherwise known as wiki engines. A wiki engine, being a form of a content management system, differs from other web-based systems such as blog software, in that the content is created without any defined owner or leader, and wikis have little inherent structure, allowing structure to emerge according to the needs of the users.[1] Wiki engines usually allow content to be written using a simplified markup language and sometimes edited with the help of a rich-text editor.[2] There are dozens of different wiki engines in use, both standalone and part of other software, such as bug tracking systems. Some wiki engines are open source, whereas others are proprietary. Some permit control over different functions (levels of access); for example, editing rights may permit changing, adding, or removing material. Others may permit access without enforcing access control. Other rules may be imposed to organize content.";

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("DFS.jar");
        AMInfo info = new AMInfo(curtask, null);

        System.out.println(STRING);

        List<channel> chns = new ArrayList<>();
        for (int i = 0; i < STRING.length(); i += 10) {
            point point = info.createPoint();
            channel chn = point.createChannel();
            chns.add(chn);
            point.execute("DFS");
            int end = i + 10;
            end = Math.min(end, STRING.length());
            chn.write(STRING.substring(i, end));
        }
        System.out.println("Waiting for result...");
        String result = chns.stream()
                .map(channel::readObject)
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println("Result: " + result);
        curtask.end();
    }
}
