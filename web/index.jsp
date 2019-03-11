<%@include file="info.jsp" %>
<html>
    <body>
        <h3>Online Book Store</h3>
        <hr>
        <form action="VerifyUser">
            <table border="0">
            <tr>
                <td>Userid</td><td><input type="text" name="userid"/></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Usertype</td><td><select name="utype"><option>Admin</option><option>Buyer</option></select></td>
            </tr>
            <tr>
                <td>SavePwd</td><td><input type="checkbox" name="save" value="yes"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            </table>
            </pre>
        </form>                        
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>
