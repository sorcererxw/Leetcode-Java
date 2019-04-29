function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number[]} G
 * @return {number}
 */
const numComponents = function (head, G) {
    const set = new Set();
    for (let g of G) set.add(g);
    let node = head;
    let flag = false;
    let count = 0;
    while (node != null) {
        if (set.has(node.val)) {
            if (flag === false) {
                flag = true;
                count++
            }
        } else {
            if (flag === true) {
                flag = false;
            }
        }
        node=node.next
    }
    return count;
};