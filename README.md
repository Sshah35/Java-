# Java-
All Java codes for projects as well as others
Running Notes 
JDBC

JDBC - Program

Create Table:


Create table Student and add few records

Create  Table Student
(
  id  int primary key,
  name varchar(30) not null,
  email varchar(30) unique 
)

select * from student

insert into student values (1, 'tom', 'tom@abc.com')

insert into student values (2, 'amy', 'amy@abc.com')



Java main method to access the Derby database



public static void main(String[] args) {
        // TODO code application logic here

        //Setup driver
        String driver = "org.apache.derby.jdbc.ClientDriver";
        //Setup database connection string
        String connectionURL = "jdbc:derby://localhost:1527/sample;create=true;user=app;password=app";

        try {
            //load class
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }

           Connection conn = null;
           Statement stmt = null;
           ResultSet rs = null;
            try {
            //establish connection
             conn = DriverManager.getConnection(connectionURL);
            //create statement
             stmt = conn.createStatement();
            //execute query and get resultset
             rs = stmt.executeQuery("select * from student");
            
            //loop result set
            while (rs.next()) {
                //write record + column
                System.out.println(rs.getString("id") + "  " + rs.getString("name") + "  " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    
                }
            }

        
    } //main
If you get compilation error: class NOT Found then add Library: Java DB Library 


- Right click on Java Project

- Select Property 

- Add Library

- Select Java DB Library





Create Student class
public class Student {
    
    private int id;
    private String name;
    private String email;

  public Student() {
    }
    
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}



In the main method() , add Students in the ArrayList 


ArrayList<Student> stuList = new ArrayList<Student>();
            //loop result set
            while (rs.next()) {
                //write record + column
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name") ;
                String email =  rs.getString("email");
                Student stu = new Student(id,name,email);
                stuList.add(stu);
               
            }
             System.out.println(stuList);

DBUtil class



public class DBUtil {
    
       //Setup driver
       private String driver = "org.apache.derby.jdbc.ClientDriver";
        //Setup database connection string
       private String connectionURL = "jdbc:derby://localhost:1527/sample;create=true;user=app;password=app";

    public ArrayList<Student> getStudentList() {

        ArrayList<Student> stuList = new ArrayList<Student>();

        

        try {
            //load class
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //establish connection
            conn = DriverManager.getConnection(connectionURL);
            //create statement
            stmt = conn.createStatement();
            //execute query and get resultset
            rs = stmt.executeQuery("select * from student");

            //loop result set
            while (rs.next()) {
                //write record + column
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                Student stu = new Student(id, name, email);
                stuList.add(stu);

            }
            System.out.println(stuList);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {

            }
        }

        return stuList;

    }
}


Modify your WebService - get() method and call DBUtil class.


   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Student> getJson() {
        //TODO return proper representation object
         DBUtil db = new DBUtil();
        return db.getStudentList();

    }



Deploy the Web Application  project on a Glass fish server

Right click on RestWebService and Test the RestService URI

Validate the Get operation 

You would see the service will return the studentList in a JSON format.




