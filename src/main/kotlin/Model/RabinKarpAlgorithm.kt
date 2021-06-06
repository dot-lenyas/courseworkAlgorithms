package Model

class RabinKarpAlgorithm: SearchAlgorithm {


    override var name = "RabinKarp"

    override fun Searching(pat: String, txt: String, q: Int)
    {
        var d = 256
        val M: Int = pat.length

        val N: Int = txt.length

        var i: Int
        var j: Int

        var p = 0 // хеш-значение для шаблона


        var t = 0 // хеш-значение для txt


        var h = 1

        for (i in 0..M-2)
        {
            h = (h*d)%q
        }

        for (i in 0..M-1)
        {
            p = (d*p + pat[i].toInt())%q;

            t = (d*t + txt[i].toInt())%q;
        }


        for (i in 0..N-M)
        {
            if ( p == t )
            {
                var counter = 0
                for (j in 0..M-1)
                {
                    counter++
                    if (txt[i+j].toInt() != pat[j].toInt()) {
                        break;
                    }

                }
                if (counter == M)
                {
                    System.out.println("Pattern found at index " + i)
                }
            }
            if ( i < N-M )

            {

                t = (d*(t - txt[i].toInt()*h) + txt[i+M].toInt())%q



                // Мы можем получить отрицательное значение t, преобразовав его

                // к положительному

                if (t < 0)

                    t = (t + q)

            }
        }

    }


}