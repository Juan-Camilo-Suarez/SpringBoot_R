<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Organization Login Form Spring Security</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $.ajax({
            url: '/getusers',
            dataType:'json',
            async:false,
            error: function(xhr, statusText, err) {
                console.log("error"+xhr.status);
            },

            success: function(data) {
                for (let i = 0; i < data.length; i++) {
                    var rowcontent = "<tr><th>" + data[i].name + "</th>";
                    rowcontent = rowcontent + "<td>" + data[i].age + "</td>"
                    rowcontent = rowcontent + "<td>" + data[i].email + "</td></tr>"
                    $("#tbl_body").append(rowcontent);
                }
            },
            type: 'GET'
        });
    });
</script>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Profile</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log Out</a>
                </li>
            </ul>
            <#--                <span class="navbar-text">-->
            <#--        Navbar text with an inline element-->
            <#--      </span>-->
        </div>
    </div>
</nav>

<table>
   <thead>
   <tr>
       <th>Name</th>
       <th>Age</th>
       <th>Email</th>
   </tr>
   </thead>
    <tbody id="tbl_body"></tbody>

</table>


</body>