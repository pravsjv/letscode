package com.meta.pthirty.simplifypath;

import java.util.ArrayDeque;
import java.util.Deque;

public class Variant1 {

    public String simplifiedPath(String cwd, String absPath){
        // edge case
        if(absPath == null && cwd == null)
            throw new IllegalArgumentException("Empty input.");

        if(absPath == null || absPath.isEmpty())
            return cwd;

        // if cwd is not empty, append cwd to absPath in the beginning
        String path = cwd != null && !cwd.isEmpty() ? cwd+absPath : absPath;

        Deque<String> stack = new ArrayDeque<>();
        for(String dir : path.split("/")){
            if("..".equals(dir)){
                if(!stack.isEmpty())
                    stack.pop();
            } else if(!dir.isEmpty() && !".".equals(dir)){
                stack.push(dir);
            }
        }

        if(stack.isEmpty())
            return "/";

        StringBuilder simplifiedPath = new StringBuilder();
        while(!stack.isEmpty()){
            simplifiedPath.append("/").append(stack.pollLast());
        }

        return simplifiedPath.toString();
    }
}
