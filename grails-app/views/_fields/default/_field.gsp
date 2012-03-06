<div class="clearfix ${invalid ? 'error' : ''}">
    <label for="${property}">${label}<g:if test="${required}"> <span class="required-indicator">*</span></g:if></label>
    <div class="input">
        ${widget}
        <span class="help-block"><g:each in="${errors}" var="error">${error}<br /></g:each>${helpBlock}</span>
    </div>
</div>
