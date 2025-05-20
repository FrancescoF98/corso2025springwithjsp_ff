<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Discenti</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="container mt-4">

<nav class="ms-1 me-1 p-3 navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <div class="container-fluid">
        <ul class="navbar-nav d-flex gap-3">
            <li class="nav-item">
                <a class="btn btn-primary mb-3" href="<c:url value='/docenti/lista'/>">Docenti</a>
            </li>
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
        <th>ID</th><th>Nome</th><th>Cognome</th><th>Matricola</th><th>Età</th><th>Azioni</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="d" items="${discenti}">
        <tr>
            <td>${d.id}</td>
            <td>${d.nome}</td>
            <td>${d.cognome}</td>
            <td>${d.matricola}</td>
            <td>${d.eta}</td>
            <td>
                <a class="btn btn-sm btn-secondary" href="<c:url value='/discenti/${d.id}/edit'/>">
                <i class="bi bi-pencil-square"></i>
                Modifica
                </a>
                <a class="btn btn-sm btn-danger"
                   href="<c:url value='/discenti/${d.id}/delete'/>"
                   onclick="return confirm('Sei sicuro?')">
                   <i class="bi bi-trash"></i>
                   Elimina
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
