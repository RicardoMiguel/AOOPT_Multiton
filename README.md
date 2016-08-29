Advanced Object-oriented Programming Technics - Singleton and Multiton

Database (a table of characters) can be accessed only through a class implementing the interface of type IConnection. The Database should be a Singleton but only a concrete connection should use it (not the main function). The connections should be Multitons: there are only three of them returned by the getInstance method in the round-robin fashion (1 2 3 1 2 3 ...). 
The client (main function) gets the connection object and use it to access the database. 
Complete the following code. In the main function: get 4 connections and prove that they all use the same database. Then prove also that, in fact (in spite of 4 initialized references), there are only 3 connection objects.

interface IConnection { 
  char get(int index); 
  void set(int index, char c); 
  int length(); 
} 
class Database { 
  private char[] tab = new char[100]; 
  /* ... */ 
  public static IConnection getConnection() { 
     return Connection.getInstance(); 
  } 
  private static class Connection implements IConnection { 
    private Database db; 
    /* ... */ 
    public static IConnection getInstance(){
      /* ... */ 
    } 
    public char get(int index) { 
      return db.tab[index]; 
    } 
    public void set(int index, char c) {
      db.tab[index] = c; 
    }
    public int length() { 
      return baza.tab.length; 
    } 
  } 
}

Why Singletons are evil: https://blogs.msdn.microsoft.com/scottdensmore/2004/05/25/why-singletons-are-evil/