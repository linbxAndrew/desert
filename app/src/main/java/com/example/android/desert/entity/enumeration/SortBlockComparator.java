package com.example.android.desert.entity.enumeration;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较类
 */
public class SortBlockComparator implements Comparator<DesertMapBlockEnum> {
    protected enum ComparisonMethod {
        MinXIncrease("根据minX进行升序", "minX", 1),
        MinYIncrease("根据minY进行升序", "minY", 1),
        MaxXIncrease("根据maxX进行升序", "maxX", 1),
        MaxYIncrease("根据maxY进行升序", "maxY", 1),
        MinXDecrease("根据minX进行降序", "minX",0),
        MinYDecrease("根据minY进行降序", "minY",0),
        MaxXDecrease("根据maxX进行降序", "maxX",0),
        MaxYDecrease("根据maxY进行降序", "maxY",0);
        private String desc;
        private String target;
        private int increase;

        ComparisonMethod(String desc, String target, int increase) {
            this.desc = desc;
            this.target = target;
            this.increase = increase;
        }
        private ComparisonMethod valuesOf(String target, int isIncreate) {
            for (ComparisonMethod method : ComparisonMethod.values()) {
                if (method.target.equalsIgnoreCase(target) && method.increase == isIncreate) {
                    return method;
                }
            }
            return null;
        }
    }

    ComparisonMethod method;

    public ComparisonMethod getMethod() {
        return method;
    }

    public void setMethod(ComparisonMethod method) {
        this.method = method;
    }

    public SortBlockComparator(ComparisonMethod method) {
        this.method = method;
    }

    @Override
    public int compare(DesertMapBlockEnum b1, DesertMapBlockEnum b2) {
        double result;
        switch (method) {
            case MinXIncrease:
                result = b1.minX - b2.minX;
            case MaxXIncrease:
                result = b1.maxX - b2.maxX;
            case MinYIncrease:
                result = b1.minY - b2.minY;
            case MaxYIncrease:
                result = b1.maxY - b2.maxY;
            case MinXDecrease:
                result = b2.minX - b1.minX;
            case MaxXDecrease:
                result = b2.maxX - b1.maxX;
            case MinYDecrease:
                result = b2.minY - b1.minY;
            case MaxYDecrease:
                result = b2.maxY - b1.maxY;
            default:
                result = 0;
        }
        return (int)result;
    }


    static DesertMapBlockEnum[] blockEnumsMinXIncrease, blockEnumsMaxXIncrease, blockEnumsMinYIncrease, blockEnumsMaxYIncrease;
    public static void sortBlock() {

        int length = DesertMapBlockEnum.values().length;
        SortBlockComparator comparetor = new SortBlockComparator(SortBlockComparator.ComparisonMethod.MinXIncrease);

        Arrays.sort(DesertMapBlockEnum.values(), comparetor);
        blockEnumsMinXIncrease = Arrays.copyOf(DesertMapBlockEnum.values(), length);

        comparetor.setMethod(SortBlockComparator.ComparisonMethod.MaxXIncrease);
        Arrays.sort(DesertMapBlockEnum.values(), comparetor);
        blockEnumsMaxXIncrease = Arrays.copyOf(DesertMapBlockEnum.values(), length);

        comparetor.setMethod(SortBlockComparator.ComparisonMethod.MinYIncrease);
        Arrays.sort(DesertMapBlockEnum.values(), comparetor);
        blockEnumsMinYIncrease = Arrays.copyOf(DesertMapBlockEnum.values(), length);

        comparetor.setMethod(SortBlockComparator.ComparisonMethod.MaxYIncrease);
        Arrays.sort(DesertMapBlockEnum.values(), comparetor);
        blockEnumsMaxYIncrease = Arrays.copyOf(DesertMapBlockEnum.values(), length);
    }
}