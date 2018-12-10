/**
 * Created by Sorcerer on 2016/1/3 0003.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class _292_Nim_Game {
    public static void main(String[] args) {

    }

    /*
    1 +
    2 +
    3 +
    4 -
    5 +
    6 +
    7 +
    8 -
    9 +
    10 +
     */

    public static boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}
