<g:each in="${actionCats}" var="actionCat">
    <g:render template="/blocks/actionCatRow" model="[ plan: plan, actionCat: actionCat, targetAction: targetAction, targetController: targetController ]" />
</g:each>
