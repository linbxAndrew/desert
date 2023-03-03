package com.example.android.desert.entity.enumeration;

import android.support.v4.os.IResultReceiver;
import android.util.Log;

import com.example.android.desert.entity.Coordinate;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum DesertMapBlockEnum {

    S1(
            new String[]{"D1", "S2", "S4", "S5"}, new double[]{9.4, 82.0, 21.3, 82.0, 24.1, 86.3, 26.0, 85.8, 24.9, 67.6, 21.6, 66.7, 10.5, 67.2, 8.3, 70.2,
            8.8, 76.4}
    ), S2(
            new String[]{"D1", "S1", "S3", "S4", "C1"}, new double[]{24.1, 93.7, 28.3, 93.9, 31.0, 92.6, 35.2, 94.2, 34.6, 83.5, 36.6, 82.4, 36.0, 72.2, 26.6, 72.3,
            27.7, 86.6, 23.5, 86.8}
    ), S3(
            new String[]{"S2", "S4", "S9", "C1", "C2"}, new double[]{38.0, 82.5, 43.8, 82.9, 43.8, 76.4, 46.0, 76.1, 45.8, 69.5, 41.0, 69.4, 41.0, 71.7, 37.7, 72.2}
    ), S4(
            new String[]{"S1", "S2", "S3", "S5", "S9", "S10", "S11", "S12"}, new double[]{26.3, 69.7, 27.2, 70.8, 39.7, 70.5, 39.7, 60.6, 30.8, 60.2, 29.9, 50.8, 19.7, 50.8, 21.0, 65.3,
            26.3, 65.4}

    ), S5(
            new String[]{"S1", "S4", "S11"}, new double[]{10.5, 66.7, 12.7, 65.3, 19.1, 65.3, 18.3, 55.9, 6.3, 56.0, 6.3, 57.4, 8.8, 59.7, 9.6, 62.8,
            7.7, 62.8, 7.7, 66.7, 9.4, 67.2}
    ), S6(
            new String[]{"C1", "C2", "S7"}, new double[]{48.0, 93.9, 55.0, 93.9, 55.0, 89.6, 48.0, 89.1}
    ), S7(
            new String[]{"S6", "S8", "S27", "C2", "C3"}, new double[]{57.8, 88.3, 56.4, 89.1, 56.1, 94.0, 68.1, 94.2, 68.1, 90.6, 65.3, 90.3, 66.1, 78.4, 58.1, 78.6}

    ), S8(
            new String[]{"S7", "S9", "S25", "S26", "C2", "C3", "L1"}, new double[]{55.3, 76.1, 57.8, 76.3, 58.3, 77.4, 65.3, 77.4, 66.1, 76.3, 67.5, 76.3, 68.3, 62.1, 63.6, 61.6,
            61.9, 64.8, 55.8, 65.1}

    ), S9(
            new String[]{"S3", "S4", "S8", "S10", "L1", "C2"}, new double[]{47.7, 75.9, 53.9, 75.9, 53.6, 64.9, 46.9, 64.4, 46.0, 60.6, 41.3, 60.5, 41.6, 68.0, 47.4, 68.2}

    ), S10(
            new String[]{"S4", "S9", "S12", "L1", "L2", "W1"}, new double[]{31.9, 59.5, 46.6, 59.5, 45.8, 50.4, 39.7, 50.4, 39.1, 41.9, 31.0, 42.2}

    ), S11(
            new String[]{"S4", "S5", "S12", "S13"}, new double[]{6.0, 53.9, 18.3, 54.7, 17.7, 50.9, 19.7, 49.3, 19.7, 41.9, 6.3, 42.2, 6.6, 45.7, 8.8, 47.2,
            5.8, 48.1}

    ), S12(
            new String[]{"S4", "S10", "S11", "S13", "L2"}, new double[]{21.9, 50.0, 29.9, 49.5, 29.7, 42.4, 28.0, 41.7, 27.4, 37.3, 21.3, 37.0}

    ), S13(
            new String[]{"S11", "S12", "S14", "S15", "L2"}, new double[]{6.0, 40.4, 19.4, 40.1, 19.7, 36.5, 27.7, 36.3, 27.2, 30.1, 20.2, 29.9, 20.2, 31.7, 7.2, 32.4,
            7.7, 34.7, 5.5, 37.8}

    ), S14(
            new String[]{"S13", "S15", "S16"}, new double[]{6.9, 30.4, 17.7, 30.2, 17.4, 11.5, 15.8, 11.1, 16.0, 12.6, 13.8, 11.5, 12.2, 10.3, 4.4, 11.1,
            4.7, 17.4, 5.8, 18.2, 4.4, 21.2, 6.3, 24.0}

    ), S15(
            new String[]{"S13", "S14", "S16", "S17", "L2"}, new double[]{20.2, 28.7, 27.2, 29.1, 29.9, 27.8, 29.4, 20.0, 19.7, 20.2}
    ), S16(
            new String[]{"S14", "S15", "S17"}, new double[]{19.7, 18.7, 30.8, 18.4, 31.6, 20.4, 32.7, 20.4, 33.0, 10.8, 19.1, 11.0}
    ), S17(
            new String[]{"S15", "S16", "S18", "W1", "L2"}, new double[]{32.2, 27.9, 40.2, 28.1, 41.3, 26.3, 45.2, 25.9, 44.9, 16.2, 42.7, 14.9, 43.0, 13.1, 42.2, 10.6,
            34.6, 10.6, 34.6, 21.7, 31.9, 22.5}

    ), S18(
            new String[]{"S17", "S19", "W1",}, new double[]{46.6, 25.9, 56.4, 26.3, 56.4, 18.2, 54.4, 18.2, 52.5, 21.0, 46.9, 18.2}

    ), S19(
            new String[]{"S18", "S20", "W1", "J1"}, new double[]{57.5, 26.1, 62.5, 25.8, 63.1, 19.5, 68.9, 18.4, 69.2, 12.3, 58.3, 15.9}

    ), S20(
            new String[]{"S19", "S21", "S22", "W1", "J1", "C6"}, new double[]{63.9, 35.6, 88.6, 35.5, 89.7, 30.4, 73.6, 29.9, 73.6, 25.0, 69.2, 24.1, 68.3, 20.0, 64.4, 20.8}

    ), S21(
            new String[]{"S20", "J1", "C6"}, new double[]{90.6, 34.0, 96.4, 34.0, 96.7, 32.0, 94.4, 30.9, 95.0, 28.6, 96.7, 27.4, 96.4, 25.0, 91.9, 24.8}

    ), S22(
            new String[]{"S20", "S23", "S24", "W1", "C6"}, new double[]{66.4, 42.7, 75.8, 42.9, 76.1, 41.4, 81.4, 41.6, 81.7, 37.5, 66.7, 37.0}
    ), S23(
            new String[]{"S22", "S24", "S25", "W1", "L1"}, new double[]{63.1, 52.3, 75.3, 52.4, 75.6, 51.3, 75.3, 49.1, 75.8, 44.0, 65.8, 44.4, 65.6, 50.0, 62.8, 50.1}
    ), S24(
            new String[]{"S22", "S23", "S25", "S26", "C4", "C5", "C6"}, new double[]{79.7, 63.6, 82.2, 63.6, 83.3, 50.0, 81.4, 49.5, 81.4, 42.9, 77.2, 42.6, 76.7, 57.0, 80.8, 57.7}
    ), S25(
            new String[]{"S8", "S23", "S24", "S26", "L1"}, new double[]{63.6, 60.6, 67.5, 60.6, 67.8, 57.8, 75.0, 57.4, 75.0, 53.9, 63.1, 53.4}

    ), S26(
            new String[]{"S8", "S24", "S25", "C3", "C4"}, new double[]{68.9, 76.3, 75.0, 76.3, 75.8, 63.9, 79.2, 63.3, 78.6, 58.7, 69.2, 58.8, 68.6, 61.5, 70.0, 63.8}

    ), S27(
            new String[]{"S7", "C3", "C4"}, new double[]{68.9, 94.0, 73.3, 94.0, 74.7, 92.4, 76.4, 94.4, 89.7, 94.0, 91.4, 80.9, 81.9, 81.2, 81.1, 90.1,
            68.6, 90.3}
    ), C1(
            new String[]{"S2", "S3", "S6", "C2"}, new double[]{36.9, 94.2, 46.6, 94.4, 45.8, 84.2, 35.8, 84.3}
    ), C2(
            new String[]{"C1", "S3", "S6", "S7", "S8", "S9"}, new double[]{48.0, 88.1, 56.4, 87.9, 56.9, 78.2, 55.8, 77.1, 46.0, 77.3, 45.2, 82.9, 47.7, 83.2}

    ), C3(
            new String[]{"S7", "S8", "S26", "S27", "C4"}, new double[]{66.9, 89.8, 79.7, 89.6, 79.7, 77.8, 67.5, 77.3}
    ), C4(
            new String[]{"C3", "C5", "S24", "S26", "S27"}, new double[]{81.7, 79.6, 92.2, 79.4, 92.5, 74.3, 90.8, 71.5, 92.5, 68.7, 92.8, 65.3, 77.2, 64.3, 76.7, 76.6,
            81.1, 76.8}

    ), C5(
            new String[]{"C4", "C6", "S24"}, new double[]{83.9, 63.6, 92.8, 63.8, 93.9, 52.4, 92.2, 49.1, 93.1, 48.0, 85.5, 48.3}
    ), C6(
            new String[]{"C5", "S20", "S21", "S22", "S24"}, new double[]{82.5, 49.0, 84.4, 49.0, 85.0, 47.0, 93.6, 47.0, 95.8, 43.0, 96.1, 35.2, 90.6, 35.2, 89.4, 37.3,
            83.9, 37.3}
    ), L1(
            new String[]{"S8", "S9", "S10", "S23", "S25", "W1"}, new double[]{48.3, 64.1, 61.7, 63.9, 61.7, 50.1, 47.7, 50.3}
    ), L2(
            new String[]{"S10", "S12", "S13", "S15", "S17", "W1"}, new double[]{29.7, 41.1, 42.4, 40.9, 42.2, 29.1, 29.1, 29.2}

    ), W1(
            new String[]{"L1", "L2", "S10", "S17", "S18", "S19", "S20", "S22", "S23"}, new double[]{40.5, 49.5, 64.2, 49.5, 65.3, 37.0, 62.5, 36.6, 62.2, 28.2, 41.9, 27.4, 41.3, 28.2, 43.5, 29.2,
            43.5, 41.9, 41.0, 41.9}
    ), J1(
            new String[]{"S19", "S20", "S21"}, new double[]{75.0, 29.7, 90.3, 29.4, 90.6, 24.1, 97.2, 23.6, 96.7, 8.7, 73.9, 8.3, 71.4, 10.6, 70.8, 23.1,
            74.4, 23.8}
    ), D1(
            new String[]{"S1", "S2"}, new double[]{13, 94, 22, 94, 22, 85, 21, 82, 11, 83, 7, 86, 8, 92, 9, 93, 11, 93}
    ), Other(
            new String[]{""}, new double[]{}
    );

    // 多边形的每一个点的坐标的数组
    private Coordinate[] coordinates;
    // 该多边形有几个点。
    int pointNum;
    // 多边形的最大X、Y坐标，最小X、Y坐标。
    protected double minX, maxX, minY, maxY;

    BlockType type;
    int num;


    /**
     * 构造函数。
     *
     * @param positions
     */
    private DesertMapBlockEnum(String[] redundant, @Nullable double[] positions) {
        String name = this.name();
        char charType = name.charAt(0);
        this.type = BlockType.parseBLockType(charType);
        if (this.type == BlockType.Other) {
            this.num = 0;
        } else {
            try {
                int num = Integer.parseInt(name.substring(1));
                this.num = num;
            } catch (NumberFormatException e) {
                this.type = BlockType.Other;
                this.num = 0;
            }
        }

        if (positions == null) {
            // 如果是点在空白处（设置空白处没有边的点。）。
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;
            pointNum = 0;
            coordinates = null;
        } else {
            minX = 100;
            maxX = 0;
            minY = 100;
            maxY = 0;
            if (positions.length % 2 == 1) {
                throw new IllegalArgumentException("参数数量不是奇数，错误。");
            }
            pointNum = positions.length / 2;
            coordinates = new Coordinate[pointNum];
            for (int i = 0, j = 0; i < positions.length; i += 2, j += 1) {
                // Log.i("DesertMapBlockEnum", "i = " + i + ", j = " + j);
                coordinates[j] = new Coordinate(positions[i], positions[i + 1]);
                minX = coordinates[j].getCoordinateX() < minX ? coordinates[j].getCoordinateX() : minX;
                minY = coordinates[j].getCoordinateY() < minY ? coordinates[j].getCoordinateY() : minY;
                maxX = coordinates[j].getCoordinateX() > maxX ? coordinates[j].getCoordinateX() : maxX;
                maxY = coordinates[j].getCoordinateY() > maxY ? coordinates[j].getCoordinateY() : maxY;

            }
        }
    }

    /**
     * 判断点坐标是否在指定的块内
     *
     * @param pointCoordinate
     * @param block
     * @return
     */
    private static boolean isThePointInTheBlock(Coordinate pointCoordinate, DesertMapBlockEnum block) {
        double px;
        double py;
        px = pointCoordinate.getCoordinateX();
        py = pointCoordinate.getCoordinateY();
        if (px < block.minX || px > block.maxX || py < block.minY || py > block.maxY) {
            // Log.i("isThePointInTheBlock" + block.name(), "minX：" + block.minX
            // + "maxX：" + block.maxX + "minY：" + block.minY + "block.maxY：" +
            // block.maxY);
            // Log.i("isThePointInTheBlock" + block.name(), "px：" + px + ", py："
            // +py);
            // Log.i("isThePointInTheBlock" + block.name(), "out of range");
            return false;
        } else {
            boolean flag = false;
            int i, j;
            double ix;
            double iy;
            double jx;
            double jy;
            // 遍历每一条边（第一条边，起点是最后一点，终点是第一点；第二条边，起点是第二点，终点是第三点……）
            for (i = 0, j = block.pointNum - 1; i < block.pointNum; j = i++) {
                ix = block.coordinates[i].getCoordinateX();
                iy = block.coordinates[i].getCoordinateY();
                jx = block.coordinates[j].getCoordinateX();
                jy = block.coordinates[j].getCoordinateY();
                // 如果从点向右的射线和块的边有交点，那就把flag取反。最终取奇数次反的在内部，偶数次在外部。
                if ((iy > py) != (jy > py)) {
                    // 计算点的横线与边的交点的x坐标。如果这个x坐标大于所求点的x坐标，那这条线可用。
                    double intersectionX = ix + (iy - py) / (iy - jy) * (jx - ix);
                    // System.out.println("intersectionX = " + intersectionX);
                    if (px < intersectionX) {
                        flag = !flag;
                    }
                }
            }
            return flag;
        }
    }

    /**
     * 判断点坐标在哪个块内
     *
     * @param coordinateX
     * @param coordinateY
     * @return
     */
    public static DesertMapBlockEnum inWhichBlock(double coordinateX, double coordinateY) {
        return inWhichBlock(new Coordinate(coordinateX, coordinateY));
    }

    /**
     * 判断点坐标在哪个块内
     *
     * @param pointCoordinate
     * @return
     */
    public static DesertMapBlockEnum inWhichBlock(Coordinate pointCoordinate) {
        for (DesertMapBlockEnum block : DesertMapBlockEnum.values()) {
            if (isThePointInTheBlock(pointCoordinate, block)) {
                return block;
            }
        }
        // System.out.println("都不是，返回Other吧。");
        return Other;
    }

    /**
     * 判断点坐标是否在指定的块内
     *
     * @param coordinateX：横坐标。
     * @param coordinateY：纵坐标
     * @param block
     * @return
     */
    private static boolean isThePointInTheBlock(double coordinateX, double coordinateY, DesertMapBlockEnum block) {
        return isThePointInTheBlock(new Coordinate(coordinateX, coordinateY), block);
    }

    /**
     * 判断两块是否相邻
     *
     * @param block
     * @return
     */
    public boolean isAdjacent(DesertMapBlockEnum block) {
        if (BlockRelationEnum.valueOf(this.name()).getAdjacentBlocks().contains(block)) {
            return true;
        } else {
            return false;
        }
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    public int getPointNum() {
        return pointNum;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public String getDesc() {
        switch (this.type) {
            case BaseCamp:
            case Mausoleum:
            case GoldenMountain:
            case Other:
                return this.type.getDesc();
            case Village:
            case Desert:
            case Oasis:
                return num + "号" + this.type.getDesc();
        }
        return BlockType.Other.getDesc();
    }

    @Override
    public String toString() {
        return "DesertMapBlockEnum{" +
                ", coordinates=" + Arrays.toString(coordinates) +
                ", pointNum=" + pointNum +
                ", minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                '}';
    }


}
