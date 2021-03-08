package com.example.conduit

import com.example.api.ConduitClient
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTests {
    private var conduitClient = ConduitClient()
    @Test
    fun `GET articles`(){
       val articles =  conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }
}