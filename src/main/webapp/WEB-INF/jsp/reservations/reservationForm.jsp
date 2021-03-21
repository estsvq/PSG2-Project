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
            Book a room for your pet!
        </h1>
        <form:form modelAttribute="reservation" class="form-horizontal" id="add-owner-form">
            <div class="form-group has-feedback">
                <div class="control-group">
                    <petclinic:selectField label="Pet" name="pet" size="1" names="${userPets}"/>
                </div>
                <petclinic:inputField label="Start date" name="startDate"/>
                <petclinic:inputField label="Finnish date" name="finnishDate"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Ask for reservation</button>
                </div>
            </div>
        </form:form>
        </jsp:body>
</petclinic:layout>
