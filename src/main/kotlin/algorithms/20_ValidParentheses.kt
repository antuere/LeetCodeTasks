package algorithms

import java.util.*

/*
Given a string s containing just
the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true
*/

fun main(){
    println("Result is ${isValid("(){}[]")}")
}



fun isValid(s: String): Boolean {
    if(s.length % 2 == 1) return false

    val stack = Stack<Char>()

    s.forEach { char ->
        if((char == ')' || char == '}' || char == ']')) {
            if(stack.isNotEmpty()) {
                val nextChar = stack.pop()
                if(char - nextChar > 2 || char - nextChar < -2){
                    return false
                }
            } else {
                return false
            }
        } else {
            stack.add(char)
        }
    }

    return stack.isEmpty()
}