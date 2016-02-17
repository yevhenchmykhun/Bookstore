Yevhen Chmykhun 17 Feb 2016

The Bookstore application requires access to a MySQL database.

Before running the application,

Download MySQL from: http://dev.mysql.com/downloads/

Change properties username and password in src/main/resources/hibernate.cfg.xml

Run the SQL scripts found in src/main/webapp/setup directory. The schema script creates tables necessary for the application. The data script adds sample data to the tables. Run the schema creation script first, then run the sample data script.

Download Tomcat server from http://tomcat.apache.org/

In $TOMCAT_HOME/conf/tomcat-users.xml add following rows:

and set up attributes username and password. This attributes is required at the login page.

Create folder for book covers, for example $TOMCAT_HOME/webapps/book-covers.

In $TOMCAT_HOME/conf/server.xml in host tag add following row:

where docBase attribute is absolute path to created folder and path attribute is relative path.

For example:



In src/main/webapp/WEB-INF/web.xml set up docBase value in of with absoluteCoversPath and path value in of with relativeCoversPath

For example:

    <context-param>
        <description>The relative path to book covers</description>
        <param-name>relativeCoversPath</param-name>
        <param-value>/book-covers/</param-value>
    </context-param>

    <context-param>
        <description>The absolute path to book covers</description>
        <param-name>absoluteCoversPath</param-name>
        <param-value>/home/evgenii/eclipse_luna/servers/apache-tomcat-8.0.28/webapps/book-covers/</param-value>
    </context-param>
