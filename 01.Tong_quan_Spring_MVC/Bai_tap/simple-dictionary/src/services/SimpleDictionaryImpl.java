package services;

import models.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleDictionaryImpl implements SimpleDictionary {
    private static Map<Integer,Dictionary> dictionary=new HashMap<>();
    static {
        dictionary.put(1,new Dictionary("greeting","chao hoi"));
        dictionary.put(2,new Dictionary("bicycle","xe dap"));
        dictionary.put(3,new Dictionary("computer","may tinh"));
        dictionary.put(4,new Dictionary("technology","cong nghe"));
        dictionary.put(5,new Dictionary("information","thong tin"));
        dictionary.put(6,new Dictionary("keyboard","ban phim"));
        dictionary.put(7,new Dictionary("screen  ","man hinh"));
        dictionary.put(8,new Dictionary("setup","cai dat"));
        dictionary.put(9,new Dictionary("position","vi tri"));
        dictionary.put(10,new Dictionary("style","phong cach"));
    }

    @Override
    public List<Dictionary> getAllList() {
        return new ArrayList<>(dictionary.values());
    }
}
