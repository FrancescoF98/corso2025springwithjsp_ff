<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Corsi</title>
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

    <h1>Elenco Corsi</h1>
    <a class="btn btn-primary mb-3" href="<c:url value='/corsi/new'/>">Nuovo Corso</a>

    <a class="btn btn-secondary mb-3" href="/corsi/lista">Rimuovi filtri</a>
    <a class="btn btn-secondary mb-3" href="/corsi/lista?filtro=asc">Ordina per nome (A-Z)</a>
    <a class="btn btn-secondary mb-3" href="/corsi/lista?filtro=desc">Ordina per nome (Z-A)</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th><th>Nome</th><th>Docente</th><th>Anno Accademico</th><th>Studenti</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="cs" items="${corsi}">
                <tr>
                    <td>${cs.id}</td>
                    <td>${cs.nome}</td>
                    <td>${cs.id_doc.nome} ${cs.id_doc.cognome}</td>
                    <td>${cs.anno_accademico}</td>
                    <td>${cs.discenti.size()}</td>
                    <td>
                        <a class="btn btn-sm btn-secondary" href="<c:url value='/corsi/${cs.id}/edit'/>"><i class="bi bi-pencil-square"></i>Modifica</a>
                        <a class="btn btn-sm btn-danger"
                           href="<c:url value='/corsi/${cs.id}/delete'/>"
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
