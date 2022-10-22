package C1_C100;

import java.util.ArrayList;
import java.util.List;

public class C54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0, j = 0, d = 0, k = 0; k < n * m; k++){
            res.add(matrix[i][j]);
            matrix[i][j] = 101;
            int a = i + dx[d], b = j + dy[d];
            if(a < 0 || a >= n || b < 0 || b >= m || matrix[a][b] == 101){
                d = (d + 1) % 4;
                a = i + dx[d]; b = j + dy[d];
            }
            i = a; j = b;
        }
        return res;
    }
}
