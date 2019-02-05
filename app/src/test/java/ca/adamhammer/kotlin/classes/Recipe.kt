package ca.adamhammer.kotlin.classes

data class Recipe(private val name : String, private val ingredients : Map<Ingredient, Int>) {
    //Count the Calories in this Recipe
    private fun countCalories() = ingredients.keys.sumBy { food -> food.calories * (ingredients[food] ?: 0) }

    //Gets the Description of the Recipe
    override fun toString() = """
        $name - Calories: ${countCalories()}
        ${ingredients.map { (ingredient, quantity) -> "$quantity x ${ingredient.javaClass.simpleName} = ${ingredient.calories * quantity}" }}
        Dairy Free = ${!hasDairy()}
    """.trimMargin()

    operator fun plus(name: String) = Recipe(name, ingredients)

    operator fun plus(ingredient: Ingredient): Recipe {
        val ingredientMap = HashMap<Ingredient, Int>(ingredients)
        ingredientMap[ingredient] = (ingredientMap[ingredient] ?: 0) + 1
        return Recipe(name, ingredientMap)
    }

    operator fun plus(recipe: Recipe): Recipe {
        val ingredientMap = HashMap<Ingredient, Int>(ingredients)
        ingredientMap.putAll(recipe.ingredients)
        return Recipe(name, ingredientMap)
    }

    fun hasDairy() : Boolean {
        ingredients.keys.forEach {
            if (it is Dairy)
                return@hasDairy true
        }
        return false
    }
}