<%@ page import="griffon.portal.values.ArtifactTab" %>
<!doctype html>
<html>
<head>
    <theme:layout name="plain"/>
    <theme:title><g:message code="griffon.portal.Archetype.show.label"
                            args="[archetypeName]"/></theme:title>
</head>

<body>

<theme:zone name="body">
    <tmpl:/shared/pageheader><h2>${archetypeName}</h2>${archetypeInstance.title}</tmpl:/shared/pageheader>

    <div class="row">
        <div class="span7">
            <g:render template="/artifact/common/artifact_header_properties"
                      model="[artifactInstance: archetypeInstance, downloads: downloads]"/>
        </div>

        <div class="span4">
            <g:render template="/artifact/common/authored_by"
                      bean="${authorList}" model="[authorList: authorList]"/>
        </div>
    </div>

    <%
        def tabs = ArtifactTab.values().flatten()
        // tabs.remove ArtifactTab.REPOSITORY
    %>

    <ui:tabs>
        <g:each in="${tabs}" var="artifactTab">
            <ui:tab title="${artifactTab.capitalizedName}"
                    active="${'Description' == artifactTab.capitalizedName}">
                <g:render template="/artifact/tabs/${artifactTab.name}"
                          model="[artifactInstance: archetypeInstance]"/>
            </ui:tab>
        </g:each>
    </ui:tabs>

</theme:zone>
</body>
</html>