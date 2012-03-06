<div class="span8">
    <div class="pageblock">
        <h2>Latest Actions</h2>
        <g:each in="${acts}" var="act">
            <p><g:link controller="action" action="view" id="${act.id}">${act.summary.encodeAsHTML()}</g:link></p>
        </g:each>
    </div>
</div>
