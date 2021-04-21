<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2><spring:message code="cause" /></h2>
    <table id="causesTable" class="table table-striped">
        <thead>
            <tr>
                <th><spring:message code="cause"/></th>
                <th><spring:message code="budget_target"/></th>
                <th><spring:message code="is_open"/></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${causes}" var="cause">
                <tr>
                    <td>
                        <spring:url value="/cuases/{causeId}" var="causeUrl">
                            <spring:param name="causeId" value="${cause.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(causeUrl)}"><c:out value="${cause.name}"/></a>
                    </td>
                    <td>
                        <c:out value="${cause.budgetTarget}"/>
                    </td>
                    <c:choose>
                        <c:when test="${cause.isOpen}">
                            <td>
                                <spring:message code="openTrue"/>
                            </td>
                            <td>
                                <spring:url value="/cuases/{causeId}/donations/new" var="donateUrl">
                                    <spring:param name="causeId" value="${cause.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(donateUrl)}"><spring:message code="donate"/></a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <spring:message code="openFalse"/>
                            </td>
                        </c:otherwise>
                    </c:choose>

                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</petclinic:layout>