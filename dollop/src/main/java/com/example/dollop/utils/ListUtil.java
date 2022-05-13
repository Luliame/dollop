package com.example.dollop.utils;

import java.util.List;

public class ListUtil {
    public static float Average(List<Integer> values){
        int res = 0;
        
        if (values.size() == 0)
            return res;

        for (int v : values) {
            res += v;
        }

        return res/values.size();
    }
}
