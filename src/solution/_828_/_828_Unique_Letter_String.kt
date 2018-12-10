package solution._828_

/**
 * @author: SorcererXW
 * @date: 2018/5/14
 * @description:
 */
class Solution {
    private lateinit var map: HashMap<String, Int>
    private val mod: Int = 1000000000 + 7
    private fun cal(s: String) {
        for (i: Int in 0 until s.length) {
            for (j: Int in i + 1..s.length) {
                val substring = s.substring(i, j)
                if (map[substring] == null) {
                    map[substring] = 1
                } else {
                    map[substring] = map[substring]!! + 1
                }
            }
        }
    }

    private fun uniq(s: String): Int {
        val hash = IntArray(500, { 0 })
        var cnt = 0
        for (i in 0 until s.length) {
            hash[s[i].toInt()]++
            if (hash[s[i].toInt()] == 1) {
                cnt++
            } else if(hash[s[i].toInt()] == 2) {
                cnt--
            }
        }
        return cnt
    }

    fun uniqueLetterString(S: String): Int {
        map = HashMap()
        cal(S)
        var res = 0
        map.forEach({
//            println("${it.key}: ${uniq(it.key)} * ${it.value}")
            res += (uniq(it.key) * it.value)
            res %= mod
        })
        return res
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.uniqueLetterString("PNJBRGRPQSLSXPQBQKGGTUSHTKLLXHGXZBDMHNBZXKWZXTAANMHTOIRXHEYANOPLBVJROVZUDZNMETKKXRDMRHVMLDBHQTRIYGQFMBTZPPXGCLRJJYWHZZURDNTKWPNHLEJHFPPVQJAGSZCNUDMZWWCYUAQZGTUDMPJKLUQOSESLYGYWZKIXJQGHSOCVJQIGVXWQLOYUGFHCJSCJGHQMIGLGYAZWELSHZAPAEZQGMCMRMFRFZTTDGQUIZYDUCBVXZZUIDDCNWUAAPDUNZLBAGNIFNDBJYALQQGBRAMHBIVVERVXRTCSZSZWIGRLWZMUTEYSWZAGUDTPVLRJMOBUHOZBGHKHVOXAWCXMJNAZLQLKQQQNOCLUFGKOVBOKVKOEZEKNWHCFGCENVAABLPVTCEJVZNDTZNCRELHEDWLWIQGDBDGCTGUBZCZGTOVUFNCICJLWSMFDCRQEAGHUEVYEXQDHFFIKVECUAZRELOFJMYJJZNNJDKIMBKLRHSJUSBSTQHVLEJTJCCZQNZBVYFZXGAUDYOSCKYSMMINOANJMBAFHTNBRRZQAGLLWXLXMJANYFELMWRUFTLZUUHBSJEXOOBJKMYMLITIWJTDXSCOTZVZNVIXPDHNSXSODIEATIPIAODGCMDGYVZRJRVFCCMECCHXTIRAIQIJOWZWNRVRKOSIMQSDYRSCBONPPJTEYOEBNUOMRBIFRBQBTECLFQZTBBYROOMREHVFWTRVCODLLGJCTGUXEICJOUDMXBEVZRVRAVKIDNRICWSBNXMXVDCKZAHMQZBRLQUGTMJVOQBXARMLGJEQCORHNODVNOQFOMDPKRCOQOUDCPEOCHKHNHDGHBBYJIIYRVPKVSDYDIWOWCTGDZEHQAFDSZHJKTAYAYQCFVNAJQUQUQGFTPTRYAMLLXNSYSISFBEFNTDJWHZBWRVKRIHQXUOFBHRJKRIGJLDKRMUJQWAJGUFKSQEKMFAIJZSJIOTMCIVROAOEQPOIUD"))
}
