import java.security.*;
import java.util.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys; //Importerar flera klasser för bland annat JWT
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Inloggning
{

    //Skapar en lista över användarnamn och lösenord.
    final List<Anvandare> listaPaAnvandare = Arrays.asList(
            new Anvandare("anna","losen"),
            new Anvandare("berit", "123456"),
            new Anvandare("kalle", "password"));

    // Genererar en slumpmässig text från universally unique identifier (UUID).
    final private String slumpmassig = (UUID.randomUUID().toString());

    // Tar den slumpmässiga texten och skapar en nyckel
    final private Key hemlig_nyckel = Keys.hmacShaKeyFor(slumpmassig.getBytes());

    // Skapar token från hemlig_nyckel
    public boolean validation_av_anvandare(String anvandarNamn, String losenOrd, String token)
    {
        String skapaToken = Jwts.parserBuilder()
                .setSigningKey(hemlig_nyckel)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get(losenOrd, String.class);


        // "skapaToken" och anvandarNamn är lika så returneras true, annars false.
        if (Objects.equals(skapaToken, anvandarNamn))
        {
            System.out.println("Inloggad som: " + "\"" + anvandarNamn + "\"" + " med lösenord " + "\"" + losenOrd + "\".");
            return true;
        }

        else
            System.out.println("Någonting gick fel vid inloggningen, var god försök igen.");
            return false;
    }

    public String skapa_Token(String anvandare, String losenord)
    {

        if (Objects.equals(anvandare, "anna")) {}
        else if (Objects.equals(anvandare, "berit")) {}
        else if (Objects.equals(anvandare, "kalle")) {}

        //Genererar token för användare
        for (Anvandare anvandare_test : listaPaAnvandare)
        {
            if (anvandare.equals(anvandare_test.anvandarNamn) && losenord.equals(anvandare_test.losenord))
            {
                String token = Jwts.builder()
                .setSubject(anvandare)
                .addClaims(Map.of(anvandare_test.losenord, anvandare_test.anvandarNamn))
                .signWith(hemlig_nyckel)
                .compact();
                return token;
            }
            else{};
        }


        throw new RuntimeException();



    }


}


