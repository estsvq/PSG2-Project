<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">

    <h2><spring:message code="owner_information" /></h2>


    <table class="table table-striped">
        <tr>
            <th><spring:message code="name" /></th>
            <td><b><c:out value="${owner.firstName} ${owner.lastName}"/></b></td>
        </tr>
        <tr>
            <th><spring:message code="address" /></th>
            <td><c:out value="${owner.address}"/></td>
        </tr>
        <tr>
            <th><spring:message code="city" /></th>
            <td><c:out value="${owner.city}"/></td>
        </tr>
        <tr>
            <th><spring:message code="telephone" /></th>
            <td><c:out value="${owner.telephone}"/></td>
        </tr>
    </table>

    <spring:url value="{ownerId}/edit" var="editUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default"><spring:message code="edit_owner" /></a>

    <spring:url value="{ownerId}/delete" var="delUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(delUrl)}" class="btn btn-default"><spring:message code="delete_owner" /></a>

    <spring:url value="{ownerId}/pets/new" var="addUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default"><spring:message code="add_pet" /></a>

    <spring:url value="{ownerId}/reservations/new" var="addUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default"><spring:message code="add_reservation" /></a>

    <br/>
    <br/>
    <br/>
    <h2><spring:message code="pets_visits_reservations" /></h2>

    <table class="table table-striped">
        <c:forEach var="pet" items="${owner.pets}">

            <tr>
                <td valign="top">
                <h3><spring:message code="pet" /></h3>
                    <dl class="dl-horizontal">
                        <dt><spring:message code="name" /></dt>
                        <dd><c:out value="${pet.name}"/></dd>
                        <dt><spring:message code="birthdate" /></dt>
                        <dd><petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt><spring:message code="type" /></dt>
                        <dd><spring:message code="${pet.type.name}" /></dd>
                        <dd>
                            <spring:url value="/owners/{ownerId}/pets/{petId}/delete" var="delUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(delUrl)}" class="btn btn-default"><spring:message code="delete_pet" /></a>
                        </dd>
                    </dl>
                </td>
                <td valign="top">
                <h3><spring:message code="visits" /></h3>
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th><spring:message code="visit_date" /></th>
                            <th><spring:message code="description" /></th>
                            
                        </tr>
                        </thead>
                        <c:forEach var="visit" items="${pet.visits}">
                            <tr>
                                <td><petclinic:localDate date="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <spring:url value="/owners/{ownerId}/pets/{petId}/edit" var="petUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(petUrl)}"><spring:message code="update_pet" /></a>
                            </td>
                            <td>
                                <spring:url value="/owners/{ownerId}/pets/{petId}/visits/new" var="visitUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(visitUrl)}"><spring:message code="add_visit" /></a>
                            </td>
                            
                        </tr>
                    </table>
                </td>
                <td valign="top">
                <h3><spring:message code="reservations" /></h3>
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th><spring:message code="start_date" /></th>
                            <th><spring:message code="end_date" /></th>
                        </tr>
                        </thead>
                        <c:forEach var="reservation" items="${pet.reservations}">
                            <tr>
                                <td><petclinic:localDate date="${reservation.startDate}" pattern="yyyy-MM-dd"/></td>
                                <td><petclinic:localDate date="${reservation.finnishDate}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                        
                    </table>
                </td>
            </tr>

        </c:forEach>
    </table>

</petclinic:layout>
