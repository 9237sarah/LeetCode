// https://leetcode.com/problems/merge-intervals/

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for (int i = 0; i < intervals.size();) {
            int j = i + 1;
            while (j < intervals.size() && intervals.get(j).start <= intervals.get(i).end) {
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j++).end);
            }
            res.add(intervals.get(i));
            i = j;
        }
        return res;
    }
}