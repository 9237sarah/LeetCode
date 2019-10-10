// https://leetcode.com/problems/insert-interval/

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        res.add(newInterval);
        if (intervals == null) {
            return res;
        }
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                res.add(res.size() - 1, interval);
            } else if (interval.start > newInterval.end) {
                res.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        return res;
    }
}