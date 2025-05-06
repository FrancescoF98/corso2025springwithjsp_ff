<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Studenti</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<nav class="ms-5 me-5 p-3 navbar navbar-expand-sm bg-white navbar-white sticky-top">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="btn btn-primary mb-3" href="<c:url value='/docenti/lista'/>">Docenti</a>
            </li>
            <li class="nav-item">
                <a class="btn btn-primary mb-3" href="<c:url value='/studenti/lista'/>">Studenti</a>
            </li>
        </ul>
        </div>
</nav>

<h1>Elenco Studenti</h1>
<a class="btn btn-primary mb-3" href="<c:url value='/studenti/new'/>">Nuovo Studente</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th><th>Nome</th><th>Cognome</th><th>Matricola</th><th>Età</th><th>Città Residenza</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${studenti}">
        <tr>
            <td>${s.id}</td>
            <td>${s.nome}</td>
            <td>${s.cognome}</td>
            <td>${s.matricola}</td>
            <td>${s.eta}</td>
            <td>${s.citta_residenza}</td>
            <td>
                <a class="btn btn-sm btn-secondary" href="<c:url value='/studenti/${s.id}/edit'/>">Modifica</a>
                <a class="btn btn-sm btn-danger"
                   href="<c:url value='/studenti/${d.id}/delete'/>"
                   onclick="return confirm('Sei sicuro?')">Elimina</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
