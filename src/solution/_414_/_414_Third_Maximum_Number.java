package solution._414_;

/**
 * Author: Sorcerer
 * Date: 2018/4/29
 * Description:
 */
public class _414_Third_Maximum_Number {

    private int MAX_SIZE = 3;

    private int[] mList;

    private int mSize = 0;

    private void push(int a) {
        if(isContain(a)){
            return;
        }
        if (mSize < MAX_SIZE) {
            mList[mSize++] = a;
            return;
        }
        int minIndex = minIndex();
        if (mList[minIndex] < a) {
            mList[minIndex] = a;
        }
    }

    private boolean isContain(int a){
        for(int i=0;i<mSize;i++){
            if(mList[i]==a)return true;
        }
        return false;
    }

    private int minIndex() {
        if (mSize == 0) {
            return 0;
        }
        int min = mList[0];
        int idx = 0;
        for (int i = 1; i < mSize; i++) {
            if (mList[i] < min) {
                min = mList[i];
                idx = i;
            }
        }
        return idx;
    }

    private int maxIndex() {
        if (mSize == 0) {
            return 0;
        }
        int max = mList[0];
        int idx = 0;
        for (int i = 1; i < mSize; i++) {
            if (mList[i] > max) {
                max = mList[i];
                idx = i;
            }
        }
        return idx;
    }

    private int max() {
        if (mSize == 0) {
            return 0;
        }
        return mList[maxIndex()];
    }

    private int min() {
        if (mSize == 0) {
            return 0;
        }
        return mList[minIndex()];
    }

    @SuppressWarnings("WeakerAccess")
    public int thirdMax(int[] nums) {
        mList = new int[MAX_SIZE];
        mSize = 0;
        for (int num : nums) {
            push(num);
        }
        if (mSize < MAX_SIZE) {
            return max();
        }
        return min();
    }

    public static void main(String[] args) {
        _414_Third_Maximum_Number solution = new _414_Third_Maximum_Number();
        System.out.println(
                solution.thirdMax(new int[]{1, 2,2,3})
        );
    }
}
