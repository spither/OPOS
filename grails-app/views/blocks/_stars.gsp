<form style="width: 80px; margin-left: 10px;">
    <g:if test="${caption}">
        <span id="${id}_caption" class="stars-caption"></span>
    </g:if>
    <div id="${id}_select_wrapper">
        <select name="rating" id="${id}_select" <g:if test="${!disabled}">onchange="${remoteFunction(controller: 'rating', action: 'rate', id: bean.id, params: '\'type=' + type + scopeParam + '&rating=\' + this.value')}"</g:if> >
            <option value="1" ${userValue == 1 ? 'selected' : ''}>1</option>
            <option value="2" ${userValue == 2 ? 'selected' : ''}>2</option>
            <option value="3" ${userValue == 3 ? 'selected' : ''}>3</option>
            <option value="4" ${userValue == 4 ? 'selected' : ''}>4</option>
            <option value="5" ${userValue == 5 ? 'selected' : ''}>5</option>
            <option value="6" ${userValue == 6 ? 'selected' : ''}>6</option>
            <option value="7" ${userValue == 7 ? 'selected' : ''}>7</option>
            <option value="8" ${userValue == 8 ? 'selected' : ''}>8</option>
            <option value="9" ${userValue == 9 ? 'selected' : ''}>9</option>
            <option value="10" ${userValue == 10 ? 'selected' : ''}>10</option>
        </select>
    </div>
</form>
<r:script>
    $('#${id}_select_wrapper').stars({
        inputType: 'select',
        split: 2,
        cancelShow: false,
        <g:if test="${caption}">
            captionEl: $('#${id}_caption'),
        </g:if>
        <g:if test="${disabled}">
            disabled: true,
        </g:if>
        callback: function(ui, type, value) {
            jQuery.ajax({
                type: 'POST',
                data: 'type=${type}${scopeParam}&rating=' + value,
                url: '${createLink(controller: 'rating', action: 'rate', id: bean.id)}'
            });
        }
    });
</r:script>
