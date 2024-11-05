package com.example.lista2

data class User(val username: String, val password: String)

object UserManager {
    private val users: MutableList<User> = mutableListOf(
        User("user1", "password1"),
        User("user2", "password2"),
        User("user3", "password3"),
        User("user4", "password4"),
        User("user5", "password5")
    )

    fun addUser(username: String, password: String) {
        users.add(User(username, password))
    }

    fun checkUsername(username: String): Boolean {
        if (users.find { it.username == username } != null) {
            return true
        } else {
            return false
        }
    }

    fun findUser(username: String, password: String): User? {
        return users.find { it.username == username && it.password == password }
    }
}
