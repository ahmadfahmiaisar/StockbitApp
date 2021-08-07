package com.example.base.abstraction

interface Mapper<in I, out O> {
    fun map(input: I): O
}
