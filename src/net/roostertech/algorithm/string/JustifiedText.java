package net.roostertech.algorithm.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pnguyen on 11/29/17.
 https://www.interviewbit.com/problems/justified-text/
 */
public class JustifiedText {

    private String makeJustifiedline(ArrayList<String> words, int start, int end, int inProgressLength, int lineLength) {
        StringBuilder sb = new StringBuilder();
        int wordCount = end - start;
        int extraSpace = lineLength - inProgressLength;
        int extraSpacePerWord = wordCount == 1? 0 : (lineLength - inProgressLength)  / (wordCount - 1);
        int leftOver =  extraSpace - (extraSpacePerWord * (wordCount - 1));

        for (int j = start; j < end; j++) {
            sb.append(words.get(j));
            if (j == end - 1) {
                break;
            }
            for (int k = 0; k < extraSpacePerWord + 1 + (leftOver > 0? 1 : 0); k++) {
                sb.append(" ");
            }
            leftOver--;
        }
        for (int i = 0; i < leftOver; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }


    public ArrayList<String> fullJustify(ArrayList<String> words, int lineLength) {
//        System.out.println(words);
        ArrayList<String> lines =  new ArrayList<>();
        if (words.size() == 0) {
            return lines;
        }

        int start = 0;
        int lineInProgress = 0;

        for (int i = 0; i < words.size(); i++) {
            if (lineInProgress + words.get(i).length() > lineLength) {
                // subtract back out no white space at the end of last word
                lines.add(makeJustifiedline(words, start, i, lineInProgress - 1, lineLength));
                lineInProgress = 0;
                start = i;
            }
            lineInProgress += words.get(i).length() + 1;
        }

        // last line of text does not need padding in the middle
        StringBuilder sb = new StringBuilder();
        lineInProgress = 0;
        for (int j = start; j < words.size(); j++) {
            sb.append(words.get(j));
            lineInProgress += words.get(j).length();
            if (j == words.size() - 1) {
                break;
            }
            sb.append(" ");
            lineInProgress ++;
        }
        for (int i = 0; i < lineLength - lineInProgress; i++) {
            sb.append(" ");

        }
        lines.add(sb.toString());


        for (String line: lines) {
            System.out.println(line.length() + "-" + line + "-");
        }

        return lines;
    }

    @Test
    public void testTexFormat() {
        fullJustify(new ArrayList<>(Arrays.asList("The fox jump over the lazy brown cat".split(" "))), 10);
        fullJustify(new ArrayList<>(Arrays.asList("The fox jump over the lazy brown cat".split(" "))), 20);
//        fullJustify(new ArrayList<>(Arrays.asList("".split(" "))), 10);
        fullJustify(new ArrayList<>(), 10);

        fullJustify(new ArrayList<>(Arrays.asList("avtngldh", "whzqtnup", "unlmd", "donvganmjs", "lwwthymm", "tszixdap", "ocwwhhcino", "ccuejh", "qfacux", "a", "cep", "polvxet", "hyllx", "sfpc", "ga", "rxjxjlw", "dmaye", "ixdaas", "xutq", "vp", "xect", "xzlb", "tbclmdsrzl", "gfvku", "hvyavrpiu", "txd", "h", "ra", "ogruyvzknv", "hz", "imuft", "ardoyzgykd", "mnee", "ayceoj", "w", "wyoukkgv", "eqfbpzlkgl", "gpznhxncaf", "sngvcy", "gbg", "w", "ts", "j", "lepajgzfk", "kp", "joszb", "agpvxz", "jlzz", "fo", "vyhbzhxhx", "ouglmjc", "nvjwcpuvf", "ldhscmkpo", "sc", "fbxwcm", "wrwkwydzk", "z", "vf", "hmxwl", "al", "qv", "u", "zy", "wkm", "mtzrau", "mi", "ci", "bv", "xlhjyclpeq", "r", "hhroboeje", "nfcplkxhwe")),
                76);

        fullJustify(new ArrayList<>(Arrays.asList("am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy")),
            14);
        fullJustify(new ArrayList<>(Arrays.asList("What", "must", "be", "shall", "be.")), 12);
    }
}
//The fox jump over ##
//the lazy brown cat ##