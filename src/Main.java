import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Kontrol edilecek kelimeleri liste halinde oluşturun

        List<String> kelimeler = new ArrayList<>();
        kelimeler.add("koca");
        kelimeler.add("küçük");
        kelimeler.add("ev");
        kelimeler.add("çay");
        kelimeler.add("tahta");
        kelimeler.add("gözlük");
        kelimeler.add("tahtakale");

        // Her kelimeyi kontrol edin ve sonucu ekrana yazdırın
        for (String kelime : kelimeler) {
            if (buyukUnluUyumuKontrolEt(kelime)) {
                System.out.println(kelime + " büyük ünlü uyumuna uyar.");
            } else {
                System.out.println(kelime + " büyük ünlü uyumuna uymaz.");
            }
        }
    }

    public static boolean buyukUnluUyumuKontrolEt(String kelime) {
        kelime = kelime.toLowerCase(); // Tüm harfleri küçük harfe dönüştürme
        kelime=getUnluHarfler(kelime);

        if (kelime.length() < 2) {
            // Tek harfli kelimeler için uyum kontrolü yapma
            return false;
        }

        char oncekiHarf = kelime.charAt(0);

        // İlk harfi dikkate almadan kalan harfleri kontrol edin
        for (int i = 1; i < kelime.length(); i++) {
            char suankiHarf = kelime.charAt(i);

            // Son ünlü kalın ise, önceki ünlü de kalın olmalıdır
            if (isKalinUnlu(oncekiHarf) && !isKalinUnlu(suankiHarf)) {
                return false;
            }

            // Son ünlü ince ise, önceki ünlü de ince olmalıdır
            if (isInceUnlu(oncekiHarf) && !isInceUnlu(suankiHarf)) {
                return false;
            }

            // Önceki harfi güncelleyin
            oncekiHarf = suankiHarf;
        }

        return true;
    }

    public static boolean isKalinUnlu(char harf) {
        // Verilen harfin kalın bir ünlü harf olup olmadığını kontrol edin
        return "aıou".contains(String.valueOf(harf));
    }

    public static boolean isInceUnlu(char harf) {
        // Verilen harfin ince bir ünlü harf olup olmadığını kontrol edin
        return "eiöü".contains(String.valueOf(harf));
    }
    public static String getUnluHarfler(String kelime) {
        String unluharfler="";
        for (int i=0;i<kelime.length();i++){
            char karakter=kelime.charAt(i);
            if("aeıioöuü".contains(String.valueOf(karakter))){
                unluharfler=unluharfler+karakter;
            }
        }
        return unluharfler;
    }
}