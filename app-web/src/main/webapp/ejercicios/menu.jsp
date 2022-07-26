<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>

body{

    background-image: url(./fondojava2.png) ;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center center;
    min-height: 100vh;
    
}
h1{
    padding-bottom: 20px;
    padding-top: 20px;
    opacity: 0.8;
    color: white;
    font-size: 50px
}
    .btn{
        opacity: 0.9;
        font-size: 25px;  
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    </style>


</head>
<body>
    <main>
        <div class="titulo">
            <h1>Home</h1>
        </div>

        <div >

           <a class="btn btn-primary btn-lg " href="<%=request.getContextPath()%>/controllers/menu" target="_blank" role="button">Ir a la tabla menu</a>

        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>