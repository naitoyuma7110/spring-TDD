package rs.com.tm.siriusxi.tdd.roman;

/**
 * ローマ数字とアラビア数字の変換を実行するクラス
 *
 * @author naito
 */
final class RomanConverter {
    /**
     * ローマ数字とアラビア数字の変換メソッド
     *
     * @params  String roman
     * @retrn   Int
     */
    public static int convertRomanToArabicNumber(String roman){
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        }
        throw new IllegalArgumentException();
    }
}
