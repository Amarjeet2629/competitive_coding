package org.cp.LLD.test;

import java.util.List;

public class Main {
    public static User change(User a){
        a.getPostIds().add("3456");

        return null;
    }

    public static void main(String ...args){
        User user = new User();
        change(user);
        List<String> arr = user.getPostIds();

        arr.add("123");

        for(String res: user.getPostIds()){
            System.out.print(res + ", ");
        }
    }
}
