<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Parts List</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Parts List</b> </div>
                <div align="right"><a href="createPart">Add new Part</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty partList}">
                There are no Parts
            </c:if>
            <c:if test="${not empty partList}">

                <form action="searchPart">
                    <div class="row">
                      <div class="col-md-6"><div class="col-md-6">Search Detail:</div><div class="col-md-6">
                      <input type="text" name="searchName" id="searchName"> </div></div>
                      <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                    </div>
                </form>

                <div class="btn-group">
                    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">Sorted <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                          <li><a href="getPageAllParts">All</a></li>
                          <li><a href="getPagePartsNeed">Need</a></li>
                          <li><a href="getPagePartsOptional">Optional</a></li>
                       </ul>
                </div>

                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <!-- <th>Id</th> -->
                        <th>Detail</th>
                        <th>Need</th>
                        <th>Amount</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${partList}" var="p">
                        <tr>
                            <!-- <th><c:out value="${p.id}"/></th> -->
                            <th><c:out value="${p.detail}"/></th>
                            <th>
                                <c:if test="${p.need > 0}"><c:out value="Yes"/></c:if>
                                <c:if test="${p.need < 1}"><c:out value="No"/></c:if>
                            </th>
                            <th><c:out value="${p.amount}"/></th>
                            <th><a href="editPart?id=<c:out value='${p.id}'/>">Edit</a></th>
                            <th><a href="deletePart?id=<c:out value='${p.id}'/>">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                        <tr>
                            <th>Total assemble computers :</th>
                            <th><c:out value="${numComp}"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr></tr>
                    </tbody>
                </table>

                <ul class="pager">
                    <li class="previous"><a href="previousPage"><< Previous</a></li>
                    <li class="next"><a href="nextPage">Next >></a></li>
                </ul>

            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>