<%@ page import="grails.util.GrailsNameUtils" %>
<!doctype html>
<html>
<head>
  <meta name="layout" content="categorized">
  <title>${GrailsNameUtils.getNaturalName(params.type)}s - ${categoryType.capitalizedName}</title>
</head>

<body>

<div class="row">
  <tmpl:/pageheader><h1>${GrailsNameUtils.getNaturalName(params.type)}s - ${categoryType.capitalizedName}<g:if test="${params.tagName}">: ${params.tagName}</g:if></h1></tmpl:/pageheader>
</div>

<div class="row">
  <g:if test="${artifactList}">
    <g:render template="artifact_box" collection="${artifactList}" var="artifactInstance"/>
  </g:if>
  <g:else>
    <p><g:message code="categories.${categoryType.name}.unavailable" args="[params.type]"/></p>
  </g:else>
</div>

</body>
</html>
