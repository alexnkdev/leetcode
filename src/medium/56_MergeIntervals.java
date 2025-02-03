class Solution {
    static int START = 0;
    static int END = 1;

    public int[][] merge(int[][] intervals) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            points.add(new Point(intervals[i][0], START));
            points.add(new Point(intervals[i][1], END));
        }
        Collections.sort(points, new Comparator<>() {
            public int compare(Point p1, Point p2) {
                if (p1.i < p2.i) {
                    return -1;
                }
                if (p1.i > p2.i) {
                    return 1;
                }
                if (p1.type == START && p2.type == END) {
                    return -1;
                }
                if (p2.type == START && p1.type == END) {
                    return 1;
                }
                return 0;
            }
        });
        int in_interval = 0;
        Point intervalStart = null;
        List<List<Integer>> ret = new ArrayList<>();
        for (Point p : points) {
            if (p.type == START) {
                in_interval++;
                if (in_interval == 1) {
                    intervalStart = p;
                }
            } else if (p.type == END) {
                in_interval--;
                if (in_interval == 0) {
                    ret.add(Arrays.asList(intervalStart.i, p.i));
                }
            }
        }
        int[][] retArr = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = new int[2];
            retArr[i][0] = ret.get(i).get(0);
            retArr[i][1] = ret.get(i).get(1);
        }
        return retArr;
    }

    static class Point {
        int i;
        int type;
        public Point(int i, int type) {
            this.i = i;
            this.type = type;
        }
    }
}