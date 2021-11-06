<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>detail D'acticle </title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="inscription">
        <fieldset>
                <legend>Détail d'acticle</legend>
                <p>Vous pouvez consulter le detail d'un article ici.</p>

                <label for="designation">Désignation article <span class="requis">*</span></label>
                <input type="text" id="int" name="text" value="" size="20" maxlength="60" />
               
                <br />

                <label for="description">Description article <span class="requis">*</span></label>
                <input type="text" id="int" name="text" value="" size="20" maxlength="20" />
                
                <br />

                <label for="quantite">Quantité article <span class="requis">*</span></label>
                <input type="text" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                
                <br />

            </fieldset>
        </form>
    </body>
</html>