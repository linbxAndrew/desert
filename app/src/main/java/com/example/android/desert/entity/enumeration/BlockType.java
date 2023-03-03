package com.example.android.desert.entity.enumeration;

public enum BlockType {
    BaseCamp("大本营"), Desert("沙漠"), Oasis("绿洲"), Mausoleum("王陵"), Village("村庄"), GoldenMountain("金山"), Other("其他区域");

    private String desc;

    private BlockType(String desc) {
        this.desc = desc;
    }

    public BlockType parseBLockType(String name) {
        char type = name.charAt(0);
        return parseBLockType(type);
    }


    public static BlockType parseBLockType(char type) {
        switch (Character.toUpperCase(type)) {
            case 'S':
                return Desert;
            case 'L':
                return Oasis;
            case 'W':
                return Mausoleum;
            case 'J':
                return GoldenMountain;
            case 'D':
                return BaseCamp;
            case 'C':
                return Village;
            case 'O':
            default:
                return Other;
        }
    }

    public String getDesc() {
        return desc;
    }
}
