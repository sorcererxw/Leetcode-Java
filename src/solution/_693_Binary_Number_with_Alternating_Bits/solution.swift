class Solution {
    func hasAlternatingBits(_ N: Int) -> Bool {
        var last = -1
        var n = N
        while n>0 {
          if last==n%2 {
            return false
          }
          last = n%2
          n/=2
        }
        return true
    }
}