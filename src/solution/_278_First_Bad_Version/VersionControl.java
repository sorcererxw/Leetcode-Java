package solution._278_First_Bad_Version;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description:
 */
class VersionControl {
    private int version = 4;

    boolean isBadVersion(int v) {
        return v >= version;
    }
}
