<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="donations">
    <jsp:body>
        <h1>
            <spring:message code="donate_to_cause" />
        </h1>
        <form:form modelAttribute="donation" class="form-horizontal" id="add-owner-form">
            <div class="form-group has-feedback">
                <spring:message code="cause" var="causeLabel" />
                <petclinic:inputField label="${causeLabel}" name="cause" disabled="true"/>
                <spring:message code="date" var="dateLabel" />
                <petclinic:inputField label="${dateLabel}" name="date" disabled="true"/>
                <spring:message code="amount" var="amountLabel" />
                <petclinic:inputField label="${amountLabel}" name="amount"/>
                <input type="hidden" name="client" value="${donation.client.getUsername()}">
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit"><spring:message code="submit_donation" /></button>
                </div>
            </div>
        </form:form>
        </jsp:body>
</petclinic:layout>
