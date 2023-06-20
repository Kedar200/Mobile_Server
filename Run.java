public class Run {
    public static void main(String[] args) {
        Server kedaServer = new Server(1983);
        creaelog c = new creaelog();

        try {
            c.createlog("Server Started");
            c.createlog("Waiting for the client");
            kedaServer.start_server();
        } catch (Exception e) {
            c.createlog("Server not Started: " + e.toString());
        }

    }
}
