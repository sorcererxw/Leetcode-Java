import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _811_Subdomain_Visit_Count {
    static class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<>();
            for (String cpdomain : cpdomains) {
                String[] split = cpdomain.split(" ");
                int cnt = Integer.valueOf(split[0]);
                String[] sub = split[1].split("\\.");
                String domain = "";
                for (int i = sub.length - 1; i >= 0; i--) {
                    if (domain.length() == 0) {
                        domain = sub[i];
                    } else {
                        domain = sub[i] + "." + domain;
                    }
                    if (map.containsKey(domain)) {
                        map.put(domain, map.get(domain) + cnt);
                    } else {
                        map.put(domain, cnt);
                    }
                }
            }
            return map.entrySet().stream()
                    .map(entry -> entry.getValue() + " " + entry.getKey())
                    .collect(Collectors.toList());
        }
    }

    public static void main(String... args) {
        System.out.println(new Solution().subdomainVisits(
                new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}
        ));
    }
}
