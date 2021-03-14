package com.example.conduit

import com.example.api.ConduitClient
import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {
    private var conduitClient = ConduitClient()
    @Test
    fun `GET articles`(){
        runBlocking {
            val articles =  conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`(){
        runBlocking {
            val articles =  conduitClient.api.getArticles(author  = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by tags`(){
        runBlocking {
            val articles =  conduitClient.api.getArticles(tags = listOf("dragons","butts"))
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `POST users - create user`(){
        val userCreds = UserCreds(
            email = "testemali${Random.nextInt(999,9999) }@test.com",
            password = "password${Random.nextInt(999,9999)}",
            username =  "User${Random.nextInt(100,1000)}"
        )
        runBlocking {
            val response = conduitClient.api.signUpUser(SignupRequest(userCreds) )
            assertEquals(userCreds.username ,response.body()?.user?.username)
        }
    }
}