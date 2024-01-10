package com.maulida.readify.model

class Novel (
    var idNovel: String = "",
    var genreNovel: String = "",
    var judulNovel: String = "",
    var descNovel: String = "",
)

val data1 = Novel(
    idNovel = "1",
    genreNovel = "Horor",
    judulNovel = "The Call",
    descNovel = "Hantu ada di depanmu..percaya?"
)

val data2 = Novel(
    idNovel = "2",
    genreNovel = "Romantis",
    judulNovel = "Mystique",
    descNovel = "Ini adalah kisah cinta pelukis River dengan..."
)

val data3 = Novel(
    idNovel = "3",
    genreNovel = "Aksi",
    judulNovel = "Weak Hero",
    descNovel = "Pahlawan lemah yang paling kuat!"
)

val data4 = Novel(
    idNovel = "4",
    genreNovel = "Fantasi",
    judulNovel = "Lore Olympus",
    descNovel = "Diangkat dari mitologi legendaris. Romansa.."
)

val data5 = Novel(
    idNovel = "5",
    genreNovel = "Drama",
    judulNovel = "Rumor Has It",
    descNovel = "lorem ipsum"
)

val listDataDummy = listOf(data1, data2, data3, data4, data5)
