<div class="${actionCat.code}Row row">
    <div class="span2 imgHolder">
        <r:img uri="/images/petals/${actionCat.code}.png" alt="" class="pull-right" />
    </div>
    <div class="span14 bubble row">
        <div class="row">
            <div class="span5">
                <a href="${createLink(action: targetAction, controller: targetController, params: [ pid: plan.id, cid: actionCat.id ])}">
                    ${actionCat.name}
                </a>
            </div>
            <div class="span3">
                <a href="${createLink(action: targetAction, controller: targetController, params: [ pid: plan.id, cid: actionCat.id ])}">
                    (${actionCat.actCount} action${actionCat.actCount == 1 ? '' : 's'})
                </a>
            </div>
            <div class="span1">
                &nbsp;
            </div>
            <div class="span2 starCol">
                <rating:stars active="false" bean="${plan}" caption="${false}" id="avgrating-${plan.id}-${actionCat.id}" scope="cat_${actionCat.id}" />
            </div>
            <div class="span3">
                (from <rating:numRates bean="${plan}" scope="cat_${actionCat.id}" tail="true" />)
            </div>
        </div>
    </div>
</div>
