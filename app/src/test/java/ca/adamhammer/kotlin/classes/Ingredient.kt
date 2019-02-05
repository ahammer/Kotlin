package ca.adamhammer.kotlin.classes

open class Ingredient(val calories : Int) {
    //If we combine Ingredient or Multiply it, We have a Recipe
    operator fun plus(ingredient: Ingredient) =
        Recipe("", mapOf(this to 1, ingredient to 1))
    operator fun times(i: Int): Recipe =
        Recipe("", mapOf(this to i))
}