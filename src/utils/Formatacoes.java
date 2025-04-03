package utils;

public class Formatacoes {
    public static String formatarNome(String nome) {
        String[] preposicoes = {"do", "da", "de", "dos", "das"};
        String[] palavras = nome.toLowerCase().split("\\s+");

        for (int i = 0; i < palavras.length - 1; i++) {
            if (!ehPreposicao(palavras[i], preposicoes)) {
                palavras[i] = palavras[i].substring(0, 1).toUpperCase() + palavras[i].substring(1);
            }
        }
        palavras[palavras.length - 1] = palavras[palavras.length - 1].substring(0, 1).toUpperCase() + palavras[palavras.length - 1].substring(1);
        return String.join(" ", palavras);
    }

    public static boolean ehPreposicao(String palavra, String[] preposicoes) {
        for (String p : preposicoes) {
            if (palavra.equalsIgnoreCase(p)) {
                return true;
            }
        }
        return false;
    }

    public static String obterPrimeiroNome(String nome) {
        String[] palavras = nome.split("\\s+");
        return palavras.length > 0 ? palavras[0] : "";
    }

    public static void div() {
        System.out.println("-------------------");
    }
}
