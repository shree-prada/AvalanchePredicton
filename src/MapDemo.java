/*

write a program to display the empnames of employees whose
empno is greater than a given empno
from emp table

Note - Display only empnames in ascending order

The DB Credentials



Name of the DB - fs;
Name of the table- emp;
JDBC_DRIVER = "com.mysql.jdbc.Driver";
DB_URL = "jdbc:mysql://localhost/fs";
Username-student
Password-student

emp schema;

+----------+---------------+------+-----+---------+-------+
| Field    | Type          | Null | Key | Default | Extra |
+----------+---------------+------+-----+---------+-------+
| empno    | int(4)        | NO   | PRI | NULL    |       |
| ename    | varchar(50)   | NO   |     | NULL    |       |
| job      | varchar(50)   | NO   |     | NULL    |       |
| mgr      | int(4)        | YES  |     | NULL    |       |
| hiredate | date          | YES  |     | NULL    |       |
| sal      | decimal(10,2) | YES  |     | NULL    |       |
| comm     | decimal(10,2) | YES  |     | NULL    |       |
| deptno   | int(2)        | YES  | MUL | NULL    |       |
+----------+---------------+------+-----+---------+-------+


input = 7600
output =
BLAKE
CLARK
FORD
FORD
JAMES
KEVIN
KEVIN
KEVIN
MARTIN
SCOTT

Explanation - Here we have 10 employes names whose empno is > 7600

input = 7800
output =
FORD
FORD
JAMES
KEVIN
KEVIN
KEVIN


Explanation - Here we have 6 employes names whose empno is > 7800


*/

import java.sql.*;
import java.util.*;
class Test{

    public static void main(String[] args) {
        String DB_URL="jdbc:mysql://localhost/root";
        String USER="shreeprada";
        String PASS="root";
        Connection conn=null;
        Statement stmt=null;
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        List<String> arr=new ArrayList<>();
        try{
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            stmt=conn.createStatement();
            String sql;
            sql="SELECT cname,climit from emp";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                String name=rs.getString("cname");
                int no=rs.getInt("climit");
                    arr.add(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){e.printStackTrace();}
        Collections.sort(arr);
        for(String i:arr)
            System.out.println(i);
    }
}


