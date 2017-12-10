package net.roostertech.algorithm.hashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pnguyen on 12/8/17.
 */
public class ValidSudoku {
    public int isValidSudoku(final List<String> a) {
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] columns = new Set[9];
        Set<Integer>[] boxes = new Set[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!Character.isDigit(c)) {
                    continue;
                }

                int num = c - '0';
                if (num == 0) {
                    return 0;
                }

                int boxIndex = (i - i %3) + j / 3;

//                System.out.println(num + " - > "+ i+ " " + j + " Box" + boxIndex);
                if (rows[i].contains(num) || columns[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return 0;
                }

                rows[i].add(num);
                columns[j].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return 1;
    }

    @Test
    public void testValidSudoku() {
        System.out.println(isValidSudoku(Arrays.asList(
                "....5..1.",
                ".4.3.....",
                ".....3..1",
                "8......2.",
                "..2.7....",
                ".15......",
                ".....2...",
                ".2.9.....",
                "..4......")));
    }
}
