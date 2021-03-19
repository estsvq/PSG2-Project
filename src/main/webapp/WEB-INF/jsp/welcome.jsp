<%@ page session="false" trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
                <!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->

                <petclinic:layout pageName="home">
                    <h1>Welcome to the PSG2-2021-G2-23 Petclinic</h1>
                    <div class="row">
                        <div class="col-md-12" >
                            <spring:url value="/resources/images/pets2.png" htmlEscape="true" var="petsImage" />
                            <img class="img-responsive" src="${petsImage}" style="margin-left: auto;margin-right: auto;" />
                        </div>
                    </div>
                </petclinic:layout>