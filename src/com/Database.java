package com;

/**
 * Created by Ricardo on 16/03/2016.
 */
class Database {
    private static Database db;
    private char[] tab = new char[100];
    private static final int MAX_CONNECTIONS = 3;
    private IConnection[] connections;
    private int connectionCounter;

    private Database(){
        connections = new Connection[MAX_CONNECTIONS];
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connections[i] = new Connection();
        }
        connectionCounter = -1;
        tab[0] = 'd';
        tab[1] = 'a';
        tab[2] = 't';
        tab[3] = 'a';
    }
    private static Database getInstance(){
        if(db == null){
            db = new Database();
        }
        return db;
    }

    public static IConnection getConnection() {
        return Connection.getInstance();
    }

    private static class Connection implements IConnection {

        private Connection(){

        }

        public static IConnection getInstance(){
            Database database = Database.getInstance();

            if(database.connectionCounter == MAX_CONNECTIONS-1){
                database.connectionCounter = -1;
            }
            return database.connections[++database.connectionCounter];
        }

        public char get(int index) {
            return db.tab[index];
        }
        public void set(int index, char c) {
            db.tab[index] = c;
        }
        public int length() {
            return db.tab.length;
        }

        @Override
        public String toString() {
            return Database.getInstance() + " " + super.toString();
        }
    }
}
