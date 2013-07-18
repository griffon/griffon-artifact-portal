<%@ page import="griffon.portal.values.SettingsTab; grails.util.GrailsNameUtils" %>

<%
    def notificationsState = profileInstance.notifications.watchlist ? 'enabled' : 'disabled'
    def notificationsClass = profileInstance.notifications.watchlist ? 'success' : 'important'
%>
<p>
    Your watchlist is currently <span
    class="label ${notificationsClass}">${notificationsState}</span>. You can change this in your <g:link
    controller="profile" action="settings" mapping="settings"
    params="[username: profileInstance.user.username, tab: SettingsTab.NOTIFICATIONS.name]">settings</g:link>.
</p>

<g:if test="${watchlistList}">
<%-- preload images --%>
    <g:img dir="images" file="watch_off.png" style="display: none"/>
    <g:img dir="images" file="watch_on.png" style="display: none"/>
    <ui:table class="table-condensed">
        <thead>
        <ui:tr>
            <ui:th>&nbsp;</ui:th>
            <ui:th>${message(code: 'artifact.type.label', default: 'Type')}</ui:th>
            <ui:th>${message(code: 'artifact.name.label', default: 'Name')}</ui:th>
            <ui:th>${message(code: 'artifact.title.label', default: 'Title')}</ui:th>
        </ui:tr>
        </thead>
        <tbody>
        <g:each in="${watchlistList}" status="i" var="artifactInstance">
            <ui:tr>
                <%
                    def watchingId = "watching_${artifactInstance.type}_${artifactInstance.id}"
                %>
                <td><g:remoteLink controller="artifact"
                                  action="watch"
                                  id="${artifactInstance.id}"
                                  mapping="watch_artifact"
                                  onSuccess="toggleWatcher(data, '${watchingId}')"><g:img
                        id="${watchingId}"
                        name="${watchingId}"
                        dir="images"
                        file="watch_on.png"/></g:remoteLink></td>
                <td>${fieldValue(bean: artifactInstance, field: "type")}</td>
                <td>
                    <g:link controller="${artifactInstance.type}"
                            action="show"
                            params="[name: artifactInstance.name]"
                            mapping="show_${artifactInstance.type}">${fieldValue(bean: artifactInstance, field: "capitalizedName")}</g:link>
                </td>
                <td>${fieldValue(bean: artifactInstance, field: "title")}</td>
            </ui:tr>
        </g:each>
        </tbody>
    </ui:table>
</g:if>
<g:else>
    <p>You have no items in your watching list.</p>
</g:else>