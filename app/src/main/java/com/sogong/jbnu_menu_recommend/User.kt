package com.sogong.jbnu_menu_recommend

data class User(
    var email: String,
    var name: String,
    var department: String,
    var uId: String
){
    constructor(): this("", "", "", "")
}
