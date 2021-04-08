import parcs.*;

public class Master {
    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("DFS.jar");
        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("DFS");
        c.write("SOME BIG STRING");

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readLong());
        curtask.end();
    }
}
