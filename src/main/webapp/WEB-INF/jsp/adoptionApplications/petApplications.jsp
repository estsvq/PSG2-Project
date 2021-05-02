<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="petApplications">
    <h2 style = "float: left;"><spring:message code="petApplications" /></h2>

    <table id="adoptionsReqTable" class="table table-striped">
        <thead>
        <tr>
            <th><spring:message code="name" /></th>
            <th><spring:message code="city" /></th>
            <th><spring:message code="telephone" /></th>
            <th><spring:message code="description" /></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${applications}" var="application">
                <tr>
                    <td>
                        <c:out value="${application.applicant.firstName}"/>
                    </td>
                    <td>
                        <c:out value="${application.applicant.city}"/>
                    </td>
                    <td>
                        <c:out value="${application.applicant.telephone}"/>
                    </td>       
                    <td>
                        <c:out value="${application.description}"/>
                    </td>                    
                    <td>
                        <spring:url value="applications/{applicationId}/approve" var="approveURL">
                            <spring:param name="applicationId" value="${application.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(approveURL)}" class="btn btn-default">
                            <spring:message code="approve"/>
                        </a>
                    </td>
                    
                </tr>
            
        </c:forEach>

        </tbody>
    </table>
</petclinic:layout>
