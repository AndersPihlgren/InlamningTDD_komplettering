public class Main
{
    public static void main(String[] args)
    {

    //Skapar ett nytt objekt med namn "inloggning" från klasen Inloggning.
    Inloggning inloggning = new Inloggning();

    String forstaAnvandaren = "anna";
    String forstaLosenordet = "losen";

    //Skickar in första användarens användarnamn och hennes lösenord.
    String token = inloggning.skapa_Token(forstaAnvandaren, forstaLosenordet);

    //Sparar en boolean (true, false) i variabeln "resultat".
    boolean result = inloggning.validation_av_anvandare(forstaAnvandaren, forstaLosenordet, token);
    }
}


