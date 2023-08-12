package linxiu.utils;

public class XrayBlock {
    public double x;
    public double y;
    public double z;
    public String type;

    public XrayBlock(double a, double a2, double a3, String xx) {
        this.z = a;
        this.y = a2;
        this.x = a3;
        this.type = xx;
    }

    public XrayBlock() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
}
