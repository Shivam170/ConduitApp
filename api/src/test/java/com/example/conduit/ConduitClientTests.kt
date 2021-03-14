package com.example.conduit

import com.example.api.ConduitClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTests {
    private var conduitClient = ConduitClient()
    @Test
    fun `GET articles`(){
        runBlocking {
            val articles =  conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
//       val articles =  conduitClient.api.getArticles().execute()
//        assertNotNull(articles.body()?.articles)
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
}