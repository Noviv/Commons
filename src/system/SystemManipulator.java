package system;

import datastructures.InfoSet;
import java.lang.management.ManagementFactory;

public class SystemManipulator {

    private SystemManipulator() {
    }

    /**
     * Gets basic system info.
     *
     * @return The <code>InfoSet</code> of information.
     */
    public static InfoSet getBasicInfo() {
        InfoSet info = new InfoSet();
        info.add("Architecture", System.getProperty("os.arch"));
        info.add("OS", System.getProperty("os.name"));
        info.add("OS Version", System.getProperty("os.version"));
        info.add("Current JVM Max Memory", Runtime.getRuntime().maxMemory());
        info.add("Current JVM Free Memory", Runtime.getRuntime().freeMemory());
        return info;
    }

    /**
     * Gets the current process ID of the program.
     *
     * @return Long PID.
     */
    public static long getProcessID() {
        return Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
    }
}
