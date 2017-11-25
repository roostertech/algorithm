package net.roostertech.algorithm.string;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pnguyen on 11/24/17.
 */
public class Multiply {
    public static String multiply(String a, String b) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - (int) '0';
            for (int j = b.length() - 1; j >= 0; j--) {
                int digitB = b.charAt(j) - (int) '0';
                int mult = digitA * digitB;
                int resIndex = a.length() - i - 1 + b.length() - j - 1;
                int remainder = mult % 10;

                while (true) {
//                    System.out.println("a " + digitA + " b " + digitB + " mult " + mult + " remainder " + remainder + " resIndex " + resIndex);
                    if (resIndex + 1 > result.size()) {
                        result.add(remainder);
//                        System.out.println("add  " + result);

                    } else {
                        mult += result.get(resIndex);
                        remainder = mult % 10;
                        result.set(resIndex, remainder);
//                        System.out.println("set  " + result);

                    }
                    if (mult < 10) {
                        break;
                    }
                    resIndex++;
                    mult /= 10;
                    remainder = mult % 10;
                }
            }
        }

        boolean allZero = true;
        StringBuilder sb = new StringBuilder();
        // trim leading zero
        while (result.size() > 0) {
            if (result.get(result.size() - 1) == 0) {
                result.remove(result.size() - 1);
            } else {
                break;
            }
        }
        for (int i = result.size() -1 ; i >= 0; i--) {
            if (result.get(i) != 0) {
                allZero = false;
            }
            sb.append(result.get(i));
        }
        if (allZero) {
            return "0";
        }
        return sb.toString();
    }

    @Test
    public void testMutiply() {
        //290851027081985078955918627261751688832742312387314888842460711865148550965912482730570750031304678344564428861596637320
        Assert.assertEquals("35", multiply("7", "5"));
        Assert.assertEquals("35", multiply("007", "00005"));

        Assert.assertEquals("290851027081985078955918627261751688832742312387314888842460711865148550965912482730570750031304678344564428861596637320",
        multiply("5131848155574784703269632922904933776792735241197982102373370", "56675688419586288442134264892419611145485574406534291250836"));

        Assert.assertEquals("129281419508942330644788914772375911909165364374172850648846234013189757981044692486872392891670352883617068289942863624",
                multiply("6020453667958309279424408570378228292268488402", "0021473700594524297017810575200827941459805716642468749607585313713214621412"));
    }
}
