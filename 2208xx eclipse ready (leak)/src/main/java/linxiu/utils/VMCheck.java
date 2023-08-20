package linxiu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import linxiu.Client;

public final class VMCheck {

    private static volatile VMCheck INSTANCE;

    private VMCheck() {
        init();
        if (INSTANCE != null) {
            throw new RuntimeException("INSTANTIATION ERROR");
        }
    }
    
    public static VMCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (Client.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VMCheck();
                }
            }
        }
        return INSTANCE;
    }

    private String[] PROCESS_NAMES;

    
    private void init(){
            PROCESS_NAMES = new String[]{
                    "vboxservice.exe",
                    "vboxtray.exe",
                    "xenservice.exe",
                    "vmtoolsd.exe",
                    "vmwaretray.exe",
                    "vmwareuser.exe",
                    "vgauthservice.exe",
                    "vmacthlp.exe",
                    "vmsrvc.exe",
                    "vmusrvc.exe",
                    "prl_cc.exe",
                    "prl_tools.exe",
                    "qemu-ga.exe",
                    "vmcomputeagent.exe",
                    "sandboxie",
                    "vdagent",
                    "vdservice",
                    "fiddler",
                    "joeboxserver.exe",
                    "joeboxcontrol.exe",
                    "blnsvr.exe",
                    "pakkit.exe"
            };

            DEBUG_ARGS = new String[]{
                    "-xbootclasspath", "-xdebug",
                    "-agentlib", "-javaagent:",
                    "-xrun:", "-verbose", "-agentpath:"
            };

            MAC_ADDRESSES = new String[]{
                    //VMWare
                    "\\x00\\x05\\x69",
                    "00:05:69",
                    "\\x00\\x0C\\x29",
                    "00:0C:29",
                    "\\x00\\x1C\\x14",
                    "00:1C:14",
                    "\\x00\\x50\\x56",
                    "00:50:56",
                    //VirtualBox
                    "08:00:27",
                    //Xen
                    "\\x00\\x16\\x3E",
                    //Parallels
                    "\\x00\\x1C\\x42",
                    //Hybrid Analysis
                    "\\x0A\\x00\\x27"
            };

            FILE_NAMES = new String[]{
                    //VMBOX
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "drivers" + FileUtil.SEPARATOR + "VBoxMouse.sys",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "drivers" + FileUtil.SEPARATOR + "VBoxGuest.sys",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "drivers" + FileUtil.SEPARATOR + "VBoxSF.sys",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "drivers" + FileUtil.SEPARATOR + "VBoxVideo.sys",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxdisp.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxhook.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxmrxnp.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxogl.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglarrayspu.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglcrutil.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglerrorspu.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglfeedbackspu.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglpackspu.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxoglpassthroughspu.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxservice.exe",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "vboxtray.exe",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "VBoxControl.exe",
                    //VMWARE
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "Vmmouse.sys",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vm3dgl.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vmdum.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vm3dver.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vmtray.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "VMToolsHook.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vmmousever.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vmhgfs.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "vmGuestLib.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Drivers" + FileUtil.SEPARATOR + "VmGuestLibJava.dll",
                    FileUtil.SYS_DIR + FileUtil.SEPARATOR + "Driversvmhgfs.dll",
                    //WIN DEF
                    System.getProperty("user.home") + FileUtil.SEPARATOR + "Desktop" + FileUtil.SEPARATOR + "moutonheart.wav"
            };
    }
    // Note: WHEN DEBUGGING IN CLIENT, REMOVE -javaagent
    private String[] DEBUG_ARGS;

    private String[] MAC_ADDRESSES;

    private final byte[] ANYRUN_X64 = {(byte) 0x53, (byte) 0x48, (byte) 0x83, (byte) 0xEC, (byte) 0x20, (byte) 0xE8, (byte) 0x46, (byte) 0xEA, (byte) 0xFF, (byte) 0xFF, (byte) 0x48, (byte) 0x8B, (byte) 0x1D, (byte) 0xAB, (byte) 0x55, (byte) 0x00, (byte) 0x00, (byte) 0xB9, (byte) 0xF4, (byte) 0x11, (byte) 0x00, (byte) 0x00, (byte) 0xFF, (byte) 0xD3, (byte) 0xEB, (byte) 0xF7};
    private final byte[] ANYRUN_X86 = {(byte) 0x8D, (byte) 0x4C, (byte) 0x24, (byte) 0x04, (byte) 0x83, (byte) 0xE4, (byte) 0xF0, (byte) 0xFF, (byte) 0x71, (byte) 0xFC, (byte) 0x55, (byte) 0x89, (byte) 0xE5, (byte) 0x51, (byte) 0x83, (byte) 0xEC, (byte) 0x14, (byte) 0xE8, (byte) 0xDA, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0x8D, (byte) 0x76, (byte) 0x00, (byte) 0x8D, (byte) 0xBC, (byte) 0x27, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xC7, (byte) 0x04, (byte) 0x24, (byte) 0xF4, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0xE8, (byte) 0x84, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x83, (byte) 0xEC, (byte) 0x04, (byte) 0xEB, (byte) 0xEF};


    private String[] FILE_NAMES;


    public boolean runChecks() {
        return checkAnyRun() || checkMac() || checkFiles() || checkVMFiles() || checkVirtualBoxFiles() || checkUsername() || checkProcess();
    }


    private boolean checkMac() {
        try {
            for (String mac : MAC_ADDRESSES) {
                if (getMacAddress().equalsIgnoreCase(mac))
                    return true;
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    private List<String> listRunningProcesses() {
        List<String> processes = new ArrayList<>();
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
            BufferedReader input = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (!line.trim().equals("")) {
                    line = line.substring(1);
                    processes.add(line.substring(0, line.indexOf("\"")));
                }
            }
            input.close();
        } catch (Exception ignored) {
        }
        return processes;
    }

    private boolean checkProcess() {
        for (String runningProcess : listRunningProcesses()) {
            for (String process : PROCESS_NAMES) {
                if (runningProcess.toLowerCase().contains(process)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkFiles() {
        for (String file : FILE_NAMES) {
            if (Files.exists(Paths.get(file))) {
                return true;
            }
        }
        return false;
    }

    private String getMacAddress() throws UnknownHostException {
        StringBuilder macAddressBuilder = new StringBuilder();

        try {
            InetAddress ipAddress = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
            byte[] macAddressBytes = networkInterface.getHardwareAddress();

            for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++) {
                String macAddressHexByte = String.format("%02X", macAddressBytes[macAddressByteIndex]);
                macAddressBuilder.append(macAddressHexByte);

                if (macAddressByteIndex != macAddressBytes.length - 1)
                    macAddressBuilder.append(":");
            }
        } catch (UnknownHostException | SocketException ignored) {
        }

        return macAddressBuilder.toString();
    }


    private boolean checkVMFiles() {
        final String osNameMatch = System.getProperty("os.name").toLowerCase();
        if (osNameMatch.contains("linux")) {
            return new File("/etc/vmware-tools").exists();
        } else if (osNameMatch.contains("windows")) {
            String path = !System.getProperty("os.arch").equalsIgnoreCase("x86") ?
                    System.getenv("ProgramFiles(X86)") : System.getenv("ProgramFiles");
            return new File(path + "\\VMware\\VMware Tools").exists();
        } else if (osNameMatch.contains("mac os") || osNameMatch.contains("macos") || osNameMatch.contains("darwin")) {
            return new File("/Library/Application Support/VMware Tools").exists();
        }

        return false;
    }

    private boolean checkVirtualBoxFiles() {
        final String osNameMatch = System.getProperty("os.name").toLowerCase();
        if (osNameMatch.contains("linux")) {
            return new File("/etc/init.d/vboxadd").exists();
        } else if (osNameMatch.contains("windows")) {
            String path = !System.getProperty("os.arch").equalsIgnoreCase("x86") ?
                    System.getenv("ProgramFiles(X86)") : System.getenv("ProgramFiles");
            return new File(path + "\\Oracle\\VirtualBox Guest Additions").exists();
        }
        return false;
    }

    private boolean checkUsername() {
        String username = System.getProperty("user.name");
        return username.equals("WDAGUtilityAccount") || username.toLowerCase().startsWith("hal-");
    }

    private boolean checkAnyRun() {
        try {
            File f = new File(FileUtil.SYS_DIR, "windanr.exe");
            if (!f.exists()) {
                return false;
            }
            return searchSig(f, (System.getenv("ProgramFiles(x86)") != null) ? ANYRUN_X64 : ANYRUN_X86);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean searchSig(File file, byte[] badBytes) throws Exception {
        if (file.exists()) {
            if (file.isDirectory()) {
                if (file.canRead()) {
                    try {
                        for (File subFiles : Objects.requireNonNull(file.listFiles())) {
                            searchSig(subFiles, badBytes);
                        }
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }
                }
            } else if (file.isFile()) {
                if (file.canRead()) {
                    byte[] fileBytes = Files.readAllBytes(file.toPath());
                    for (int i = 0; i <= fileBytes.length - badBytes.length; i++) {
                        if (match(fileBytes, badBytes, i))
                            return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean match(byte[] haystack, byte[] needle, int start) {
        if (needle.length + start <= haystack.length) {
            for (int i = 0; i < needle.length; i++) {
                if (needle[i] == haystack[i + start])
                    return true;
            }
        }
        return false;
    }

    private boolean checkArguments() {
        for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            for (String blacklist : DEBUG_ARGS) {
                if (arg.toLowerCase().startsWith(blacklist)) {
                    return true;
                }
            }
        }
        return false;
    }
}
