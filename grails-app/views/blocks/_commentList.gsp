<div class="span8">
    <div class="pageblock">
        <h2>Latest Comments</h2>
        <g:each in="${plans}" var="plan">
            <p><g:link controller="action" action="plan" id="${plan.id}">${plan.org.name.encodeAsHTML()}</g:link></p>
        </g:each>
    </div>
</div>
