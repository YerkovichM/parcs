import parcs.*;

public class Master {
    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("DFS.jar");
        AMInfo info = new AMInfo(curtask, null);
        point p1 = info.createPoint();
        point p2 = info.createPoint();
        System.out.println("Initial input: SOME BIG STRING 2ND PART OF STRING");

        channel c1 = p1.createChannel();
        p1.execute("DFS");
        c1.write("SOME BIG STRING");

        channel c2 = p2.createChannel();
        p2.execute("DFS");
        c2.write("2ND PART OF STRING");

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c1.readObject() + c2.readObject());
        curtask.end();
    }
}
