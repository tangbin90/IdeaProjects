package net.tangbin;

/**
 * Created by TangBin on 22/12/2016.
 */
import java.util.*;
import java.sql.*;
import java.util.Date;

public class Picture {
    public static int PAGE_SIZE = 3;
    private String path;
    private Date storetime;
    private String owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getStoretime() {
        return storetime;
    }

    public void setStoretime(Date storetime) {
        this.storetime = storetime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
