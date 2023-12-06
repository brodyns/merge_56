import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = (new Solution()).merge(ints);
    }
}

class Solution{
    public int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (int[] x, int[] y)->Integer.compare(x[0], y[0]));
        int start = intervals[0][0];
        int rightBound = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > rightBound){
                res.add(new int[]{start, rightBound});
                start = intervals[i][0];
                rightBound = intervals[i][1];
            }else{
                rightBound = Math.max(rightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightBound});
        return res.toArray(new int[][]{});
    }
}
