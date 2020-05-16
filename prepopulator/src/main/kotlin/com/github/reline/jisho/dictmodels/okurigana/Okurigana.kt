package com.github.reline.jisho.dictmodels.okurigana

data class OkuriganaEntry(
        val text: String,
        val reading: String,
        val furigana: List<Okurigana>
)

data class Okurigana(
        val ruby: String,
        val rt: String? = null
)