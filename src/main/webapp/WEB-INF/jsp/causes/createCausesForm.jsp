<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2>
               <spring:message code="new" />&nbsp; <spring:message code="cause" />
    </h2>
    <form:form modelAttribute="cause" class="form-horizontal" id="add-cause-form">
        <div class="form-group has-feedback">

            <spring:message code="name" var="nameLabel"/>
            <petclinic:inputField label="${nameLabel}" name="name"/>
            <spring:message code="description" var="descriptionLabel"/>
            <petclinic:inputField label="${descriptionLabel}" name="description"/>
            <spring:message code="budget_target" var="budgetTargetLabel"/>
            <petclinic:inputField label="${budgetTargetLabel}" name="budgetTarget"/>
            <spring:message code="act_non_prof_org" var="actNonProfOrgLabel"/>
            <petclinic:inputField label="${actNonProfOrgLabel}" name="actNonProfOrg"/>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">

                        <button class="btn btn-default" type="submit"><spring:message code="add_cause" /></button>

            </div>
        </div>
    </form:form>
</petclinic:layout>