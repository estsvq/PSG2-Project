<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptions">
    <h2>
               <spring:message code="new" />&nbsp; <spring:message code="adoption" />
    </h2>
   
    <form:form modelAttribute="adoptionApplication" class="form-horizontal" id="add-adoption-application-form">
      <table class="table table-striped">
        <tr>
            <th><spring:message code="pet_name" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.pet.name}"/></b></td>
        </tr>
            <tr>
            <th><spring:message code="description" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.description}"/></b></td>
        </tr>
        <tr>
            <th><spring:message code="type" /></th>
            <td><b><spring:message code="${adoptionApplication.adoptionRequest.pet.type.name}" /></b></td>
        </tr>
          <tr>
            <th><spring:message code="owner_name" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.pet.owner.firstName}" /></b></td>
        </tr>
          <tr>
            <th><spring:message code="address" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.pet.owner.address}" /></b></td>
        </tr>
          <tr>
            <th><spring:message code="city" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.pet.owner.city}" /></b></td>
        </tr>
          <tr>
            <th><spring:message code="telephone" /></th>
            <td><b><c:out value="${adoptionApplication.adoptionRequest.pet.owner.telephone}" /></b></td>
        </tr>
    </table>
        <div class="form-group has-feedback">
            <spring:message code="description" var="descriptionLabel"/>
            <petclinic:inputField label="${descriptionLabel}" name="description"/>
            <input type="hidden" name="adoptionRequest" value="${adoptionApplication.adoptionRequest.id}" />
             <input type="hidden" name="applicant" value="${adoptionApplication.applicant.id}" />

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" type="submit"><spring:message code="add_adoption_application" /></button>
            </div>
        </div>
    </form:form>
</petclinic:layout>