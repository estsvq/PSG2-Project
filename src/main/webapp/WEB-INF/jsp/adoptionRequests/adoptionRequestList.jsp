<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptionsRequests">
    <h2 style = "float: left;"><spring:message code="adoptionsRequests" /></h2>
    
    <a href="/adoptions/new" style="float: right; margin-bottom: 10px;">
        <button><spring:message code="add_adoptionReq" /></button>
    </a>

    <table id="adoptionsReqTable" class="table table-striped">
        <thead>
        
        <tr>
            <th style="width: 20%;"><spring:message code="pet" /></th>
            <th style="width: 16%;"><spring:message code="name" /></th>
            <th style="width: 16%;"><spring:message code="address" /></th>
            <th style="width: 16%;"><spring:message code="city" /></th>
            <th style="width: 16%"><spring:message code="telephone" /></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${adoptions}" var="adoption">
                <tr>
                    <td>
                        <spring:url value="/adoptions/{adoptionID}" var="adoptionURL">
                            <spring:param name="adoptionID" value="${adoption.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(adoptionURL)}">
                            <c:out value="${adoption.pet.name}"/>
                        </a>
                    </td>
                    <td>
                        <c:out value="${adoption.pet.owner.firstName}"/>
                    </td>
                    <td>
                        <c:out value="${adoption.pet.owner.address}"/>
                    </td>
                    <td>
                        <c:out value="${adoption.pet.owner.city}"/>
                    </td>
                    <td>
                        <c:out value="${adoption.pet.owner.telephone}"/>
                    </td>
                </tr>
            
        </c:forEach>

        </tbody>
    </table>
</petclinic:layout>
