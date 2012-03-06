<div class="modal-header">
    <a href="#" class="close">×</a>
    <h3>Add Comment</h3>
</div>
<g:form controller="comment" action="save" method="post">
    <input type="hidden" name="targetClass" value="${target.class.name}" />
    <input type="hidden" name="targetId" value="${target.id}" />
    <div class="modal-body">
        <f:field property="message">
            <g:textArea class="xlarge" name="message" rows="5" />
        </f:field>
        <f:field property="private" label="Private?" helpBlock="Tick to make this message private to the Action Plan owner">
            <g:checkBox name="private" />
        </f:field>
    </div>
    <div class="modal-footer">
        <input type="submit" class="btn primary">Save</a>
        <a href="#" class="btn secondary" onclick="jQuery('#add-comment').modal('hide');">Cancel</a>
    </div>
</g:form>
