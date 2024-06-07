package org.hmk.largest_square_formed_in_a_matrix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Solution.maxSquare(2, 2, new int[][]{
//                {1, 1},
//                {1, 1}
//        }));
//        System.out.println(Solution.maxSquare(2, 2, new int[][]{
//                {0, 0},
//                {0, 0}
//        }));
        Result res = buildInput("/Users/huomingkun/Downloads/fileInput (1).txt");
        System.out.println(Solution.maxSquare(res.m, res.n, res.mat));
    }

    private static Result buildInput(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            Result res = new Result();
            String[] ss = lines.get(0).split(" ");
            res.m = Integer.parseInt(ss[0]);
            res.n = Integer.parseInt(ss[1]);

            res.mat = new int[res.m][res.n];
            for (int i = 0; i < res.m; ++i) {
                String[] tmp = lines.get(i + 1).split(" ");
                for (int j = 0; j < res.n; ++j) {
                    res.mat[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            return res;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

class Result {
    int n;
    int m;
    int[][] mat;
}
