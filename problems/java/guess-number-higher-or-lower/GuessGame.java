package solution._374_Guess_Number_Higher_or_Lower;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description:
 */
class GuessGame {
    private int answer = 6;

    int guess(int num) {
        if (num > answer) {
            return -1;
        } else if (num < answer) {
            return 1;
        } else {
            return 0;
        }
    }
}
