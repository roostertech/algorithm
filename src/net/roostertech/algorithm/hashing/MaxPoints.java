package net.roostertech.algorithm.hashing;

import org.junit.Test;

import java.util.*;

/**
 * Created by pnguyen on 12/3/17.
 */
public class MaxPoints {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;                                 // 32 bits » 32-bit
            result = 31 * result + y;                                 // 32 bits » 32-bit
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Point)) {
                return false;
            }

            Point typed = (Point) other;
            return x == typed.x && y == typed.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // wrong problem intepretation
    public int maxPointsWrongWay(ArrayList<Integer> a, ArrayList<Integer> b) {
        // assume and and b has same size
        HashMap<Point, Boolean> pointMap = new HashMap<>();
        HashSet<Point> pointSet = new HashSet<>();
        HashSet<Integer> xSet = new HashSet<>();
        HashSet<Integer> ySet = new HashSet<>();


        int highestX = 0;
        int highestY = 0;

        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);
            int y = b.get(i);
            if (x > highestX) {
                highestX = x;
            }
            if (y > highestY) {
                highestY = y;
            }
            xSet.add(x);
            ySet.add(y);

            pointSet.add(new Point(x, y));
        }

        ArrayList<Integer> sortedX = new ArrayList<>(xSet);
        ArrayList<Integer> sortedY = new ArrayList<>(ySet);

        Collections.sort(sortedX);
        Collections.sort(sortedY);

        int max = 0;

//        System.out.println(sortedX);
//        System.out.println(sortedY);
//        System.out.println(pointSet);

        // Scan all the rows;
        for (int row: sortedY) {
            int lastColumn = -1;
            int currLen = 0;
            for (int column: sortedX) {
                if (pointSet.contains(new Point(column, row))) {
                    if (lastColumn >= 0 && column == lastColumn + 1) {
                        lastColumn = column;
                        currLen ++;
                    } else {
                        // new line
                        if (currLen > max) {
                            max = currLen;
                        }

                        lastColumn = column;
                        currLen = 1;
                    }

                    // scan for diags
                    int diagLen = 1;
                    int diagX = column + 1;
                    int diagY = row + 1;
                    while (pointSet.contains(new Point(diagX, diagY))) {
                        diagX++;
                        diagY++;
                        diagLen++;
                    }

                    if (diagLen > max) {
                        max = diagLen;
                    }
                }
            }

            if (currLen > max) {
                max = currLen;
            }
        }

        // all the columns
        for (int column: sortedX) {
            int lastRow = -1;
            int currLen = 0;
            for (int row: sortedY) {
                if (pointSet.contains(new Point(column, row))) {
                    if (lastRow >= 0 && row == lastRow + 1) {
                        lastRow = row;
                        currLen ++;
                    } else {
                        // new line
                        if (currLen > max) {
                            max = currLen;
                        }

                        lastRow = row;
                        currLen = 1;
                    }
                }
            }

            if (currLen > max) {
                max = currLen;
            }
        }


        System.out.println(max);
        return max;
    }


    // has the same slope, on the same line
    // point at the same spot is counted as on the same line
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() == 0) {
            return 0;
        };
        if (a.size() != b.size()) {
            return 0;
        }

        int max = 0;
        // iterate to each point, use at as the origin and scan for
        for (int i = 0; i < a.size(); i++) {
            int duplicate = 1;
            int vertical = 0;
            int horizontal = 0;
            int startX = a.get(i);
            int startY = b.get(i);
            HashMap<Double, Integer> slopes = new HashMap<>();

            // only need to scan for lines going back to previous point, they are already accounted
            for (int j = i + 1; j < a.size(); j++) {
                int pointX = a.get(j);
                int pointY = b.get(j);
                if (startX == pointX) {
                    if (startY == pointY) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else if (startY == pointY) {
                    horizontal++;
                } else {
                    double slope, deltaX, deltaY;
                    if (pointX > startX) {
                        deltaX = pointX - startX;
                        deltaY = pointY - startY;
                    } else {
                        deltaX = startX - pointX;
                        deltaY = startY - pointY;
                    }

                    slope = deltaY / deltaX;
                    System.out.println("(" + startX + ","+startY+")"+"(" + pointX + ","+pointY+") " + slope);
                    if (slopes.containsKey(slope)) {
                        slopes.put(slope, slopes.get(slope) + 1);
                    } else {
                        slopes.put(slope, 1);
                    }
                }
            }

            System.out.println("dup " + duplicate + " v " + vertical + " h " + horizontal);

            System.out.println(slopes);

            if (duplicate + vertical > max) {
                max = duplicate + vertical;
            }

            if (duplicate + horizontal > max) {
                max = duplicate + horizontal;
            }

            for (int val: slopes.values()) {
                if (duplicate + val > max) {
                    max = duplicate + val;
                }
            }
        }

        System.out.println(max);
        return max;
    };

    @Test
    public void testMaxPoints() {
        maxPoints(new ArrayList<Integer>(Arrays.asList(15, 1, -8,  3, -14,   -7, -2, -11, -18,  9,   7,   1,  9, 6)),
                  new ArrayList<Integer>(Arrays.asList(8, -7, -4, -2, -14,  -17, -10, 11,   2, -4, -15, -16, 16, 1))
        );

//        maxPoints(new ArrayList<Integer>(Arrays.asList(1,2,3)),
//                new ArrayList<Integer>(Arrays.asList(1,2,3))
//        );
//
//        // line at column 0
//        maxPoints(new ArrayList<Integer>(Arrays.asList(0,0,0)),
//                  new ArrayList<Integer>(Arrays.asList(1,2,3))
//        );

//        // line at column 0
//        maxPoints(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0)),
//                  new ArrayList<Integer>(Arrays.asList(0,1,4,5,6,9,10))
//        );
    }
}
