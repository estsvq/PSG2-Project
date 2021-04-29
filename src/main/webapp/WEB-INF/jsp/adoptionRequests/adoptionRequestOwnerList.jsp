<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptionsRequestsOwner">
    <h2 style = "float: left;"><spring:message code="petsInAdoption" /></h2>

    <table id="adoptionsReqTable" class="table table-striped">
        <thead>
        
        <tr>
            <th><spring:message code="pets" /></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${adoptions}" var="adoption">
                <tr>
                    <td>
                        <spring:url value="/adoptions/{adoptionID}/applications" var="applicationURL">
                            <spring:param name="adoptionID" value="${adoption.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(applicationURL)}">
                            <c:out value="${adoption.pet.name}"/>
                        </a>
                    </td>
                    
                </tr>
            
        </c:forEach>

        </tbody>
    </table>
</petclinic:layout>
