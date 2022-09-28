package org.proxy;

import java.util.Set;

public class ProxyMain {
    public static void main(String[] args) {
        DBConnection connection = new ProxyMysql();
        connection.dbConnect("Sully");
        connection.dbConnect("Reese");
    }
}

abstract class DBConnection {
    Set<String> users;
    protected abstract void connect();

    protected void dbConnect(String user) {
        if(users.contains(user))
            this.connect();
        else
            System.out.println("No access Allowed");
    }
}

class Mysql extends DBConnection {

    @Override
    protected void connect() {
        System.out.println("Mysql Connected");
    }
}

class ProxyMysql extends DBConnection {

    DBConnection connection;

    public ProxyMysql() {
        this.users = Set.of("Jake", "Rosie", "Reese");
        this.connection = new Mysql();
    }

    @Override
    public void connect() {
        System.out.println("ProxyMysql Called");
        this.connection.connect();
    }
}


