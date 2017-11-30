package net.roostertech.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by pnguyen on 11/29/17.
 https://www.interviewbit.com/problems/merge-intervals/
 */


public class MergeInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private void merge(Interval old, Interval insert) {
        if (old.start< insert.start) {
            insert.start = old.start;
        }

        if (old.end > insert.end) {
            insert.end = old.end;
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result;

        // swap if needed
        if (newInterval.end < newInterval.start) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }

        Iterator<Interval> itor = intervals.iterator();
        int index = 0;
        int insertIndex = -1;
        while (itor.hasNext()) {
            Interval interval = itor.next();

            // if new interval to the left
            if (newInterval.end < interval.start) {
                if (insertIndex == -1) {
                    insertIndex = index;
                }
            //touch on left edge
            } else if (newInterval.end >= interval.start && newInterval.start <= interval.start) {
                merge(interval, newInterval);
                itor.remove();
                if (insertIndex == -1) {
                    insertIndex = index;
                }

            // touch on right edge
            } else if (newInterval.start <= interval.end && newInterval.end >= interval.end) {
                merge(interval, newInterval);
                itor.remove();
                if (insertIndex == -1) {
                    insertIndex = index;
                }
            } else {
                // on the right, do nothing
            }
            index++;
        }
        if (insertIndex != -1) {
            intervals.add(insertIndex, newInterval);
        } else {
            intervals.add(newInterval);
        }

        return intervals;
    }

    @Test
    public void testInsert() {
        insert(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(5, 6))), new Interval(10, 8));
    }
}
