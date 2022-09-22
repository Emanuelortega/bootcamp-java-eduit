<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.domain.Menu"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
      .table,th,td{
        border: 1px solid black
      }

      .columnas{
        font-size: 25px;
        text-decoration: blink;
      }
      
      body{
       
        background-image: linear-gradient(45deg,#0031d4,#505488,#2f3f80,#151669,
        #5a4894,#a14040,#491414);
        background-size: 600% 600%;
        
        animation: animacion 15s infinite;
      }
      
      @keyframes animacion{
      	0%{
      	background-position: 0% 50%;
     	 }
     	 50%{
      		background-position: 100% 50%;
    	  }
      
     	 100%{
      	background-position: 0% 50%;
     	 }
      }
      h1{
        font-family:'Courier New', Courier, monospace;
        color: white;
        text-align: center;
        padding: 15px
      }

      table{
        opacity: 0.9;
      }
 
    </style>
</head>
<body>
    <main>
      <div class="conteiner" >
        <div class="row">
          <div col class="col-12">
            <section>
              <h1> Tabla Menu</h1>
            </section>
                <section>
                <%List<Menu> list =(List<Menu>)request.getAttribute("menus");%>
                  <table class="table table-dark table-striped">
                    <thead>
                      <tr class="columnas">
                        <th scope="col">Id</th>
                        <th scope="col">Menu</th>
                        <th scope="col">Root</th>
                        <th scope="col">Id Padre</th>
                        <th scope="col">Link</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <%for(Menu fila : list){ %>
                        <tr>
                          <th scope="row"><%=fila.getId() %></th>
                          <td><%=fila.getTexto() %></td>
                          <td><%=fila.isRoot() %></td>
                          <td><%=fila.getIdMenuPadre()%></td>
                          <td><a href="<%=fila.getLink()%>" target="_blank"><%=fila.getLink()%></a></td>
                        </tr>
                        <%} %>
                    </tbody>
                  </table>
                </section>   
          </div>
        </div>
      </div>
    </main>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>