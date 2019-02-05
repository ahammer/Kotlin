package ca.adamhammer.kotlin

import ca.adamhammer.kotlin.classes.Dairy
import ca.adamhammer.kotlin.classes.Ingredient
import ca.adamhammer.kotlin.classes.Recipe
import org.junit.Test

import org.junit.Assert.*

/**
 * Demonstrates a few principles in Kotlin
 * - Operator Overloading
 * - Class Inheritance
 * - Multi-line String Templates
 * - Data Classes
 * - Objects
 */
class FoodTest {
    object Milk : Dairy(80)
    object Sugar: Ingredient(500)
    object Flour : Ingredient(10)

    @Test
    fun basicRecipe() {
        //These are equivalent Recipes
        val recipeConstructor =
            Recipe("Sugar Cookies", mapOf(Milk to 1, Sugar to 1, Flour to 10))
        val recipeOperator = Milk + Sugar + (Flour * 10) + "Sugar Cookies"

        //This recipe has extra flour
        val recipeOperatorExtraFlour = Milk + Sugar + (Flour * 12) + "Sugar Cookies"

        assertEquals(recipeConstructor, recipeOperator)
        assertNotEquals(recipeConstructor, recipeOperatorExtraFlour)

        System.out.println(recipeOperator)
        System.out.println()
        System.out.println((Sugar * 10) + Flour + "Sweet Flour")
    }

    @Test
    fun testDairyFreeRecipe() {
        assertFalse((Sugar + Flour + "Sweet Flour").hasDairy())
        assertTrue((Milk + Sugar + Flour + "Sweet Flour").hasDairy())
    }

}


