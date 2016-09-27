package com.adventure;

/**
 * Created by chill on 9/27/16.
 */

import static  spark.Spark.*;

public class main {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }

}