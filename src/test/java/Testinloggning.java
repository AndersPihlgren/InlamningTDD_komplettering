import org.junit.jupiter.params.provider.CsvSource; //
import org.junit.jupiter.params.ParameterizedTest;  // Importerar flera klass från Junit/Jupiter
import static org.junit.jupiter.api.Assertions.*;   //
import org.junit.jupiter.api.Test;                  //


//Denna fil ligger i en egen mapp med namnet "test" för att poängtera att detta inte är den riktiga inloggningen.
public class Testinloggning
{
    //Skapar ett nytt objekt med namn "inloggning" från klassen Inloggning.
    private final Inloggning inloggning = new Inloggning();

    //@ParameterizedTest-annotationen gör så att vi kan köra samma test flera gånger men med olika argument
    @ParameterizedTest

    //@CsvSource-annotationen gör att vi kan använda en lista med komma-separerade värden och testa flera argument.
    //Skapar lista över användare och deras lösenord från tabell till inlämningsuppgiften.
    @CsvSource(value = {"anna, losen, true",
                        "berit, 123456, true",
                        "kalle, password, true" } )

    //Tar in två stringar anvandareTest och losenordTest för användarnamn och lösenord och en boolean för token.
    public void Test_av_autentisering(String anvandareTest, String losenordTest, boolean expected)

    {
        //Jämför det förväntade resultatet med det faktiska resultatet.
        String Token = inloggning.skapa_Token(anvandareTest, losenordTest);
        boolean result = inloggning.validation_av_anvandare(anvandareTest, losenordTest, Token);
        assertEquals(expected, result);
    }


    //KOMPLETTERING

    @ParameterizedTest

    //Skapar en förenklad CSV för användaren "anna" och dennes lösenord "losen".
    @CsvSource(value = {"anna, losen, true" } )

    /* Skapar en metod med namn "unHappyPath" för att testa att ett felaktigt användarnamn
       ger felmeddelande. Det vill säga att går det felaktiga användarnamnet INTE igenom
       så fungerar testet.
     */
    public void unHappyPath(String anvandareTest, String losenordTest){

        String Token = inloggning.skapa_Token(anvandareTest, losenordTest);

        //Byter ut användaren "anna" mot en användare som inte finns med namn "maria".
        boolean result = inloggning.validation_av_anvandare("maria", "Matbestyr1050", Token);


        /* Under "Run" i IntelliJ så får unHappyPath statusen "Assertion failure" då
            den hade förväntat ("Expected") sig "anna" och "losen" vilket skulle retunera boolean "true"
            men jag skickade istället ("Actual") in "maria" och "Matbestyr1050" vilket ger boolean "false".
            Dock så skulle testet fått status "Assertion failure" även om bara en de förväntade värdena skulle vara fel.
         */
        assertTrue(result);

    }

}
