package cwiczenia.lab2b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytul;
    public String adresStrony;
    public String szerokosc;
    public String wysokosc;
    public String adresGrafiki;
    public String adresMiniaturki;

    public Infografika(String tekst) {
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);

        if (m.find())
            tytul = m.group(1);
        else
            tytul = "asd";

        pat = Pattern.compile("<media:content\\s*url=\"(.*)\"\\s*type");
        m = pat.matcher(tekst);
        if(m.find())
            adresGrafiki=m.group(1);
        else
            adresGrafiki= "0";

        pat = Pattern.compile("<media:thumbnail\\s*url=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
            adresMiniaturki=m.group(1);
        else
            adresMiniaturki= "0";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);

        if (m.find())
            adresStrony = m.group(1);
        else
            adresStrony = "";


        pat = Pattern.compile("width=\"(.*)\"\\s*height");
        m = pat.matcher(tekst);

        if (m.find())
            szerokosc = m.group(1);
        else
            szerokosc = "0";

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if(m.find())
            wysokosc=m.group(1);
        else
            wysokosc= "0";

    }

    public void print() {
        System.out.printf("\n\nTytul:%s \n", tytul);
        System.out.printf("Adres strony:%s \n", adresStrony);
        System.out.printf("Szerokosc:%s \n", szerokosc);
        System.out.printf("Wysokosc:%s \n", wysokosc);
        System.out.printf("Adres grafiki:%s \n", adresGrafiki);
        System.out.printf("Adres miniaturkki:%s \n", adresMiniaturki);
    }
}
