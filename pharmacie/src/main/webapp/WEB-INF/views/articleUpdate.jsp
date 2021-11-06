<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Creation D'acticle </title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
   <body style="background-color:#4BA74D;">
        <form method="post" action="articlesList">
        <fieldset>
                <legend>Creation d'acticle</legend>
                <p>Vous pouvez vous créer un nouvel article via ce formulaire.</p>

                <label for="designation">Désignation article <span class="requis">*</span></label>
                <input type="text" id="int" name="text" value="" size="200" maxlength="200" />
               
                <br />

                <label for="description">Description article <span class="requis">*</span></label>
                <input type="text" id="int" name="text" value="" size="200" maxlength="200" />
                
                <br />

                <label for="quantite">Quantité article <span class="requis">*</span></label>
                <input type="text" id="confirmation" name="confirmation" value="" size="200" maxlength="200" />
                
                <br />

                
                <br />

                <input type="submit" value="Valider" class="sansLabel" />
                
                <br />
                
                <a href="login" class="signup-image-link">Login</a> 
                <a href="${pageContext.request.contextPath}/user/" class="signup-image-link">Logout</a>
            </fieldset>
        </form>
        <section></section>

    </body>
</html>