<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Discenti</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<nav class="ms-1 me-1 p-3 navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="btn btn-primary mb-3" href="<c:url value='/docenti/lista'/>">Docenti</a>
            </li>
            <li class="nav-item">

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

<h1>Elenco Discenti</h1>
<a class="btn btn-primary mb-3" href="<c:url value='/discenti/new'/>">Nuovo Discente</a>

<a class="btn btn-secondary mb-3" href="/discenti/lista">Rimuovi filtri</a>
<a class="btn btn-secondary mb-3" href="/discenti/lista?filtro=asc">Ordina per nome (A-Z)</a>
<a class="btn btn-secondary mb-3" href="/discenti/lista?filtro=desc">Ordina per nome (Z-A)</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th><th>Nome</th><th>Cognome</th><th>Matricola</th><th>Età</th><th>Città Residenza</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${discenti}">
        <tr>
            <td>${s.id}</td>
            <td>${s.nome}</td>
            <td>${s.cognome}</td>
            <td>${s.matricola}</td>
            <td>${s.eta}</td>
            <td>${s.citta_residenza}</td>
            <td>
                <a class="btn btn-sm btn-secondary" href="<c:url value='/discenti/${s.id}/edit'/>">Modifica</a>
                <a class="btn btn-sm btn-danger"
                   href="<c:url value='/discenti/${d.id}/delete'/>"
                   onclick="return confirm('Sei sicuro?')">Elimina</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
