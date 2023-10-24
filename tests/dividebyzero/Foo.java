import org.checkerframework.checker.dividebyzero.qual.*;

// A simple tempcase for your divide-by-zero checker.
// The file contains "// ::" comments to indicate expected
// errors and warnings.
//
// Passing this tempdoes not guarantee a perfect grade on this assignment,
// but it is an important start. You should always write your own tempcases,
// in addition to using those provided to you.
class Foo {

    public static void f() {
        int one  = 1;
        int zero = 0;
        // :: error: divide.by.zero
        int x    = one / zero;
        int y    = zero / one;
        // :: error: divide.by.zero
        int z    = x / y;
        String s = "hello";
    }

    public static void g(int y) {
        if (y == 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y != 0) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y == 0)) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y != 0)) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y < 0) {
            int x = 1 / y;
        }

        if (y <= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (y > 0) {
            int x = 1 / y;
        }

        if (y >= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }
    }

    public static void h() {
        int zero_the_hard_way = 0 + 0 - 0 * 0;
        // :: error: divide.by.zero
        int x = 1 / zero_the_hard_way;

        int one_the_hard_way = 0 * 1 + 1;
        int y = 1 / one_the_hard_way;
    }

    public static void l() {
        // :: error: divide.by.zero
        int a = 1 / (1 - 1);
        int y = 1;
        // :: error: divide.by.zero
        int x = 1 / (y - y);
        int z = y-y;
        // :: error: divide.by.zero
        int k = 1/z;
    }

    public static void testOperators() { 
        int x = 1;
        x--;
        x--;

        int y = -1;
        y++;
        y++;

        int z = 1;
        z--;

        // x is non-zero, but x should be top at this point. So, temprefiners. 
        if(x != 0){
            int temp = 1 / x;
        }
        if (x < 0){
            int temp = 1 / x;
        }
        if(x <= -1){
            int temp = 1 / x;
        }
        if (x == -1){
            int temp = 1 / x;
        }

        if(y != 0){
            int temp = 1 / y;
        }
        if (y > 0){
            int temp = 1 / y;
        }
        if(y >= 1){
            int temp = 1 / y;
        }
        if (y == 1){
            int temp = 1 / y;
        }

        if (y == 1){
            int temp = 1 / y;
        }

        if (z == 0){
            // :: error: divide.by.zero
            int temp = 1 / z;
        }
    }

    public static void testPlus() {
        int positive = 1;
        int negative = -1;
        int zero = 0;

        int temp = 1 / (positive + zero);
        temp = 1/ (zero + positive);
        temp = 1/(zero + negative);
        temp = 1/ (negative + zero);
        temp = 1 / (positive + positive);
        temp = 1 / (negative + negative);

        // :: error: divide.by.zero
        temp = 1 / (zero + zero);

        // :: error: divide.by.zero
        temp = 1 / (negative + positive);

        // :: error: divide.by.zero
        temp = 1/ (positive + negative);
    }

    public static void testMinus() { 
        int positive = 1;
        int negative = -1;
        int zero = 0;

        int temp = 1 / (positive - zero);
        temp = 1/ (zero - positive);
        temp = 1/(zero - negative);
        temp = 1/ (negative - zero);

        // :: error: divide.by.zero
        temp = 1 / (positive - positive);
        // :: error: divide.by.zero
        temp = 1 / (negative - negative);

        // :: error: divide.by.zero
        temp = 1 / (zero - zero);
        temp = 1/ (negative - positive);
        temp = 1 / (positive - negative);
    }

    public static void testTimes() { 
        int positive = 1;
        int negative = -1;
        int zero = 0;


        // :: error: divide.by.zero
        int temp = 1 / (positive * zero);
        // :: error: divide.by.zero
        temp = 1/ (zero * positive);
        // :: error: divide.by.zero
        temp = 1/(zero * negative);
        // :: error: divide.by.zero
        temp = 1/ (negative * zero);
        temp = 1 / (positive * positive);
        temp = 1 / (negative * negative);

        // :: error: divide.by.zero
        temp = 1 / (zero * zero);
        temp = 1/ (negative * positive);
        temp = 1 / (positive * negative);
    }

    public static void testDivide() { 
        int positive = 1;
        int negative = -1;
        int zero = 0;


        // :: error: divide.by.zero
        int temp = 1 / (positive / zero);
        // :: error: divide.by.zero
        temp = 1/ (zero / positive);
        // :: error: divide.by.zero
        temp = 1/ (zero / negative);
        // :: error: divide.by.zero
        temp = 1/ (negative / zero);
        temp = 1 / (positive / positive);
        temp = 1 / (negative / negative);

        // :: error: divide.by.zero
        temp = 1 / (zero / zero);

        
        temp = 1/ (negative / positive);
        temp = 1 / (positive / negative);
    }

    public static void testMod() { 
        int positive = 1;
        int negative = -1;
        int zero = 0;


        // :: error: divide.by.zero
        int temp = 1 / (positive % zero);
        // :: error: divide.by.zero
        temp = 1/ (zero % positive);
        // :: error: divide.by.zero
        temp = 1/ (zero % negative);
        // :: error: divide.by.zero
        temp = 1/ (negative % zero);
        temp = 1 / (positive % positive);
        temp = 1 / (negative % negative);

        // :: error: divide.by.zero
        temp = 1 / (zero % zero);
        temp = 1/ (negative % positive);
        temp = 1 / (positive % negative);
    }
}
