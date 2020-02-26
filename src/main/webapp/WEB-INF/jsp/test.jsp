<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="../recources/css/login.css">
</head>

<body>
<div class="wrapper fadeInDown">
    <div id="formContent">

        <div >

        <form method="POST" action="/login">
            <div><input type="text" id="login" class="fadeIn second" name="login" placeholder="login"></div>
            <div> <input type="password" id="password" class="fadeIn third" name="login" placeholder="password"></div>
            <div> <input type="submit" class="fadeIn fourth" value="Log In"></div>
        </form>


        <div id="formFooter">
            <a class="underlineHover" href="/registration">Sign Up</a>
        </div>
        </div>


    </div>
</div>
</body>
</html>