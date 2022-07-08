package leetcode535TinyURL的加密与解密;

import java.util.HashMap;
import java.util.Map;

public class leetcode535 {
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

class Codec {
    private Map<Integer, String> map = new HashMap<Integer, String>();
    private int id;

    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return map.get(key);
    }
}