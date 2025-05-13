<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Errore</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

    <nav class="ms-1 me-1 p-3 navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
            <div class="container-fluid">
                <ul class="navbar-nav d-flex gap-3">
                    <li class="nav-item">
                        <a class="btn btn-primary mb-3" href="<c:url value='/docenti/lista'/>">Docenti</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-primary mb-3" href="<c:url value='/discenti/lista'/>">Discenti</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-primary mb-3" href="<c:url value='/corsi/lista'/>">Corsi</a>
                    </li>
                </ul>
            </div>
    </nav>

    <p></p>
    <img src="https://i.makeagif.com/media/6-18-2016/i4va3h.gif"
         width="400"
         class="d-block mx-auto" />

    <h3></h3>
    <h3 style="text-align: center;">Qualcosa è andato storto.</h3>
    <p></p>

    <h5><b>Codice di stato:</b></h5>
    <h6>${status}</h6>
    <p></p>

    <h5><b>Messaggio:</b></h5>
    <h6>${message}</h6>
    <p></p>

    <h5><b>Exception:</b></h5>
    <h6>${exception}</h6>
    <p></p>

    <h5><b>Exception Type:</b></h5>
    <h6>${exception_type}</h6>



</body>
</html>
