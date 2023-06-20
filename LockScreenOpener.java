import java.io.IOException;

public class LockScreenOpener {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c",
                    "rundll32.exe user32.dll,LockWorkStation");
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Lock screen opened successfully.");
            } else {
                System.out.println("Failed to open lock screen.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
