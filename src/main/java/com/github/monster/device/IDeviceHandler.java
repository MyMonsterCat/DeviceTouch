package com.github.monster.device;

import com.github.monster.entity.Point;
import com.github.monster.device.size.IDeviceSize;

import java.io.Closeable;
import java.io.IOException;

public interface IDeviceHandler extends Closeable {

    void down(int x, int y) throws IOException;

    void up(int x, int y) throws IOException;

    void move(int x, int y) throws IOException;

    void swipe(int x1, int y1, int x2, int y2, int duration) throws IOException;

    IDeviceSize getDeviceSize();

    default Point convertToRealPoint(int x, int y) {
        return new Point((int) (x / getDeviceSize().getScale()), (int) (y / getDeviceSize().getScale()));
    }
}
