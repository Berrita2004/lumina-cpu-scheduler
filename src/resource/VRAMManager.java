package resource;

public class VRAMManager {

    private int totalVRAM;
    private int usedVRAM;

    public VRAMManager(int totalVRAM) {
        this.totalVRAM = totalVRAM;
        this.usedVRAM = 0;
    }

    public boolean allocate(int memory) {

        if (usedVRAM + memory <= totalVRAM) {

            usedVRAM += memory;

            return true;
        }

        return false;
    }

    public void release(int memory) {

        usedVRAM -= memory;

        if (usedVRAM < 0) {
            usedVRAM = 0;
        }
    }

    public int getAvailableVRAM() {
        return totalVRAM - usedVRAM;
    }

    public int getUsedVRAM() {
        return usedVRAM;
    }
}