<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="reservations">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#finnishDate").datepicker({dateFormat: 'yy/mm/dd'});
                $("#startDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h1>
            <spring:message code="book_room_pet" />
        </h1>
        <form:form modelAttribute="reservation" class="form-horizontal" id="add-owner-form">
            <div class="form-group has-feedback">
                <div class="control-group">
                    <spring:message code="pet" var="petLabel" />
                    <petclinic:selectField label="${petLabel}" name="pet" size="1" names="${userPets}"/>
                </div>
                <spring:message code="start_date" var="startDateLabel" />
                <petclinic:inputField label="${startDateLabel}" name="startDate"/>
                <spring:message code="end_date" var="endDateLabel" />
                <petclinic:inputField label="${endDateLabel}" name="finnishDate"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit"><spring:message code="ask_reservation" /></button>
                </div>
            </div>
        </form:form>
        </jsp:body>
</petclinic:layout>
