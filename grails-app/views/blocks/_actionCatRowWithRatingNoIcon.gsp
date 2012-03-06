<div class="${actionCat.code}Row row">
    <div class="span16 bubble row">
        <div class="row">
            <div class="span2">&nbsp;</div>
            <div class="span5">
                ${actionCat.name}
            </div>
            <div class="span3">
                (${actionCat.actCount} action${actionCat.actCount == 1 ? '' : 's'})
            </div>
            <div class="span1">
                &nbsp;
            </div>
            <div class="span2 starCol">
                <sec:ifLoggedIn>
                    <rating:stars bean="${plan}" caption="${false}" id="rating-${plan.id}-${actionCat.id}" scope="cat_${actionCat.id}" />
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <g:link class="star-login" controller="login" action="auth">
                        <div class="stars-off" style="width:80px; margin-left: 10px;"></div>
                    </g:link>
                </sec:ifNotLoggedIn>
            </div>
            <div class="span3">
                &lt;-- Add your rating
            </div>
        </div>
    </div>
</div>
