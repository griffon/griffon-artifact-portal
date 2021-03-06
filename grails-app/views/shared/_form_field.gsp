<ui:field bean="${bean}" name="${field}">
    <ui:fieldInput>
        <g:if test="${password}">
            <g:passwordField name="${field}" required="true"
                             class="input-xlarge" value="${bean[field]}"/>
        </g:if>
        <g:else>
            <g:textField name="${field}" required="true"
                         class="input-xlarge" value="${bean[field]}"/>
        </g:else>
    </ui:fieldInput>
    <ui:fieldErrors></ui:fieldErrors>
    <g:if test="${hint}">
        <ui:fieldHint>
            <p class="help-block">${hint}</p>
        </ui:fieldHint>
    </g:if>
</ui:field>