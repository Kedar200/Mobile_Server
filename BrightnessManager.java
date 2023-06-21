import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrightnessManager implements Runnable {
    int brightness;

    BrightnessManager(int b) {
        this.brightness = b;
    }

    @Override
    public void run() {
        try {
            String s = String.format("$brightness = %d;", brightness)
                    + "$delay = 0;"
                    + "$myMonitor = Get-WmiObject -Namespace root\\wmi -Class WmiMonitorBrightnessMethods;"
                    + "$myMonitor.wmisetbrightness($delay, $brightness)";
            String command = "powershell.exe  " + s;
            // Executing the command
            Process powerShellProcess = Runtime.getRuntime().exec(command);

            powerShellProcess.getOutputStream().close();

            // Report any error messages
            String line;

            BufferedReader stderr = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getErrorStream()));
            line = stderr.readLine();
            if (line != null) {
                System.err.println("Standard Error:");
                do {
                    System.err.println(line);
                } while ((line = stderr.readLine()) != null);

            }
            stderr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}