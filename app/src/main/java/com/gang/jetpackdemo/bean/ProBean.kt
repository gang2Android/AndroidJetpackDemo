package com.gang.jetpackdemo.bean

data class ProBean(
    val `data`: Data1,
    val msg: String,
    val status: Int
)

data class Data1(
    val brandinfo: List<Brandinfo>,
    val count: String,
    val currentpage: Int,
    val gcategory: List<Gcategory>,
    val list: List<X>,
    val pagelistcount: Int,
    val pagesize: Int
)

data class Brandinfo(
    val brand: String
)

data class Gcategory(
    val cate_id: String,
    val cate_name: String,
    val poster_picpath: String
)

data class X(
    val default_image: String,
    val description: String,
    val goods_id: String,
    val goods_name: String,
    val is_sell_out: String,
    val price: String,
    val sale: String,
    val spec_name_1: String,
    val spec_name_2: String,
    val voucher_price: String
)