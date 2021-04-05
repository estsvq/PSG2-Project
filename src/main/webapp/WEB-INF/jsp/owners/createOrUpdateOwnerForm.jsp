<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">
    <h2>
        <c:if test="${owner['new']}"><spring:message code="new" />&nbsp;</c:if> <spring:message code="owner" />
    </h2>
    <form:form modelAttribute="owner" class="form-horizontal" id="add-owner-form">
        <div class="form-group has-feedback">
            <spring:message code="first_name" var="firstNameLabel"/>
            <petclinic:inputField label="${firstNameLabel}" name="firstName"/>
            <spring:message code="last_name" var="lastNameLabel"/>
            <petclinic:inputField label="${lastNameLabel}" name="lastName"/>
            <spring:message code="address" var="addressLabel"/>
            <petclinic:inputField label="${addressLabel}" name="address"/>
            <spring:message code="city" var="cityLabel"/>
            <petclinic:inputField label="${cityLabel}" name="city"/>
            <spring:message code="telephone" var="telephoneLabel"/>
            <petclinic:inputField label="${telephoneLabel}" name="telephone"/>
            <spring:message code="username" var="usernameLabel"/>
            <petclinic:inputField label="${usernameLabel}" name="user.username"/>
            <spring:message code="password" var="passwordLabel"/>
            <petclinic:inputField label="${passwordLabel}" name="user.password"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${owner['new']}">
                        <button class="btn btn-default" type="submit"><spring:message code="add_owner" /></button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit"><spring:message code="update_owner" /></button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
