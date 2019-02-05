package ca.adamhammer.kotlin

import junit.framework.Assert.assertEquals
import org.junit.Test

class NullSafety {

    //Immutable Value
    //Type Inferred to String
    //Uses Val, So "Const/Final" can not be changed
    //Does not specify ? operator, so can not be null
    private val defaultString = "default"


    //Mutable Variable
    private var mutableNullableString : String? = null

    @Test
    fun nullSafety() {
        //?: Elvis Operator. E.g. Use mutableNullableString unless Null, then use defaultString
        //Type Inferred to Null Safe String
        val nullSafeString = mutableNullableString ?: defaultString
        assertEquals(defaultString, nullSafeString)

        //Mutate the value of the nullable string to "hello"
        mutableNullableString = "hello"
        val nullSafeStringAfterMutation : String = mutableNullableString ?: "default"

        //Now that the nullable String is not null, the value "hello" is used
        assertEquals("hello", nullSafeStringAfterMutation)

        //Things that won't work
        //nullSafeString = "anything else"
        //Since nullSafeString is value object, it's value can't change

        //var myString : String = null
        //Variables require ? operator to indicate possible null values
    }
}
