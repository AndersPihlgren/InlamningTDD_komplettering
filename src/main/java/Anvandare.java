
//Skapar en public-klass för användarna och deras lösenord.
public class Anvandare
{
public String anvandarNamn;
public String losenord;

    //"this" är en referens som pekar mot ett nuvarande objekt till en metod/constructor för att undvika förvirring
    public Anvandare(String anvandarNamn, String losenord)
    {
    this.anvandarNamn = anvandarNamn;
    this.losenord = losenord;
    }
}
