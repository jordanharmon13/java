/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorda
 */
class HardCodedPasswordHandler {
    public List getAllUsers() {
        List<User> userList = new ArrayList();
        userList.add(new User("Jordan", "jordan")); 
        userList.add(new User("David", "david")); 
        userList.add(new User("Dave", "dave")); 
        userList.add(new User("Deann", "deann")); 
        return userList;
    }
}
