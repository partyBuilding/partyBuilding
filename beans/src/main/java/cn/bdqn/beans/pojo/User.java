package cn.bdqn.beans.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int partyBranchId;
}
