package com.study.kokhrimenko.algoriths.array.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
	public static void main(String[] args) {
		List<Interval> inputInterval = new ArrayList<>();
		
		MergeInterval executor = new MergeInterval();
		inputInterval.add(new Interval(1, 3));
		inputInterval.add(new Interval(8, 10));
		inputInterval.add(new Interval(2, 6));		
		inputInterval.add(new Interval(15, 18));
		
		System.out.println(executor.merge(inputInterval));
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		Comparator<Interval> comp = Comparator.comparing((Interval i) -> i.start);
		Collections.sort(intervals, comp);
		Interval temp = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (temp.end >= curr.start) {
				temp.end = Math.max(curr.end, temp.end);
			} else {
				result.add(temp);
				temp = curr;
			}
		}
		result.add(temp);
		return result;
	}

	public static final class Interval {
		private int start;
		private int end;
		
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}		
	}
}
