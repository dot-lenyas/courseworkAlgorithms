package Model

import java.awt.SystemColor.text


class KnutMorrisPratt: SearchAlgorithm {
    override var name = "KnutMorrisPratt"

    override fun Searching(pat: String, txt: String, q: Int)
    {
        var pfl1 = pfl(pat)
        var indexes = IntArray(txt.length)
        var size = 0
        var k = 0
        for (i in 0..txt.length-1) {
            while (pat[k] !== txt[i] && k > 0) {
                k = pfl1[k - 1]
            }
            if (pat[k] == txt[i]) {
                k = k + 1
                if (k == pat.length) {
                    indexes[size] = i + 1 - k
                    size += 1
                    k = pfl1[k - 1]
                }
            } else {
                k = 0
            }
        }
    }

    fun pfl(text: String): IntArray {
        val pfl = IntArray(text.length)
        pfl[0] = 0
        for (i in 1..text.length-1) {
            var k = pfl[i - 1]
            while (text[k] != text[i] && k > 0) {
                k = pfl[k - 1]
            }
            if (text[k] == text[i]) {
                pfl[i] = k + 1
            } else {
                pfl[i] = 0
            }
        }
        return pfl
    }

}