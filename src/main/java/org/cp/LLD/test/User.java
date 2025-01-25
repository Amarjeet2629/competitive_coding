package org.cp.LLD.test;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<String> postIds;

    public User(){
        this.postIds = new ArrayList<>();
    }

    public List<String> getPostIds(){
        return postIds;
    }
}
