<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="My">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Part Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Part Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="partRegisterForm" cssClass="form-horizontal" modelAttribute="part" method="post" action="savePart">

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="detail" >Detail</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${partObject.id}"/>
                            <form:input cssClass="form-control" path="detail" value="${partObject.detail}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div align="center"><b>Please enter 1 for need part or 0 for optional</b> </div>
                        <form:label path="need" cssClass="control-label col-xs-3">Need</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="need" value="${partObject.need}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="amount">Amount</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="amount" value="${partObject.amount}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="savePart" class="btn btn-primary" value="Save" onclick="return submitPartForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function submitPartForm() {

            var detail = $('#detail').val().trim();
            var need = $('#need').val();
            var amount = $('#amount').val();
            if(detail.length ==0) {
                alert('Please enter nameDetail');
                $('#detail').focus();
                return false;
            }

            if(need < 0 || need > 1) {
                alert('Please enter proper need');
                $('#need').focus();
                return false;
            }

            if(amount < 0) {
                alert('Please enter proper amount');
                $('#amount').focus();
                return false;
            }
            return true;
        };
    </script>
</body>
</html>