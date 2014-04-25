package system;

import datastructures.InfoSet;

public class SystemManipulator {

    private SystemManipulator() {
    }

    public static InfoSet getBasicInfo() {
        InfoSet info = new InfoSet();
        info.add("Architecture", System.getProperty("os.arch"));
        info.add("OS", System.getProperty("os.name"));
        info.add("OS Version", System.getProperty("os.version"));
        info.add("Current JVM Max Memory", Runtime.getRuntime().maxMemory());
        info.add("Current JVM Free Memory", Runtime.getRuntime().freeMemory());
        return info;
    }
}
