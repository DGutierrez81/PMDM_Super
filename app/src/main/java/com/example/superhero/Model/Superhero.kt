package com.example.superhero.Model

import androidx.annotation.DrawableRes

data class Superhero(val superheroName: String, val realName: String, val publisher: String, @DrawableRes val photo: Int)