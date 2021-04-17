<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">

    <h2><spring:message code="cause_information" /></h2>


    <table class="table table-striped">
        <tr>
            <th><spring:message code="name" /></th>
            <td><b><c:out value="${cause.name}"/></b></td>
        </tr>
        <tr>
            <th><spring:message code="description" /></th>
            <td><c:out value="${cause.description}"/></td>
        </tr>
        <tr>
            <th><spring:message code="target_budget" /></th>
            <td><c:out value="${cause.targetBugdet}"/></td>
        </tr>
        <tr>
            <th><spring:message code="total_budget" /></th>
            <td><c:out value="${cause.totalBudget}"/></td>
        </tr>
         <tr>
            <th><spring:message code="organization" /></th>
            <td><c:out value="${cause.organization}"/></td>
        </tr>
        <tr>
            <th><spring:message code="is_open" /></th>
            <td><c:out value="${cause.isOpen}"/></td>
        </tr>
    </table>

    <spring:url value="{causeId}/donate" var="donateUrl">
        <spring:param name="causeId" value="${cause.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(donateUrl)}" class="btn btn-default"><spring:message code="add_donation" /></a>

    <br/>
    <br/>
    <br/>
    <h2><spring:message code="donations" /></h2>
    <table id="donationsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;"><spring:message code="name" /></th>
            <th style="width: 200px;"><spring:message code="quantity" /></th>
            <th><spring:message code="date" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${donations}" var="donation">
            <tr>
                <td>
                    <c:out value="${donation.name}"/>
                </td>
                <td>
                    <c:out value="${donation.amount}"/>
                </td>
                <td>
                  <petclinic:localDate date="${donation.date}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</petclinic:layout>
