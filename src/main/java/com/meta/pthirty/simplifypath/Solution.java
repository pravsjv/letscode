package com.meta.pthirty.simplifypath;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String absPath){
        // edge case
        if(absPath == null || absPath.isEmpty())
            throw new IllegalArgumentException("Empty input.");

        Deque<String> stack = new ArrayDeque();
        for(String dir : absPath.split("/")){
            if("..".equals(dir)){
                if(stack.isEmpty())
                    stack.poll();
            } else if(!dir.isEmpty() && !".".equals(dir)){
                stack.push(dir);
            }
        }

        if(stack.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.pollLast());
        }

        return sb.toString();
    }
}
