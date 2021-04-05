<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<petclinic:layout pageName="vets">
    <h2><spring:message code="vets" /></h2>

    <table id="vetsTable" class="table table-striped">
        <thead>
        <tr>
            <th><spring:message code="name" /></th>
            <th><spring:message code="specialties" /></th>
            <th><spring:message code="actions" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vets.vetList}" var="vet">
            <tr>
                <td>
                    <spring:url value="/vets/{vetId}" var="vetUrl">
                        <spring:param name="vetId" value="${vet.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(vetUrl)}"><c:out value="${vet.firstName} ${vet.lastName}"/></a>
                </td>
                <td>
                    <c:forEach var="specialty" items="${vet.specialties}">
                        <spring:message code="${specialty.name}" />&nbsp;
                    </c:forEach>
                    <c:if test="${vet.nrOfSpecialties == 0}"><spring:message code="none" /></c:if>
                </td>
                <td>
                    <spring:url value = "/vets/{vetId}/delete" var="vetUrl">
                        <spring:param name="vetId" value="${vet.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(vetUrl)}" class="btn btn-default"><spring:message code="delete" /></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table class="table-buttons">
        <tr>
            <td>
            <sec:authorize access="hasAuthority('admin')">
		        <a class="btn btn-default" href='<spring:url value="/vets/new" htmlEscape="true"/>'><spring:message code="add_vet" /></a>
	        </sec:authorize>
            </td>
            <td>
                <a href="<spring:url value="/vets.xml" htmlEscape="true" />"><spring:message code="view_xml" /></a>
            </td>            
        </tr>
    </table>
</petclinic:layout>
