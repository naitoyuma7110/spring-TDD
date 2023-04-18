/*
 * MIT License
 *
 *     Copyright (c) 2019  Mohamed Mahmoud Taman - Sirius-X Innovations
 *
 *     Permission is hereby granted, free of charge, to any person obtaining a copy
 *     of this software and associated documentation files (the "Software"), to deal
 *     in the Software without restriction, including without limitation the rights
 *     to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *     copies of the Software, and to permit persons to whom the Software is
 *     furnished to do so, subject to the following conditions:
 *
 *     The above copyright notice and this permission notice shall be included in all
 *     copies or substantial portions of the Software.
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *     SOFTWARE.
 */

package rs.com.tm.siriusxi.tdd.roman;

import javax.imageio.IIOImage;
import java.util.HashMap;
import java.util.Map;

/**
 * アラビア数字をローマ数字に変換するためのクラス
 *
 * 例)
 * II:2
 * IV:4
 * VII:7
 * IX:9
 * XI:11
 *
 * @author change to naito
 * @since 1.0
 */
final class RomanConverter {

    /**
     * ローマ数字とアラビア数字をKey:valueで対応させたMap型オブジェクトを作成
     * HashMapをインスタンス化したMap型無名クラスを代入している
     * {}部分はコンストラクタをオーバーライドし、内部でputメソッドを使用し各数字ペアをMapオブジェクトに登録している
     *
     *
     *
     */
    private static final Map<Character, Integer> romanSymbols = new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 1L;

        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }

    };

//  コンストラクタ
    private RomanConverter() {
    }

    /**
     * Staticメソッド
     *
     * @param roman character
     * @return equivalent Arabic representation.
     */
    static int convertRomanToArabicNumber(String roman) {

//      toUpperCase：大文字変換
        roman = roman.toUpperCase();

        int sum = 0;
        int current = 0;
        int previous = 0;

//      文字列を渡された際、ループにより各文字を走査してアラビア数字に変換する
        for (int index = roman.length() - 1; index >= 0; index--) {
//          指定indexがローマ数字が含まれるか否か判定
            if (doesSymbolsContainsRomanCharacter(roman, index)) {
//              ローマ数字と対応するアラビア数字を取得
                current = getSymbolValue(roman, index);

//              現在取得している文字が、前回の文字よりも数値として大きい場合(IV, VX, IXXなど)
                if (current < previous) {
                    sum -= current;
//              現在取得している文字が、前回の文字よりも数値として小さい,もしくは同じ場合(VI, XV, XXVなど)
                } else {
                    sum += current;
                }

                previous = current;

            } else {
//              IllegalArgumentException：指定した型以外の引数が渡された場合の例外(この場合はstring以外=数字)
                throw new IllegalArgumentException(
                        String.format("Invalid roman character %s ", getCharValue(roman, index)));
            }
        }
        return sum;
    }

    private static boolean doesSymbolsContainsRomanCharacter(String roman, int index) {
//      Mapに登録されたkeyを検索する
        return romanSymbols.containsKey(getCharValue(roman, index));
    }

    private static Integer getSymbolValue(String roman, int index) {
//      MapのKeyとなるローマ数字からアラビア数字を検索し返す
        return romanSymbols.get(getCharValue(roman, index));
    }

//  文字列のindex番目の文字を返す
    private static char getCharValue(String roman, int index) {
        return roman.charAt(index);
    }
}
