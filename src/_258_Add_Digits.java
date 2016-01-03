/**
 * Created by Sorcerer on 2016/1/3 0003.
 */
public class _258_Add_Digits {
    public static void main(String[] args) {

    }

    /*
    1 1
    2 2
    3 3
    4 4
    5 5
    6 6
    7 7
    8 8
    9 9

    10 1
    11 2
    12 3
    .
    .
    .
    18 9

    19 1
    20 2
     */
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
