<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Organization Login Form Spring Security</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    // var colors=new Array("green", "yellow", "red", "yellow", "green");
    function color1(color, delay) {
        $.ajax({
            url: 'http://192.168.2.35:8080/?color='+color+'&delay='+delay,
            dataType:'json',
            async:false,
            error: function(xhr, statusText, err) {
                console.log("error"+xhr.status);
            },

            type: 'GET'
        });

    }
    function color2(colors) {
        for (let i = 0; i < colors.length;  i++) {
            color = colors[i];
            $.ajax({

                url: 'http://192.168.2.35:8080/?color='+color+'&delay=1500',
                dataType:'json',
                async:false,
                error: function(xhr, statusText, err) {
                    console.log("error"+xhr.status);
                },

                type: 'GET'

            })

        }
    }
    function color3() {
        for (let i = 0; i < 2;  i++) {
            $.ajax({

                url: 'http://192.168.2.35:8080/?color=yellow&delay=1000',
                dataType:'json',
                async:false,
                error: function(xhr, statusText, err) {
                    console.log("error"+xhr.status);
                },

                type: 'GET'

            })

        }
    }
    function alert(){
        alert("?????????????????? ????????????????")
    }
</script>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Home</a>
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

<button type="button"  onclick="color2(['red','green', 'yellow']);" class="btn btn-light">???????????????? </button>
<button type="button" class="btn btn-primary">??????????????????</button>
<button type="button" onclick="color3()"class="btn btn-warning">yellow</button>


</body>
</html>