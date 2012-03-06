<blockquote>
    <sec:ifAnyGranted roles="ROLE_COMMENT_MOD">
        <div class="commentMods">
            <g:link controller="comment" action="toggleShow" id="${comment.id}">
                <g:if test="${comment.moderatorHidden}">
                    Show comment
                </g:if>
                <g:else>
                    Hide comment
                </g:else>
            </g:link>
        </div>
    </sec:ifAnyGranted>
    <p><g:nl2br>${comment.message.encodeAsHTML()}</g:nl2br></p>
    <small>${comment.sender.alias?.encodeAsHTML() ?: ''} at <g:formatDate date="${comment.dateCreated}" type="datetime" style="LONG" timeStyle="SHORT"/></small>
</blockquote>
