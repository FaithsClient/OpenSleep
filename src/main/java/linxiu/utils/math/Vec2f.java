/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils.math;

import linxiu.utils.render.gl.GLUtils;

public final class Vec2f {
    private float x;
    private float y;

    public Vec2f() {
        this(0.0f, 0.0f);
    }

    public Vec2f(Vec2f vec) {
        this(vec.x, vec.y);
    }

    public Vec2f(double x, double y) {
        this((float)x, (float)y);
    }

    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2f setX(float x) {
        this.x = x;
        return this;
    }

    public Vec2f setY(float y) {
        this.y = y;
        return this;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Vec2f add(Vec2f vec) {
        return new Vec2f(this.x + vec.x, this.y + vec.y);
    }

    public Vec2f add(double x, double y) {
        return this.add(new Vec2f(x, y));
    }

    public Vec2f add(float x, float y) {
        return this.add(new Vec2f(x, y));
    }

    public Vec2f sub(Vec2f vec) {
        return new Vec2f(this.x - vec.x, this.y - vec.y);
    }

    public Vec2f sub(double x, double y) {
        return this.sub(new Vec2f(x, y));
    }

    public Vec2f sub(float x, float y) {
        return this.sub(new Vec2f(x, y));
    }

    public Vec2f scale(float scale) {
        return new Vec2f(this.x * scale, this.y * scale);
    }

    public Vec3f toVec3() {
        return new Vec3f(this.x, this.y, 0.0);
    }

    public Vec2f copy() {
        return new Vec2f(this);
    }

    public Vec2f transfer(Vec2f vec) {
        this.x = vec.x;
        this.y = vec.y;
        return this;
    }

    public float distanceTo(Vec2f vec) {
        double dx = this.x - vec.x;
        double dy = this.y - vec.y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    public Vec3f toScreen() {
        return GLUtils.toWorld(this.toVec3());
    }

    public String toString() {
        return "Vec2{x=" + this.x + ", y=" + this.y + '}';
    }
}

