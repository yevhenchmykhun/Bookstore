<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Bookstore.com Admin Panel</title>
    <link rel="stylesheet" href="../css/admin-login.css"/>
</head>
<body>
<header>
    <div id="head">
        Bookstore.com <br/>
        Admin Panel
    </div>
</header>
<section>
    <form action="j_security_check" method="post" id="login-form">
        <label>
            <span>Username</span>
            <input type="text" placeholder="Username" autofocus name="j_username"/>
        </label>
        <label>
            <span>Password</span>
            <input type="password" placeholder="Password" name="j_password"/>
        </label>
        <label>
            <input type="submit" value="Sign In"/>
        </label>
    </form>
</section>
</body>
