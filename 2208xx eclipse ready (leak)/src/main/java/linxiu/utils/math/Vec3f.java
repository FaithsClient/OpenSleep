/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils.math;

import linxiu.utils.render.gl.GLUtils;

public final class Vec3f {
    private double x;
    private double y;
    private double z;

    public Vec3f() {
        this(0.0, 0.0, 0.0);
    }

    public Vec3f(Vec3f vec) {
        this(vec.x, vec.y, vec.z);
    }

    public Vec3f(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3f setX(double x) {
        this.x = x;
        return this;
    }

    public Vec3f setY(double y) {
        this.y = y;
        return this;
    }

    public Vec3f setZ(double z) {
        this.z = z;
        return this;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public Vec3f add(Vec3f vec) {
        return this.add(vec.x, vec.y, vec.z);
    }

    public Vec3f add(double x, double y, double z) {
        return new Vec3f(this.x + x, this.y + y, this.z + z);
    }

    public Vec3f sub(Vec3f vec) {
        return new Vec3f(this.x - vec.x, this.y - vec.y, this.z - vec.z);
    }

    public Vec3f sub(double x, double y, double z) {
        return new Vec3f(this.x - x, this.y - y, this.z - z);
    }

    public Vec3f scale(float scale) {
        return new Vec3f(this.x * (double)scale, this.y * (double)scale, this.z * (double)scale);
    }

    public Vec3f copy() {
        return new Vec3f(this);
    }

    public Vec3f transfer(Vec3f vec) {
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
        return this;
    }

    public double distanceTo(Vec3f vec) {
        double dx = this.x - vec.x;
        double dy = this.y - vec.y;
        double dz = this.z - vec.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public Vec2f rotationsTo(Vec3f vec) {
        double[] diff = new double[]{vec.x - this.x, vec.y - this.y, vec.z - this.z};
        double hDist = Math.sqrt(diff[0] * diff[0] + diff[2] * diff[2]);
        return new Vec2f(Math.toDegrees(Math.atan2(diff[2], diff[0])) - 90.0, - Math.toDegrees(Math.atan2(diff[1], hDist)));
    }

    public Vec3f toScreen() {
        return GLUtils.toScreen(this);
    }

    public String toString() {
        return "Vec3{x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
    }
}

