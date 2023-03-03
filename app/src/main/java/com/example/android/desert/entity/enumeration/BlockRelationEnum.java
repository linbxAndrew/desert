package com.example.android.desert.entity.enumeration;

import android.util.Log;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public enum BlockRelationEnum {

    S1(
            new String[]{"D1", "S2", "S4", "S5"}
    ), S2(
            new String[]{"D1", "S1", "S3", "S4", "C1"}
    ), S3(
            new String[]{"S2", "S4", "S9", "C1", "C2"}
    ), S4(
            new String[]{"S1", "S2", "S3", "S5", "S9", "S10", "S11", "S12"}
    ), S5(
            new String[]{"S1", "S4", "S11"}
    ), S6(
            new String[]{"C1", "C2", "S7"}
    ), S7(
            new String[]{"S6", "S8", "S27", "C2", "C3"}
    ), S8(
            new String[]{"S7", "S9", "S25", "S26", "C2", "C3", "L1"}

    ), S9(
            new String[]{"S3", "S4", "S8", "S10", "L1", "C2"}
    ), S10(
            new String[]{"S4", "S9", "S12", "L1", "L2", "W1"}
    ), S11(
            new String[]{"S4", "S5", "S12", "S13"}

    ), S12(
            new String[]{"S4", "S10", "S11", "S13", "L2"}
    ), S13(
            new String[]{"S11", "S12", "S14", "S15", "L2"}

    ), S14(
            new String[]{"S13", "S15", "S16"}

    ), S15(
            new String[]{"S13", "S14", "S16", "S17", "L2"}
    ), S16(
            new String[]{"S14", "S15", "S17"}
    ), S17(
            new String[]{"S15", "S16", "S18", "W1", "L2"}

    ), S18(
            new String[]{"S17", "S19", "W1",}

    ), S19(
            new String[]{"S18", "S20", "W1", "J1"}

    ), S20(
            new String[]{"S19", "S21", "S22", "W1", "J1", "C6"}

    ), S21(
            new String[]{"S20", "J1", "C6"}

    ), S22(
            new String[]{"S20", "S23", "S24", "W1", "C6"}
    ), S23(
            new String[]{"S22", "S24", "S25", "W1", "L1"}
    ), S24(
            new String[]{"S22", "S23", "S25", "S26", "C4", "C5", "C6"}
    ), S25(
            new String[]{"S8", "S23", "S24", "S26", "L1"}
    ), S26(
            new String[]{"S8", "S24", "S25", "C3", "C4"}
    ), S27(
            new String[]{"S7", "C3", "C4"}
    ), C1(
            new String[]{"S2", "S3", "S6", "C2"}
    ), C2(
            new String[]{"C1", "S3", "S6", "S7", "S8", "S9"}
    ), C3(
            new String[]{"S7", "S8", "S26", "S27", "C4"}
    ), C4(
            new String[]{"C3", "C5", "S24", "S26", "S27"}
    ), C5(
            new String[]{"C4", "C6", "S24"}
    ), C6(
            new String[]{"C5", "S20", "S21", "S22", "S24"}
    ), L1(
            new String[]{"S8", "S9", "S10", "S23", "S25", "W1"}
    ), L2(
            new String[]{"S10", "S12", "S13", "S15", "S17", "W1"}

    ), W1(
            new String[]{"L1", "L2", "S10", "S17", "S18", "S19", "S20", "S22", "S23"}
    ), J1(
            new String[]{"S19", "S20", "S21"}
    ), D1(
            new String[]{"S1", "S2"}
    ), other(
            new String[]{""}
    );


    // 块
    DesertMapBlockEnum block;
    // block块的相邻块
    private Set<DesertMapBlockEnum> adjacentBlocks;

    /**
     * 构造函数
     * @param names
     */
    private BlockRelationEnum(String[] names) {
        try {
            this.block = DesertMapBlockEnum.valueOf(this.name());
        } catch (IllegalArgumentException e) {
            this.block = DesertMapBlockEnum.Other;
            this.adjacentBlocks = null;
            return;
        }
        this.adjacentBlocks = new HashSet<DesertMapBlockEnum>();
        DesertMapBlockEnum adjacentBlock;
        for (String name : names) {
            try {
                Log.i("BlockRelationEnum", "name = " + name);
                adjacentBlock = DesertMapBlockEnum.valueOf(name);
                if (adjacentBlock != null) {
                    Log.i("BlockRelationEnum", "adjacentBlock：" + adjacentBlock);
                    this.adjacentBlocks.add(adjacentBlock);
                } else {
                    Log.i("BlockRelationEnum", "adjacentBlock：" + adjacentBlock);
                    Log.i("BlockRelationEnum", "不应该出现的错误。");
                }
            } catch (IllegalArgumentException e) {
                Log.i("BlockRelationEnum", "相邻块还未实例化。");
                continue;
            }
        }
    }

    public DesertMapBlockEnum getBlock() {
        return block;
    }

    public Set<DesertMapBlockEnum> getAdjacentBlocks() {
        return adjacentBlocks;
    }

    public static void outputRelation() {
        for (BlockRelationEnum b : BlockRelationEnum.values()) {
            System.out.print("\n块" + b.name() + "，相邻块：");
            for (DesertMapBlockEnum adj : b.getAdjacentBlocks()) {
                System.out.print(adj.name() + "\t");
            }
        }
        System.out.println("\n");
    }

    /**
     * 通过打印关系矩阵，人工判断关系是否出错(比如S1和S2相邻，S2却和S1不相邻)。
     */
    public static void verifyRelation() {
        BlockRelationEnum[] relations = BlockRelationEnum.values();
        DesertMapBlockEnum[] blocks = DesertMapBlockEnum.values();
        Set<DesertMapBlockEnum> relationBlocks;
        int len = relations.length;
        int[][] matrix = new int[len][len];
        int i, j;
        for (i = 0; i < len; i++) {
            relationBlocks = relations[i].getAdjacentBlocks();
            for (j = 0; j < len; j++) {
                if (relationBlocks.contains(blocks[j])) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        boolean flag = true;
        for (i = 0; i < len && flag; i++) {
            for (j = 0; j < len; j++) {
                System.out.print(matrix[i][j]);
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("\nscary!!!");
                    System.out.println(blocks[i].name() + " no " + blocks[j].name());
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("\nok");
        }
    }


}
